package com.Siren.MusicPlayer.ui.search;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.Siren.MusicPlayer.R;
import com.Siren.MusicPlayer.RxBus;
import com.Siren.MusicPlayer.data.jsonmodel.BodyBean;
import com.Siren.MusicPlayer.data.model.PlayList;
import com.Siren.MusicPlayer.data.model.Song;
import com.Siren.MusicPlayer.event.PlayListNowEvent;
import com.Siren.MusicPlayer.ui.base.BaseActivity;
import com.Siren.MusicPlayer.ui.playlist.AddToPlayListDialogFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements SearchContract.View ,SearchContract.ActionCallback{

    @BindView(R.id.rv_music_search)
    RecyclerView musicComment;
    @BindView(R.id.toolbar_music_search)
    Toolbar toolbar;
    @BindView(R.id.search_input_text)
    TextView mySearchContent;
    @BindView(R.id.search_input_send)
    Button toSearch;
    @BindView(R.id.search_progress)
    ProgressBar searchProgress;
    SearchContract.Presenter presenter;
    SearchAdapter adapter;
    List<BodyBean> searchResult = new ArrayList<>();

    private Handler mhandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    searchProgress.setVisibility(View.INVISIBLE);
                    adapter.clearSongList();
                    adapter.notifyDataSetChanged();
                    break;

            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        supportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("搜索");
        }
        searchProgress.setVisibility(View.GONE);
        musicComment.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SearchAdapter(this,searchResult,this);
        musicComment.setAdapter(adapter);

        new SearchPresenter(this).start();
    }

    @OnClick(R.id.search_input_send)
    public void onSearchClick(){
        String searchKey = mySearchContent.getText().toString();
        if(!searchKey.isEmpty()){
            mySearchContent.setText("");
            presenter.search(searchKey);
            searchProgress.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void setAdapter(List<BodyBean> searchResult) {
//        Log.e("MusicComment","回调");
//        Log.e("MusicComment",Integer.toString(searchResult.size()));
        this.searchResult.clear();
        this.searchResult.addAll(searchResult);
        mhandler.sendMessage(mhandler.obtainMessage(1));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void handleError(Throwable e) {

    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onAction(View actionView, Song song) {
        final Song tmpsong = song;
        PopupMenu actionMenu = new PopupMenu(this, actionView, Gravity.END | Gravity.BOTTOM);
        actionMenu.inflate(R.menu.music_action);
        actionMenu.getMenu().findItem(R.id.menu_item_delete).setVisible(false);
        actionMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_add_to_play_list:
                        new AddToPlayListDialogFragment()
                                .setCallback(new AddToPlayListDialogFragment.Callback() {
                                    @Override
                                    public void onPlayListSelected(PlayList playList) {
                                        presenter.addSongToPlayList(tmpsong, playList);
                                    }
                                })
                                .show(getSupportFragmentManager().beginTransaction(), "AddToPlayList");
                        break;
                    case R.id.menu_item_delete:
                        break;
                }
                return true;
            }
        });
        actionMenu.show();
    }

    @Override
    public void OnClickItem(PlayList songs, int position) {
        RxBus.getInstance().post(new PlayListNowEvent(songs,position));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.stop();
    }
}
