package com.example.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText Name, ephone,Email;
    Button btnregister;
    RadioGroup radioGroupGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.Name);
        ephone = findViewById(R.id.phone);
        Email = findViewById(R.id.email);
        radioGroupGender = findViewById(R.id.radio);
        btnregister = findViewById(R.id.register);

        btnregister.setOnClickListener(v -> validateForm());
    }

    private void validateForm() {
        String name = Name.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String phone = ephone.getText().toString().trim();
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();


        if (name.isEmpty()) {
            Name.setError("Name is required");
            return;
        }
        if (phone.isEmpty() || phone.length() < 10 ) {
            ephone.setError("Enter Valid Phone Number");
            return;
        }

        if (email.isEmpty() || !email.contains("@")) {
            Email.setError("Valid email is required");
            return;
        }

        if (selectedGenderId == -1) {
            Toast.makeText(MainActivity.this, "Select the Gender", Toast.LENGTH_SHORT).show();// -1 means no radio button selected Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
        }


    }
}
