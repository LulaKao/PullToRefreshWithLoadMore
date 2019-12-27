package com.example.refreshtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreUIHandler;

public class ILoadMoreFooterView extends RelativeLayout implements LoadMoreUIHandler  {
    private ImageView loadingImage;
    private TextView loadText;

    public ILoadMoreFooterView(Context context) {
        super(context, null);
    }

    public ILoadMoreFooterView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public ILoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupViews();
    }

    private void setupViews() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_loadmore_footer, this);
        loadingImage = findViewById(R.id.loading_progress_icon);
        loadText = findViewById(R.id.loading_text);
        setVisibility(GONE);
    }


    @Override
    public void onLoading(LoadMoreContainer container) {
        setVisibility(VISIBLE);
        loadingImage.setVisibility(VISIBLE);
        loadText.setText(R.string.loading_text);
        final RotateAnimation anim = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(-1);
        anim.setDuration(1000);
        loadingImage.setImageResource(R.drawable.loading);
        loadingImage.startAnimation(anim);
    }

    @Override
    public void onLoadFinish(LoadMoreContainer container, boolean empty, boolean hasMore) {
        if (!hasMore) {
            setVisibility(VISIBLE);
            if (empty) {
                loadText.setText(R.string.loading_empty);
            } else {
                loadText.setText(R.string.loading_finish_empty);
            }
            loadingImage.setVisibility(INVISIBLE);
        } else {
            setVisibility(INVISIBLE);
        }
    }

    @Override
    public void onWaitToLoadMore(LoadMoreContainer container) {
        setVisibility(VISIBLE);
        loadText.setText(R.string.load_click_more);
        loadingImage.setVisibility(INVISIBLE);
    }

    @Override
    public void onLoadError(LoadMoreContainer container, int errorCode, String errorMessage) {
        loadingImage.clearAnimation();
        loadingImage.setImageResource(R.drawable.infoicon);
        loadText.setText(R.string.loading_finish_error);
    }
}
