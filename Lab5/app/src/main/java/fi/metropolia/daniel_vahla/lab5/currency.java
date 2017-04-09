package fi.metropolia.daniel_vahla.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class currency extends AppCompatActivity implements View.OnClickListener{
    String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        Button calcButton = (Button)findViewById(R.id.CalculateButton);
        calcButton.setOnClickListener(this);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    result = "USD";
                    break;
            case R.id.radioButton2:
                if (checked)
                    result = "YEN";
                    break;
        }
    }
    public void onClick(View v) {
        Intent res = new Intent();
        res.putExtra("choice", result);
        setResult(RESULT_OK,res);
        finish();
    }
}
