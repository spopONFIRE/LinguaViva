package com.example.tccomelhor

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

data class RegistroRequest(val nome: String, val email: String, val senha: String)
data class RegistroResponse(val id: Int, val nome: String, val email: String)

interface ApiService {
    @POST("register")
    suspend fun registrar(@Body body: RegistroRequest): Response<RegistroResponse>
}

object ApiClient {
    private const val BASE_URL = "http://192.168.15.7:8000/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}