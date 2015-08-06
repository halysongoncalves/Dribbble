package br.goncalves.dribbble.presenters;

import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.Dribbble;
import br.goncalves.dribbble.R;
import br.goncalves.common.BusProvider;
import br.goncalves.dribbble.domain.GetShotController;
import br.goncalves.dribbble.interfaces.DetailView;
import br.goncalves.dribbble.interfaces.DetailsPresenter;
import br.goncalves.dribbble.model.entities.ConnectionError;
import br.goncalves.dribbble.model.entities.GenericError;
import br.goncalves.dribbble.model.entities.HttpError;
import br.goncalves.dribbble.model.entities.Shot;
import br.goncalves.dribbble.model.rest.WebServiceManagerImpl;

public class DetailsPresenterImpl implements DetailsPresenter {
    private final DetailView detailView;

    public DetailsPresenterImpl(DetailView detailView) {
        BusProvider.getUIBusInstance().register(this);
        this.detailView = detailView;
    }

    @Override
    public void loadShot(int shotId) {
        new GetShotController(WebServiceManagerImpl.getInstance(),
                BusProvider.getUIBusInstance())
                .requestShot(shotId);
    }

    @Subscribe
    public void onPopulateShot(Shot shot) {
        detailView.hideLoading();
        detailView.showObservableScrollView();
        detailView.showShot(shot);
    }

    @Subscribe
    public void onConnectionError(ConnectionError connectionError) {
        detailView.showError(Dribbble.getContext().getString(R.string.fragment_home_dialog_text_title_error),
                Dribbble.getContext().getString(R.string.fragment_home_dialog_text_messae_connection_error));
    }

    @Subscribe
    public void onHttpError(HttpError httpError) {
        detailView.showError(Dribbble.getContext().getString(R.string.fragment_home_dialog_text_title_error),
                Dribbble.getContext().getString(R.string.fragment_home_dialog_text_messae_http_error));
    }

    @Subscribe
    public void onGenericError(GenericError genericError) {
        detailView.showError(Dribbble.getContext().getString(R.string.fragment_home_dialog_text_title_error),
                Dribbble.getContext().getString(R.string.fragment_home_dialog_text_messae_generic_error));
    }

    @Override
    public void onDestroy() {
        BusProvider.getUIBusInstance().unregister(this);
    }

}
