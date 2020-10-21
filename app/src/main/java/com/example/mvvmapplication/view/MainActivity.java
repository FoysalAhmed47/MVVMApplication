package com.example.mvvmapplication.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmapplication.R;
import com.example.mvvmapplication.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    EditText editText1,editText2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        button1=findViewById(R.id.button);

    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mainActivityViewModel.additionFunction(editText1.getText().toString(),editText2.getText().toString()).observe(MainActivity.this, new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {

                    Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                }
            });


//           String resultText = mainActivityViewModel.additionFunction(editText1.getText().toString(),editText2.getText().toString());
//            Toast.makeText(MainActivity.this,resultText,Toast.LENGTH_LONG).show();

        }
    });
    }

}
