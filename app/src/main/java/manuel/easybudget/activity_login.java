package manuel.easybudget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class activity_login extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);

    String username;
    String password;

    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                String pass = mDatabaseHelper.searchPass(username);

                //sample user
                if(username.equals("user") && password.equals("123")) {

                    //redirect to MainActivity
                    showToast("Login Successful");
                    Intent intent=new Intent(activity_login.this,MainActivity.class);
                    startActivity(intent);
                }

                //if user exists
                else if(pass.equals(password)) {
                    //redirect to MainActivity
                    showToast("Login Successful");
                    Intent intent=new Intent(activity_login.this,MainActivity.class);
                    startActivity(intent);
                }

                else {
                    showToast("Invalid username/password");
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(activity_login.this,SignupActivity.class);
                startActivity(intent2);
            }

        });
    }

    private void showToast(String text) {
        Toast.makeText(activity_login.this, text, Toast.LENGTH_SHORT).show();
    }
}
