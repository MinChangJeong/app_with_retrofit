package com.frontend.cj_app.common.api;

import com.frontend.cj_app.common.payload.Assignment_Request;
import com.frontend.cj_app.common.payload.Assignment_Response;
import com.frontend.cj_app.common.payload.Assignmented_Request;
import com.frontend.cj_app.common.payload.Assignmented_Response;
import com.frontend.cj_app.common.payload.Complete_Request;
import com.frontend.cj_app.common.payload.Complete_Response;
import com.frontend.cj_app.common.payload.Confirm_Request;
import com.frontend.cj_app.common.payload.Confirm_Response;
import com.frontend.cj_app.common.payload.User_Request;
import com.frontend.cj_app.common.payload.User_login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitAPI {
    // 로그인
    @Headers({"Content-Type: application/json"})
    @POST("/user/login")
    Call <User_login> LoginUser(@Body User_login data);

    // 회원가입
    @Headers({"Content-Type: application/json"})
    @POST("/user/registerUser")
    Call <User_Request> registerUser(@Body User_Request data);

    // 배송 자동 할당
    @Headers({"Content-Type: application/json"})
    @POST("/coury/autoAssignmentCoury")
    Call <Assignment_Response> autoAssignmentCoury(@Body Assignment_Request data);

    // 업무 확정
    @Headers({"Content-Type: application/json"})
    @POST("/coury/confirmCouryList")
    Call <Confirm_Response> confirmCouryList(@Body Confirm_Request data);

    // 배송 완료
    @Headers({"Content-Type: application/json"})
    @POST("/coury/updateCompletedCoury")
    Call <Complete_Response> updateCompletedCoury(@Body Complete_Request data);

    // 할당 받은 배송 리스트 조회
    @Headers({"Content-Type: application/json"})
    @POST("/ncoury/getAssignmentedCouryList")
    Call <Assignmented_Response> getAssignmetedCouryList(@Body Assignmented_Request data);
}
