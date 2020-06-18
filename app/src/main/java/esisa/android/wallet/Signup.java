package esisa.android.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import esisa.android.wallet.dal.DbInscription;

import esisa.android.wallet.models.Utilisateur;

public class Signup extends AppCompatActivity {

    private Button addBtn;
    private EditText name, phoneNumber, email, password, confirmPassword;
    private ImageView userPicture;
    private FloatingActionButton btnAddPicture;
    public DbInscription dbInscription;
    public Utilisateur userInscription;


    //Firebase code
        FirebaseDatabase firebaseDatabase;
        DatabaseReference walletRef;
    long cp = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        addBtn = findViewById(R.id.btn1);
        btnAddPicture = (FloatingActionButton)findViewById(R.id.floatingActionButton4);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                userInscription.setFullname(name.getText().toString());
//                userInscription.setNumber(phoneNumber.getText().toString());
//                userInscription.setEmail(email.getText().toString());
//                userInscription.setPassword(password.getText().toString());
//                userInscription.setCpassword(confirmPassword.getText().toString());
//                boolean insert =  dbInscription.addInscription(userInscription);
//                if(insert){
//                    Toast.makeText(getBaseContext(),"Utilisateur bien enregistre : "+ userInscription.getFullname(), Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(getBaseContext(),"Error, ressayer a nouveau", Toast.LENGTH_LONG).show();
//                }
            addedUser();
            clear();

            }
        });


        name = findViewById(R.id.editTextname);
        phoneNumber = findViewById(R.id.editTextTel);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        confirmPassword = findViewById(R.id.editTextConfirmedPassword);

        //image
            userPicture = (ImageView) findViewById(R.id.imageView);

        firebaseDatabase = FirebaseDatabase.getInstance();
        walletRef = firebaseDatabase.getReference("Wallet Application");
        walletRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    cp = (dataSnapshot.getChildrenCount());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void addedUser(){
       if(password.getText().toString().equals(confirmPassword.getText().toString())) {
           if(email.getText().toString().contains("@") && email.getText().toString().contains(".com")){
               // clear();
              // Inscription userInscription = new Inscription();
               Utilisateur userInscription = new Utilisateur();

               userInscription.setFullname(name.getText().toString().trim());
               userInscription.setNumber(phoneNumber.getText().toString().trim());
               userInscription.setEmail(email.getText().toString().trim());
               userInscription.setPassword(password.getText().toString().trim());
               userInscription.setCpassword(confirmPassword.getText().toString().trim());

               walletRef.child("Utilisateurs").child(String.valueOf(cp + 1)).setValue(userInscription);
               Toast.makeText(getBaseContext(), "Bien Enregistrement", Toast.LENGTH_LONG).show();
           }else{
               Toast.makeText(getBaseContext(), "Please Enter a valid email, manque .com or @", Toast.LENGTH_LONG).show();
           }

       }else{
           Toast.makeText(getBaseContext(), "Password must be the same", Toast.LENGTH_LONG).show();
       }
}

    public void clear(){
        name.setText("");
        phoneNumber.setText("");
        email.setText("");
        password.setText("");
        confirmPassword.setText("");
    }




}
