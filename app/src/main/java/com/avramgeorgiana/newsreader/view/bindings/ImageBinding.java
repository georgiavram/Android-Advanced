package com.avramgeorgiana.newsreader.view.bindings;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBinding {

    @BindingAdapter("imgUrl")
    public static void setImageUrl(ImageView imageView, @Nullable String url) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
