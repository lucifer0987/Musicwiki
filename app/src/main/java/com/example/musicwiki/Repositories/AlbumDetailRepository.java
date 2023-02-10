package com.example.musicwiki.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.musicwiki.Model.AlbumDetails;
import com.example.musicwiki.Model.BaseResponseAlbumDetails;
import com.example.musicwiki.Model.TagDetails;
import com.example.musicwiki.Model.Tags;
import com.example.musicwiki.Network.ApiClient;
import com.example.musicwiki.Network.ApiService;
import com.example.musicwiki.Utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumDetailRepository {

    private ApiService apiService;

    public AlbumDetailRepository(){
        //creating retrofit instance
        apiService = ApiClient.getInstance().getMyApi();
    }

    public LiveData<AlbumDetails> getAlbumDetails(String album, String artist){
        MutableLiveData<AlbumDetails> baseResponseAlbumDetailsMutableLiveData = new MutableLiveData<>();

        apiService.getAlbumDetails("album.getinfo", artist, album, Constants.API_KEY, Constants.format)
                .enqueue(new Callback<BaseResponseAlbumDetails>() {
                    @Override
                    public void onResponse(Call<BaseResponseAlbumDetails> call, Response<BaseResponseAlbumDetails> response) {
                        assert response.body() != null;
                        baseResponseAlbumDetailsMutableLiveData.setValue(response.body().getAlbum());
                    }

                    @Override
                    public void onFailure(Call<BaseResponseAlbumDetails> call, Throwable t) {
                        baseResponseAlbumDetailsMutableLiveData.setValue(null);
                    }
                });

        return baseResponseAlbumDetailsMutableLiveData;
    }

}
