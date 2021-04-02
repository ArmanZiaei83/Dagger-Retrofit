package com.example.fagger_retrofit.DI;

import com.example.fagger_retrofit.RetrofitHolder.RetrofitHolder;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Provides;
import retrofit2.Retrofit;

@dagger.Module
public class Module {

    @Singleton
    @Provides
    RetrofitHolder bindRetrofitHolder(){
        return new RetrofitHolder();
    }
}
