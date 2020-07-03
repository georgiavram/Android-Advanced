package com.avramgeorgiana.newsreader.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.avramgeorgiana.newsreader.databinding.MainFragmentBinding;
import com.avramgeorgiana.newsreader.ui.factory.ViewModelFactory;
import com.avramgeorgiana.newsreader.ui.navigator.AlertNavigator;
import com.google.gson.Gson;

public class MainFragment extends Fragment {

    private NewsListViewModel mViewModel;
    private AlertNavigator alertNavigator;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MainFragmentBinding binding = MainFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertNavigator = new AlertNavigator(getChildFragmentManager(), requireContext());
        mViewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsListViewModel.class);
        mViewModel.openLink.observe(this, this::openLink);
        mViewModel.article.observe(this, this::openArticle);
        getLifecycle().addObserver(mViewModel);
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }

    private void openArticle(@NonNull ArticleItemViewModel item) {
        Intent i = new Intent(getActivity(), NewsDetails.class);
        Gson gson = new Gson();
        String articleJson = gson.toJson(item);
        i.putExtra("article", articleJson);
        startActivity(i);
    }
}