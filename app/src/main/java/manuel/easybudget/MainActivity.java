package manuel.easybudget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    double expectedIncome;
    double rentMorgage;
    double bills;
    double leftover;

    EditText expectedInput;
    EditText rentmorgageInput;
    EditText billsInput;

    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expectedInput = findViewById(R.id.expectedInput);
        rentmorgageInput = findViewById(R.id.rentmorgageInput);
        billsInput = findViewById(R.id.billsInput);

        calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expectedIncome = Double.valueOf(expectedInput.getText().toString());
                rentMorgage = Double.valueOf(rentmorgageInput.getText().toString());
                bills = Double.valueOf(billsInput.getText().toString());
                leftover = expectedIncome - rentMorgage - bills;
                final TextView leftoverOutput = findViewById(R.id.leftoverOutput);

                leftoverOutput.setText(String.valueOf(leftover));
                showToast(String.valueOf(expectedIncome));
                showToast(String.valueOf(rentMorgage));
                showToast(String.valueOf(bills));
                //does this work
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
