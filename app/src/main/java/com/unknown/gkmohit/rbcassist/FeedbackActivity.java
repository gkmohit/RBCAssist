package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.heckathon.rbcassist.domain.Appointment;
import io.heckathon.rbcassist.domain.Customer;
import io.heckathon.rbcassist.handlers.impl.StaticDataHanlder;

public class FeedbackActivity extends AppCompatActivity {


    //Member variables
    @Bind(R.id.agentNameTitleTV)
    TextView mAgentNameTV;

    @Bind(R.id.appointmentDateTV)
    TextView mAppointmentDateTV;

    @Bind(R.id.serviceTypeTV)
    TextView mServiceTypeTV;

    @Bind(R.id.ratingBar)
    RatingBar mRatingBar;

    @Bind(R.id.commentET)
    EditText mCommentET;

    @Bind(R.id.submitButton)
    Button mSubmitButton;

    Customer mCustomer = new Customer();
    Appointment mAppointment = new Appointment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCustomer = (Customer) intent.getSerializableExtra("customer");
        mAppointment = (Appointment) intent.getSerializableExtra("appointment");

        mAgentNameTV.setText(mAppointment.getAgentName());
        mAppointmentDateTV.setText(mAppointment.getStrDate());
        mServiceTypeTV.setText(StaticDataHanlder.getServiceType(mAppointment.getServiceTypeId()));
        mRatingBar.setRating(5);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FeedbackActivity.this, WelcomeActivity.class);
                //Optional parameters
                myIntent.putExtra("customer", mCustomer);
                finish();
                Toast.makeText(view.getContext(), "Your feed back has been submitted. Thank you", Toast.LENGTH_LONG).show();
                FeedbackActivity.this.startActivity(myIntent);

            }
        });
    }


}
