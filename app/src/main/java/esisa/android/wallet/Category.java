package esisa.android.wallet;

import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Category extends AppCompatActivity {


    ConstraintLayout mLayout;
    int mDefaultColor;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mLayout = (ConstraintLayout) findViewById(R.id.drawer_layout);
        mDefaultColor = ContextCompat.getColor(Category.this, R.color.colorPrimary);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }

    public void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                mLayout.setBackgroundColor(mDefaultColor);
            }
        });
        colorPicker.show();
    }
}
