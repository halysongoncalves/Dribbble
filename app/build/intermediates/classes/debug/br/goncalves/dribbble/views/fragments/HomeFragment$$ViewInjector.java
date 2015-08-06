// Generated code from Butter Knife. Do not modify!
package br.goncalves.dribbble.views.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HomeFragment$$ViewInjector {
  public static void inject(Finder finder, final br.goncalves.dribbble.views.fragments.HomeFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296366, "field 'mProgressBar'");
    target.mProgressBar = (android.widget.ProgressBar) view;
    view = finder.findRequiredView(source, 2131296365, "field 'recyclerView'");
    target.recyclerView = (android.support.v7.widget.RecyclerView) view;
    view = finder.findRequiredView(source, 2131296364, "field 'swipeRefreshLayout'");
    target.swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) view;
  }

  public static void reset(br.goncalves.dribbble.views.fragments.HomeFragment target) {
    target.mProgressBar = null;
    target.recyclerView = null;
    target.swipeRefreshLayout = null;
  }
}
