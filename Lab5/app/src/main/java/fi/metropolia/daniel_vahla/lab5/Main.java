package fi.metropolia.daniel_vahla.lab5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity implements View.OnClickListener {
    private TextView result;
    private EditText theInput;
    private float EURtoUSD = (float) 1.06;
    private float EURtoYEN = (float) 117.66;
    final int EXECUTE_ORDER = 66;
    private float conversion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convButton = (Button)findViewById(R.id.ConvertButton);
        convButton.setOnClickListener(this);
        result = (TextView)findViewById(R.id.ConvertResult);
        theInput = (EditText)findViewById(R.id.InputHere);
    }



    public void onClick(View v){
        Intent myIntent = new Intent(this, currency.class);
        startActivityForResult(myIntent,EXECUTE_ORDER);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == EXECUTE_ORDER){

            if(resultCode == Activity.RESULT_OK){

                String txt = data.getStringExtra("choice");
                String temp = theInput.getText().toString();
                double amount = Float.parseFloat(temp);
                result.setTextColor(Color.BLACK);

                switch (txt){
                    case "USD":
                        amount *= EURtoUSD;
                        temp = String.format("%.2f",amount);
                        result.setText(temp);
                        break;
                    case "YEN":
                        amount *= EURtoYEN;
                        temp = String.format("%.2f",amount);
                        result.setText(temp);
                }
            }
        }
    }
}
