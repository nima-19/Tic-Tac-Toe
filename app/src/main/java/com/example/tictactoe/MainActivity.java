package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activeUser = 0;
    int[] gameState ={2,2,2,2,2,2,2,2,2};
    int[][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn (View view){
        ImageView counter = (ImageView)view;
        Log.i("activeUser", counter.getTag().toString());
        int tappedCount = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCount]=activeUser;
        counter.setTranslationY(-1500);
        if(activeUser == 0) {
                counter.setImageResource(R.drawable.red);
                activeUser = 1;
        } else {
            counter.setImageResource(R.drawable.yellow);
            activeUser =0;
        }
        counter.animate().translationYBy(1500).setDuration(200);
        for(int winningPosition[] : winningPosition)
        {
            if(gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]]== gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]]!=2) {
                String winner;
                if(activeUser == 1) {
                    winner = "Red";
                } else{
                    winner = "Yellow";
                }
                Toast.makeText(this, winner + " is winner", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
