package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
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

public class PastAppointments extends AppCompatActivity {

    //Member variables
    @Bind(R.id.greetingTV)
    TextView mGreetingTV;

    @Bind(R.id.currentAppointmentsTable)
    TableLayout mCurrentAppointmentsTable;

    Customer mCustomer = new Customer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_appointments);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCustomer = (Customer) intent.getSerializableExtra("customer");
        String greetingText = "Hello " + mCustomer.getFirstName() + " " + mCustomer.getLastName() + ",";
        mGreetingTV.setText(greetingText);

        mCurrentAppointmentsTable.setColumnStretchable(0, true);
        mCurrentAppointmentsTable.setColumnStretchable(1, true);
        mCurrentAppointmentsTable.setColumnStretchable(2, true);
        for(Appointment appointment : mCustomer.getCompletedAppointments()){

            TextView dateTV = new TextView(this);
            TextView agentTV = new TextView(this);
            TextView typeTV = new TextView(this);
            TextView statusTV = new TextView(this);
            TableRow row = new TableRow(this);
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

            //Status text view
            statusTV.setText(appointment.getStatus());
            statusTV.setTextSize(15);
            statusTV.setGravity(Gravity.CENTER);

            //Adding text view to the table

            row.addView(dateTV);
            row.addView(typeTV);
            row.addView(statusTV);
            mCurrentAppointmentsTable.addView(row);
        }

    }

}
