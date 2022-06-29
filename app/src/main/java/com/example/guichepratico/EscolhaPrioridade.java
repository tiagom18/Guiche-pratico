package com.example.guichepratico;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EscolhaPrioridade extends AppCompatActivity {

    private View btnEscolhaPrioridade;
    private SharedPreferences save;
    private SharedPreferences.Editor editor;
    private RadioGroup valor;
    private String opcoes = "";

    public int getIndiceSelecionado() {
        return indiceSelecionado;
    }

    public void setIndiceSelecionado(int indiceSelecionado) {
        this.indiceSelecionado = indiceSelecionado;
    }

    private int indiceSelecionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_prioridade);

        valor = (RadioGroup) findViewById(R.id.radioGroupOpcoes);
        save = getSharedPreferences("save",MODE_PRIVATE);

//Recupera o valor do indiceSelecionado
        indiceSelecionado = save.getInt("chave_radio", 0);
        //Executa a condição abaixo para ver qual o ultimo ID que fora salvo, ou seja
        //qual o ultimo radioButton foi marcado
        if(indiceSelecionado == R.id.prioridadeNormal){
            valor.check(R.id.prioridadeNormal);
        }else if (indiceSelecionado == R.id.prioridadePrioritaria){
            valor.check(R.id.prioridadePrioritaria);
        }else if(indiceSelecionado == R.id.prioridadeJuridica){
            valor.check(R.id.prioridadeJuridica);
        }

        Toast.makeText(this, "Id: " + indiceSelecionado, Toast.LENGTH_LONG).show();
        Log.d("teste", "indiceSelecionado" + this.getIndiceSelecionado());
        this.setBtnEscolhaPrioridade(findViewById(R.id.confirmar));
        this.getBtnEscolhaPrioridade().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaPrioridade.this, EscolhaAtendimento.class);
                startActivity(intent);
            }
        });
    }


    public View getBtnEscolhaPrioridade() {
        return btnEscolhaPrioridade;
    }

    public void setBtnEscolhaPrioridade(View btnEscolhaPrioridade) {
        this.btnEscolhaPrioridade = btnEscolhaPrioridade;
    }
    @Override
    protected void onStop() {
    /*
    Ao ser chamado o metodo onStop ou seja, após a aplicação parar é feito um putString
    do nome digitado pelo usuário, assim ele grava o ultimo nome digitado para que quando
    volte para a aplicação o campo Nome já esta preenchido
    */
        super.onStop();
        /*
         * A variavel indiceSelecionado pega o ID do radio button que esta marcado
         * dessa maneira é salvo ela com uma chave do tipo chave_radio, para assim
         * recuperar a mesma no método Oncreate
         * */
        indiceSelecionado = valor.getCheckedRadioButtonId();
        editor = save.edit();
        editor.putInt("chave_radio", indiceSelecionado);
        editor.commit();
    }
}