package pt.isec.a9805004.topmem.toplevelmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.isec.a9805004.topmem.R;
import pt.isec.a9805004.topmem.game.GameActivity;
import pt.isec.a9805004.topmem.settings.SettingsFragment;

/**
 * Created by KazeGil on 17/12/15.
 */
public class TopLevelActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toplevelmenu);

    }


    public void onClickMenu(View v) {
        Button btn = (Button) v;

        //if(btn.getId() == R.id.btnIniciar)
        //Toast.makeText(getApplicationContext(), "Clicaste no Botao",
        //        Toast.LENGTH_LONG).show();

        switch (btn.getId()) {
            case R.id.btnIniciar:
                startActivity(new Intent(TopLevelActivity.this, GameActivity.class));
                break;
            case R.id.btnSettings:
                startActivity(new Intent(TopLevelActivity.this, SettingsFragment.class));
                break;
            case R.id.btnSair:
                finish();
                System.exit(0);
                break;
        }
    }
}
