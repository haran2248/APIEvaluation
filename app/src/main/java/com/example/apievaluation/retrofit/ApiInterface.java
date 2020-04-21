package com.example.apievaluation.retrofit;

import com.example.apievaluation.Models.Person;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("all")
    Call<List<Person>> getPeople();

    @POST("add")
    Call<Void> sendPeople(@Body Map<String,String> map);

}
