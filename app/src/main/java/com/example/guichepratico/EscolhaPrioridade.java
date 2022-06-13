package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EscolhaPrioridade extends AppCompatActivity {

    public View getBtnEscolhaPrioridade() {
        return btnEscolhaPrioridade;
    }

    public void setBtnEscolhaPrioridade(View btnEscolhaPrioridade) {
        this.btnEscolhaPrioridade = btnEscolhaPrioridade;
    }

    private View btnEscolhaPrioridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_prioridade);
        this.setBtnEscolhaPrioridade(findViewById(R.id.confirmar));
        this.getBtnEscolhaPrioridade().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaPrioridade.this, EscolhaAtendimento.class);
                startActivity(intent);
            }
        });
    }
}