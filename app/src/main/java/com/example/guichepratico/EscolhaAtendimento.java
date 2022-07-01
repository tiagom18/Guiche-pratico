package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EscolhaAtendimento extends AppCompatActivity {


    private View btnEscolhaAtendimento;
    private SharedPreferences salvarAtendimento;
    private SharedPreferences.Editor editorAtendimento;
    private RadioGroup grupoAtendimento;
    private int btnIdAtendimentoSelecionada;
    private String prioridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_atendimento);

        grupoAtendimento = (RadioGroup) findViewById(R.id.radioGroupOpcoesAtendimento);

        Intent it= getIntent();

        Bundle params = it.getExtras();
        prioridade = params.getString("PRIORIDADE");

        this.setBtnEscolhaAtendimento(findViewById(R.id.confirmar));
        this.getBtnEscolhaAtendimento().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnIdAtendimentoSelecionada = grupoAtendimento.getCheckedRadioButtonId();
                RadioButton btnAtendimento = findViewById(btnIdAtendimentoSelecionada);
                String atendimento = btnAtendimento.getText().toString();

                Intent intentAtendimento = new Intent(EscolhaAtendimento.this, EscolhaAgencia.class);
                Bundle params = new Bundle();
                params.putString("PRIORIDADE", prioridade);
                params.putString("ATENDIMENTO",atendimento);
                intentAtendimento.putExtras(params);
                startActivity(intentAtendimento);
            }
        });
    }
    public View getBtnEscolhaAtendimento() {
        return btnEscolhaAtendimento;
    }

    public void setBtnEscolhaAtendimento(View btnEscolhaAtendimento) {
        this.btnEscolhaAtendimento = btnEscolhaAtendimento;
    }

    public SharedPreferences getSalvarAtendimento() {
        return salvarAtendimento;
    }

    public void setSalvarAtendimento(SharedPreferences salvarAtendimento) {
        this.salvarAtendimento = salvarAtendimento;
    }

    public SharedPreferences.Editor getEditorAtendimento() {
        return editorAtendimento;
    }

    public void setEditorAtendimento(SharedPreferences.Editor editorAtendimento) {
        this.editorAtendimento = editorAtendimento;
    }

    public RadioGroup getGrupoAtendimento() {
        return grupoAtendimento;
    }

    public void setGrupoAtendimento(RadioGroup grupoAtendimento) {
        this.grupoAtendimento = grupoAtendimento;
    }

    public int getBtnIdAtendimentoSelecionada() {
        return btnIdAtendimentoSelecionada;
    }

    public void setBtnIdAtendimentoSelecionada(int btnIdAtendimentoSelecionada) {
        this.btnIdAtendimentoSelecionada = btnIdAtendimentoSelecionada;
    }



}