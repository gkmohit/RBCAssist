package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.heckathon.rbcassist.domain.Agent;
import io.heckathon.rbcassist.domain.Appointment;
import io.heckathon.rbcassist.domain.Customer;
import io.heckathon.rbcassist.handlers.impl.AppointmentHandlerImpl;
import io.heckathon.rbcassist.handlers.impl.StaticDataHanlder;

public class CallLater extends AppCompatActivity {

    //Member variables
    @Bind(R.id.dateSpinner)
    Spinner mDateSpinner;

    @Bind(R.id.timeSpinner)
    Spinner mTimeSpinner;

    @Bind(R.id.agentSpinner)
    Spinner mAgentSpinner;

    @Bind(R.id.nextButton)
    Button mNextButton;

//    @Bind(R.id.like) Button mLike;

    Customer mCustomer = new Customer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_later);

        ButterKnife.bind(this);
//        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
//        mLike.setTypeface(font);
        Intent intent = getIntent();
        mCustomer = (Customer) intent.getSerializableExtra("customer");

        //Agent Names
        //
        ArrayList<String> agentArrayList = new ArrayList<String>();

        for ( Agent agent : AppointmentHandlerImpl.getAgentList()){
            agentArrayList.add(agent.getFirstName() + " " + agent.getLastName());
        }
        String[] agentArray = new String[agentArrayList.size()];
        agentArrayList.toArray(agentArray);
        ArrayAdapter<String> accountAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, agentArray);
        mAgentSpinner.setAdapter(accountAdapter);

        //Service type
        //

        String[] timerray = new String[StaticDataHanlder.getTimeSlots().size()];
        StaticDataHanlder.getTimeSlots().toArray(timerray);
        ArrayAdapter<String> serviceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timerray);
        mTimeSpinner.setAdapter(serviceAdapter);

        //Date level
        //

        String[] dateStringArray = new String[StaticDataHanlder.getDateSlots().size()];
        StaticDataHanlder.getDateSlots().toArray(dateStringArray);
        ArrayAdapter<String> urgencyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dateStringArray);
        mDateSpinner.setAdapter(urgencyAdapter);

        //String customerId, String agentId, String serviceId, String location, Date date, int waittime
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String customerId = new String(mCustomer.getCustomerId());
                String serviceId = new String(StaticDataHanlder.getServiceId(mDateSpinner.getSelectedItem().toString()));
                int waitTime = AppointmentHandlerImpl.getWaitTime();
                String category = new String(StaticDataHanlder.getAccountId(mTimeSpinner.getSelectedItem().toString()));
                Intent myIntent = new Intent(CallLater.this, CallLaterConfirmationActivity.class);
                //TODO Create appoint object to pass to next intent
                Appointment appointment = new Appointment();
                //Optional parameters
                myIntent.putExtra("customer", mCustomer);
                myIntent.putExtra("apointment", appointment);
//                myIntent.putExtra("serviceId", serviceId);
//                myIntent.putExtra("waitTime", waitTime);
//                myIntent.putExtra("category", category);
                CallLater.this.startActivity(myIntent);
            }
        });

    }
}
