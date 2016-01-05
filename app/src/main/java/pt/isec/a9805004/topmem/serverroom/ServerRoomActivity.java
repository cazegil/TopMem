package pt.isec.a9805004.topmem.serverroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pt.isec.a9805004.topmem.R;
import pt.isec.a9805004.topmem.lib.event.response.StartServerResponse;
import pt.isec.a9805004.topmem.lib.manager.EventManager;
import pt.isec.a9805004.topmem.lib.server.HTTPService;

/**
 * Created by KazeGil on 17/12/15.
 */
public class ServerRoomActivity extends Activity {

    private boolean mServerStarted = false;
    private TextView ip;
    private TextView port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server_room_activity);

        ip = TextView.class.cast(findViewById(R.id.txtIp));
        port = TextView.class.cast(findViewById(R.id.txtPort));

        //regist listener for events
        EventManager.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //unregist listener for events
        EventManager.unregister(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartStopServer:
                if (!mServerStarted) {
                    startActivity(new Intent(ServerRoomActivity.this, HTTPService.class));
                    ((Button) v).setText(R.string.txt_stop);
                } else {
                    stopService(new Intent(ServerRoomActivity.this, HTTPService.class));
                    ((Button) v).setText(R.string.txt_start);
                }
                break;

            default:
                break;
        }
    }

    public void onEventMainThread(StartServerResponse event) {
        if (event.success) {
            ip.setText(event.ip);
            port.setText(String.valueOf(event.port));
        } else {
            ip.setText(null);
            port.setText(null);
        }
    }
}
