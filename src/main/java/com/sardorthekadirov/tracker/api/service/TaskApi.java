package com.sardorthekadirov.tracker.api.service;

import com.sardorthekadirov.tracker.api.model.RemoteTask;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TaskApi {

    @GET ("todos")
    Call<List<RemoteTask>> getAllTask();

    @GET("todos/{id}")
    Call<RemoteTask> getTaskById(@Path("id") int id);

    @POST("todos")
    Call<RemoteTask> createTask(@Body RemoteTask remoteTask);

    @DELETE("todos/{id}")
    Call<Void> deleteTask(@Path("id") int id);

}
