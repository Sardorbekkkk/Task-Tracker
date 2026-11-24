package com.sardorthekadirov.tracker.api.client;

import com.sardorthekadirov.tracker.api.service.TaskApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient instance;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private ApiClient() {

        //Настроили "Шпиона" он нужен для отслеживания Результатов Обмена данными между клиентом и сервером
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Создали клиента Через него наша программа обменивается даннысм с Сервером
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //Настроили Retrofit
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.client(httpClient.build());
        builder.addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }



    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return  instance;
    }

    public TaskApi API() {
        return retrofit.create(TaskApi.class);
    }
}
