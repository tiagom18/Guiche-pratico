package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EscolhaAgencia extends AppCompatActivity {

    private RadioGroup grupoAgencia;


    private View btnEscolhaAgencia;
    private String prioridade;
    private String atendimento;
    private int btnIdAgenciaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_agencia);

        grupoAgencia = (RadioGroup) findViewById(R.id.radioGroupOpcoesAgencia);

        Intent it= getIntent();

        Bundle params = it.getExtras();
        prioridade = params.getString("PRIORIDADE");
        atendimento = params.getString("ATENDIMENTO");

        this.setBtnEscolhaAgencia(findViewById(R.id.confirmar));
        this.getBtnEscolhaAgencia().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnIdAgenciaSelecionada = grupoAgencia.getCheckedRadioButtonId();
                RadioButton btnAgencia = findViewById(btnIdAgenciaSelecionada);
                String agencia = btnAgencia.getText().toString();

                Intent intentAgencia = new Intent(EscolhaAgencia.this, AcompanheTicket.class);
                Bundle params = new Bundle();
                params.putString("PRIORIDADE", prioridade);
                params.putString("ATENDIMENTO",atendimento);
                params.putString("AGENCIA", agencia);
                intentAgencia.putExtras(params);
                startActivity(intentAgencia);

            }
        });
    }

    public View getBtnEscolhaAgencia() {
        return btnEscolhaAgencia;
    }

    public void setBtnEscolhaAgencia(View btnEscolhaAgencia) {
        this.btnEscolhaAgencia = btnEscolhaAgencia;
    }
}