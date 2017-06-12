package com.vivekunni.trackr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddTimeTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_add);
        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText tt_name = (EditText) findViewById(R.id.tt_name);
                EditText tt_pass_percent = (EditText) findViewById(R.id.tt_passpercent);
                String name = tt_name.getText().toString();
                Float passpercent = new Float(tt_pass_percent.getText().toString());
                if(!name.isEmpty() && !passpercent.isNaN()) {
                    Timetable t = new Timetable(name, passpercent);

                    DataBaseHelper db = new DataBaseHelper(getApplicationContext());
                    db.createTimeTable(t);
                }
                else{
                    TextView message_box = (TextView)findViewById(R.id.message_box);
                    message_box.setText("Please enter the fields before submiting");
                }

            }
        });
    }
}
