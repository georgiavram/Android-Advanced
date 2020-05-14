package com.avramgeorgiana.newsreader.ui.main;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.avramgeorgiana.newsreader.databinding.ItemBinding;

public class ArticleItemViewModel extends ViewModel {
    ItemBinding binding;

    @Nullable
    private int id;
    private String title;
    private String imageUrl;
    private String content;

    public ArticleItemViewModel(String title, String imageUrl, String content) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

//    @BindingAdapter({"imgUrl", "placeholder"})
//    public static void setImageUrl(ImageView imageView, @Nullable String url, @DrawableRes int placeHolder) {
//        Glide
//                .with(imageView.getContext())
//                .load(url)
//                .fallback(placeHolder)
//                .into(imageView);
//    }
}
