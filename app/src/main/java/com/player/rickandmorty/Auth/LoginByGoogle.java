package com.player.rickandmorty.Auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.player.rickandmorty.R;
import com.player.rickandmorty.View.Home;
import com.player.rickandmorty.View.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginByGoogle extends AppCompatActivity {

    @BindView(R.id.login)
    ImageView login;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_google);
        ButterKnife.bind(this);

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc=GoogleSignIn.getClient(this,gso);
    }
    @OnClick(R.id.login)
    void openLogin(){
        SignIn();
    }

    private void SignIn(){
        Intent intent=gsc.getSignInIntent();
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 100){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                task.getResult(ApiException.class);
                openHomeActivity();
            }catch(ApiException e){
                Toast.makeText(this ,"Error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openHomeActivity() {
        finish();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        Toast.makeText(this, "Bienvenido "+account.getDisplayName(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        finish();
    }


}
