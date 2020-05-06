package com.avramgeorgiana.newsreader.ui.main;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.ViewModel;


public class NewsListViewModel extends ViewModel {
    @NonNull
    ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();


}
