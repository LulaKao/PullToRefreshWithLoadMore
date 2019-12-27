package com.example.refreshtest;

import in.srain.cube.views.loadmore.LoadMoreContainer;

public interface LoadMoreUIHandler {
    // 加载中
    public void onLoading(LoadMoreContainer container);
    // 加载完成: 数据为空 / 没有更多
    public void onLoadFinish(LoadMoreContainer container, boolean empty, boolean hasMore);
    // 等待加载更多
    public void onWaitToLoadMore(LoadMoreContainer container);
    // 加载失败
    public void onLoadError(LoadMoreContainer container, int errorCode, String errorMessage);
}
