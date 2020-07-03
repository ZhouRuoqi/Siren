package com.Siren.MusicPlayer.ui.recommend.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Siren.MusicPlayer.data.jsonmodel.MyMusicList;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import com.Siren.MusicPlayer.R;

public class CategoryMusicAdapter extends RecyclerView.Adapter<CategoryMusicAdapter.MusicViewHolder> {
    List<MyMusicList> myMusicLists;
    private Context mContext;
    CategoryMusicListener itemClick;
    public interface CategoryMusicListener {
        void clickItem(MyMusicList myMusicList);
    }

    public void setOnCategoryMusicListener(CategoryMusicListener listener) {
        itemClick = listener;
    }

    public CategoryMusicAdapter(Context context, List<MyMusicList> myMusicLists){
        this.myMusicLists = myMusicLists;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MusicViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_category_music,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder viewHolder,  int i) {
        viewHolder.musicListName.setText(myMusicLists.get(i).getListName());
        Glide.with(mContext)
                .load(myMusicLists.get(i).getImageUrl())
                .apply(new RequestOptions()
                .placeholder(R.mipmap.bro1)
                .error(R.mipmap.bro2))
                .into(viewHolder.musicListCover);
        final MyMusicList myMusicListT = myMusicLists.get(i);
        viewHolder.musicListCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.clickItem(myMusicListT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myMusicLists.size();
    }

    class MusicViewHolder extends RecyclerView.ViewHolder{
        ImageView musicListCover;
        TextView musicListName;
        public MusicViewHolder(View view){
            super(view);
            musicListCover = view.findViewById(R.id.iv_item_category_novel_cover);
            musicListName = view.findViewById(R.id.tv_item_category_novel_name);
        }
    }
}
