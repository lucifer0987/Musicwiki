package com.example.musicwiki.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.musicwiki.Model.TagDetailsService;
import com.example.musicwiki.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class TagDetailAdapter extends RecyclerView.Adapter<TagDetailAdapter.ViewHolder> {

    List<TagDetailsService> data = new ArrayList<>();
    Context context;
    private onItemClicked onItemClickedInterface = null;

    public TagDetailAdapter(Context context, onItemClicked onItemClickedInterface){
        this.context = context;
        this.onItemClickedInterface = onItemClickedInterface;
    }

    public interface onItemClicked{
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public TagDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.tag_detail_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TagDetailAdapter.ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.artist.setText(data.get(position).getArtist());
        Picasso.get()
                .load(data.get(position).getImage())
                .placeholder(R.drawable.default_image)
                .error(R.drawable.default_image)
                .fit().into(holder.image);

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

        TextView artist, title;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artist = itemView.findViewById(R.id.artist);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
        }
    }

    public void setData(List<TagDetailsService> list){
        this.data = list;
        notifyDataSetChanged();
    }
}
