package com.example.musicwiki.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.musicwiki.Model.TagDetailsService;
import com.example.musicwiki.R;
import com.example.musicwiki.Adapters.TagDetailAdapter;
import com.example.musicwiki.ViewModels.TagDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

public class TagDetailActivity extends AppCompatActivity
implements TagDetailAdapter.onItemClicked{

    RelativeLayout main_layout;
    ProgressBar progress_bar;
    TextView tag_name, tag_description;
    ImageView arrow_back;
    String tagNameStr = "";
    TagDetailsViewModel tagDetailsViewModel;
    LinearLayout tabs_area, albums_area, artists_area, tracks_area;
    TextView albums_area_txt, artists_area_txt, tracks_area_txt;
    View albums_area_line, artists_area_line, tracks_area_line;
    RecyclerView tag_details_tab_rv;
    TagDetailAdapter adapter;
    GridLayoutManager layoutManager;
    List<TagDetailsService> list = new ArrayList<>();
    int tagPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_detail);

        initView();
        makeInvisible();
        tagNameStr = getIntent().getStringExtra("tag");
        tag_name.setText(tagNameStr);

        adapter = new TagDetailAdapter(TagDetailActivity.this, this);
        layoutManager = new GridLayoutManager(this, 2);
        tag_details_tab_rv.setLayoutManager(layoutManager);
        tag_details_tab_rv.setAdapter(adapter);

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        albums_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTabClick(albums_area);
            }
        });

        artists_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTabClick(artists_area);
            }
        });

        tracks_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTabClick(tracks_area);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        makeInvisible();
        if(!tagNameStr.equals("")){
            getTagDetails();
        }else{
            makeVisible();
            tag_description.setVisibility(View.GONE);
            tabs_area.setVisibility(View.GONE);
        }
    }

    private void getTagDetails() {
        tagDetailsViewModel.getTopTagsList(tagNameStr).observe(this, tagDetailsResponse -> {
            if(tagDetailsResponse.getWiki() != null && !tagDetailsResponse.getWiki().getSummary().equals("")) {
                tag_description.setVisibility(View.VISIBLE);
                tag_description.setText(tagDetailsResponse.getWiki().getSummary());
                handleTabClick(albums_area);
                getTagAlbumsDetails();
            }else{
                tag_description.setVisibility(View.GONE);
            }
        });
    }

    private void getTagAlbumsDetails() {
        tagDetailsViewModel.getAlbumListByTag(tagNameStr, 30).observe(this, tagAlbumResponse -> {

            list.clear();
            for(int i = 0; i < tagAlbumResponse.getAlbum().size(); i++){
                TagDetailsService tagDetailsService = new TagDetailsService();
                tagDetailsService.setImage(tagAlbumResponse.getAlbum().get(i).getImage().get(3).getText());
                tagDetailsService.setTitle(tagAlbumResponse.getAlbum().get(i).getName());
                tagDetailsService.setArtist(tagAlbumResponse.getAlbum().get(i).getArtist().getName());
                list.add(tagDetailsService);
            }

            adapter.setData(list);
            makeVisible();

        });

    }

    private void getTagArtistsDetails() {
        tagDetailsViewModel.getArtistListByTag(tagNameStr, 30).observe(this, tagArtistResponse -> {

            list.clear();
            for(int i = 0; i < tagArtistResponse.getArtist().size(); i++){
                TagDetailsService tagDetailsService = new TagDetailsService();
                tagDetailsService.setImage(tagArtistResponse.getArtist().get(i).getImage().get(3).getText());
                tagDetailsService.setTitle(tagArtistResponse.getArtist().get(i).getName());
                tagDetailsService.setArtist("");
                list.add(tagDetailsService);
            }

            adapter.setData(list);
            makeVisible();

        });

    }

    private void getTagTracksDetails() {
        tagDetailsViewModel.getTrackListByTag(tagNameStr, 30).observe(this, tagTracksResponse -> {

            list.clear();
            for(int i = 0; i < tagTracksResponse.getTrack().size(); i++){
                TagDetailsService tagDetailsService = new TagDetailsService();
                tagDetailsService.setImage(tagTracksResponse.getTrack().get(i).getImage().get(3).getText());
                tagDetailsService.setTitle(tagTracksResponse.getTrack().get(i).getName());
                tagDetailsService.setArtist(tagTracksResponse.getTrack().get(i).getArtist().getName());
                list.add(tagDetailsService);
            }

            adapter.setData(list);
            makeVisible();

        });
    }

    private void initView() {
        main_layout = findViewById(R.id.main_layout);
        progress_bar = findViewById(R.id.progress_bar);
        arrow_back = findViewById(R.id.arrow_back);
        tag_name = findViewById(R.id.tag_name);
        tag_description = findViewById(R.id.tag_description);
        tagDetailsViewModel = new ViewModelProvider(this).get(TagDetailsViewModel.class);
        tag_details_tab_rv = findViewById(R.id.tag_details_tab_rv);

        tabs_area = findViewById(R.id.tabs_area);
        albums_area = findViewById(R.id.albums_area);
        artists_area = findViewById(R.id.artists_area);
        tracks_area = findViewById(R.id.tracks_area);

        albums_area_txt = findViewById(R.id.albums_area_txt);
        artists_area_txt = findViewById(R.id.artists_area_txt);
        tracks_area_txt = findViewById(R.id.tracks_area_txt);

        albums_area_line = findViewById(R.id.albums_area_line);
        artists_area_line = findViewById(R.id.artists_area_line);
        tracks_area_line = findViewById(R.id.tracks_area_line);
    }

    private void handleTabClick(LinearLayout layout) {
        if(layout == albums_area){
            albums_area_txt.setTypeface(null, Typeface.BOLD);
            albums_area_line.setVisibility(View.VISIBLE);
            if(tagPos != 0) {
                makeInvisible();
                getTagAlbumsDetails();
                tagPos = 0;
            }
        }else{
            albums_area_txt.setTypeface(null, Typeface.NORMAL);
            albums_area_line.setVisibility(View.GONE);
        }

        if(layout == artists_area){
            artists_area_txt.setTypeface(null, Typeface.BOLD);
            artists_area_line.setVisibility(View.VISIBLE);
            if(tagPos != 1) {
                makeInvisible();
                getTagArtistsDetails();
                tagPos = 1;
            }
        }else{
            artists_area_txt.setTypeface(null, Typeface.NORMAL);
            artists_area_line.setVisibility(View.GONE);
        }

        if(layout == tracks_area){
            tracks_area_txt.setTypeface(null, Typeface.BOLD);
            tracks_area_line.setVisibility(View.VISIBLE);
            if(tagPos != 2) {
                makeInvisible();
                getTagTracksDetails();
                tagPos = 2;
            }
        }else{
            tracks_area_txt.setTypeface(null, Typeface.NORMAL);
            tracks_area_line.setVisibility(View.GONE);
        }
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
        if(tagPos == 0){
            Intent intent = new Intent(TagDetailActivity.this, AlbumDetailActivity.class);
            intent.putExtra("album", list.get(position).getTitle());
            intent.putExtra("artist", list.get(position).getArtist());
            startActivity(intent);
        }
    }
}