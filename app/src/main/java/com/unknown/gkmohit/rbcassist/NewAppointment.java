package com.unknown.gkmohit.rbcassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.heckathon.rbcassist.domain.AccountType;
import io.heckathon.rbcassist.domain.Customer;
import io.heckathon.rbcassist.domain.ServiceType;
import io.heckathon.rbcassist.handlers.impl.StaticDataHanlder;

public class NewAppointment extends AppCompatActivity {

    //Member variables
    @Bind(R.id.categorySpinner)
    Spinner mCategorySpinner;

    @Bind(R.id.typeSpinner)
    Spinner mTypeSpinner;
    Customer mCustomer = new Customer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        mCustomer = (Customer) intent.getSerializableExtra("customer");

        //Account type
        ArrayList<String> accountTypeArrayList = new ArrayList<String>();

        for ( AccountType account : StaticDataHanlder.getAccountList()){
            accountTypeArrayList.add(account.getAccountType());
        }
        String[] accountTypeStringArray = new String[accountTypeArrayList.size()];
        accountTypeArrayList.toArray(accountTypeStringArray);
        ArrayAdapter<String> accountAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, accountTypeStringArray);
        mCategorySpinner.setAdapter(accountAdapter);

        //Service type
        ArrayList<String> serviceArrayList = new ArrayList<String>();

        for ( ServiceType service : StaticDataHanlder.getServiceList()){
            serviceArrayList.add(service.getServiceType());
        }
        String[] serviceStringArray = new String[serviceArrayList.size()];
        serviceArrayList.toArray(serviceStringArray);
        ArrayAdapter<String> serviceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, serviceStringArray);
        mTypeSpinner.setAdapter(serviceAdapter);

        //Agent names
        //ArrayList<String>


    }
}
