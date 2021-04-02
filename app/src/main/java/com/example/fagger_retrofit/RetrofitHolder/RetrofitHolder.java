package com.example.fagger_retrofit.RetrofitHolder;

import com.example.fagger_retrofit.Models.Post;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHolder {

    public Retrofit createRetrofit (){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Api prepareApi (){
        return createRetrofit().create(Api.class);
    }

    public Observable<Post> getObservable(Api api){
        return api.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<List<Post>, ObservableSource<Post>>() {
                    @Override
                    public ObservableSource<Post> apply(@NotNull List<Post> posts) throws Exception {
                        return Observable.fromIterable(posts).subscribeOn(Schedulers.io());
                    }
                });
    }

    @Inject
    public RetrofitHolder() {
    }
}
