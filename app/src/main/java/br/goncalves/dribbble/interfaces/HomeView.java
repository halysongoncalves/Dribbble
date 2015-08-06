package br.goncalves.dribbble.interfaces;

import android.support.v7.widget.GridLayoutManager;

import java.util.List;

import br.goncalves.dribbble.model.entities.Shot;

public interface HomeView {
    void initializePresenter(int page);

    void loadRecyclerView();

    void showAllPopularityShots();

    void hideAllPeople();

    void loadToolbar();

    void showLoading();

    void hideLoading();

    void showError(String title, String message);

    GridLayoutManager getGridLayout();

    void clearListShot();

    void loadMoreData(int current_page);

    void loadGridLayout(int colums);

    void updateListShot(List<Shot> shotList);

    List<Shot> getAllListShot();
}
