package com.magnatraining.spinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Spinner spinner;
    private SpinnerAdapter spinnerAdapter;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        populateSpinner();
        setListenerOnSpinner();
    }

    private void createSpinner()
    {
        spinner = (Spinner)findViewById(R.id.spinner);
    }

    private void populateSpinner()
    {
        List<String> list = new ArrayList<String>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(arrayAdapter);

    }

    private void setListenerOnSpinner()
    {
        spinner.setOnItemSelectedListener(new SpinnerListener());
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class SpinnerListener implements AdapterView.OnItemSelectedListener
    {



        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(parent.getContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}
