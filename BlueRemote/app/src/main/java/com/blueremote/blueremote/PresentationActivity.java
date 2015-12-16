package com.blueremote.blueremote;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;

public class PresentationActivity extends ActionBarActivity implements View.OnClickListener{
    public static final String FROM_START_BTN="from_start";
    public static final String FROM_NOW_BTN="from_now";
    public static final String PREV_SLIDE_BTN="prev_slide";
    public static final String FORW_SLIDE_BTN="forw_slide";
    public static final String EXIT_FULLSCREEN_BTN="exit_fullscreen";
    public static final String POWER_POINT = "powerpoint";

    Button FromStartButton;
    Button FromNowButton;
    Button prevButton;
    Button forwButton;
    Button exitButton;
    Button powerPointButton;
    OutputStream out = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_activity);

        FromStartButton = (Button)findViewById(R.id.fromStartBtn);
        FromNowButton = (Button)findViewById(R.id.fromNowBtn);
        prevButton = (Button)findViewById(R.id.backBtn);
        forwButton = (Button)findViewById(R.id.forwardBtn);
        exitButton = (Button)findViewById(R.id.exitBtn);
        powerPointButton = (Button)findViewById(R.id.startPwrPoint);

        FromStartButton.setOnClickListener(this);
        FromNowButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        forwButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
        powerPointButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.backBtn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((PREV_SLIDE_BTN + '\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.forwardBtn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((FORW_SLIDE_BTN + '\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.fromNowBtn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((FROM_NOW_BTN + '\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.fromStartBtn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((FROM_START_BTN + '\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.exitBtn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((EXIT_FULLSCREEN_BTN + '\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.startPwrPoint:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((POWER_POINT + '\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
