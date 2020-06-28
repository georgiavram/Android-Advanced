package com.avramgeorgiana.newsreader.feature.newslist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avramgeorgiana.newsreader.databinding.ItemBinding;
import com.avramgeorgiana.newsreader.listener.NewsHandler;
import com.avramgeorgiana.newsreader.ui.main.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    public List<ArticleItemViewModel> articleList;
    private NewsHandler handler;
    private Context context;

    public NewsAdapter(Context context) {
        articleList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binder = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NewsViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.binding.setViewModel(articleList.get(position));
        ArticleItemViewModel item = articleList.get(position);
        holder.bind(item);
    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public void setItems(List<ArticleItemViewModel> news, NewsHandler handler) {
        this.handler = handler;
        this.articleList = news;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        public final ItemBinding binding;
        public TextView title;
        public TextView content;
        public ImageView imageView;

        public NewsViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.imageView = binding.imageView;
            binding.setHandler(handler);
        }

        public void bind(ArticleItemViewModel item) {
            binding.setViewModel(item);
            binding.executePendingBindings();
        }

    }


}
