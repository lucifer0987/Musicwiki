package com.example.musicwiki.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.musicwiki.Model.Album;
import com.example.musicwiki.Model.Albums;
import com.example.musicwiki.Model.BaseResponseTopAlbum;
import com.example.musicwiki.Model.BaseResponseTopArtist;
import com.example.musicwiki.Model.BaseResponseTopTracks;
import com.example.musicwiki.Model.TagDetails;
import com.example.musicwiki.Model.Tags;
import com.example.musicwiki.Model.Topartists;
import com.example.musicwiki.Model.Track;
import com.example.musicwiki.Model.Tracks;
import com.example.musicwiki.Network.ApiClient;
import com.example.musicwiki.Network.ApiService;
import com.example.musicwiki.Utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TagDetailsRepository {

    private ApiService apiService;

    public TagDetailsRepository(){
        //creating retrofit instance
        apiService = ApiClient.getInstance().getMyApi();
    }

    public LiveData<Tags> getTagDetails(String tag){
        MutableLiveData<Tags> tagsMutableLiveData = new MutableLiveData<>();

        apiService.getTagDetails("tag.getinfo", tag, Constants.API_KEY, Constants.format)
                .enqueue(new Callback<TagDetails>() {
                    @Override
                    public void onResponse(Call<TagDetails> call, Response<TagDetails> response) {
                        assert response.body() != null;
                        tagsMutableLiveData.setValue(response.body().getTag());
                    }

                    @Override
                    public void onFailure(Call<TagDetails> call, Throwable t) {
                        tagsMutableLiveData.setValue(null);
                    }
                });

        return tagsMutableLiveData;
    }

    public LiveData<Albums> getAlbumListByTag(String tag, int limit){
        MutableLiveData<Albums> albumMutableLiveData = new MutableLiveData<>();

        apiService.getAlbumListByTag("tag.gettopalbums", tag, Constants.API_KEY, limit, Constants.format)
                .enqueue(new Callback<BaseResponseTopAlbum>() {
                    @Override
                    public void onResponse(Call<BaseResponseTopAlbum> call, Response<BaseResponseTopAlbum> response) {
                        assert response.body() != null;
                        albumMutableLiveData.setValue(response.body().getAlbums());
                    }

                    @Override
                    public void onFailure(Call<BaseResponseTopAlbum> call, Throwable t) {
                        albumMutableLiveData.setValue(null);
                    }
                });

        return albumMutableLiveData;
    }

    public LiveData<Topartists> getArtistListByTag(String tag, int limit){
        MutableLiveData<Topartists> topartistsMutableLiveData = new MutableLiveData<>();

        apiService.getArtistListByTag("tag.gettopartists", tag, Constants.API_KEY, limit, Constants.format)
                .enqueue(new Callback<BaseResponseTopArtist>() {
                    @Override
                    public void onResponse(Call<BaseResponseTopArtist> call, Response<BaseResponseTopArtist> response) {
                        assert response.body() != null;
                        topartistsMutableLiveData.setValue(response.body().getTopartists());
                    }

                    @Override
                    public void onFailure(Call<BaseResponseTopArtist> call, Throwable t) {
                        topartistsMutableLiveData.setValue(null);
                    }
                });

        return topartistsMutableLiveData;
    }

    public LiveData<Tracks> getTrackListByTag(String tag, int limit){
        MutableLiveData<Tracks> tracksMutableLiveData = new MutableLiveData<>();

        apiService.getTrackListByTag("tag.gettoptracks", tag, Constants.API_KEY, limit, Constants.format)
                .enqueue(new Callback<BaseResponseTopTracks>() {
                    @Override
                    public void onResponse(Call<BaseResponseTopTracks> call, Response<BaseResponseTopTracks> response) {
                        assert response.body() != null;
                        tracksMutableLiveData.setValue(response.body().getTracks());
                    }

                    @Override
                    public void onFailure(Call<BaseResponseTopTracks> call, Throwable t) {
                        tracksMutableLiveData.setValue(null);
                    }
                });

        return tracksMutableLiveData;
    }


}
