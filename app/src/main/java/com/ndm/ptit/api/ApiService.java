package com.ndm.ptit.api;

import com.ndm.ptit.enitities.BaseResponse;
import com.ndm.ptit.enitities.login.LoginRequest;
import com.ndm.ptit.enitities.login.LoginRespone;
import com.ndm.ptit.enitities.signup.SignUpRequest;
import com.ndm.ptit.enitities.signup.SignUpResponse;
import com.ndm.ptit.enitities.speciality.SpecialityResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/login")
    Call<LoginRespone> login(@Body LoginRequest loginRequest);

    @POST("api/login")
    Call<SignUpResponse> signup(@Body SignUpRequest signUpRequest);

    @GET("api/specialites")
    Call<BaseResponse<SpecialityResponse>> getAllSpecialities(
            @Header("Authorization") String token
    );
}
