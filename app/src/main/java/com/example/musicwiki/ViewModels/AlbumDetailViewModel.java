package com.example.musicwiki.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicwiki.Model.AlbumDetails;
import com.example.musicwiki.Repositories.AlbumDetailRepository;

public class AlbumDetailViewModel extends ViewModel {

    AlbumDetailRepository albumDetailRepository;

    public AlbumDetailViewModel(){
        albumDetailRepository = new AlbumDetailRepository();
    }

    public LiveData<AlbumDetails> getAlbumDetails(String album, String artist){
        return albumDetailRepository.getAlbumDetails(album, artist);
    }

}
