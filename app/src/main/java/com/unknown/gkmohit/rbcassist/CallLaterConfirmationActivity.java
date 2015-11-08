package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.heckathon.rbcassist.domain.Appointment;
import io.heckathon.rbcassist.domain.Customer;
import io.heckathon.rbcassist.handlers.impl.AppointmentHandlerImpl;
import io.heckathon.rbcassist.handlers.impl.StaticDataHanlder;

public class CallLaterConfirmationActivity extends AppCompatActivity {

    //Member Variables
    @Bind(R.id.categoryTV)
    TextView mCategoryTV;

    @Bind(R.id.greetingTV)
    TextView mGreetingTV;

    @Bind(R.id.dateTV)
    TextView mDateTV;

    @Bind(R.id.agentNameTV)
    TextView mAgentNameTV;

    @Bind(R.id.editButton)
    Button mEditButton;

    @Bind(R.id.confirmButton)
    Button mConfirmButton;

//    @Bind(R.id.calenderButton)
//    Button mCalenderButton;

    Customer mCustomer = new Customer();
    Appointment mAppointment = new Appointment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        ButterKnife.bind(this);
        Intent intent = getIntent();

        //Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        mCustomer = (Customer) intent.getSerializableExtra("customer");
        mAppointment = (Appointment) intent.getSerializableExtra("appointment");

        //Setting greeting
        String greetingText = "Hello " + mCustomer.getFirstName() + " " + mCustomer.getLastName() + ",";
        mGreetingTV.setText(greetingText);

        mCategoryTV.setText(StaticDataHanlder.getServiceType(mAppointment.getServiceTypeId()));
        //Setting agent name
        mAgentNameTV.setText(mAppointment.getAgentName());
        //Setting date
        mDateTV.setText(mAppointment.getStrDate());


        //

        //Setting wait time
//        mWaitTime = intent.getIntExtra("waitTime", 1);
//        mWaitTimeTV.setText("" + mWaitTime + " minutes");

        //Setting service ID
//        mServiceId = StaticDataHanlder.getServiceType(intent.getStringExtra("serviceId"));
//        mServiceTV.setText(mServiceId);

        //Setting category
//        mCategory = StaticDataHanlder.getAccountType(intent.getStringExtra("category"));
//        mCategoryTV.setText(mCategory);

        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CallLaterConfirmationActivity.this, NewAppointment.class);
                myIntent.putExtra("customer", mCustomer);
                finish();
                startActivity(myIntent);
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String customerId, String agentId, String serviceId, String location, Date date, int waittime
                AppointmentHandlerImpl.addAppointment(mCustomer.getCustomerId(), mAppointment.getAgentId(), mAppointment.getServiceTypeId() ,null, mAppointment.getDate() , 0);
                Intent myIntent = new Intent(CallLaterConfirmationActivity.this, WelcomeActivity.class);
                myIntent.putExtra("customer", mCustomer);
                finish();
                startActivity(myIntent);
            }
        });

    }

}
