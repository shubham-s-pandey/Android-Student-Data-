package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button view;
    EditText nm;
    EditText roll;
    EditText age;
    EditText phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.submit);
        view = findViewById(R.id.view);
        nm = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    studentModel stud= new studentModel(Integer.parseInt(roll.getText().toString()),nm.getText().toString(),Integer.parseInt(age.getText().toString()),Integer.parseInt(phone.getText().toString()));
                    DatabaseModel  dbh = new DatabaseModel(MainActivity.this);
                    dbh.add(stud);
                    Toast.makeText(MainActivity.this,"Added Successfully",Toast.LENGTH_SHORT).show();

                }
                catch(Exception e)
                {
                    System.out.println(""+e);
                }
            }
        });


        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseModel myDb = new DatabaseModel(MainActivity.this);
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Name :" + res.getString(0) + "\n");
                            buffer.append("Roll No :" + res.getString(1) + "\n");
                            buffer.append("Phone No :" + res.getString(2) + "\n");
                            buffer.append("Age :" + res.getString(3) + "\n\n");
                        }
                        showMessage("STUDENT DETAILS", buffer.toString());
                    }
                }
        );



    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
