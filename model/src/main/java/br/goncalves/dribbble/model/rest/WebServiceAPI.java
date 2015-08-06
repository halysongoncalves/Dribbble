package br.goncalves.dribbble.model.rest;

import br.goncalves.dribbble.model.entities.Page;
import br.goncalves.dribbble.model.entities.Profile;
import br.goncalves.dribbble.model.entities.Shot;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Interface representing the WebServiceAPI endpoints
 * used by retrofit
 */
public interface WebServiceAPI {
    @GET("/shots/popular")
    void getAllPopularityShots(@Query("page") int page, Callback<Page> callback);

    @GET("/shots/{shotId}")
    void getShot(@Path("shotId") int shotId, Callback<Shot> callback);

    @GET("/v1/user")
    void getProfile(@Query("access_token") String access_token, Callback<Profile> callback);
}
