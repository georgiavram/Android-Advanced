package com.avramgeorgiana.newsreader.feature.newslist.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avramgeorgiana.newsreader.databinding.ItemBinding;
import com.avramgeorgiana.newsreader.listener.NewsHandler;
import com.avramgeorgiana.newsreader.ui.main.ArticleItemViewModel;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    private List<ArticleItemViewModel> taskModelList;
    private NewsHandler handler;

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setItems(List<ArticleItemViewModel> news, NewsHandler handler) {
        this.handler = handler;
        this.taskModelList = news;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        final ItemBinding binding;

        public NewsViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
