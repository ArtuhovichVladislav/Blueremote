package com.blueremote.blueremote;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

public class MouseActivity extends ActionBarActivity implements View.OnClickListener {
    public static final String PLAY="play";
    public static final String RIGHT_MOUSE_BTN="right_mouse";
    public static final String LEFT_MOUSE_BTN="left_mouse";
    public static final String BACK_SPACE_BTN="back_space";
    public static final String ENTER = "enter";
    private boolean FLAG = true;
    Context context;
    Button KeyboardButton;
    Button rightButton;
    Button leftButton;
    Button hideKeyb;
    TextView mousePad;

    EditText editText;

    private boolean mouseMoved=false;

    private float initX =0;
    private float initY =0;
    private float disX =0;
    private float disY =0;
    OutputStream out = null;
    int counter = 0;

    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse2);

        context = this;

        KeyboardButton = (Button)findViewById(R.id.keyboardAndr);
        rightButton = (Button)findViewById(R.id.rightMousebtn);
        leftButton = (Button)findViewById(R.id.leftMousebtn);
        editText = (EditText)findViewById(R.id.editText);
        hideKeyb = (Button)findViewById(R.id.hideKeyb);
        hideKeyb.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);

        KeyboardButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        hideKeyb.setOnClickListener(this);

       editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    if(s.length() == 1)
                    {
                        out.write((s.charAt(0) + "\n").getBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               if(s.length() == 0)
               {
                   FLAG = true;
                   return;
               }
               if((s.length()-1)>0 && count!=0){
                   FLAG = false;
                   if(s.toString().substring(start).contains("\n"))
                   {
                       try {
                           out = StartActivity.connector.getMmSocket().getOutputStream();
                           out.write((ENTER + '\n').getBytes());
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
                    else if(count!=0)
                       try {
                        out = StartActivity.connector.getMmSocket().getOutputStream();
                        if(s.length() == 1)
                        {
                            out.write((s.charAt(0) + "\n").getBytes());
                        }
                        if (s.length() > 0)
                            out.write((s.charAt(s.length() - 1) + "\n").getBytes());
                        else
                            return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(count == 0)
                {
                        try {
                            out = StartActivity.connector.getMmSocket().getOutputStream();
                            out.write((BACK_SPACE_BTN + '\n').getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }
        });

        editText.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(FLAG)
                {
                    if(keyCode == KeyEvent.KEYCODE_DEL)
                        try {
                            counter++;
                            if(counter % 2 == 0)
                                return false;
                            out = StartActivity.connector.getMmSocket().getOutputStream();
                            out.write((BACK_SPACE_BTN + '\n').getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
                return false;
            }
        });
        mousePad = (TextView)findViewById(R.id.mousePad);

        mousePad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            initX =event.getX();
                            initY =event.getY();
                            mouseMoved=false;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            disX = event.getX()- initX;
                            disY = event.getY()- initY;
                            initX = event.getX();
                            initY = event.getY();
                            if(disX !=0|| disY !=0){
                                try {
                                    out = StartActivity.connector.getMmSocket().getOutputStream();
                                    out.write((disX +","+ disY+'\n').getBytes());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            mouseMoved=true;
                            break;
                        case MotionEvent.ACTION_UP:
                            if(!mouseMoved){
                                try {
                                    out = StartActivity.connector.getMmSocket().getOutputStream();
                                    out.write((LEFT_MOUSE_BTN+'\n').getBytes());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            break;
                    }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rightMousebtn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((RIGHT_MOUSE_BTN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.leftMousebtn:
                try {
                    out = StartActivity.connector.getMmSocket().getOutputStream();
                    out.write((LEFT_MOUSE_BTN+'\n').getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.keyboardAndr:
                mousePad.setEnabled(false);
                editText.setVisibility(View.VISIBLE);
                hideKeyb.setVisibility(View.VISIBLE);
                editText.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                break;
            case R.id.hideKeyb:
                mousePad.setEnabled(true);
                editText.setVisibility(View.INVISIBLE);
                editText.setText("");
                hideKeyb.setVisibility(View.INVISIBLE);
        }
    }
}