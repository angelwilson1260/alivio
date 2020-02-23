package com.cyboss.alivio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn,frgt;
    FirebaseAuth fAuth;
    CollectionReference usersRef;
    FirebaseFirestore fstore;
String nm,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frgt=(TextView)findViewById(R.id.forgot);
        mEmail = findViewById(R.id.emaillogin);
        mPassword = findViewById(R.id.pwdlogin);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.login);
        mCreateBtn = findViewById(R.id.signup);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("admin_login").document("A0111");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        nm=document.getString("Name");

                        pw=document.getString("pwd");
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
//                        Log.d(TAG, "No such document");
                    }
                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError(nm);
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError(pw);
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }



                // authenticate the user
                fstore = FirebaseFirestore.getInstance();
                 usersRef= fstore.collection("users");
                Query query = usersRef.whereEqualTo("email", email);
                query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    //--------------------------------------------------------
                                    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                    usersRef.document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot document = task.getResult();
                                                if (document.exists()) {
                                                    String type = document.getString("type");
                                                    if(type.equals("user")) {
                                                        Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                                        startActivity(new Intent(MainActivity.this, UserHome.class));
                                                    } else if (type.equals("admin")) {
                                                        Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                                        startActivity(new Intent(MainActivity.this, AdminActivity.class));
                                                    }
                                                }
                                            }
                                        }
                                    });
                                    //--------------------------------------------------------

//                                    startActivity(new Intent(getApplicationContext(),UserHome.class));
                                }else {

                                    Toast.makeText(MainActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }

                            }
                        });
                    }
                });



            }
        });



        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i=new Intent(MainActivity.this,SignupActivity.class);
                    startActivity(i);
                }catch (Exception e){
                    throw e;
                }

            }
        });
        frgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ForgotPwd.class);
                startActivity(i);
            }
        });



    }

}
