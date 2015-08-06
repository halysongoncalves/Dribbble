package br.goncalves.dribbble.model.rest;


import retrofit.RetrofitError;

public interface WebServiceManager {
    void getAllPopularityShots(int page);

    void getShot(int shotId);

    void getProfile();

    void handleError(RetrofitError retrofitError);
}
