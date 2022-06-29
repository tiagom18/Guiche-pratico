package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class EscolhaAtendimento extends AppCompatActivity {

    public View getBtnEscolhaAtendimento() {
        return btnEscolhaAtendimento;
    }

    public void setBtnEscolhaAtendimento(View btnEscolhaAtendimento) {
        this.btnEscolhaAtendimento = btnEscolhaAtendimento;
    }

    private View btnEscolhaAtendimento;
    private EscolhaPrioridade escolhaPrioridade;
    EscolhaPrioridade teste = new EscolhaPrioridade();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_atendimento);


        Log.d("teste", "indiceSelecionado" + teste.getIndiceSelecionado());
        this.setBtnEscolhaAtendimento(findViewById(R.id.confirmar));
        this.getBtnEscolhaAtendimento().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(EscolhaAtendimento.this, EscolhaAgencia.class);
                startActivity(intent);
            }
        });
    }
}