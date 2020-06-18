package esisa.android.wallet;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import esisa.android.wallet.dal.DbInscription;

public class MainActivity extends AppCompatActivity {
    // Nv Changement
    // Nv Changement2

    ListView lst;
    String[] projectsname={"projet1","projet2","projet3"};
    String[] projectsdesc={"projet1description","projet2description","projet3description"};
    Integer[] imgid = {R.drawable.food,R.drawable.travel,R.drawable.sante};
    private Button signupbt, signinbt;
    private TextView textView;
    private EditText edtusername,edtpass;
    private DbInscription dbInscription;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference walletRef;
    String emailFromDB;
    String passwordFromDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);


        Button signupbt = findViewById(R.id.signupbt);
        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity();
            }
        });

     //   lst = (ListView) findViewById(R.id.listview);

        textView=findViewById(R.id.login);
        edtusername =findViewById(R.id.username);
        edtpass=findViewById(R.id.userpass);
        walletRef = firebaseDatabase.getReference("Wallet Application").child("Utilisateurs").child("1");
        walletRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                emailFromDB = dataSnapshot.child("email").getValue().toString();
                passwordFromDB = dataSnapshot.child("password").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        signinbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailFromDB.equals(edtusername.getText().toString()) && passwordFromDB.equals(edtpass.getText().toString())){
                    Home();
                }
                else{
                    Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });




    }


    public void openSignupActivity() {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
    public void Home(){
        Intent intent = new Intent(this, AddProjectsActivity.class);
        startActivity(intent);
    }



}
