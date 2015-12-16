package com.blueremote.blueremote;

import android.bluetooth.BluetoothDevice;

class Item {
    String devName;
    BluetoothDevice bdevice;

    public Item(String devName, BluetoothDevice bdevice) {
        super();
        this.devName = devName;
        this.bdevice = bdevice;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public BluetoothDevice getBdevice() {
        return bdevice;
    }

    public void setBdevice(BluetoothDevice bdevice) {
        this.bdevice = bdevice;
    }

    @Override
    public String toString() {
        return this.getDevName();
    }
}