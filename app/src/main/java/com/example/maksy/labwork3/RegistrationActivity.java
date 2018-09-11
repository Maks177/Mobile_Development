package com.example.maksy.labwork3;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegistrationActivity extends AppCompatActivity {
    EditText firstNameET, lastNameET, phoneET, passwordET, emailET, confirmPasswordET;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstNameET = findViewById(R.id.fname);
        lastNameET = findViewById(R.id.lname);
        phoneET = findViewById(R.id.phone);
        passwordET = findViewById(R.id.password);
        emailET = findViewById(R.id.email);
        confirmPasswordET = findViewById(R.id.cpassword);
    }

    public void Register(View view) {
        final String firstName = firstNameET.getText().toString();
        if(!isValidFirstName(firstName)) {
            firstNameET.setError("Некореткне ім'я");
        }

        final String lastName = lastNameET.getText().toString();
        if(!isValidLastName(lastName)) {
            lastNameET.setError("Некореткне прізвище");
        }

        final String email = emailET.getText().toString();
        if (!isValidEmail(email)) {
            emailET.setError("Неправильно введена пошта");
        }
        final String pass = passwordET.getText().toString();
        if (!isValidPassword(pass)) {
            passwordET.setError("Пароль повинен бути більше 6 символів");
        }
        final String phone = phoneET.getText().toString();
        if (!isValidPhone(phone)) {
            phoneET.setError("Неправильно введений номер");
        }
        if (!confirmPasswordET.equals(passwordET)) {
            confirmPasswordET.setError("Перевірте чи паролі співпадають");
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

    //validating phone
    private boolean isValidPhone(String phone) {
        String PHONE_PATTERN = "[0-9]{10}";
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    // validate firstName
    private boolean isValidFirstName(String firstName) {
        String FirstName_PATTERN = "[a-z]{1,20}";
        Pattern pattern = Pattern.compile(FirstName_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
    //validateLastName
    private boolean isValidLastName(String lastName) {
        String LASTANAME_PATTERN = "[a-zA-Z]{1,20}";
        Pattern pattern = Pattern.compile(LASTANAME_PATTERN);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }
}
