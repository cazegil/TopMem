package pt.isec.a9805004.topmem.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import pt.isec.a9805004.topmem.R;
import pt.isec.a9805004.topmem.toplevelmenu.TopLevelActivity;

/**
 * Created by KazeGil on 16/12/15.
 */

public class SplashActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashActivity.this, TopLevelActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
