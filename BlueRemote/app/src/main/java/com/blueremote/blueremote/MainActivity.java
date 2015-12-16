package com.blueremote.blueremote;
import android.app.TabActivity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;


public class MainActivity extends TabActivity {
    private static final int REQUEST_ENABLE_BT = 1;

    public static BluetoothAdapter mbluetoothAdapter = null;
    public static boolean check = true;

    public ConnectThread connector = null;
    static TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources ressources = getResources();

        tabHost = getTabHost();
        tabHost.getTabWidget().setBackgroundColor(Color.parseColor("#34495e"));
        TabHost.TabSpec ts0 = tabHost.newTabSpec("Start");
        ts0.setIndicator("", ressources.getDrawable(R.drawable.homeicon));
        ts0.setContent(new Intent(this, StartActivity.class));
        tabHost.addTab(ts0);

        TabHost.TabSpec ts1 = tabHost.newTabSpec("keyboard");
        ts1.setIndicator("", ressources.getDrawable(R.drawable.pusk));
        ts1.setContent(new Intent(this, KeyboardActivity.class));
        tabHost.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("media");
        ts2.setIndicator("", ressources.getDrawable(R.drawable.media2));
        ts2.setContent(new Intent(this, MediaActivity.class));
        tabHost.addTab(ts2);

        TabHost.TabSpec ts3 = tabHost.newTabSpec("present");
        ts3.setIndicator("", ressources.getDrawable(R.drawable.present));
        ts3.setContent(new Intent(this, PresentationActivity.class));
        tabHost.addTab(ts3);

        TabHost.TabSpec ts4 = tabHost.newTabSpec("mouse");
        ts4.setIndicator("", ressources.getDrawable(R.drawable.mouse));
        ts4.setContent(new Intent(this, MouseActivity.class));
        tabHost.addTab(ts4);

        TabHost.TabSpec ts5 = tabHost.newTabSpec("shortcats");
        ts5.setIndicator("", ressources.getDrawable(R.drawable.tools));
        ts5.setContent(new Intent(this, ShortcatsActivity.class));
        tabHost.addTab(ts5);

        if(check == true) {
            for (int i = 1; i < 6; i++)
                tabHost.getTabWidget().getChildTabViewAt(i).setEnabled(false);
        }

        mbluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mbluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),"device do not support bluetooth ", Toast.LENGTH_LONG)
                    .show();
        }

        if (!mbluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_ENABLE_BT) {
            Toast.makeText(getApplicationContext(),
                    "Bluetooth enabled perfectly", Toast.LENGTH_SHORT).show();
        }
    }
}



