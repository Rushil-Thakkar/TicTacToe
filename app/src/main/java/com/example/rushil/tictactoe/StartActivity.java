package com.example.rushil.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        RadioButton r1,r2,r3,r4,r5,r6;
        r1=(RadioButton)findViewById(R.id.btnx);
        r2=(RadioButton)findViewById(R.id.btno);
        r3=(RadioButton)findViewById(R.id.btnredx);
        r4=(RadioButton)findViewById(R.id.btnbluex);
        r5=(RadioButton)findViewById(R.id.btnredo);
        r6=(RadioButton)findViewById(R.id.btnblueo);

        RadioButton RB1[]=new RadioButton[]{r1,r2};
        RadioButton RB2[]=new RadioButton[]{r3,r4};
        RadioButton RB3[]=new RadioButton[]{r5,r6};

        for(RadioButton Rb : RB1)
        {
            if(Rb.isChecked())
            {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, Rb.getText());
                startActivity(intent);
                for (RadioButton Rb1 : RB2)
                {
                    if (Rb1.isChecked())
                    {
                        intent = new Intent(this, MainActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, Rb1.getText());
                        startActivity(intent);
                        for (RadioButton Rb2 : RB3)
                        {
                            if (Rb2.isChecked())
                            {
                                intent = new Intent(this, MainActivity.class);
                                intent.putExtra(EXTRA_MESSAGE, Rb2.getText());
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        }

    }
}
