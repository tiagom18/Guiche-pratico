package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class EscolhaAgencia extends AppCompatActivity {

    public View getBtnEscolhaAgencia() {
        return btnEscolhaAgencia;
    }

    public void setBtnEscolhaAgencia(View btnEscolhaAgencia) {
        this.btnEscolhaAgencia = btnEscolhaAgencia;
    }

    private View btnEscolhaAgencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_agencia);

        this.setBtnEscolhaAgencia(findViewById(R.id.confirmar));
        this.getBtnEscolhaAgencia().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaAgencia.this, AcompanheTicket.class);
                startActivity(intent);
            }
        });
    }
}