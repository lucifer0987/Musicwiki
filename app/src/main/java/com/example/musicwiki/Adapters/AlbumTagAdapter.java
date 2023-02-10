package com.example.musicwiki.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicwiki.R;

import java.util.ArrayList;
import java.util.List;

public class AlbumTagAdapter extends RecyclerView.Adapter<AlbumTagAdapter.ViewHolder>{

    List<String> data = new ArrayList<>();
    Context context;
    private onItemClicked onItemClickedInterface = null;

    public AlbumTagAdapter(Context context, onItemClicked onItemClickedInterface){
        this.context = context;
        this.onItemClickedInterface = onItemClickedInterface;
    }

    public interface onItemClicked{
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.album_tag_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tag_name.setText(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickedInterface != null){
                    onItemClickedInterface.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tag_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tag_name = itemView.findViewById(R.id.tag_name);
        }
    }

    public void setData(List<String> list){
        this.data = list;
        notifyDataSetChanged();
    }
}
