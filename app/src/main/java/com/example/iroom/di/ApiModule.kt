package com.example.iroom.di
import android.app.Application
import com.example.iroom.BuildConfig
import com.example.iroom.model.remote.ApiService
import com.example.iroom.utils.Const
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun apiService(@Named("retrofit") retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    @Provides
    @Singleton
    @Named("retrofit")
    fun retrofit(@Named("ok_http") client: OkHttpClient,
                 @Named("converter_gson") converterFactory: Converter.Factory) = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(client)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    @Singleton
    @Named("ok_http")
    fun client(@Named("http_logger") logger: Interceptor,
               @Named("cache_http") cache: Cache
    ) = OkHttpClient.Builder()
        .cache(cache)
        .connectTimeout(Const.HTTP_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(Const.HTTP_TIMEOUT, TimeUnit.SECONDS)
        .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS))
        .addInterceptor(logger)
        .addInterceptor {
            val request = it
                .request()
                .newBuilder()
//                .addHeader("access-token",MemberPref.getAccessToken())
//                .addHeader("app-id","iroom-service")
                .build()
            return@addInterceptor it.proceed(request)
        }
        .build()

    @Provides
    @Singleton
    @Named("http_logger")
    fun logger(): Interceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

    @Provides
    @Singleton
    @Named("converter_gson")
    fun gsonConverterFactory(): Converter.Factory = GsonConverterFactory.create()


    @Provides
    @Singleton
    @Named("cache_http")
    fun cache(application: Application): Cache {
        val file = File(application.cacheDir, "http-cache")
        return Cache(file, Const.HTTP_CACHE_SIZE)
    }
}