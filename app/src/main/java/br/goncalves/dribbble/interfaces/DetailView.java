package br.goncalves.dribbble.interfaces;

import android.content.Intent;
import android.support.v7.graphics.Palette;

import br.goncalves.dribbble.model.entities.Shot;


public interface DetailView {
    void loadToolbar();

    void loadShotId(Intent intent);

    void intializePresenter(int id);

    void loadListerners();

    void hideLoading();

    void showError(String title, String message);

    void showObservableScrollView();

    void showShot(Shot shot);

    void setImage(String url);

    void setUserImage(String url);

    void setName(String title);

    void setDescription(String description);

    void setHomepage(String homepage);

    void setCompanies(String companies);

    void colorBrightElements(Palette.Swatch brightSwatch);

    void share(String title, String message);

    void makeTranslucentStatusBar();
}
