package ru.startandroid.recyclerviewanddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName,etEmail,etAge ;
    Button btnInsert,btnView ;
    DBHelper DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etAge = findViewById(R.id.etAge);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);

        // get object in DBHelper.class
        DB = new DBHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UserList.class));
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get information from editTexts
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String age = etAge.getText().toString();

                // send information to database by insetUserdata method
                Boolean checkInsertData = DB.insertUserdata(name,email,age);

                if (checkInsertData == true){
                    Toast.makeText(MainActivity.this, "New Entry Insert", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "New Entry NOT Insert", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}