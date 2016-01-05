package pt.isec.a9805004.topmem.lib.event;
/**
 *
 */
public abstract class AbstractResponse {

    public String tag;
    public boolean success = true;
    public Throwable throwable;

    public AbstractResponse() {
    }

    public AbstractResponse(boolean success) {
        this.success = success;
    }

    public AbstractResponse(Throwable throwable) {
        this.success = false;
        this.throwable = throwable;
    }
}
