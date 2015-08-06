package br.goncalves.dribbble.views.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import br.goncalves.dribbble.R;
import br.goncalves.common.Constants;
import br.goncalves.dribbble.interfaces.HomeView;
import br.goncalves.dribbble.interfaces.NavigationDrawerCallbacks;
import br.goncalves.dribbble.interfaces.RecyclerViewClickListener;
import br.goncalves.dribbble.model.entities.Shot;
import br.goncalves.dribbble.presenters.HomePresenterImpl;
import br.goncalves.dribbble.views.activities.DetailsActivity;
import br.goncalves.dribbble.views.adapters.EndlessRecyclerOnScrollListener;
import br.goncalves.dribbble.views.adapters.PopularityShotsAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeFragment extends Fragment implements HomeView, NavigationDrawerCallbacks,
        RecyclerViewClickListener, SwipeRefreshLayout.OnRefreshListener {
    private static int START_PAGE = 1;
    private static final int COLUMNS = 2;
    private PopularityShotsAdapter popularityShotsAdapter;
    private HomePresenterImpl homePresenterImpl;
    private GridLayoutManager gridLayoutManager;
    private List<Shot> allListShot = new ArrayList<>();

    @InjectView(R.id.fragment_home_progress)
    ProgressBar mProgressBar;
    @InjectView(R.id.fragment_home_recycler)
    RecyclerView recyclerView;
    @InjectView(R.id.fragment_home_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, viewHome);

        loadGridLayout(COLUMNS);
        loadRecyclerView();
        initializePresenter(START_PAGE);

        return viewHome;
    }

    @Override
    public void initializePresenter(int page) {
        homePresenterImpl = new HomePresenterImpl(this);
        homePresenterImpl.loadAllPopularityShots(true, 1);
    }

    @Override
    public void onDestroy() {
        homePresenterImpl.onDestroy();
        super.onDestroy();
    }

    @Override
    public void loadGridLayout(int colums) {
        gridLayoutManager = new GridLayoutManager(getActivity(), colums);
    }

    @Override
    public GridLayoutManager getGridLayout() {
        return gridLayoutManager;
    }

    @Override
    public void loadRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(getGridLayout());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(getGridLayout()) {
            @Override
            public void onLoadMore(int current_page) {
                loadMoreData(current_page);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void showAllPopularityShots() {
        popularityShotsAdapter = new PopularityShotsAdapter(getAllListShot(), this);
        recyclerView.setAdapter(popularityShotsAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateListShot(List<Shot> shotList) {
        for (Shot shot : shotList) {
            allListShot.add(shot);
        }
    }


    @Override
    public void clearListShot() {
        getAllListShot().clear();
    }

    @Override
    public List<Shot> getAllListShot() {
        return allListShot;
    }

    @Override
    public void hideAllPeople() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void loadToolbar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String title, String message) {
        new MaterialDialog.Builder(getActivity())
                .title(title)
                .content(message)
                .positiveText(R.string.fragment_home_dialog_button_error_positive)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        homePresenterImpl.loadAllPopularityShots(true, START_PAGE);
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        getActivity().finish();
                    }
                })
                .titleColorRes(R.color.color_gray_dark)
                .contentColorRes(R.color.color_gray_dark)
                .positiveColorRes(R.color.color_primary_dark)
                .negativeColorRes(R.color.color_primary_dark)
                .show();
    }

    @Override
    public void loadMoreData(int current_page) {
        swipeRefreshLayout.setRefreshing(true);
        homePresenterImpl.loadAllPopularityShots(false, current_page);
    }

    @Override
    public void onRefresh() {
        homePresenterImpl.loadAllPopularityShots(false, 1);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
    }

    @Override
    public void onClick(View view, int position) {
        Intent detailActivityIntent = new Intent(getActivity(), DetailsActivity.class);
        detailActivityIntent.putExtra(Constants.SHOT, popularityShotsAdapter.getShotList().get(position).getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            detailActivityIntent.putExtra(Constants.POSITION, position);

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                    getActivity(), new Pair<View, String>(view, "cover" + position));
            getActivity().startActivity(detailActivityIntent, options.toBundle());
        } else {
            getActivity().startActivity(detailActivityIntent);
        }
    }

}
