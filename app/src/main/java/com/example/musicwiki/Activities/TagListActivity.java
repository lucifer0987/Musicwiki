package com.example.musicwiki.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.musicwiki.Model.Tags;
import com.example.musicwiki.R;
import com.example.musicwiki.Adapters.TopTagsAdapter;
import com.example.musicwiki.ViewModels.TopTagsViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class TagListActivity extends AppCompatActivity
        implements TopTagsAdapter.onItemClicked {

    RelativeLayout main_layout;
    ProgressBar progress_bar;
    ImageView genre_drop_down_img;
    RecyclerView genre_rv;
    TopTagsViewModel topTagsViewModel;
    int tagOffset = 0;
    int tagNumResult = 10;
    int tagTotalResult = 100;
    List<Tags> topTagsList = new ArrayList<>();
    TopTagsAdapter adapter;
    int genreMoreClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        genre_rv.setLayoutManager(gridLayoutManager);
        adapter = new TopTagsAdapter(topTagsList, this);
        genre_rv.setAdapter(adapter);

        makeInvisible();
        getTopTags();

        genre_rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(genreMoreClicked == 1 && gridLayoutManager.getItemCount() == gridLayoutManager.findLastCompletelyVisibleItemPosition()+1){
                    if(tagOffset < tagTotalResult){
                        tagOffset += tagNumResult;
                        makeInvisible();
                        getTopTags();
                    }
                }
            }
        });

        genre_drop_down_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(genreMoreClicked == 0){
                    tagOffset += tagNumResult;
                    tagNumResult += 10;
                    makeInvisible();
                    getTopTags();
                    genreMoreClicked = 1;
                    genre_drop_down_img.setImageResource(R.drawable.arrow_up);
                }else{
                    tagOffset = 0;
                    tagNumResult = 10;
                    if(topTagsList.size() > 10){
                        topTagsList.subList(10, topTagsList.size()).clear();
                    }

                    adapter.notifyDataSetChanged();
                    genreMoreClicked = 0;
                    genre_drop_down_img.setImageResource(R.drawable.arrow_down);
                }
            }
        });
    }

    private void getTopTags() {
        topTagsViewModel.getTopTagsList(tagNumResult, tagOffset).observe(this, topTagsResponse -> {

            makeVisible();

            if(topTagsResponse != null){
                topTagsList.addAll(topTagsResponse);
                Log.e("data", topTagsList.toString());
                adapter.notifyItemRangeChanged(0, topTagsList.size());

            }else{
                Snackbar snackbar = Snackbar
                        .make(main_layout, "Some error occurred. Please try again!", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                getTopTags();
                            }
                        });
                snackbar.show();
            }
        });
    }

    private void initView() {
        main_layout = findViewById(R.id.main_layout);
        progress_bar = findViewById(R.id.progress_bar);
        genre_drop_down_img = findViewById(R.id.genre_drop_down_img);
        genre_rv = findViewById(R.id.genre_rv);
        topTagsViewModel = new ViewModelProvider(this).get(TopTagsViewModel.class);
    }

    private void makeVisible(){
        main_layout.setVisibility(View.VISIBLE);
        progress_bar.setVisibility(View.GONE);
    }

    private void makeInvisible(){
        main_layout.setVisibility(View.GONE);
        progress_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onTagClicked(int position) {
        Intent intent = new Intent(TagListActivity.this, TagDetailActivity.class);
        intent.putExtra("tag", topTagsList.get(position).getName());
        startActivity(intent);
    }
}