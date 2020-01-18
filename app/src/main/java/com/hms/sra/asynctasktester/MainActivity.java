package com.hms.sra.asynctasktester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Worker wrkr;
    EditText result;
    EditText pResult;
    EditText preResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (EditText)findViewById(R.id.etid);

        pResult = (EditText)findViewById(R.id.petid);
        preResult = (EditText)findViewById(R.id.preetid);
        //wrkr = new Worker(result);

    }

    public void onEnqueueClickListener(View view) {
        try {
            new Worker(result,pResult,preResult).execute("");
        }
        catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }

}
