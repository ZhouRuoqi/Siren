package com.Siren.MusicPlayer.ui.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;

import com.Siren.MusicPlayer.R;
import com.Siren.MusicPlayer.Web.TextHelper;
import com.Siren.MusicPlayer.ui.base.BaseActivity;
import com.Siren.MusicPlayer.ui.base.BaseFragment;
import com.Siren.MusicPlayer.ui.music.MusicPlayerFragment;
import com.Siren.MusicPlayer.ui.playlist.PlayListFragment;
import com.Siren.MusicPlayer.ui.recommend.RecommendFragment;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

import java.util.List;

public class MainActivity extends BaseActivity {

    static final int DEFAULT_PAGE_INDEX = 2;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindViews({R.id.radio_button_play_list, R.id.radio_button_music, R.id.radio_button_music_recommend})
    List<RadioButton> radioButtons;

    String[] mTitles;
    private long mExitTime = 0;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        // Main Controls' Titles
        mTitles = getResources().getStringArray(R.array.mp_main_titles);

        // Fragments
        BaseFragment[] fragments = new BaseFragment[mTitles.length];
        fragments[0] = new PlayListFragment();
        fragments[1] = new MusicPlayerFragment();
        fragments[2] = new RecommendFragment();
        fragments[3] = new RecommendFragment();
        fragments[4] = new RecommendFragment();

        // Inflate ViewPager
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), mTitles, fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.mp_margin_large));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Empty
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Empty
            }

            @Override
            public void onPageSelected(int position) {
                radioButtons.get(position).setChecked(true);
            }
        });

        radioButtons.get(DEFAULT_PAGE_INDEX).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - mExitTime < 2000){
            moveTaskToBack(true);
        }else {
            mExitTime = System.currentTimeMillis();
            TextHelper.showText("再按一次退出应用");
        }

    }

    @OnCheckedChanged({R.id.radio_button_play_list, R.id.radio_button_music, R.id.radio_button_music_recommend})
    public void onRadioButtonChecked(RadioButton button, boolean isChecked) {
        if (isChecked) {
            onItemChecked(radioButtons.indexOf(button));
        }
    }

    private void onItemChecked(int position) {
        viewPager.setCurrentItem(position);
        toolbar.setTitle(mTitles[position]);
    }


}
