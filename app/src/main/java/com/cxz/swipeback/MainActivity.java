package com.cxz.swipeback;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

import com.cxz.swipelibrary.SwipeBackActivity;
import com.cxz.swipelibrary.SwipeBackLayout;
/**
 * Created by chenxz on 2017/2/17.
 */
public class MainActivity extends SwipeBackActivity {

    private static final int VIBRATE_DURATION = 20;

    private Toolbar mToolbar;

    private RadioGroup mRadioGroup;

    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(mToolbar);
        mRadioGroup = (RadioGroup) findViewById(R.id.tracking_mode);

        mSwipeBackLayout = getSwipeBackLayout();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int edgeFlag = 0;
                switch (checkedId){
                    case R.id.mode_left:
                        edgeFlag = SwipeBackLayout.EDGE_LEFT;
                        break;
                    case R.id.mode_right:
                        edgeFlag = SwipeBackLayout.EDGE_RIGHT;
                        break;
                    case R.id.mode_bottom:
                        edgeFlag = SwipeBackLayout.EDGE_BOTTOM;
                        break;
                    case R.id.mode_all:
                        edgeFlag = SwipeBackLayout.EDGE_ALL;
                        break;
                }
                mSwipeBackLayout.setEdgeTrackingEnabled(edgeFlag);
            }
        });

        mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {

            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                vibrate(VIBRATE_DURATION);
            }

            @Override
            public void onScrollOverThreshold() {
                vibrate(VIBRATE_DURATION);
            }
        });
    }

    public void start(View view){
        startActivity(new Intent(MainActivity.this,MainActivity.class));
    }

    public void finish(View view){
        scrollToFinishActivity();
    }

    private void vibrate(long duration) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0, duration};
        vibrator.vibrate(pattern, -1);
    }
}
