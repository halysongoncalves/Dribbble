package br.goncalves.dribbble.interfaces;


import android.widget.ScrollView;

public interface ScrollViewListener {
    void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy);
}