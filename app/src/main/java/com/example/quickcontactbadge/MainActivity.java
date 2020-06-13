package com.example.quickcontactbadge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    private QuickContactBadge email;
    private QuickContactBadge contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (QuickContactBadge)findViewById(R.id.email);
        contact = (QuickContactBadge)findViewById(R.id.contact);

        email.assignContactFromEmail("eddie@gmail.com", true);
        

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            Bundle bundle = new Bundle();
            bundle.putString(ContactsContract.Intents.Insert.NAME, "Eddie");
            contact.assignContactFromPhone("123456789", true, bundle);
        }
        else{
            contact.assignContactFromPhone("123456789", true);
        }

    }
}