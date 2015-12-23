package pt.isec.a9805004.topmem.lib.logger;

import java.text.MessageFormat;

/**
 * Log utility class
 */
public class Log {

    private static int sLogLevel = android.util.Log.VERBOSE;

    /**
     * Set the log level ({@link android.util.Log} levels)
     */
    public static void setLogLevel(int logLevel) {
        sLogLevel = logLevel;
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    public static void w(String tag, String message, Object... args) {
        if (android.util.Log.WARN >= sLogLevel) {
            android.util.Log.w(tag, MessageFormat.format(message, args));
        }
    }

    public static void w(String tag, Throwable throwable, String message, Object... args) {
        if (android.util.Log.WARN >= sLogLevel) {
            android.util.Log.w(tag, MessageFormat.format(message, args), throwable);
        }
    }

    public static void i(String tag, String message, Object... args) {
        if (android.util.Log.INFO >= sLogLevel) {
            android.util.Log.i(tag, MessageFormat.format(message, args));
        }
    }

    public static void i(String tag, Throwable throwable, String message, Object... args) {
        if (android.util.Log.INFO >= sLogLevel) {
            android.util.Log.i(tag, MessageFormat.format(message, args), throwable);
        }
    }

    public static void d(String tag, String message, Object... args) {
        if (android.util.Log.DEBUG >= sLogLevel) {
            android.util.Log.d(tag, MessageFormat.format(message, args));
        }
    }

    public static void d(String tag, Throwable throwable, String message, Object... args) {
        if (android.util.Log.DEBUG >= sLogLevel) {
            android.util.Log.d(tag, MessageFormat.format(message, args), throwable);
        }
    }

    public static void v(String tag, String message, Object... args) {
        if (android.util.Log.VERBOSE >= sLogLevel) {
            android.util.Log.v(tag, MessageFormat.format(message, args));
        }
    }

    public static void v(String tag, Throwable throwable, String message, Object... args) {
        if (android.util.Log.VERBOSE >= sLogLevel) {
            android.util.Log.v(tag, MessageFormat.format(message, args), throwable);
        }
    }

    public static void e(String tag, String message, Object... args) {
        if (android.util.Log.ERROR >= sLogLevel) {
            android.util.Log.e(tag, MessageFormat.format(message, args));
        }
    }

    public static void e(String tag, Throwable throwable, String message, Object... args) {
        if (android.util.Log.ERROR >= sLogLevel) {
            android.util.Log.e(tag, MessageFormat.format(message, args), throwable);
        }
    }
}
