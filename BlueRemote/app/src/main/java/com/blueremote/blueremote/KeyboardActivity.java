package com.blueremote.blueremote;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.io.OutputStream;


public class KeyboardActivity extends ActionBarActivity {
    public static final String LEFT="left";
    public static final String RIGHT="right";
    public static final String UP="up";
    public static final String DOWN="down";
    public static final String ENTER="enter";
    public static final String CALC="calc";
    public static final String COMP="comp";
    public static final String BROW="brow";
    public static final String NOTE="note";
    public static final String CLOSE="close";
    public static final String BACK="back";
    public static final String FORW="forw";
    public static final String SELECT_WINDOW="select_window";
    public static final String START = "start";
    public static final String SHUTDOWN = "shutdown";

    private Button bForward = null;
    private Button bRight = null;
    private Button bUp = null;
    private Button bDown = null;
    private Button bStart = null;
    private Button bCalc = null;
    private Button bComp = null;
    private Button bBrow = null;
    private Button bNote = null;
    private Button bPusk = null;
    private Button bShutdown = null;
    private Button bClose = null;
    private Button bBack = null;
    private Button bForw = null;
    private Button bSelectWindow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_activity);

        bForward = (Button) findViewById(R.id.btnLeft);
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((LEFT+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bRight = (Button) findViewById(R.id.btnRight);
        bRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((RIGHT+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bUp = (Button) findViewById(R.id.btnUp);
        bUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((UP+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bDown = (Button) findViewById(R.id.btnDown);
        bDown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((DOWN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bStart = (Button) findViewById(R.id.btnStart);
        bStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((ENTER+'\n').getBytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bCalc = (Button) findViewById(R.id.btnCalc);
        bCalc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((CALC+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bComp = (Button) findViewById(R.id.btnExpl);
        bComp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((COMP+'\n').getBytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bBrow = (Button) findViewById(R.id.btnBrowser);
        bBrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((BROW+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bBack = (Button) findViewById(R.id.btnBack);
        bBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((BACK+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bForw = (Button) findViewById(R.id.btnForw);
        bForw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((FORW+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bClose = (Button) findViewById(R.id.btnClose);
        bClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((CLOSE+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bSelectWindow = (Button) findViewById(R.id.alt_tab);
        bSelectWindow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        out.write((SELECT_WINDOW+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bPusk  = (Button) findViewById(R.id.puskBtn);
        bPusk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((START+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bNote = (Button) findViewById(R.id.noteBtn);
        bNote.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((NOTE+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bShutdown  = (Button) findViewById(R.id.shutButn);
        bShutdown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutputStream out = null;
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((SHUTDOWN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
