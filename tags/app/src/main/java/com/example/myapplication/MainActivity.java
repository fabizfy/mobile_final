package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn =(Button) findViewById(R.id.button);
        Button btn1 =(Button)findViewById(R.id.button1);
        Button btn2 =(Button)findViewById(R.id.button2);
        Button btn3 =(Button)findViewById(R.id.button3);
        Button btn4 =(Button)findViewById(R.id.button4);
        Button btn5 =(Button)findViewById(R.id.button5);
        Button btn6 =(Button)findViewById(R.id.button6);
        Button btn7 =(Button)findViewById(R.id.button7);
        Button btn8 =(Button)findViewById(R.id.button8);
        Button btn9=(Button)findViewById(R.id.button9);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(MainActivity.this,Psychology.class);
                startActivity(int1);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2=new Intent(MainActivity.this,Art.class);
                startActivity(int2);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3=new Intent(MainActivity.this,mathematics.class);
                startActivity(int3);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4=new Intent(MainActivity.this,physics.class);
                startActivity(int4);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5=new Intent(MainActivity.this,Chemistry.class);
                startActivity(int5);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6=new Intent(MainActivity.this,geography.class);
                startActivity(int6);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int7=new Intent(MainActivity.this,grammar.class);
                startActivity(int7);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int8=new Intent(MainActivity.this,litterature.class);
                startActivity(int8);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int9=new Intent(MainActivity.this,science.class);
                startActivity(int9);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int10=new Intent(MainActivity.this,history.class);
                startActivity(int10);
            }
        });

    }
}
