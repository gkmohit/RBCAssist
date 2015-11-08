package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.heckathon.rbcassist.domain.Appointment;
import io.heckathon.rbcassist.domain.Customer;
import io.heckathon.rbcassist.handlers.impl.StaticDataHanlder;

public class WelcomeActivity extends AppCompatActivity {

    //Member variables
    @Bind(R.id.greetingTV)
    TextView mGreetingTV;

    @Bind(R.id.currentAppointmentsTable)
    TableLayout mCurrentAppointmentsTable;

    @Bind(R.id.createNewAppointmentButton)
    Button mCreateNewAppointmentButton;

    @Bind(R.id.pastAppointmentsButton)
    Button mPastAppointmentsButton;

    @Bind(R.id.cancelAppointmentsButton)
    Button mCancelAppointmentsButton;

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



        mCurrentAppointmentsTable.setColumnStretchable(0, true);
        mCurrentAppointmentsTable.setColumnStretchable(1, true);
        mCurrentAppointmentsTable.setColumnStretchable(2, true);
        for(Appointment appointment : mCustomer.getAppointments()){

            TextView dateTV = new TextView(this);
            TextView agentTV = new TextView(this);
            TextView typeTV = new TextView(this);
            CheckBox selectCB = new CheckBox(this);
            TableRow row = new TableRow(this);
            //Adding checkbox
            selectCB.setSelected(false);
            //Date text view
            dateTV.setText(appointment.getStrDate());
            dateTV.setTextSize(15);
            dateTV.setGravity(Gravity.CENTER);
            //Agent text view
            //agentTV.setText(appointment.getAgentName());
            //agentTV.setTextSize(20);
            //agentTV.setGravity(Gravity.CENTER);

            //Type text view
            typeTV.setText(StaticDataHanlder.getServiceType(appointment.getServiceTypeId()));
            typeTV.setTextSize(15);
            typeTV.setGravity(Gravity.CENTER);
            //Adding text view to the table
            row.addView(selectCB);
            row.addView(dateTV);
            row.addView(typeTV);
            mCurrentAppointmentsTable.addView(row);
        }
    }

    @Override
    public void onBackPressed() {
        Intent myIntent =new Intent(WelcomeActivity.this, LoginActivity.class);
        finish();
        startActivity(myIntent);
    }

}
