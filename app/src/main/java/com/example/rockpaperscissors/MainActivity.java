package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    int randomNum=1;
    int cpu=1;
    String[] rps={"Rock","Paper","Scissors"};
    String msg1="";
    String msg2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1=(Button)findViewById(R.id.btn1);

        Spinner sp= (Spinner)findViewById(R.id.spinner1);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cpu=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        TextView t1 = (TextView)findViewById(R.id.result);
        TextView t2 = (TextView)findViewById(R.id.result2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum= rand.nextInt(3);
                if(cpu==randomNum){
                    msg1="Draw";
                }else if((cpu==0&&randomNum==2)||(cpu==2&&randomNum==0)||(cpu==2&&randomNum==1)){
                    msg1="Congrats You won!!";
                }else{
                    msg1="Sorry! You Lost.";
                }
                msg2="We chose "+rps[randomNum]+", and you chose "+rps[cpu];
                t1.setText(msg1);
                t2.setText(msg2);
            }
        });
    }
}