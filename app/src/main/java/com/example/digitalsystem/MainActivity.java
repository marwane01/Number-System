package com.example.digitalsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Spinner spinner,spinner2;
    Button button;
    String names[]={"Decimal","Binary","Octal","Hexadecimal"};
    ArrayAdapter <String> adapter;
    String record="",record1="";
    TextView textView,textView1;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editTextTextPersonName);
        textView=(TextView)findViewById(R.id.textView);
        textView1=(TextView)findViewById(R.id.textView1);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        button=(Button)findViewById(R.id.button);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        record = "Decimal";
                        editText.setText("");
                        editText.setKeyListener(DigitsKeyListener.getInstance("0123456789."));

                        break;
                    case 1:
                        record = "Binary";
                        editText.setText("");
                        editText.setKeyListener(DigitsKeyListener.getInstance("01"));
                        break;
                    case 2:
                        record = "Octal";
                        editText.setText("");
                        editText.setKeyListener(DigitsKeyListener.getInstance("01234567."));
                        break;
                    case 3:
                        record = "Hexadecimal";
                        editText.setText("");
                        editText.setInputType(InputType.TYPE_CLASS_TEXT);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        record1 = "Decimal";

                        break;
                    case 1:
                        record1 = "Binary";
                        break;
                    case 2:
                        record1 = "Octal";
                        break;
                    case 3:
                        record1 = "Hexadecimal";

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void convert(View view) {
        textView.setTextSize(18);
        String aa=editText.getText().toString();
        textView.setText(aa);




    }

}
