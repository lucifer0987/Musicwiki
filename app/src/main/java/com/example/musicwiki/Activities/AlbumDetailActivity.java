package com.example.musicwiki.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicwiki.Adapters.AlbumTagAdapter;
import com.example.musicwiki.R;
import com.example.musicwiki.ViewModels.AlbumDetailViewModel;
import com.example.musicwiki.ViewModels.TagDetailsViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailActivity extends AppCompatActivity
implements AlbumTagAdapter.onItemClicked{

    RelativeLayout main_layout;
    ProgressBar progress_bar;
    TextView album_artist, album_title, album_description;
    ImageView arrow_back, album_image;
    String albumStr = "", artistStr = "";
    RecyclerView genre_list_rv;
    AlbumDetailViewModel albumDetailViewModel;
    List<String> tagList = new ArrayList<>();
    LinearLayoutManager layoutManager;
    AlbumTagAdapter albumTagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        initView();
        makeInvisible();
        albumStr = getIntent().getStringExtra("album");
        artistStr = getIntent().getStringExtra("artist");

        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        genre_list_rv.setLayoutManager(layoutManager);
        albumTagAdapter = new AlbumTagAdapter(AlbumDetailActivity.this, this);
        genre_list_rv.setAdapter(albumTagAdapter);

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        makeInvisible();
        getAlbumDetails();
    }

    private void getAlbumDetails() {
        albumDetailViewModel.getAlbumDetails(albumStr, artistStr).observe(this, albumDetails -> {
            makeVisible();
            album_title.setText(albumDetails.getName());
            album_artist.setText(albumDetails.getArtist());
            album_description.setText(albumDetails.getWiki().getSummary());
            Picasso.get()
                    .load(albumDetails.getImage().get(4).getText())
                    .error(R.drawable.default_image)
                    .placeholder(R.drawable.default_image)
                    .fit()
                    .into(album_image);

            for(int i = 0; i < albumDetails.getTags().getTag().size(); i++){
                tagList.add(albumDetails.getTags().getTag().get(i).getName());
            }
            albumTagAdapter.setData(tagList);

        });
    }

    private void initView() {
        main_layout = findViewById(R.id.main_layout);
        progress_bar = findViewById(R.id.progress_bar);
        arrow_back = findViewById(R.id.arrow_back);
        album_image = findViewById(R.id.album_image);
        album_artist = findViewById(R.id.album_artist);
        album_title = findViewById(R.id.album_title);
        album_description = findViewById(R.id.album_description);
        genre_list_rv = findViewById(R.id.genre_list_rv);
        albumDetailViewModel = new ViewModelProvider(this).get(AlbumDetailViewModel.class);
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
    public void onItemClick(int position) {
        Intent intent = new Intent(AlbumDetailActivity.this, TagDetailActivity.class);
        intent.putExtra("tag", tagList.get(position));
        startActivity(intent);
    }
}