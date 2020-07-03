package com.avramgeorgiana.newsreader.listener;

import com.avramgeorgiana.newsreader.ui.main.ArticleItemViewModel;

public interface NewsHandler {

    void onItemSelected(ArticleItemViewModel item);

    void onDeleteItemSelected(ArticleItemViewModel item);
}
