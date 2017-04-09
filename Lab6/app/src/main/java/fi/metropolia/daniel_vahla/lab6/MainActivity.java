package fi.metropolia.daniel_vahla.lab6;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;
import java.util.StringTokenizer;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.LV;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    Random r = new Random();
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, months);
        ListView LV = (ListView) findViewById(R.id.monthList);
        LV.setAdapter(myAdapter);
        result = (TextView)findViewById(R.id.score);
        LV.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        int i = r.nextInt(12);
        String selected = (String) parent.getItemAtPosition(position);
        if (selected.equals(months[i])){
            result.setText(R.string.win);
            result.setTextColor(Color.GREEN);
        }else{
            result.setText(R.string.loose);
            result.setTextColor(Color.RED);
        }
    }
}
