package br.goncalves.dribbble.model.rest;


import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import br.goncalves.common.BusProvider;
import br.goncalves.common.Constants;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class WebServiceManagerImpl implements WebServiceManager {
    public static WebServiceManagerImpl webServiceManagerImpl;
    private final WebServiceAPI webServiceAPI;

    private WebServiceManagerImpl() {
        RestAdapter webServiceAPIRest = new RestAdapter.Builder()
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .setEndpoint(Constants.HOST)
                .build();

        webServiceAPI = webServiceAPIRest.create(WebServiceAPI.class);
    }

    public static WebServiceManagerImpl getInstance() {
        if (webServiceManagerImpl == null)
            webServiceManagerImpl = new WebServiceManagerImpl();

        return webServiceManagerImpl;
    }

    @Override
    public void getAllPopularityShots(int page) {
        webServiceAPI.getAllPopularityShots(page, new Callback<br.goncalves.dribbble.model.entities.Page>() {
            @Override
            public void success(br.goncalves.dribbble.model.entities.Page page, Response response) {
                BusProvider.getRestBusInstance().post(page);
            }

            @Override
            public void failure(RetrofitError error) {
                handleError(error);
            }
        });
    }

    @Override
    public void getShot(int shotId) {
        webServiceAPI.getShot(shotId, new Callback<br.goncalves.dribbble.model.entities.Shot>() {
            @Override
            public void success(br.goncalves.dribbble.model.entities.Shot shot, Response response) {
                BusProvider.getRestBusInstance().post(shot);
            }

            @Override
            public void failure(RetrofitError error) {
                handleError(error);
            }
        });
    }

    @Override
    public void getProfile() {
        webServiceAPI.getProfile(Constants.TOKEN, new Callback<br.goncalves.dribbble.model.entities.Profile>() {
            @Override
            public void success(br.goncalves.dribbble.model.entities.Profile profile, Response response) {
                BusProvider.getRestBusInstance().post(profile);
            }

            @Override
            public void failure(RetrofitError error) {
                handleError(error);
            }
        });
    }

    @Override
    public void handleError(RetrofitError retrofitError) {
        switch (retrofitError.getKind()) {
            case HTTP:
                BusProvider.getRestBusInstance().post(new br.goncalves.dribbble.model.entities.HttpError());
                break;

            case NETWORK:
                BusProvider.getRestBusInstance().post(new br.goncalves.dribbble.model.entities.ConnectionError());
                break;

            default:
                BusProvider.getRestBusInstance().post(new br.goncalves.dribbble.model.entities.GenericError());
                break;
        }
    }
}
