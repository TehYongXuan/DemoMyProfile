package sg.edu.rp.c346.id21010860.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);

    }
        @Override
        protected void onPause() {
            super.onPause();
            //step1a: Get the user input from the EditText and store it in a variable
           String strName = etName.getText().toString();
           float gpa = Float.parseFloat(etGPA.getText().toString());
            //step2: oBTAIN AN INSTANCE OF THE SharedPreferences
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            //step3: Obtain an instance of the SharedPreferences Editor for update later
            SharedPreferences.Editor prefEdit = prefs.edit();
            //step4: add the key-value pair
            prefEdit.putString("strName",strName);
            prefEdit.putString("gpa",gpa+"");
            //step5: Call commit() to save the changes made to the SharedPreferences
            prefEdit.commit();
        }


        @Override
        protected void onResume() {
            super.onResume();
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            String strName = prefs.getString("name","John");
            String gpa = prefs.getString("gpa","4.0");

            etName.setText(strName);
            etGPA.setText(gpa + "");


    }
}
