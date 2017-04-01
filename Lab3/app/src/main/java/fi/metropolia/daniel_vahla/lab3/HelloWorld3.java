package fi.metropolia.daniel_vahla.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HelloWorld3 extends AppCompatActivity implements View.OnClickListener {
    private TextView UT;
    private TextView LT;
    private Button BT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world3);
        UT = (TextView)findViewById(R.id.TopText);
        LT = (TextView)findViewById(R.id.BottomText);
        BT = (Button)findViewById(R.id.Button1);
        BT.setOnClickListener(this);
    }
    public void onClick(View button1){
        if(UT.getText()==getString(R.string.Hello)){
            UT.setText(R.string.World);
            LT.setText(R.string.Hello);
        }else {
            LT.setText(R.string.World);
            UT.setText(R.string.Hello);
        }
    }
}
