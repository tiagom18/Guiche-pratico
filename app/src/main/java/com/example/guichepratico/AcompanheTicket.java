package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class AcompanheTicket extends AppCompatActivity {

    private String agencia;
    private String atendimento;
    private String prioridade;
    public View getBtnMenuInicial() {
        return btnMenuInicial;
    }
    public void setBtnMenuInicial(View btnMenuInicial) {
        this.btnMenuInicial = btnMenuInicial;
    }
    private View btnMenuInicial;
    private String[] numeros ={"0","1","2","3","4","5","6","7","8","9"};
    private String senha = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhe_ticket);

        Intent it= getIntent();
        Random ran = new Random();


        int num = 3;

        for ( int i = 0; i < num; i++){
            int a = ran.nextInt(numeros.length);
            senha = numeros[a];
        }


        Bundle params = it.getExtras();
        prioridade = params.getString("PRIORIDADE");
        atendimento = params.getString("ATENDIMENTO");
        agencia = params.getString("AGENCIA");

        TextView valorTicket = findViewById(R.id.textViewValor);
        valorTicket.setText("Prioridade:\n" + prioridade +"\n"+ "Atendimento:\n"+ atendimento +"\n"+"Agencia: \n"+ agencia +"\n"+ "Senha: \n" +senha);
        this.setBtnMenuInicial(findViewById(R.id.menuInicial));
        this.getBtnMenuInicial().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AcompanheTicket.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}