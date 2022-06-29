package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class AcompanheTicket extends AppCompatActivity {

    public View getBtnMenuInicial() {
        return btnMenuInicial;
    }

    public void setBtnMenuInicial(View btnMenuInicial) {
        this.btnMenuInicial = btnMenuInicial;
    }

    private View btnMenuInicial;

    private SharedPreferences salvarPrioridade;
    private SharedPreferences.Editor editorPrioridade;
    private RadioGroup valorPrioridade;

    public SharedPreferences getSalvarPrioridade() {
        return salvarPrioridade;
    }

    public void setSalvarPrioridade(SharedPreferences salvarPrioridade) {
        this.salvarPrioridade = salvarPrioridade;
    }

    public SharedPreferences.Editor getEditorPrioridade() {
        return editorPrioridade;
    }

    public void setEditorPrioridade(SharedPreferences.Editor editorPrioridade) {
        this.editorPrioridade = editorPrioridade;
    }

    public RadioGroup getValorPrioridade() {
        return valorPrioridade;
    }

    public void setValorPrioridade(RadioGroup valorPrioridade) {
        this.valorPrioridade = valorPrioridade;
    }

    public int getPrioridadeSelecionada() {
        return prioridadeSelecionada;
    }

    public void setPrioridadeSelecionada(int prioridadeSelecionada) {
        this.prioridadeSelecionada = prioridadeSelecionada;
    }

    private int prioridadeSelecionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhe_ticket);


        valorPrioridade = (RadioGroup) findViewById(R.id.radioGroupOpcoesPrioridade);
        salvarPrioridade = getSharedPreferences("save",MODE_PRIVATE);
        prioridadeSelecionada = salvarPrioridade.getInt("chave_radio", 0);

        if(prioridadeSelecionada == R.id.prioridadeNormal ){
            Log.d("teste", "aqui sim" );
        }


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