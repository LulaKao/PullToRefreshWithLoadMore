package com.example.refreshtest;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import in.srain.cube.views.loadmore.LoadMoreContainer;

public class ILoadMoreFooterView extends RelativeLayout implements LoadMoreUIHandler {
    private ImageView loadingImage;
    private TextView loadText;

    @Override
    public void onLoading(LoadMoreContainer container) {

    }

    @Override
    public void onLoadFinish(LoadMoreContainer container, boolean empty, boolean hasMore) {

    }

    @Override
    public void onWaitToLoadMore(LoadMoreContainer container) {

    }

    @Override
    public void onLoadError(LoadMoreContainer container, int errorCode, String errorMessage) {

    }
}
