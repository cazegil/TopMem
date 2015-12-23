package pt.isec.a9805004.topmem;

import android.app.Application;
import android.content.Context;

import pt.isec.a9805004.topmem.lib.logger.Log;
import pt.isec.a9805004.topmem.lib.manager.ConfigurationManager;
import pt.isec.a9805004.topmem.lib.manager.EventManager;

public class TopMemApp extends Application {

    private static final String TAG = "TopMemApp";

    private static Context context;

    private static TopMemApp sInstance;
    private static boolean sIsInitialized;

    public static TopMemApp getInstance() {
        return sInstance;
    }

    public static Context getContext() {
        return TopMemApp.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        sInstance = this;
        EventManager.register(this);
        initializeManagers();
    }

    /**
     * Call when application exits to clean resources
     */
    public static void shutdown() {
        shutdownManagers();
        sIsInitialized = false;
        EventManager.unregister(TopMemApp.sInstance);
    }

    public static boolean isIsInitialized() {
        return sIsInitialized;
    }

    private static void initializeManagers() {
        ConfigurationManager.initialize();
        EventManager.initialize();
    }

    private static void shutdownManagers() {
        Log.v(TAG, "Shutting down managers");
        ConfigurationManager.shutdown();
        EventManager.shutdown();
    }
}
