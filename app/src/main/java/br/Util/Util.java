
package br.Util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import android.util.AndroidException;

public class Util extends Activity {


    public static boolean checarConexaoCelular(Context ctx){

        boolean  conectado = false;

        try{

            final ConnectivityManager connMgr = (ConnectivityManager)ctx.getSystemService(ctx.CONNECTIVITY_SERVICE);

            final android.net.NetworkInfo Wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if(Wifi.getState() == NetworkInfo.State.CONNECTED){
                conectado = true;
            }
            if(mobile.getState() == NetworkInfo.State.CONNECTED){
                conectado = true;
            }




        }catch (Exception e){

            conectado = false;

        }



        return conectado;
    }
}
