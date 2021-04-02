package com.example.fagger_retrofit.DI;

import com.example.fagger_retrofit.ViewModel.MainViewModel;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = Module.class)
public
interface Component {
    void inject(MainViewModel mainViewModel);
}
