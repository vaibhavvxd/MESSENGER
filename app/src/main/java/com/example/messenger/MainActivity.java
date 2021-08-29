package com.example.messenger;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class MainActivity extends AppCompatActivity {
    Button buttonSend;
    EditText textPhoneNo;
    EditText textSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        buttonSend = (Button)findViewById(R.id.buttonSend);
        textPhoneNo = (EditText)findViewById(R.id.editTextPhoneNo);
        textSMS = (EditText)findViewById(R.id.editTextSMS);

        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String phoneNo = textPhoneNo.getText().toString();
                String sms = textSMS.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(MainActivity.this, "SMS Sent!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,
                            "SMS failed, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
    }
}