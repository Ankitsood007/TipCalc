package com.codewithankit.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText enteredamount;
    private SeekBar seekbar;
    private Button calculatebutton;
    private TextView totalresultamount;
    private TextView textViewseekbar;
    private TextView finalresultdisplay;
    private float amountentered;
    private int seekbarpercentage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredamount = (EditText) findViewById(R.id.billamountID);
        seekbar       = (SeekBar) findViewById(R.id.percentageID);
        calculatebutton = (Button) findViewById(R.id.calculatebuttonID);
        totalresultamount = (TextView) findViewById(R.id.resultID);
        textViewseekbar = (TextView) findViewById(R.id.textviewseekbarID);
        finalresultdisplay = (TextView) findViewById(R.id.finalmessagedisplayID);


        //here this statement just means that we are registering that our button has an event listener attached to it..
        calculatebutton.setOnClickListener(this);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewseekbar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarpercentage = seekbar.getProgress();

            }
        });
    }

    @Override
    public void onClick(View v) {
        calculate();
    }

    public void calculate(){
        float finalans = 0.0f;
        float finalamounttobepayed = 0.0f;
        if(!enteredamount.getText().toString().equals("")) {

            amountentered = Float.parseFloat(enteredamount.getText().toString());
            finalamounttobepayed = amountentered;
            finalans = amountentered*seekbarpercentage/100;
            finalamounttobepayed = finalamounttobepayed + finalans;
            totalresultamount.setText("Your Tip will be "+String.valueOf(finalans));
            finalresultdisplay.setText("The Total Amount would be " + String.valueOf(finalamounttobepayed));
        }
        else{
            Toast.makeText(MainActivity.this , "Please Enter a bill Amount. " , Toast.LENGTH_LONG).show();
        }
    }
}
