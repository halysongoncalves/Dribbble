package br.goncalves.dribbble.views.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import br.goncalves.dribbble.Dribbble;
import br.goncalves.dribbble.R;
import br.goncalves.common.Constants;
import br.goncalves.common.TextViews;
import br.goncalves.dribbble.interfaces.DetailView;
import br.goncalves.dribbble.interfaces.DetailsPresenter;
import br.goncalves.dribbble.interfaces.ScrollViewListener;
import br.goncalves.dribbble.model.entities.Shot;
import br.goncalves.dribbble.presenters.DetailsPresenterImpl;
import br.goncalves.dribbble.utils.GUI;
import br.goncalves.dribbble.views.customview.ObservableScrollView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;

public class DetailsActivity extends AppCompatActivity implements DetailView,
        Palette.PaletteAsyncListener, ScrollViewListener {
    private Palette.Swatch brightSwatch;
    private boolean isTranslucent = false;
    private DetailsPresenter detailsPresenter;
    private int shotId;
    private Shot shot;

    @InjectViews({
            R.id.activity_about_text_view_name,
            R.id.activity_detail_text_view_description_content,
            R.id.activity_detail_text_view_homepage,
            R.id.activity_detail_text_view_company,
            R.id.activity_detail_text_view_description,
    })
    List<TextView> textViewDetails;

    @InjectViews({
            R.id.activity_detail_text_view_description
    })
    List<TextView> textViewDetailsHeader;

    @InjectView(R.id.activity_details_progress)
    ProgressBar progressBar;
    @InjectView(R.id.activity_detail_book_info)
    View descriptionContainer;
    @InjectView(R.id.activity_detail_cover)
    ImageView imageViewCover;
    @InjectView(R.id.activity_about_roudend_image_view_avatar)
    ImageView imageViewUser;
    @InjectView(R.id.activity_movie_detail_scroll)
    ObservableScrollView observableScrollView;
    @InjectView(R.id.activity_details_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ButterKnife.inject(this);
        loadToolbar();
        loadShotId(getIntent());
        intializePresenter(shotId);
        loadListerners();
        //makeTranslucentStatusBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_details_action_share:
                share(getString(R.string.activity_detail_label_tagline),
                        getString(R.string.activity_details_share_message) + "\n" + shot.getUrl());
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void loadToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void loadShotId(Intent intent) {
        shotId = (Integer) intent.getSerializableExtra(Constants.SHOT);
    }

    @Override
    public void intializePresenter(int id) {
        detailsPresenter = new DetailsPresenterImpl(this);
        detailsPresenter.loadShot(id);
    }

    @Override
    public void loadListerners() {
        observableScrollView.setScrollViewListener(this);
    }

    @Override
    public void makeTranslucentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int moviePosition = getIntent().getIntExtra(Constants.POSITION, 0);
            imageViewCover.setTransitionName("cover" + moviePosition);
            GUI.makeTheStatusbarTranslucent(this);
        }
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String title, String message) {
        new MaterialDialog.Builder(this)
                .title(title)
                .content(message)
                .positiveText(R.string.fragment_home_dialog_button_error_positive)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        detailsPresenter.loadShot(shotId);
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        finish();
                    }
                })
                .titleColorRes(R.color.color_gray_dark)
                .contentColor(R.color.color_gray_dark)
                .positiveColorRes(R.color.color_primary_dark)
                .negativeColorRes(R.color.color_primary_dark)
                .show();
    }

    @Override
    public void showObservableScrollView() {
        observableScrollView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showShot(Shot shot) {
        this.shot = shot;
        setImage(shot.getImageUrl());
        setUserImage(shot.getPlayer().getAvatarUrl());
        setName(shot.getPlayer().getName());
        setDescription(shot.getDescription());
        setHomepage(shot.getPlayer().getWebSite());
        setCompanies(shot.getPlayer().getLocation());
    }

    @Override
    public void setImage(String url) {
        Picasso.with(Dribbble.getContext())
                .load(url)
                .placeholder(R.drawable.placeholder_shot_details)
                .resize(427, 320)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                        Palette.generateAsync(bitmap, this);
                        imageViewCover.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }

    @Override
    public void setUserImage(String url) {
        Picasso.with(Dribbble.getContext())
                .load(url)
                .placeholder(R.drawable.placeholder_people)
                .into(imageViewUser);
    }


    @Override
    public void setName(String title) {
        if (title != null) {
            textViewDetails.get(TextViews.TITLE).setVisibility(View.VISIBLE);
            textViewDetails.get(TextViews.TITLE).setText(title);
        }
    }

    @Override
    public void setDescription(String description) {
        if (description != null) {
            textViewDetails.get(TextViews.DESCRIPTION_CONTENT).setVisibility(View.VISIBLE);
            textViewDetails.get(TextViews.DESCRIPTION).setVisibility(View.VISIBLE);
            textViewDetails.get(TextViews.DESCRIPTION).setText(Html.fromHtml(description));
        }
    }

    @Override
    public void setHomepage(String homepage) {
        if (homepage != null) {
            textViewDetails.get(TextViews.HOMEPAGE).setVisibility(View.VISIBLE);
            textViewDetails.get(TextViews.HOMEPAGE).setText(homepage);
        }
    }

    @Override
    public void setCompanies(String companies) {
        if (companies != null) {
            textViewDetails.get(TextViews.COMPANY).setVisibility(View.VISIBLE);
            textViewDetails.get(TextViews.COMPANY).setText(companies);
        }
    }

    @Override
    public void share(String title, String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, title));
    }

    @Override
    public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y > imageViewCover.getHeight()) {
            textViewDetails.get(TextViews.TITLE).setTranslationY(
                    y - imageViewCover.getHeight());
            if (!isTranslucent) {
                isTranslucent = true;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    GUI.setTheStatusbarNotTranslucent(this);
                    if (brightSwatch != null) {
                        getWindow().setStatusBarColor(brightSwatch.getRgb());
                    }
                }
            }
        }

        if (y < imageViewCover.getHeight() && isTranslucent) {
            textViewDetails.get(TextViews.TITLE).setTranslationY(0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                GUI.makeTheStatusbarTranslucent(this);
                isTranslucent = false;
            }
        }
    }

    @Override
    public void onGenerated(Palette palette) {
        if (palette != null) {
            Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
            Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
            Palette.Swatch lightSwatch = palette.getLightVibrantSwatch();

            if (lightSwatch != null) {
                descriptionContainer.setBackgroundColor(lightSwatch.getRgb());
                ButterKnife.apply(textViewDetails, GUI.setter, lightSwatch.getTitleTextColor());
            }

            if (lightSwatch == null && vibrantSwatch != null)
                colorBrightElements(vibrantSwatch);

            if (darkVibrantSwatch != null && lightSwatch != null)
                colorBrightElements(darkVibrantSwatch);
        }
    }

    @Override
    public void colorBrightElements(Palette.Swatch brightSwatch) {
        textViewDetails.get(TextViews.TITLE).setTextColor(brightSwatch.getTitleTextColor());
        textViewDetails.get(TextViews.TITLE).setBackgroundColor(brightSwatch.getRgb());
        this.brightSwatch = brightSwatch;

        if (textViewDetails.get(TextViews.HOMEPAGE).getVisibility() == View.VISIBLE)
            GUI.tintAndSetCompoundDrawable(this, R.drawable.ic_domain,
                    brightSwatch.getRgb(), textViewDetails.get(TextViews.HOMEPAGE));

        if (textViewDetails.get(TextViews.COMPANY).getVisibility() == View.VISIBLE)
            GUI.tintAndSetCompoundDrawable(this, R.drawable.ic_world,
                    brightSwatch.getRgb(), textViewDetails.get(TextViews.COMPANY));

        ButterKnife.apply(textViewDetailsHeader, GUI.setter, brightSwatch.getRgb());
    }
}
