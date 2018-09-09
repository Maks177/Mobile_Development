package com.example.maksy.labwork3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegistrationActivity extends Activity {
    EditText firstnameET, lastnameET, phoneET, passwordET, emailET, confirmpasswordET;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firstnameET = findViewById(R.id.fname);
        lastnameET = findViewById(R.id.lname);
        phoneET = findViewById(R.id.phone);
        passwordET = findViewById(R.id.password);
        emailET = findViewById(R.id.email);
        confirmpasswordET = findViewById(R.id.cpassword);
    }

    public void Register(View view) {

        final String email = emailET.getText().toString();
        if (!isValidEmail(email)) {
            emailET.setError("Неправильно введена пошта");
        }
        final String pass = passwordET.getText().toString();
        if (!isValidPassword(pass)) {
            passwordET.setError("Парооль повинен бути більше 6 символів");
        }
        final String phone = phoneET.getText().toString();
        if (!isValidPhone(phone)) {
            phoneET.setError("Неправильно введений номер");
        }
        final String fname = firstnameET.getText().toString();
        if(isValidFirstName(fname)) {
            firstnameET.setError("Некореткне ім'я");
        }
        final String lname = lastnameET.getText().toString();
        if((isValidLastNAme(lname))) {
            lastnameET.setError("Некореткне прізвище");
        }
        if (!confirmpasswordET.equals(passwordET)) {
            confirmpasswordET.setError("Перевірте чи паролі співпадають");
        }

    }


    //validating email
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,6})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    // validating password
    private boolean isValidPassword(String pass) {
        if (pass.length() < 6) {
            return false;
        }
        final String PASSWORD_PATTERN = "[a-zA-Z0-9]{6,20}";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    private boolean isValidPhone(String phone) {
        String PHONE_PATTERN = "[0-9]{10}";
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean isValidFirstName(String fname) {

        String FirstName_PATTERN = "[A-Za-z]+[А-Яа-я]{1,10}";
        Pattern pattern = Pattern.compile(FirstName_PATTERN);
        Matcher matcher = pattern.matcher(fname);
        return matcher.matches();
    }

    private boolean isValidLastNAme(String lname) {

        String LASTANAME_PATTERN = "[A-Za-z]+[А-Яа-я]{1,10}";
        Pattern pattern = Pattern.compile(LASTANAME_PATTERN);
        Matcher matcher = pattern.matcher(lname);
        return matcher.matches();
    }

}
