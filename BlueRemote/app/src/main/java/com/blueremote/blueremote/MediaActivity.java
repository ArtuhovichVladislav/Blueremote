package com.blueremote.blueremote;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;

public class MediaActivity extends ActionBarActivity {

    public static final String PLAY_BTN="play";
    public static final String NEXT_BTN="next";
    public static final String PREV_BTN="prev";

    public static final String VOL_UP="vol_up";
    public static final String VOL_DOWN="vol_down";
    public static final String VOL_MUTE="mute";

    public static final String MEDIA_PLAYER="player";

    private Button bNext = null;
    private Button bPrev = null;
    private Button bPlay = null;

    private Button bVolUp = null;
    private Button bVolDown = null;
    private Button bMute = null;

    private Button bPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_activity);
        bPlay = (Button) findViewById(R.id.playbtn);
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((PLAY_BTN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bNext = (Button) findViewById(R.id.nextbtn);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((NEXT_BTN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bPrev = (Button) findViewById(R.id.prevBtn);
        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((PREV_BTN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bVolUp = (Button) findViewById(R.id.volume_up);
        bVolUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((VOL_UP+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bVolDown = (Button) findViewById(R.id.volume_down);
        bVolDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((VOL_DOWN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bMute = (Button) findViewById(R.id.volume_mute);
        bMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((VOL_MUTE+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bPlayer = (Button) findViewById(R.id.mediaPlayerBtn);
        bPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((MEDIA_PLAYER+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
