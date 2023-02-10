package com.example.musicwiki.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicwiki.Model.Tags;
import com.example.musicwiki.R;

import java.util.ArrayList;
import java.util.List;

public class TopTagsAdapter extends RecyclerView.Adapter<TopTagsAdapter.ViewHolder> {

    List<Tags> topTagsList = new ArrayList<>();
    private onItemClicked onItemClickedInterface = null;

    public TopTagsAdapter(List<Tags> topTagsList, onItemClicked onItemClickedInterface){
        this.topTagsList = topTagsList;
        this.onItemClickedInterface = onItemClickedInterface;
    }

    public interface onItemClicked{
        void onTagClicked(int position);
    }

    @NonNull
    @Override
    public TopTagsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.tag_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopTagsAdapter.ViewHolder holder, int position) {
        holder.tagName.setText(topTagsList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickedInterface != null){
                    onItemClickedInterface.onTagClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return topTagsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tagName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagName = itemView.findViewById(R.id.tag_name);
        }
    }
}
