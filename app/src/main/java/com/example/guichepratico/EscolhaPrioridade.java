package com.example.guichepratico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class EscolhaPrioridade extends AppCompatActivity {

    private View btnConfirmaPrioridade;
    private RadioGroup grupoPrioridade;
    private int btnIdPrioridadeSelecionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_prioridade);
        grupoPrioridade = (RadioGroup) findViewById(R.id.radioGroupOpcoesPrioridade);

        this.setBtnConfirmaPrioridade(findViewById(R.id.confirmar));
        this.getBtnConfirmaPrioridade().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnIdPrioridadeSelecionada = grupoPrioridade.getCheckedRadioButtonId();
                RadioButton btnPrioridade = findViewById(btnIdPrioridadeSelecionada);
                String prioridade = btnPrioridade.getText().toString();

                Intent intentPrioridade = new Intent(EscolhaPrioridade.this, EscolhaAtendimento.class);
                Bundle params = new Bundle();
                params.putString("PRIORIDADE",prioridade);
                intentPrioridade.putExtras(params);
                startActivity(intentPrioridade);
            }
        });
    }


    public View getBtnConfirmaPrioridade() {
        return btnConfirmaPrioridade;
    }

    public void setBtnConfirmaPrioridade(View btnConfirmaPrioridade) {
        this.btnConfirmaPrioridade = btnConfirmaPrioridade;
    }



    public RadioGroup getGrupoPrioridade() {
        return grupoPrioridade;
    }

    public void setGrupoPrioridade(RadioGroup grupoPrioridade) {
        this.grupoPrioridade = grupoPrioridade;
    }

    public int getBtnIdPrioridadeSelecionada() {
        return btnIdPrioridadeSelecionada;
    }

    public void setBtnIdPrioridadeSelecionada(int btnIdPrioridadeSelecionada) {
        this.btnIdPrioridadeSelecionada = btnIdPrioridadeSelecionada;
    }
}