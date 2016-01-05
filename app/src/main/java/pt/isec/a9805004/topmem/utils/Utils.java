package pt.isec.a9805004.topmem.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import pt.isec.a9805004.topmem.TopMemApp;

public class Utils {

    /**
     * Gets the device's ip
     *
     * @return
     */
    @SuppressLint("DefaultLocale")
    public static String getDeviceIp() {
        final WifiManager wifiMan = (WifiManager) TopMemApp.getInstance().getContext().getSystemService(Context.WIFI_SERVICE);
        final WifiInfo wifiInf = wifiMan.getConnectionInfo();
        final int ipAddress = wifiInf.getIpAddress();
        return String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
    }
}