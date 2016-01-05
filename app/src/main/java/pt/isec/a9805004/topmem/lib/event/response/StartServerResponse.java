package pt.isec.a9805004.topmem.lib.event.response;

import pt.isec.a9805004.topmem.lib.event.AbstractResponse;

public class StartServerResponse extends AbstractResponse {

    public String ip;
    public int port;

    public StartServerResponse() {
        super();
    }

    public StartServerResponse(String ip, int port) {
        super();
        this.ip = ip;
        this.port = port;
    }

    public StartServerResponse(Throwable throwable) {
        super(throwable);
    }
}
