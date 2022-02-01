package com.example.iroom.model.remote

import com.example.iroom.model.entity.FeedbackReqDTO
import com.example.iroom.model.entity.register.LoginReqDTO
import com.example.iroom.model.entity.register.SignUpReqDTO
import com.example.iroom.utils.Const
import retrofit2.http.*

interface ApiService {

    // USER
    @POST(Const.API_LOGIN)
    suspend fun login(
        @Body loginReqDTO: LoginReqDTO
    )

    @DELETE(Const.API_LOGOUT)
    suspend fun logout()

    @POST(Const.API_SIGN_UP)
    suspend fun signUp(
        @Body signUpReqDTO: SignUpReqDTO
    )

    @GET(Const.API_GET_SELF_USER)
    suspend fun getInfo()

    @PATCH(Const.API_GET_SELF_USER)
    suspend fun updateUser(

    )

    @GET(Const.API_GET_OTHER_USER)
    suspend fun retrieveUser(
        @Path("userId") userId: String
    )

    //ROOM
    @GET(Const.API_FEEDBACK)
    suspend fun getFeedbacks(
        @Query("pageNum") pageNum: Int,
        @Query("pageSize") pageSize: Int,
        @Query("roomId") roomId: String,
        @Query("sorts") sorts: String
    )

    @POST(Const.API_FEEDBACK)
    suspend fun feedback(
        @Body feedbackReqDTO: FeedbackReqDTO
    )

}