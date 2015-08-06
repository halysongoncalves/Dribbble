package br.goncalves.dribbble.presenters;

import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.Dribbble;
import br.goncalves.dribbble.R;
import br.goncalves.common.BusProvider;
import br.goncalves.dribbble.domain.GetAllPopularityShotsController;
import br.goncalves.dribbble.interfaces.HomePresenter;
import br.goncalves.dribbble.interfaces.HomeView;
import br.goncalves.dribbble.model.entities.ConnectionError;
import br.goncalves.dribbble.model.entities.GenericError;
import br.goncalves.dribbble.model.entities.HttpError;
import br.goncalves.dribbble.model.entities.Page;
import br.goncalves.dribbble.model.rest.WebServiceManagerImpl;

public class HomePresenterImpl implements HomePresenter {
    private final HomeView homeView;

    public HomePresenterImpl(HomeView homeView) {
        BusProvider.getUIBusInstance().register(this);
        this.homeView = homeView;
        this.homeView.loadToolbar();
    }

    @Override
    public void loadAllPopularityShots(boolean showProgressBar, int page) {
        if (showProgressBar) {
            homeView.hideAllPeople();
            homeView.showLoading();
        }

        new GetAllPopularityShotsController(WebServiceManagerImpl.getInstance(),
                BusProvider.getUIBusInstance())
                .requestAllPopularityShots(page);
    }

    @Subscribe
    public void onPopulateAllPopularityShots(Page page) {
        homeView.hideLoading();
        homeView.updateListShot(page.getShotList());
        homeView.showAllPopularityShots();
    }

    @Subscribe
    public void onConnectionError(ConnectionError connectionError) {
        homeView.showError(Dribbble.getContext().getString(R.string.fragment_home_dialog_text_title_error),
                Dribbble.getContext().getString(R.string.fragment_home_dialog_text_messae_connection_error));
    }

    @Subscribe
    public void onHttpError(HttpError httpError) {
        homeView.showError(Dribbble.getContext().getString(R.string.fragment_home_dialog_text_title_error),
                Dribbble.getContext().getString(R.string.fragment_home_dialog_text_messae_http_error));
    }

    @Subscribe
    public void onGenericError(GenericError genericError) {
        homeView.showError(Dribbble.getContext().getString(R.string.fragment_home_dialog_text_title_error),
                Dribbble.getContext().getString(R.string.fragment_home_dialog_text_messae_generic_error));
    }


    @Override
    public void onDestroy() {
        BusProvider.getUIBusInstance().unregister(this);
    }

}
