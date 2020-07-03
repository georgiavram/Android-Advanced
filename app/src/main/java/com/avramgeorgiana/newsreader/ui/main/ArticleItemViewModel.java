package com.avramgeorgiana.newsreader.ui.main;

import androidx.lifecycle.ViewModel;


public class ArticleItemViewModel extends ViewModel {
    private String title;
    private String imageUrl;
    private String content;

    public ArticleItemViewModel(String title, String imageUrl, String content) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
