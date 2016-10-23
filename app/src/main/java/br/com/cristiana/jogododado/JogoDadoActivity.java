package br.com.cristiana.jogododado;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Random;

public class JogoDadoActivity extends AppCompatActivity implements OnInitListener {

    ImageView imgJogador;
    ImageView imgComputador;
    private TextToSpeech tts;

    int imagem[] = {R.drawable.dado1, R.drawable.dado2, R.drawable.dado3, R.drawable.dado4, R.drawable.dado5, R.drawable.dado6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_dado);

        imgJogador = (ImageView) findViewById(R.id.imgJog);
        imgComputador = (ImageView) findViewById(R.id.imgComp);

        //sintetizador de voz
        Context context = this;
        OnInitListener listener = this;
        tts = new TextToSpeech(context, listener);
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

        tts.speak(resultado, TextToSpeech.QUEUE_FLUSH, null);
        Toast alert = Toast.makeText(this, resultado, Toast.LENGTH_SHORT);
        alert.show();

    }


    @Override
    public void onInit(int status) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tts.shutdown();
    }
}
