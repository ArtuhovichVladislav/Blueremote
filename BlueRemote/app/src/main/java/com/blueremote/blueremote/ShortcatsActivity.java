package com.blueremote.blueremote;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;


public class ShortcatsActivity extends ActionBarActivity implements View.OnClickListener {
    public static final String COPY="copy";
    public static final String PASTE="paste";
    public static final String CUT="cut";
    public static final String SELECT_ALL="select_all";
    public static final String SHOW_DESKTOP="show_desktop";
    public static final String FULL_SCREEN="full_screen";
    public static final String MINIMIZE_WINDOW="minimize_window";
    public static final String ESC="esc";
    public static final String F1="F1";
    public static final String F2="F2";
    public static final String F3="F3";
    public static final String F4="F4";
    public static final String F5="F5";
    public static final String F6="F6";
    public static final String F7="F7";
    public static final String F8="F8";
    public static final String F9="F9";
    public static final String F10="F10";
    public static final String F11="F11";
    public static final String F12="F12";

    Button CopyButton;
    Button PasteButton;
    Button CutButton;
    Button SelectAllButton;
    Button FullScreenButton;
    Button ShowDesktopButton;
    Button MinimizeWindowButton;
    Button ESCButton;
    Button F1Button;
    Button F2Button;
    Button F3Button;
    Button F4Button;
    Button F5Button;
    Button F6Button;
    Button F7Button;
    Button F8Button;
    Button F9Button;
    Button F10Button;
    Button F11Button;
    Button F12Button;
    OutputStream out = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shortcats);

        CopyButton = (Button)findViewById(R.id.ctrl_c);
        PasteButton = (Button)findViewById(R.id.ctrl_v);
        CutButton = (Button)findViewById(R.id.ctrl_x);
        SelectAllButton = (Button)findViewById(R.id.ctrl_a);
        ShowDesktopButton = (Button)findViewById(R.id.win_d);
        MinimizeWindowButton = (Button)findViewById(R.id.win_down);
        FullScreenButton = (Button)findViewById(R.id.win_up);
        ESCButton = (Button)findViewById(R.id.esc_btn);
        F1Button = (Button)findViewById(R.id.f1);
        F2Button = (Button)findViewById(R.id.f2);
        F3Button = (Button)findViewById(R.id.f3);
        F4Button = (Button)findViewById(R.id.f4);
        F5Button = (Button)findViewById(R.id.f5);
        F6Button = (Button)findViewById(R.id.f6);
        F7Button = (Button)findViewById(R.id.f7);
        F8Button = (Button)findViewById(R.id.f8);
        F9Button = (Button)findViewById(R.id.f9);
        F10Button = (Button)findViewById(R.id.f10);
        F11Button = (Button)findViewById(R.id.f11);
        F12Button = (Button)findViewById(R.id.f12);

        CopyButton.setOnClickListener(this);
        PasteButton.setOnClickListener(this);
        CutButton.setOnClickListener(this);
        SelectAllButton.setOnClickListener(this);
        ShowDesktopButton.setOnClickListener(this);
        MinimizeWindowButton.setOnClickListener(this);
        FullScreenButton.setOnClickListener(this);
        ESCButton.setOnClickListener(this);
        F1Button.setOnClickListener(this);
        F2Button.setOnClickListener(this);
        F3Button.setOnClickListener(this);
        F4Button.setOnClickListener(this);
        F5Button.setOnClickListener(this);
        F6Button.setOnClickListener(this);
        F7Button.setOnClickListener(this);
        F8Button.setOnClickListener(this);
        F9Button.setOnClickListener(this);
        F10Button.setOnClickListener(this);
        F11Button.setOnClickListener(this);
        F12Button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctrl_c:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((COPY+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ctrl_v:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((PASTE+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ctrl_x:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((CUT+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ctrl_a:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((SELECT_ALL+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.win_d:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((SHOW_DESKTOP+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.win_up:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((FULL_SCREEN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.win_down:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((MINIMIZE_WINDOW+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.esc_btn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((ESC+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f1:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F1+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f2:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F2+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f3:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F3+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f4:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F4+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f5:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F5+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f6:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F6+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f7:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F7+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f8:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F8+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f9:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F9+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f10:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F10+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f11:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F11+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.f12:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((F12+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
