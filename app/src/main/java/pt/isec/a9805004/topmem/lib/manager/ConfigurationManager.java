package pt.isec.a9805004.topmem.lib.manager;

import java.util.Properties;

import pt.isec.a9805004.topmem.TopMemApp;
import pt.isec.a9805004.topmem.lib.logger.Log;
import pt.isec.a9805004.topmem.utils.OSUtils;

/**
 * Utility class to access configuration properties
 */
public class ConfigurationManager {

    private static final String TAG = "ConfigurationManager";

    private static final String FILENAME_PREFIX = "config";
    private static final String FILENAME_EXTENSION = "properties";

    private static Properties sProperties;

    public static void initialize() {
        long startTime = System.currentTimeMillis();
        if (ConfigurationManager.sProperties == null) {
            try {
                final String fileName = FILENAME_PREFIX + "." + FILENAME_EXTENSION;;
                sProperties = OSUtils.loadPropertiesFileFromAsset(TopMemApp.getContext().getAssets(), fileName);
            } catch (Exception e) {
                Log.e(TAG, e, "Configurations not found");
                throw new RuntimeException(e);
            }
        }
        Log.i(TAG, "{0} initialized | {1}ms", TAG, (System.currentTimeMillis() - startTime));
    }

    public static void shutdown() {
        ConfigurationManager.sProperties = null;
    }

    // ------------------------------------------------

    public static Properties getProperties() {
        return sProperties;
    }

    public static String getProperty(String key) {
        return getProperty(key, null);
    }

    public static String getProperty(String key, String defaultValue) {
        String value = defaultValue;
        if (sProperties != null) {
            value = sProperties.getProperty(key, defaultValue);
        }
        Log.v(TAG, "Getting property | key={0}, value={1}.", key, value);
        return value;
    }

    public static int getPropertyAsInt(String key, int defaultValue) {
        int value = defaultValue;
        try {
            if (sProperties != null) {
                value = Integer.valueOf(sProperties.getProperty(key));
            }
        } catch (Exception e) {
            Log.v(TAG, "Invalid or missing property | key={0}.", key);
        }

        Log.v(TAG, "Getting property | key={0}, value={1}.", key, value);
        return value;
    }

    public static double getPropertyAsDouble(String key, double defaultValue) {
        double value = defaultValue;
        try {
            if (sProperties != null) {
                value = Double.valueOf(sProperties.getProperty(key));
            }
        } catch (Exception e) {
            Log.v(TAG, "Invalid or missing property | key={0}.", key);
        }

        Log.v(TAG, "Getting property | key={0}, value={1}.", key, value);
        return value;
    }

    public static long getPropertyAsLong(String key, long defaultValue) {
        long value = defaultValue;
        try {
            if (sProperties != null) {
                value = Long.valueOf(sProperties.getProperty(key));
            }
        } catch (Exception e) {
            Log.v(TAG, "Invalid or missing property | key={0}.", key);
        }

        Log.v(TAG, "Getting property | key={0}, value={1}.", key, value);
        return value;
    }

    public static boolean getPropertyAsBoolean(String key, boolean defaultValue) {
        boolean value = defaultValue;
        try {
            if (sProperties != null) {
                value = Boolean.valueOf(sProperties.getProperty(key));
            }
        } catch (Exception e) {
            Log.v(TAG, "Invalid or missing property | key={0}.", key);
        }

        Log.v(TAG, "Getting property | key={0}, value={1}.", key, value);
        return value;
    }

}
