package fi.metropolia.daniel_vahla.lab4;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    private String lastOperator ="";
    private String tempString1 = "";
    private String tempString2 = "";
    private String viewString = "";
    private Float sum = null;
    public TextView Result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Result = (TextView)findViewById(R.id.Result);
        Button b1x1 = (Button) findViewById(R.id.b1x1);
        b1x1.setOnClickListener(this);
        Button b1x2 = (Button) findViewById(R.id.b1x2);
        b1x2.setOnClickListener(this);
        Button b1x3 = (Button) findViewById(R.id.b1x3);
        b1x3.setOnClickListener(this);
        Button b1x4 = (Button) findViewById(R.id.b1x4);
        b1x4.setOnClickListener(this);
        Button b2x1 = (Button) findViewById(R.id.b2x1);
        b2x1.setOnClickListener(this);
        Button b2x2 = (Button) findViewById(R.id.b2x2);
        b2x2.setOnClickListener(this);
        Button b2x3 = (Button) findViewById(R.id.b2x3);
        b2x3.setOnClickListener(this);
        Button b2x4 = (Button) findViewById(R.id.b2x4);
        b2x4.setOnClickListener(this);
        Button b3x1 = (Button) findViewById(R.id.b3x1);
        b3x1.setOnClickListener(this);
        Button b3x2 = (Button) findViewById(R.id.b3x2);
        b3x2.setOnClickListener(this);
        Button b3x3 = (Button) findViewById(R.id.b3x3);
        b3x3.setOnClickListener(this);
        Button b3x4 = (Button) findViewById(R.id.b3x4);
        b3x4.setOnClickListener(this);
        Button b4x1 = (Button) findViewById(R.id.b4x1);
        b4x1.setOnClickListener(this);
        Button b4x2 = (Button) findViewById(R.id.b4x2);
        b4x2.setOnClickListener(this);
        Button b4x3 = (Button) findViewById(R.id.b4x3);
        b4x3.setOnClickListener(this);
        Button b4x4 = (Button) findViewById(R.id.b4x4);
        b4x4.setOnClickListener(this);
    }

    public void onClick(View v) {
        int viewID = v.getId();
        switch(viewID){
            case R.id.b1x1:
                InputNumber(getString(R.string.s1x1));
                break;
            case R.id.b1x2:
                InputNumber(getString(R.string.s1x2));
                break;
            case R.id.b1x3:
                InputNumber(getString(R.string.s1x3));
                break;
            case R.id.b1x4:
                Operation(getString(R.string.s1x4));
                break;
            case R.id.b2x1:
                InputNumber(getString(R.string.s2x1));
                break;
            case R.id.b2x2:
                InputNumber(getString(R.string.s2x2));
                break;
            case R.id.b2x3:
                InputNumber(getString(R.string.s2x3));
                break;
            case R.id.b2x4:
                Operation(getString(R.string.s2x4));
                break;
            case R.id.b3x1:
                InputNumber(getString(R.string.s3x1));
                break;
            case R.id.b3x2:
                InputNumber(getString(R.string.s3x2));
                break;
            case R.id.b3x3:
                InputNumber(getString(R.string.s3x3));
                break;
            case R.id.b3x4:
                Operation(getString(R.string.s3x4));
                break;
            case R.id.b4x1:
                InputNumber(getString(R.string.s4x1));
                break;
            case R.id.b4x2:
                ClearButton();
                break;
            case R.id.b4x3:
                GiveResult();
                break;
            case R.id.b4x4:
                Operation(getString(R.string.s4x4));
                break;
        }
    }

    private void InputNumber(String btn){
            tempString1 += btn;
            viewString = tempString1;
            Result.setText(viewString);
    }

    private void Operation (String opr){
        if(!tempString1.equals("")){
            if(sum==null){
                sum = Float.parseFloat(tempString1);
                lastOperator = opr;
            }else{
                switch (lastOperator){
                    case "/" :
                        sum /= Float.parseFloat(tempString1);
                        break;
                    case "*":
                        sum *= Float.parseFloat(tempString1);
                        break;
                    case"-":
                        sum -= Float.parseFloat(tempString1);
                        break;
                    case "+":
                        sum += Float.parseFloat(tempString1);
                        break;
                    }
                lastOperator = opr;
                }
            tempString2 = opr;
            viewString = tempString2;
            Result.setText(viewString);
            tempString1 = "";
        }
    }

    private void GiveResult (){
        if(!tempString1.equals("")){
            switch (lastOperator){
                case "/":
                    sum /= Float.parseFloat(tempString1);
                    break;
                case "*":
                    sum *= Float.parseFloat(tempString1);
                    break;
                case "-":
                    sum -= Float.parseFloat(tempString1);
                    break;
                case "+":
                    sum += Float.parseFloat(tempString1);
            }
        }
        if(sum!=null) {
            tempString1 = sum.toString();
        }
        tempString1 = !tempString1.contains(".") ? tempString1 : tempString1.replaceAll("0*$", "").replaceAll("\\.$", "");//remove trailing .0
        Result.setText(tempString1);
        tempString2 = "";
        lastOperator ="";
        sum = null;
    }
    private void ClearButton(){
        if(tempString1.length()>1) {
            tempString1 = tempString1.substring(0, tempString1.length() - 1);
            viewString = tempString1;
            Result.setText(viewString);
        }
        if(tempString1.length()==1){
            tempString1 ="";
            viewString = "";
            Result.setText(viewString);
        }
    }
}
