package com.avramgeorgiana.newsreader.ui.main;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.avramgeorgiana.data.NewsRepository;
import com.avramgeorgiana.data.features.model.Article;
import com.avramgeorgiana.newsreader.feature.newslist.mapper.ArticleToViewModelMapper;
import com.avramgeorgiana.newsreader.listener.NewsHandler;
import com.avramgeorgiana.newsreader.ui.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver, NewsHandler {

    private final static String LINK = "https://newsapi.org/";
    public final ObservableBoolean isLoading;
    public final SingleLiveEvent<String> openLink;
    private final NewsRepository repo;
    @NonNull
    public ObservableList<ArticleItemViewModel> newsList;

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.openLink = new SingleLiveEvent<>();
        this.isLoading = new ObservableBoolean();
        this.newsList = new ObservableArrayList<>();
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
//        ArticleItemViewModel a1 = new ArticleItemViewModel("Title Mock", "https://androidwave.com/wp-content/uploads/2019/01/profile_pic.jpg", "waaaaaaww");
//        ArticleItemViewModel a2 = new ArticleItemViewModel("Title Mock2", "https://androidwave.com/wp-content/uploads/2019/01/profile_pic.jpg", "android");
//        ArticleItemViewModel a3 = new ArticleItemViewModel("Title Mock3", "https://androidwave.com/wp-content/uploads/2019/01/profile_pic.jpg", "awesome");
//        List<ArticleItemViewModel> l = new ArrayList<>();
//
//        l.add(a1);
//        l.add(a2);
//        l.add(a3);
//
//        newsList.addAll(l);
        isLoading.set(true);
        repo.getNewsArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );

    }

    private void onNewsArticlesReceived(@NonNull List<Article> articles) {
        isLoading.set(false);
        newsList.addAll(new ArticleToViewModelMapper().apply(articles));
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        // error.setValue(throwable);
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }

    @Override
    public void onDeleteItemSelected(ArticleItemViewModel item) {

    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }
}
