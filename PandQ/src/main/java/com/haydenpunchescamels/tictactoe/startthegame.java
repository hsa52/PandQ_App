package com.haydenpunchescamels.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class startthegame extends AppCompatActivity
{
    private int size;
    TableLayout gamepage;
    TextView userturn;
    char [][] playfield;
    char player;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameboard);
        size = Integer.parseInt(getString(R.string.boardsize));
        playfield = new char [size][size];
        gamepage = (TableLayout) findViewById(R.id.mainBoard);
        userturn = (TextView) findViewById(R.id.turn);

        resets();
        userturn.setText("It is "+player+"'s turn! Get Started!");

        for(int i = 0; i<gamepage.getChildCount(); i++)
        {
            TableRow row = (TableRow) gamepage.getChildAt(i);
            for(int j = 0; j<row.getChildCount(); j++)
            {
                TextView tv = (TextView) row.getChildAt(j);
                tv.setText(R.string.none);
                tv.setOnClickListener(Move(i, j, tv));
            }
        }
        Button startover = (Button) findViewById(R.id.reset);
        startover.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent current = getIntent();
                finish();
                startActivity(current);
            }
        });
    }
    protected void resets()
    {
        player = 'P';
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                playfield[i][j] = ' ';
            }
        }
    }
    protected int gamestat()
    {
        int rowP = 0,
                colP = 0,
                rowQ = 0,
                colQ = 0;
        for(int i = 0; i<size; i++){
            if(rows(i,'P'))
                return 1;

            if(equalrows(i, 'P'))
                return 1;

            if(rows(i,'Q'))
                return 2;

            if(equalrows(i,'Q'))
                return 2;

            if(diags('P'))
                return 1;

            if(diags('Q'))
                return 2;
        }

        boolean catsgame = true;
        for(int i = 0; i<size; i++)
        {
            for(int j= 0; j<size; j++)
            {
                if(playfield[i][j]==' ')
                    catsgame = false;
            }
        }
        if(catsgame)
            return -1;
        else return 0;
    }

    protected boolean diags(char player)
    {
        int count1 = 0,count2 = 0;
        for(int i = 0; i<size; i++)
            if(playfield[i][i]==player)
                count1++;
        for(int i = 0; i<size; i++)
            if(playfield[i][size-1-i]==player)
                count2++;
        if(count1==size || count2==size)
            return true;
        else return false;
    }

    protected boolean rows(int r, char player)
    {
        int count_Equal=0;
        for(int i = 0; i<size; i++)
        {
            if(playfield[r][i]==player)
                count_Equal++;
        }

        if(count_Equal==size)
            return true;
        else
            return false;
    }

    protected boolean equalrows(int c, char player)
    {
        int count_Equal=0;
        for(int i = 0; i<size; i++)
        {
            if(playfield[i][c]==player)
                count_Equal++;
        }

        if(count_Equal==size)
            return true;
        else
            return false;
    }

    protected boolean Cell_Set(int r, int c){
        return !(playfield[r][c]==' ');
    }

    protected void stopMatch()
    {
        for(int i = 0; i<gamepage.getChildCount(); i++)
        {
            TableRow row = (TableRow) gamepage.getChildAt(i);
            for(int j = 0; j<row.getChildCount(); j++)
            {
                TextView tv = (TextView) row.getChildAt(j);
                tv.setOnClickListener(null);
            }
        }
    }

    View.OnClickListener Move(final int r, final int c, final TextView tv)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!Cell_Set(r,c))
                {
                    playfield[r][c] = player;
                    if (player == 'P')
                    {
                        tv.setText(R.string.P);
                        player = 'Q';
                    } else if (player == 'Q')
                    {
                        tv.setText(R.string.Q);
                        player = 'P';
                    }
                    if (gamestat() == 0)
                    {
                        userturn.setText("It is " + player + "'s turn");
                    }
                    else if(gamestat() == -1)
                    {
                        userturn.setText("Cat's Game. Try Again");
                        stopMatch();
                    }
                    else
                    {
                        userturn.setText(player+" Loses!");
                        stopMatch();
                    }
                }
                else
                {
                    userturn.setText("Space Is Already Occupied");
                }
            }
        };
    }

    public void returnbuttonclicked(View v)
    {
        startActivity(new Intent(getApplicationContext(), homescreen.class));
    }
}
