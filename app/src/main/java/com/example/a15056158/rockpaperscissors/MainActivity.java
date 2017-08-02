package com.example.a15056158.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRock, btnScissors, btnPaper;
    ImageView ivCompChoice, ivHumanChoice;
    TextView tvResult;

    int HumanScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRock =(Button) findViewById(R.id.btnRock);
        btnPaper =(Button) findViewById(R.id.btnPaper);
        btnScissors =(Button) findViewById(R.id.btnScissors);
        ivCompChoice = (ImageView) findViewById(R.id.ivComp);
        ivHumanChoice = (ImageView) findViewById(R.id.ivHuman);
        tvResult = (TextView) findViewById(R.id.textViewResult);

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivHumanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tvResult.setText(" Score Human: " + Integer.toString(HumanScore) + " Score Computer: " + Integer.toString(ComputerScore));

            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivHumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tvResult.setText("Score Human: " + Integer.toString(HumanScore) + "Score Computer " + Integer.toString(ComputerScore));

            }
        });

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivHumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tvResult.setText("Score Human: " + Integer.toString(HumanScore) + "Score Computer " + Integer.toString(ComputerScore));

            }
        });
    }

    private String play_turn(String player_choice) {

        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3) + 1;

        if(computer_choice_number == 1){
            computer_choice = "scissors";
        }else if(computer_choice_number == 2){
            computer_choice = "paper";
        }else if(computer_choice_number == 3){
            computer_choice = "rock";
        }

        if(computer_choice == "rock"){
            ivCompChoice.setImageResource(R.drawable.rock);
        }else if(computer_choice == "scissors"){
            ivCompChoice.setImageResource(R.drawable.scissors);
        }else if(computer_choice == "paper"){
            ivCompChoice.setImageResource(R.drawable.paper);
        }

        if (computer_choice == player_choice){
            return "Draw. Nobody won";

        }else if (player_choice == "rock" && computer_choice == "scissors"){
            HumanScore++;
            return "Rock crushes scissors. You Win";
        }else if (player_choice == "rock" && computer_choice == "paper"){
            ComputerScore++;
            return "Paper covers rock. Computer Win";
        }else if (player_choice == "scissors" && computer_choice == "rock"){
            ComputerScore++;
            return "Rock crushes scissors. Computer Win";
        }else if (player_choice == "scissors" && computer_choice == "paper"){
            HumanScore++;
            return "Scissors cuts paper. You Win";
        }else if (player_choice == "paper" && computer_choice == "rock"){
            HumanScore++;
            return "Paper covers rock. You Win";
        }else if (player_choice == "paper" && computer_choice == "scissors"){
            ComputerScore++;
            return "Paper cut scissors. Computer Win";
        }

        else return "Game Over";
    }


}
