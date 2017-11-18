package self.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button_paper, button_scissors, button_rock;
    TextView score;
    ImageView computersMove, playersMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_paper = (Button) findViewById(R.id.button_paper);
        button_scissors = (Button) findViewById(R.id.button_scissors);
        button_rock = (Button) findViewById(R.id.button_rock);

        computersMove = (ImageView) findViewById(R.id.computerMoveImage);
        playersMove = (ImageView) findViewById(R.id.playersMoveImage);

        score = (TextView) findViewById(R.id.text_score);

        button_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMove.setImageResource(R.drawable.paper);
            }
        });

        button_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMove.setImageResource(R.drawable.scissors);
            }
        });

        button_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersMove.setImageResource(R.drawable.rock);
            }
        });
    }
}
