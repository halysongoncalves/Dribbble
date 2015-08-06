package br.goncalves.dribbble.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.goncalves.dribbble.Dribbble;
import br.goncalves.dribbble.R;
import br.goncalves.dribbble.interfaces.AboutPresenter;
import br.goncalves.dribbble.interfaces.AboutView;
import br.goncalves.dribbble.presenters.AboutPresenterImpl;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class AboutActivity extends AppCompatActivity implements AboutView {
    @InjectView(R.id.activity_about_roudend_image_view_avatar)
    ImageView imageViewAvatar;
    @InjectView(R.id.activity_about_text_view_name)
    TextView textViewName;
    @InjectView(R.id.activity_about_text_view_location)
    TextView textViewLocation;
    @InjectView(R.id.activity_about_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ButterKnife.inject(this);
        loadToolbar();
        initializePresenter();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemIdentifier = item.getItemId();
        switch (itemIdentifier) {
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }

    @Override
    public void loadToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initializePresenter() {
        AboutPresenter aboutPresenter = new AboutPresenterImpl(this);
        aboutPresenter.loadProfile();
    }

    @Override
    public void showPictureProfile(String avatarUrl) {
        Picasso.with(Dribbble.getContext())
                .load(avatarUrl)
                .into(imageViewAvatar);
    }

    @Override
    public void showNameProfile(String name) {
        if (name != null) {
            textViewName.setVisibility(View.VISIBLE);
            textViewName.setText(name);
        }
    }

    @Override
    public void showLocation(String company) {
        if (company != null) {
            textViewLocation.setVisibility(View.VISIBLE);
            textViewLocation.setText(company);
        }
    }
}
