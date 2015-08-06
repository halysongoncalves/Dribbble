package br.goncalves.dribbble.utils;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.view.Display;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import br.goncalves.dribbble.R;
import butterknife.ButterKnife;


public class GUI {
    public static final int DEFAULT_DELAY = 30;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void tintAndSetCompoundDrawable(Context context, @DrawableRes int drawableRes, int color, TextView textview) {
        Resources resources = context.getResources();
        int padding = (int) resources.getDimension(R.dimen.spacigns_large);

        Drawable drawable = resources.getDrawable(drawableRes);
        assert drawable != null;
        drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);

        textview.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable,
                null, null, null);

        textview.setCompoundDrawablePadding(padding);
    }

    public static ViewPropertyAnimator showViewByScale(View view) {
        return view.animate().setStartDelay(DEFAULT_DELAY)
                .scaleX(1).scaleY(1);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void showViewByRevealEffect(View hidenView, View centerPointView, int height) {
        int cx = (centerPointView.getLeft() + centerPointView.getRight()) / 2;
        int cy = (centerPointView.getTop() + centerPointView.getBottom()) / 2;

        Animator animator = ViewAnimationUtils.createCircularReveal(
                hidenView, cx, cy, 0, height);

        hidenView.setVisibility(View.VISIBLE);
        animator.start();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void makeTheStatusbarTranslucent(Activity activity) {
        Window window = activity.getWindow();
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setTheStatusbarNotTranslucent(Activity activity) {

        WindowManager.LayoutParams attrs = activity.getWindow()
                .getAttributes();
        attrs.flags &= (~WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        attrs.flags &= (~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().setAttributes(attrs);
        activity.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public static int getWindowWidth(Activity activity) {

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.y;
    }

    public static final ButterKnife.Setter<TextView, Integer> setter = new ButterKnife.Setter<TextView, Integer>() {

        @Override
        public void set(TextView view, Integer value, int index) {
            view.setTextColor(value);
        }
    };
}
