package manuel.easybudget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);

    String  personName, uname, passwd;

    EditText nameInput;
    EditText usersignupInput;
    EditText pwsignupInput;
    Button createaccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameInput = findViewById(R.id.nameInput);
        usersignupInput = findViewById(R.id.usersignupInput);
        pwsignupInput = findViewById(R.id.pwsignupInput);

        createaccountButton = findViewById(R.id.createaccountButton);
        createaccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //assign user input to variables
                personName = nameInput.getText().toString();
                uname = usersignupInput.getText().toString();
                passwd = pwsignupInput.getText().toString();

                User newuser = new User();
                newuser.setName(personName);
                newuser.setUsername(uname);
                newuser.setPassword(passwd);

                AddData(newuser);
            }
        });

    }

    public void AddData(User newEntry) {
        boolean insertData = mDatabaseHelper.addUser(newEntry);

        if(insertData) {
            showToast("Account created!");
        }
        else {
            showToast("Unsuccessful");
        }
    }

    private void showToast(String text) {
        Toast.makeText(SignupActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
