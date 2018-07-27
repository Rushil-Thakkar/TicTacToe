package com.example.rushil.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,play;
    Button [] btnArray;

    boolean Turn=true; // O=true, X=false
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText message;
        final String s="tictactoe";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1=(Button)findViewById(R.id.A1);
        a2=(Button)findViewById(R.id.A2);
        a3=(Button)findViewById(R.id.A3);
        b1=(Button)findViewById(R.id.B1);
        b2=(Button)findViewById(R.id.B2);
        b3=(Button)findViewById(R.id.B3);
        c1=(Button)findViewById(R.id.C1);
        c2=(Button)findViewById(R.id.C2);
        c3=(Button)findViewById(R.id.C3);
        play= (Button)findViewById(R.id.play);
        btnArray=new Button []{a1,a2,a3,b1,b2,b3,c1,c2,c3};
        Intent intent=getIntent();
        String s1=intent.getStringExtra(s);
        TextView t= new TextView(this);
        t.setText(s1);

        for(Button B : btnArray)
        {
            B.setOnClickListener(this);
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Turn=true;
                count=0;
                EnableAndDisable(true);
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        buttonClicked((Button) v);
    }

    public void buttonClicked(Button b)
    {
        b.setTextSize(60);
        if(Turn==true)
        {
            b.setText("O");
            b.setTextColor(Color.BLUE);
        }
        else
        {
            b.setText("X");
            b.setTextColor(Color.RED);
        }
        count++;
        b.setBackgroundColor(Color.LTGRAY);
        b.setClickable(false);
        Turn= !Turn;
        checkWinner();
    }
    public void checkWinner()
    {
        boolean winner=false;
        //for horizonatal
        if(a1.getText()==a2.getText()&& a2.getText()==a3.getText() && a3.isClickable()==false)
        {
            winner=true;
        }
        else if(b1.getText()==b2.getText()&& b2.getText()==b3.getText()&& b3.isClickable()==false)
        {
            winner=true;
        }
        else if(c1.getText()==c2.getText()&& c2.getText()==c3.getText()&& c3.isClickable()==false)
        {
            winner=true;
        }

        //for vertical
        else if(a1.getText()==b1.getText()&& b1.getText()==c1.getText() && c1.isClickable()==false)
        {
            winner=true;
        }
        else if(a2.getText()==b2.getText()&& b2.getText()==c2.getText()&& c2.isClickable()==false)
        {
            winner=true;
        }
        else if(a3.getText()==b3.getText()&& b3.getText()==c3.getText()&& c3.isClickable()==false)
        {
            winner=true;
        }
        //for diagonals
        else if(a1.getText()==b2.getText()&& b2.getText()==c3.getText() && c3.isClickable()==false)
        {
            winner=true;
        }
        else if(a3.getText()==b2.getText()&& b2.getText()==c1.getText()&& c1.isClickable()==false)
        {
            winner=true;
        }

        //prints who win
        if(winner==true)
        {
            if(Turn==true)
            {
                toast("X WINS...!!!!");
            }
            else
            {
                toast("O WINS...!!!!");
            }
            EnableAndDisable(false);
        }
        else if(count==9)
        {
            toast("DRAW...!!!!");
        }
    }

    private void EnableAndDisable(boolean d)
    {
        for(Button b:btnArray)
        {
            b.setClickable(d);

            if(d==false)
            {
                b.setBackgroundColor(Color.LTGRAY);
            }
            else if(d==true)
            {
                b.setBackgroundColor(Color.parseColor("#3f51b5"));
                b.setText("");
            }

        }
    }

    public void toast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg ,Toast.LENGTH_SHORT).show();
    }
}
