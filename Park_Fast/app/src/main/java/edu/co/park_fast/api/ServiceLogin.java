package edu.co.park_fast.api;

import edu.co.park_fast.model.Loger;
import edu.co.park_fast.model.ReponseCredentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceLogin {
    @POST("login")
    public Call<ReponseCredentials> accessLogin(@Body Loger login);
}
