package com.example.fagger_retrofit.RetrofitHolder;

import com.example.fagger_retrofit.Models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("posts")
    Observable<List<Post>> getPosts();
}
