package esisa.android.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import esisa.android.wallet.dal.DbInscription;

public class MainActivity extends AppCompatActivity {
    // Nv Changement
    // Nv Changement2

    ListView lst;
    String[] projectsname={"projet1","projet2","projet3"};
    String[] projectsdesc={"projet1description","projet2description","projet3description"};
    Integer[] imgid = {R.drawable.food,R.drawable.travel,R.drawable.sante};
    private Button signupbt;
    private TextView textView;
    private EditText edtusername,edtpass;
    private DbInscription dbInscription;
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

        lst = (ListView) findViewById(R.id.listview);

        textView=findViewById(R.id.login);
        edtusername =findViewById(R.id.username);
        edtpass=findViewById(R.id.userpass);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edtusername.getText().toString();
                String pass=edtpass.getText().toString();
                boolean res=dbInscription.Login(username,pass);
                if(res==true){
                    Home();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Inscrivez-vous",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void openSignupActivity() {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
    public void Home(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


}
