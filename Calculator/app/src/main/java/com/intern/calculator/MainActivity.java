package com.intern.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String oldNum;
    String op="+";
    boolean flag=true;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.text);
    }
    public void OnNumber(View view){
        if(flag){
         t.setText("");
         flag=false;
        }
        String num=t.getText().toString();
        String b=((Button) findViewById(view.getId())).getText().toString();
        if(b.equals("AC")){
            oldNum="0";
            t.setText("0");
            flag=true;
        }else if(b.equals("=")){
            calculate();
        }
        else if(b.equals("+/-")){
            if(num.charAt(0)=='-') num=num.substring(1);
            else num="-"+num;
            t.setText(num);
        }else{
            num+=b;
            t.setText(num);
        }
    }
    public void onOperator(View view){
        oldNum=t.getText().toString();
        t.setText("");
        switch(view.getId()){
            case R.id.buPlus:
                op="+";
                break;
            case R.id.buMinus:
                op="-";
                break;
            case R.id.buDiv:
                op="/";
                break;
            case R.id.buMul:
                op="*";
                break;
        }
    }
    public void calculate(){
        String newNum=t.getText().toString();
        double result=0.0;
        switch (op){
            case "+":
                result=Double.parseDouble(newNum)+Double.parseDouble(oldNum);
                break;
            case "-":
                result=Double.parseDouble(oldNum)-Double.parseDouble(newNum);
                break;
            case "*":
                result=Double.parseDouble(newNum)*Double.parseDouble(oldNum);
                break;
            case "/":
                result=Double.parseDouble(oldNum)/Double.parseDouble(newNum);
                break;
        }
        t.setText(result+"");
    }
}