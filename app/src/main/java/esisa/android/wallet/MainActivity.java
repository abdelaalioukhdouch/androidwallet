package esisa.android.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // Nv Changement
    ListView lst;
    String[] projectsname={"projet1","projet2","projet3"};
    String[] projectsdesc={"projet1description","projet2description","projet3description"};
    Integer[] imgid = {R.drawable.food,R.drawable.travel,R.drawable.sante};
    private Button signupbt;
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
    }

    public void openSignupActivity() {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }


}
