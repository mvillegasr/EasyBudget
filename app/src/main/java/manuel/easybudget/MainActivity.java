package manuel.easybudget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //user input variables
    double expectedIncome;
    double rentMortgage;
    double bills;
    double leftover;

    //layout fields
    EditText expectedInput;
    EditText rentmortgageInput;
    EditText billsInput;

    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link variables with those in layout
        expectedInput = findViewById(R.id.expectedInput);
        rentmortgageInput = findViewById(R.id.rentmortgageInput);
        billsInput = findViewById(R.id.billsInput);

        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //assign user input to variables
                expectedIncome = Double.valueOf(expectedInput.getText().toString());
                rentMortgage = Double.valueOf(rentmortgageInput.getText().toString());
                bills = Double.valueOf(billsInput.getText().toString());
                leftover = expectedIncome - rentMortgage - bills;

                final TextView leftoverOutput = findViewById(R.id.leftoverOutput);

                //display value
                leftoverOutput.setText(String.valueOf(leftover));
                showToast("Calculation Complete");
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
