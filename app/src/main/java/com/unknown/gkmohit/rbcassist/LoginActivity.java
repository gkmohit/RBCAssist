package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.heckathon.rbcassist.domain.Customer;
import io.heckathon.rbcassist.handlers.impl.AppointmentHandlerImpl;

public class LoginActivity extends AppCompatActivity {

    //Member variables
    @Bind(R.id.userNameET)
    EditText mUserNameET;

    @Bind(R.id.passwordET)
    EditText mPasswordET;

    @Bind(R.id.invalidLoginTV)
    TextView mInvalidLogingTV;

    @Bind(R.id.signInButton)
    Button mSignInButtom;

    AppointmentHandlerImpl mAppointmentHandlerImp = new AppointmentHandlerImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mInvalidLogingTV.setVisibility(View.INVISIBLE);

        mSignInButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = mUserNameET.getText().toString().trim();
                String password = mPasswordET.getText().toString().trim();
                Customer customer = AppointmentHandlerImpl.authenticate(userName, password);
                if (customer == null) {
                    mInvalidLogingTV.setVisibility(View.VISIBLE);
                } else {
                    mInvalidLogingTV.setVisibility(View.INVISIBLE);
                    Intent myIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    //Optional parameters
                    myIntent.putExtra("customer", customer);
                    LoginActivity.this.startActivity(myIntent);
                }
            }
        });
    }

}
