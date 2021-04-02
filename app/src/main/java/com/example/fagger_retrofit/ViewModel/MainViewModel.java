package com.example.fagger_retrofit.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.fagger_retrofit.DI.Component;
import com.example.fagger_retrofit.DI.DaggerComponent;
import com.example.fagger_retrofit.Models.Post;
import com.example.fagger_retrofit.RetrofitHolder.RetrofitHolder;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainViewModel extends ViewModel {
    Component component  = DaggerComponent.create();

    @Inject
    RetrofitHolder retrofitHolder;
    public void subscurber(Observable<Post> postObservable){
        postObservable.subscribe(new Observer<Post>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {
                System.out.println("Started");
            }

            @Override
            public void onNext(@NotNull Post post) {
                System.out.println("Post Id : " + post.getId());
            }

            @Override
            public void onError(@NotNull Throwable e) {
                System.out.println("Error : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println(". . . DONE . . . ");
            }
        });
    }

    public void prepareSub(){

        component.inject(this);
        subscurber(retrofitHolder.getObservable(retrofitHolder.prepareApi()));
    }
}
