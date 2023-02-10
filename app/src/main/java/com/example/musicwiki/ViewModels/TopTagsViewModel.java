package com.example.musicwiki.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.musicwiki.Model.Tags;
import com.example.musicwiki.Repositories.TopTagsRepository;

import java.util.List;

public class TopTagsViewModel extends ViewModel {

    TopTagsRepository topTagsRepository;

    public TopTagsViewModel(){
        topTagsRepository = new TopTagsRepository();
    }

    public LiveData<List<Tags>> getTopTagsList(int num_res, int offset){
        return topTagsRepository.getTopTags(num_res, offset);
    }
}
