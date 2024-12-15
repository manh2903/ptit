package com.ndm.ptit.api;

import com.ndm.ptit.enitities.BaseResponse;
import com.ndm.ptit.enitities.BaseResponse2;
import com.ndm.ptit.enitities.appointment.Appointment;
import com.ndm.ptit.enitities.doctor.DoctorResponse;
import com.ndm.ptit.enitities.login.LoginRequest;
import com.ndm.ptit.enitities.login.LoginRespone;
import com.ndm.ptit.enitities.services.DoctorServiceResponse;
import com.ndm.ptit.enitities.services.ServicesResponse;
import com.ndm.ptit.enitities.signup.SignUpRequest;
import com.ndm.ptit.enitities.signup.SignUpResponse;
import com.ndm.ptit.enitities.speciality.SpecialityResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @POST("api/login")
    Call<LoginRespone> login(@Body LoginRequest loginRequest);

    @POST("api/login")
    Call<SignUpResponse> signup(@Body SignUpRequest signUpRequest);

    @GET("api/specialites")
    Call<BaseResponse<SpecialityResponse>> getAllSpecialities(
            @Header("Authorization") String token
    );

    @GET("api/appointment/")
    Call<BaseResponse<Appointment>> getAllAppointment(
            @Header("Authorization") String token,
            @Query("size") int size,
            @Query("page") int page
    );


    @GET("api/services/{id}")
    Call<ServicesResponse> getServiceById(
            @Header("Authorization") String token,
            @Path("id") int id
    );

    @GET("api/doctors/service/{id}")
    Call<DoctorServiceResponse> getDoctorServiceById(
            @Header("Authorization") String token,
            @Path("id") int id
    );

    @GET("api/doctors/{id}")
    Call<BaseResponse2<DoctorResponse>> getDoctorID(
            @Header("Authorization") String token,
            @Path("id") int id
    );
}
