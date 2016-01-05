package pt.isec.a9805004.topmem.lib.event.response;

import pt.isec.a9805004.topmem.lib.event.AbstractResponse;

public class PlayerMoveResponse extends AbstractResponse {

    public String move;

    public PlayerMoveResponse() {
        super();
    }

    public PlayerMoveResponse(String move) {
        super();
        this.move = move;
    }

    public PlayerMoveResponse(Throwable throwable) {
        super(throwable);
    }
}
