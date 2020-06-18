package esisa.android.wallet;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import esisa.android.wallet.models.Project;
import esisa.android.wallet.models.Utilisateur;

public class AddProjectsActivity extends AppCompatActivity {
    public EditText name, period, budget, description;
    public Button btnAddedProject;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference walletRef;
    long cp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addprojects);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


         name = findViewById(R.id.nameProject);
         period = findViewById(R.id.periodeProject);
         budget = findViewById(R.id.budgetPeriode);
         description = findViewById(R.id.descritpionProject);

         btnAddedProject = findViewById(R.id.btnAddedPrjt);
         btnAddedProject.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                addedProject();
             }
         });

         firebaseDatabase = FirebaseDatabase.getInstance();
         walletRef = firebaseDatabase.getReference("Wallet Application");
         walletRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cp = (dataSnapshot.getChildrenCount());
             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });


    }
    public void addedProject(){
        Project project = new Project();

                project.setProjectName(name.getText().toString().trim());
                project.setProjectBudget(budget.getText().toString().trim());
                project.setProjectDescription(description.getText().toString().trim());
                project.setProjectPeriode(period.getText().toString().trim());

             walletRef.child("Projects").child(String.valueOf(cp + 1)).setValue(project);
      }

}
