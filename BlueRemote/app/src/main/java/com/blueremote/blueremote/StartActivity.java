package com.blueremote.blueremote;

import android.bluetooth.BluetoothDevice;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class StartActivity extends ActionBarActivity {
    private Button bPaired = null;

    private ArrayAdapter<Item> mpArrayAdpater = null;
    private ListView pairedList = null;
    private Set<BluetoothDevice> pairedDevices = null;
    public static ConnectThread connector = null;

    private List<Item> pSet = null;
    private int connectionCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        bPaired = (Button) findViewById(R.id.button3);
        pSet = new ArrayList<Item>();

        mpArrayAdpater = new ArrayAdapter<Item>(getApplicationContext(),android.R.layout.simple_list_item_1, pSet);

        pairedList = (ListView) findViewById(R.id.listPaired);
        pairedList.setAdapter(mpArrayAdpater);

        bPaired.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pairedDevices = MainActivity.mbluetoothAdapter.getBondedDevices();
                mpArrayAdpater.clear();
                if(connectionCount % 2 == 0){
                    if(MainActivity.check == false) {
                        connector.cancel();

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getApplicationContext(), "disconnected", Toast.LENGTH_SHORT).show();
                        for (int i = 1; i < 6; i++)
                            MainActivity.tabHost.getTabWidget().getChildTabViewAt(i).setEnabled(false);
                        MainActivity.check = true;
                    }

                    bPaired.setText(" СПИСОК УСТРОЙСТВ ");
                    connectionCount++;
                }
                else{
                    if (pairedDevices.size() > 0) {
                        for (BluetoothDevice bdevice : pairedDevices) {
                            Item item = new Item(bdevice.getName(), bdevice);
                            mpArrayAdpater.add(item);
                        }
                    }
                    pairedList.setVisibility(View.VISIBLE);
                }
            }
        });

        pairedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Item item = (Item) parent.getAdapter().getItem(position);
                String texte = item.getDevName() + " "+ item.getBdevice().getAddress();
                Toast.makeText(getApplicationContext(), texte, Toast.LENGTH_SHORT).show();

                connector = new ConnectThread(item.getBdevice());
                connector.start();

                long start = System.currentTimeMillis();
                while(MainActivity.check != false){
                    if((System.currentTimeMillis() - start) >= 7000)
                        break;
                }

                if(MainActivity.check == false) {
                    for (int i = 1; i < 6; i++)
                        MainActivity.tabHost.getTabWidget().getChildTabViewAt(i).setEnabled(true);
                    connectionCount++;
                    Toast.makeText(getApplicationContext(), "connected", Toast.LENGTH_SHORT).show();
                    bPaired.setText(" Disconnect ");
                    pairedList.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(getApplicationContext(), "connection error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}