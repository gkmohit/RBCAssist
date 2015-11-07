package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.heckathon.rbcassist.domain.Customer;

public class WelcomeActivity extends AppCompatActivity {

    //Member variables
    @Bind(R.id.greetingTV)
    TextView mGreetingTV;

    Customer mCustomer = new Customer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCustomer = (Customer) intent.getSerializableExtra("customer");
        String greetingText = "Hello " + mCustomer.getFirstName() + " " + mCustomer.getLastName() + ",";
        mGreetingTV.setText(greetingText);

    }

}
