package ballot.corentin.examplelifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int nbcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); afficherToast("onCreate()");
        setContentView(R.layout.activity_main);
        nbcall =1;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //donnees.putInt("appels", nbcall);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //donnees.getInt("appels", nbcall);
    }

    @Override
    protected void onStart() {
        super.onStart(); afficherToast("onStart()");
    }
    @Override
    protected void onRestart() {
        super.onRestart(); afficherToast("onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy(); afficherToast("onDestroy()");
    }
    @Override
    protected void onPause() {
        super.onPause(); afficherToast("onPause()");
    }
    @Override
    protected void onResume() {
        super.onResume(); afficherToast("onResume()");
    }
    @Override
    protected void onStop() {
        super.onStop(); afficherToast("onStop()");
    }

    public void afficherToast(String msg) {
        Toast mesg = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mesg.setGravity(Gravity.CENTER, 0, 0);
        mesg.show();
    }

    // onClick buttons

    /**
     * cette méthode créée une instance de ActivityOne
     * @param view
     */
    public void doOne(View view) {
        Intent monIntent = new Intent(this, ActivityOne.class);
        String message = "Message en provenance de ManActivity pour ActivityOne";
        monIntent.putExtra("MESSAGE", message);
        startActivity(monIntent);
        Toast.makeText(this, "btn one", Toast.LENGTH_SHORT).show();
    }

    /**
     * cette méthode créée une instance d'une class que je ne connais pas
     * mais qui répond à l'action et aux données que je passe ne paramètres
     * @param view
     */
    public void doTwo(View view) {
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://qwant.com"));
        startActivity(implicitIntent);
        Toast.makeText(this, "btn two", Toast.LENGTH_SHORT).show();
    }

    public void doThree(View view) {
        Intent monIntent = new Intent(this, ActivityThree.class);
        monIntent.putExtra("OP1",8);
        monIntent.putExtra("OP2",4);
        startActivityForResult(monIntent, 1);
    }

    public void exit(View view) {
        Toast.makeText(this, "btn exit", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void onActivityResult(int code, int resultCode, Intent donnees) {
        if(resultCode == RESULT_OK) {
            int restulataAddition = donnees.getIntExtra("ADD", 0);

            afficherToast("ADD : " + restulataAddition);
        }
    }
}
