package self.rockpaperscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button_paper, button_scissors, button_rock;
    TextView score, currentWinner;
    ImageView computersMoveImage, playersMoveImage;

    String computersMove = "", playersMove = "";
    String computerCurrentChoice, playersCurrentChoice;
    int playersWin, computersWin, ties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_paper = (Button) findViewById(R.id.button_paper);
        button_scissors = (Button) findViewById(R.id.button_scissors);
        button_rock = (Button) findViewById(R.id.button_rock);

        computersMoveImage = (ImageView) findViewById(R.id.computerMoveImage);
        playersMoveImage = (ImageView) findViewById(R.id.playersMoveImage);

        score = (TextView) findViewById(R.id.text_score);
        currentWinner = (TextView) findViewById(R.id.current_winner);

        button_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMoveImage.setImageResource(R.drawable.paper);
                playersCurrentChoice = "p";
                playersMove += playersCurrentChoice;
                chooseComputersMove();
                calculateScore();
            }
        });

        button_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMoveImage.setImageResource(R.drawable.scissors);
                playersCurrentChoice = "s";
                playersMove += playersCurrentChoice;
                chooseComputersMove();
                calculateScore();
            }
        });

        button_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMoveImage.setImageResource(R.drawable.rock);
                playersCurrentChoice = "r";
                playersMove += playersCurrentChoice;
                chooseComputersMove();
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        if (playersCurrentChoice.equals(computerCurrentChoice)) {
            ties++;
            currentWinner.setText("Its a Tie!!!!");
        } else if (playersCurrentChoice.equals("r") && computerCurrentChoice.equals("p")) {
            computersWin++;
            currentWinner.setText("Paper folds the rock so computer wins");
        } else if (playersCurrentChoice.equals("r") && computerCurrentChoice.equals("s")) {
            playersWin++;
            currentWinner.setText("Rock breaks the scissors so You win");
        } else if (playersCurrentChoice.equals("p") && computerCurrentChoice.equals("r")) {
            playersWin++;
            currentWinner.setText("Paper folds the rock so You win");
        } else if (playersCurrentChoice.equals("p") && computerCurrentChoice.equals("s")) {
            computersWin++;
            currentWinner.setText("Scissor cuts through the paper so computer wins");
        } else if (playersCurrentChoice.equals("s") && computerCurrentChoice.equals("p")) {
            playersWin++;
            currentWinner.setText("Scissor cuts through the paper so you wins");
        } else if (playersCurrentChoice.equals("s") && computerCurrentChoice.equals("r")) {
            computersWin++;
            currentWinner.setText("Rock breaks the scissors so computer wins");
        }
        score.setText("player : " + playersWin + " computer : " + computersWin + " ties : " + ties);
    }

    private void chooseComputersMove() {
        Random random = new Random();
        int computerChoice = random.nextInt(3) + 1;
        if (computerChoice == 1)
            computerCurrentChoice = "r";
        else if (computerChoice == 2)
            computerCurrentChoice = "p";
        else
            computerCurrentChoice = "s";
        computersMove += computerCurrentChoice;
        setComputersMoveImage();

    }

    private void setComputersMoveImage() {
        if (computerCurrentChoice.equals("r"))
            computersMoveImage.setImageResource(R.drawable.rock);
        else if (computerCurrentChoice.equals("s"))
            computersMoveImage.setImageResource(R.drawable.scissors);
        else
            computersMoveImage.setImageResource(R.drawable.paper);
    }

}
