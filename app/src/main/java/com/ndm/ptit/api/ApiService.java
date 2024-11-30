package com.ndm.ptit.api;

import com.ndm.ptit.enitities.login.LoginRequest;
import com.ndm.ptit.enitities.login.LoginRespone;
import com.ndm.ptit.enitities.signup.SignUpRequest;
import com.ndm.ptit.enitities.signup.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/login")
    Call<LoginRespone> login(@Body LoginRequest loginRequest);

    @POST("/api/login")
    Call<SignUpResponse> signup(@Body SignUpRequest signUpRequest);

}
