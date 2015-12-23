package pt.isec.a9805004.topmem.utils;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import pt.isec.a9805004.topmem.lib.logger.Log;

/**
 * Utils class for OS related operations
 */
public final class OSUtils {

    private static final String TAG = "OSUtils";

    private static final String DEFAULT_ENCODING = "utf-8";

    /**
     * Load properties file
     *
     * @param assetManager
     *         the asset manager where resources should be retrieved
     * @param fileName
     *         The name of the file
     * @return Properties The properties
     */
    public static Properties loadPropertiesFileFromAsset(final AssetManager assetManager, String fileName) throws IOException {
        InputStream inputStream = assetManager.open(fileName);
        Properties properties = new Properties();
        properties.load(inputStream);
        Log.d(TAG, "Property configurations loaded | file: {0}.", fileName);
        return properties;
    }
}
