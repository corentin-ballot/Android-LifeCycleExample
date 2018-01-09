package ballot.corentin.examplelifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);


        Intent intentRecu = getIntent();
        int operande1 = intentRecu.getIntExtra("OP1", 0);
        int operande2 = intentRecu.getIntExtra("OP2", 0);

        int addition = add(operande1, operande2);

        envoyerResultat(addition);
    }

    private void envoyerResultat(int addition) {
        Intent result = new Intent();
        result.putExtra("ADD", addition);

        setResult(RESULT_OK, result);
        this.finish();
    }

    private int add(int a, int b) {
        return a + b;
    }
}
