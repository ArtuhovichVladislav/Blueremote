package com.blueremote.blueremote;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

class ConnectThread extends Thread {
    private BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;

    public ConnectThread(BluetoothDevice device) {

        BluetoothSocket tmp = null;
        mmDevice = device;
        try {
            UUID uuid = UUID.fromString("0f2b61c1-8be2-40e6-ab90-e735818da0a7");
            tmp = mmDevice.createRfcommSocketToServiceRecord(uuid);

        } catch (IOException e) {
        }
        mmSocket = tmp;
    }

    public void run() {
        try {
            mmSocket.connect();
            if(mmSocket.isConnected())
                MainActivity.check = false;

        } catch (IOException connectException) {
            try {
                mmSocket.close();
            } catch (IOException closeException) {
            }
            return;
        }
    }

    public BluetoothSocket getMmSocket() {
        return mmSocket;
    }

    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) {
        }
        mmSocket = null;
    }
}
