package br.com.cristiana.jogododado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class JogoDadoActivity extends AppCompatActivity {

    ImageView imgJogador;
    ImageView imgComputador;

    int imagem[] = {R.drawable.dado1, R.drawable.dado2, R.drawable.dado3, R.drawable.dado4, R.drawable.dado5, R.drawable.dado6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_dado);

        imgJogador = (ImageView) findViewById(R.id.imgJog);
        imgComputador = (ImageView) findViewById(R.id.imgComp);
    }

    public void jogar(View v)
    {
        Random rJog = new Random();
        int rJogador = rJog.nextInt(5);

        Random rComp = new Random();
        int rComputador = rComp.nextInt(5);

        imgJogador.setImageResource(imagem[rJogador]);
        imgComputador.setImageResource(imagem[rComputador]);

        String resultado = "Empate";

        if (rJogador > rComputador){
            resultado = "O Jogador Ganhou";
        } else if (rComputador > rJogador){
            resultado = "O Computador Ganhou";
        }

        Toast alert = Toast.makeText(this, resultado, Toast.LENGTH_SHORT);
        alert.show();

    }


}
