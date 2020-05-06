package com.avramgeorgiana.newsreader.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avramgeorgiana.newsreader.feature.newslist.adapter.NewsAdapter;
import com.avramgeorgiana.newsreader.listener.NewsHandler;
import com.avramgeorgiana.newsreader.ui.main.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"items", "newsHandler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> news, NewsHandler handler) {
        NewsAdapter newsAdapter = (NewsAdapter) recyclerView.getAdapter();

        if (newsAdapter == null) {
            newsAdapter = new NewsAdapter();
            recyclerView.setLayoutManager((new LinearLayoutManager(recyclerView.getContext())));
            recyclerView.setAdapter(newsAdapter);
        }
        //???
        newsAdapter.setItems(news, handler);
    }
}
