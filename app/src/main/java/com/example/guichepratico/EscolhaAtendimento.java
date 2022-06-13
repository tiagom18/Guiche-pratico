package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EscolhaAtendimento extends AppCompatActivity {

    public View getBtnEscolhaAtendimento() {
        return btnEscolhaAtendimento;
    }

    public void setBtnEscolhaAtendimento(View btnEscolhaAtendimento) {
        this.btnEscolhaAtendimento = btnEscolhaAtendimento;
    }

    private View btnEscolhaAtendimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_atendimento);
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