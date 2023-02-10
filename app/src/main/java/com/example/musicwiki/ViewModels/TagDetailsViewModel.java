package com.example.musicwiki.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicwiki.Model.Albums;
import com.example.musicwiki.Model.Tags;
import com.example.musicwiki.Model.Topartists;
import com.example.musicwiki.Model.Tracks;
import com.example.musicwiki.Repositories.TagDetailsRepository;

public class TagDetailsViewModel extends ViewModel {

    TagDetailsRepository tagDetailsRepository;

    public TagDetailsViewModel(){
        tagDetailsRepository = new TagDetailsRepository();
    }

    public LiveData<Tags> getTopTagsList(String tag){
        return tagDetailsRepository.getTagDetails(tag);
    }

    public LiveData<Albums> getAlbumListByTag(String tag, int limit){
        return tagDetailsRepository.getAlbumListByTag(tag, limit);
    }

    public LiveData<Topartists> getArtistListByTag(String tag, int limit){
        return tagDetailsRepository.getArtistListByTag(tag, limit);
    }

    public LiveData<Tracks> getTrackListByTag(String tag, int limit){
        return tagDetailsRepository.getTrackListByTag(tag, limit);
    }

}
