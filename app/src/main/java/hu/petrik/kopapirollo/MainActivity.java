package hu.petrik.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView playerImage;
    ImageView botImage;
    TextView playerWin;
    TextView botWin;
    Button ko;
    Button papir;
    Button ollo;

    //0 - KŐ, 1 - PAPÍR, 2 - OLLÓ
    private int player = 0;
    private int bot = 0;

    private int playerWinCount = 0;
    private int botWinCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerImage = (ImageView) findViewById(R.id.playerImage);
        botImage = (ImageView) findViewById(R.id.botImage);
        playerWin = (TextView) findViewById(R.id.playerEredmeny);
        botWin = (TextView) findViewById(R.id.botEredmeny);
        ko = (Button) findViewById(R.id.ko);
        papir = (Button) findViewById(R.id.papir);
        ollo = (Button) findViewById(R.id.ollo);

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImage.setImageResource(R.drawable.rock);
                player = 0;
                bot = (int)(Math.random() * 3);
                kepBeallitas();
                ellenorzes();
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImage.setImageResource(R.drawable.paper);
                player = 1;
                bot = (int)(Math.random() * 3);
                kepBeallitas();
                ellenorzes();
            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImage.setImageResource(R.drawable.scissors);
                player = 2;
                bot = (int)(Math.random() * 3);
                kepBeallitas();
                ellenorzes();
            }
        });
    }

    private void kepBeallitas(){
        if (bot == 0){
            botImage.setImageResource(R.drawable.rock);
        } else if (bot == 1){
            botImage.setImageResource(R.drawable.paper);
        } else {
            botImage.setImageResource(R.drawable.scissors);
        }
    }

    private void ellenorzes()
    {
        if (player == 0 && bot == 1){
            botWinCount++;
            botWin.setText(String.valueOf(botWinCount));
        } else if (player == 0 && bot == 2){
            playerWinCount++;
            playerWin.setText(String.valueOf(playerWinCount));
        } else if (player == 1 && bot == 0){
            playerWinCount++;
            playerWin.setText(String.valueOf(playerWinCount));
        } else if (player == 1 && bot == 2) {
            botWinCount++;
            botWin.setText(String.valueOf(botWinCount));
        } else if (player == 2 && bot == 0) {
            botWinCount++;
            botWin.setText(String.valueOf(botWinCount));
        } else if (player == 2 && bot == 1){
            playerWinCount++;
            playerWin.setText(String.valueOf(playerWinCount));
        } else {
            Toast.makeText(getApplicationContext(), "Döntetlen", Toast.LENGTH_SHORT).show();
        }
    }
}