package com.example.musicwiki.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.musicwiki.Model.BaseResponseTopTags;
import com.example.musicwiki.Model.Tags;
import com.example.musicwiki.Network.ApiClient;
import com.example.musicwiki.Network.ApiService;
import com.example.musicwiki.Utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopTagsRepository {

    private ApiService apiService;

    public TopTagsRepository(){
        //creating retrofit instance
        apiService = ApiClient.getInstance().getMyApi();
    }

    public LiveData<List<Tags>> getTopTags(int num_res, int offset){
        MutableLiveData<List<Tags>> topTagsListLiveData = new MutableLiveData<>();

        apiService.getTopTags("tag.getTopTags", Constants.API_KEY, Constants.format,num_res, offset)
                .enqueue(new Callback<BaseResponseTopTags>() {
                    @Override
                    public void onResponse(Call<BaseResponseTopTags> call, Response<BaseResponseTopTags> response) {
                        if(response.body() != null) {
                            topTagsListLiveData.setValue(response.body().getToptags().getTag());
                        }else{
                            topTagsListLiveData.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseTopTags> call, Throwable t) {
                        topTagsListLiveData.setValue(null);
                    }
                });

        return topTagsListLiveData;
    }

}
