package self.rockpaperscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button_paper, button_scissors, button_rock;
    TextView score, currentWinner;
    ImageView computersMoveImage, playersMoveImage;

    String playersMove = "";
    String playersCurrentChoice;
    int playersWin, computersWin, ties;
    private ComputersMove computersMove = new ComputersMove();

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
                computersMove.chooseComputersMove(playersMove);
                setComputersMoveImage();
                calculateScore();
            }
        });

        button_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMoveImage.setImageResource(R.drawable.scissors);
                playersCurrentChoice = "s";
                playersMove += playersCurrentChoice;
                computersMove.chooseComputersMove(playersMove);
                setComputersMoveImage();
                calculateScore();
            }
        });

        button_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMoveImage.setImageResource(R.drawable.rock);
                playersCurrentChoice = "r";
                playersMove += playersCurrentChoice;
                computersMove.chooseComputersMove(playersMove);
                setComputersMoveImage();
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        if (playersCurrentChoice.equals(computersMove.computerCurrentChoice)) {
            ties++;
            currentWinner.setText("Its a Tie!!!!");
        } else if (playersCurrentChoice.equals("r") && computersMove.computerCurrentChoice.equals("p")) {
            computersWin++;
            currentWinner.setText("Paper folds the rock so computer wins");
        } else if (playersCurrentChoice.equals("r") && computersMove.computerCurrentChoice.equals("s")) {
            playersWin++;
            currentWinner.setText("Rock breaks the scissors so You win");
        } else if (playersCurrentChoice.equals("p") && computersMove.computerCurrentChoice.equals("r")) {
            playersWin++;
            currentWinner.setText("Paper folds the rock so You win");
        } else if (playersCurrentChoice.equals("p") && computersMove.computerCurrentChoice.equals("s")) {
            computersWin++;
            currentWinner.setText("Scissor cuts through the paper so computer wins");
        } else if (playersCurrentChoice.equals("s") && computersMove.computerCurrentChoice.equals("p")) {
            playersWin++;
            currentWinner.setText("Scissor cuts through the paper so you wins");
        } else if (playersCurrentChoice.equals("s") && computersMove.computerCurrentChoice.equals("r")) {
            computersWin++;
            currentWinner.setText("Rock breaks the scissors so computer wins");
        }
        score.setText("player : " + playersWin + " computer : " + computersWin + " ties : " + ties);
    }


    private void setComputersMoveImage() {
        if (computersMove.computerCurrentChoice.equals("r"))
            computersMoveImage.setImageResource(R.drawable.rock);
        else if (computersMove.computerCurrentChoice.equals("s"))
            computersMoveImage.setImageResource(R.drawable.scissors);
        else
            computersMoveImage.setImageResource(R.drawable.paper);
    }

}
