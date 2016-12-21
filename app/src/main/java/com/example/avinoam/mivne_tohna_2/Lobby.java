package com.example.avinoam.mivne_tohna_2;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.attr.data;

public class Lobby extends Activity {

    GoogleApiClient mGoogleApiClient;
    String username;
    // For our intents
    private static final int RC_SIGN_IN = 9001;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                username = null;
            } else {
                username = extras.getString("USERNAME");
            }
        } else {
            username = (String) savedInstanceState.getSerializable("USERNAME");
        }
        setContentView(R.layout.activity_lobby);
        TextView myUsername = (TextView)findViewById(R.id.username);
        myUsername.setText("Welcome " +username);
        mGoogleApiClient = MainActivity.getGoogleApiClient();
    }

    public void Disconnect(View v) {
        mGoogleApiClient.disconnect();
        finish();
    }

    public void StartMap(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
    }

}
