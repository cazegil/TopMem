package pt.isec.a9805004.topmem.lib.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;
import java.util.Map;

import pt.isec.a9805004.topmem.lib.event.response.PlayerMoveResponse;
import pt.isec.a9805004.topmem.lib.event.response.StartServerResponse;
import pt.isec.a9805004.topmem.lib.logger.Log;
import pt.isec.a9805004.topmem.lib.manager.EventManager;
import pt.isec.a9805004.topmem.lib.server.NanoHTTPD.Response.Status;
import pt.isec.a9805004.topmem.utils.Utils;

public class HTTPService extends Service {

    private static final String TAG = HTTPService.class.getSimpleName();

    private WebServer server;
    private final IBinder mBinder = new LocalBinder();

    public static String ip;
    public static int port;
    public static final Object lock = new Object();

    public class LocalBinder extends Binder {

        HTTPService getService() {
            return HTTPService.this;
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        server = new WebServer();

        try {
            server.start();
            port = server.getListeningPort();
            ip = Utils.getDeviceIp();

            Log.d(TAG, "Web server initialized on {0}:{1}", HTTPService.ip, HTTPService.port);
            EventManager.post(new StartServerResponse(ip, port));
        } catch (IOException ioe) {
            Log.e(TAG, ioe, "The server could not start.");
            EventManager.post(new StartServerResponse(ioe));
        }
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private class WebServer extends NanoHTTPD {

        public WebServer() {
            super(0);
        }

        @Override
        public Response serve(String uri, Method method, Map<String, String> header, Map<String, String> parameters, Map<String, String> files) {

            synchronized (lock) {
                Log.d(TAG, "Received {0}", uri.toString());

                if (uri.endsWith("/move")) {
                    EventManager.post(new PlayerMoveResponse("move"));
                    return new Response(Status.ACCEPTED, null, "");
                }
                return null;
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        server.stop();
    }
}