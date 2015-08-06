// Generated code from Butter Knife. Do not modify!
package br.goncalves.dribbble.views.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DetailsActivity$$ViewInjector {
  public static void inject(Finder finder, final br.goncalves.dribbble.views.activities.DetailsActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296356, "field 'progressBar'");
    target.progressBar = (android.widget.ProgressBar) view;
    view = finder.findRequiredView(source, 2131296350, "field 'descriptionContainer'");
    target.descriptionContainer = view;
    view = finder.findRequiredView(source, 2131296348, "field 'imageViewCover'");
    target.imageViewCover = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131296339, "field 'imageViewUser'");
    target.imageViewUser = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131296347, "field 'observableScrollView'");
    target.observableScrollView = (br.goncalves.dribbble.views.customview.ObservableScrollView) view;
    view = finder.findRequiredView(source, 2131296355, "field 'toolbar'");
    target.toolbar = (android.support.v7.widget.Toolbar) view;
    target.textViewDetails = Finder.listOf(
        (android.widget.TextView) finder.findRequiredView(source, 2131296340, "textViewDetails"),
        (android.widget.TextView) finder.findRequiredView(source, 2131296354, "textViewDetails"),
        (android.widget.TextView) finder.findRequiredView(source, 2131296351, "textViewDetails"),
        (android.widget.TextView) finder.findRequiredView(source, 2131296352, "textViewDetails"),
        (android.widget.TextView) finder.findRequiredView(source, 2131296353, "textViewDetails")
    );    target.textViewDetailsHeader = Finder.listOf(
        (android.widget.TextView) finder.findRequiredView(source, 2131296353, "textViewDetailsHeader")
    );  }

  public static void reset(br.goncalves.dribbble.views.activities.DetailsActivity target) {
    target.progressBar = null;
    target.descriptionContainer = null;
    target.imageViewCover = null;
    target.imageViewUser = null;
    target.observableScrollView = null;
    target.toolbar = null;
    target.textViewDetails = null;
    target.textViewDetailsHeader = null;
  }
}
