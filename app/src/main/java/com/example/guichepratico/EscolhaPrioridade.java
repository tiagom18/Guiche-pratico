package com.example.guichepratico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EscolhaPrioridade extends AppCompatActivity {

    private View btnEscolhaPrioridade;
    private SharedPreferences salvarPrioridade;
    private SharedPreferences.Editor editorPrioridade;
    private RadioGroup valorPrioridade;
    private int prioridadeSelecionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_prioridade);

        valorPrioridade = (RadioGroup) findViewById(R.id.radioGroupOpcoesPrioridade);
        salvarPrioridade = getSharedPreferences("save",MODE_PRIVATE);

        //Recupera o valor do indiceSelecionado
        prioridadeSelecionada = salvarPrioridade.getInt("chave_radio", 0);
        //Executa a condição abaixo para ver qual o ultimo ID que fora salvo, ou seja
        //qual o ultimo radioButton foi marcado


        if(prioridadeSelecionada == R.id.prioridadeNormal){
            valorPrioridade.check(R.id.prioridadeNormal);
        }else if (prioridadeSelecionada == R.id.prioridadePrioritaria){
            valorPrioridade.check(R.id.prioridadePrioritaria);
        }else if(prioridadeSelecionada == R.id.prioridadeJuridica){
            valorPrioridade.check(R.id.prioridadeJuridica);
        }

        //me salvou
        Toast.makeText(this, "Id: " + prioridadeSelecionada, Toast.LENGTH_LONG).show();
        Log.d("teste", "prioridade Selecionada" + this.getPrioridadeSelecionada());

        if(prioridadeSelecionada == R.id.prioridadeNormal ){
            Log.d("teste", "aqui sim" );
        }
        //só pro teste
        this.setBtnEscolhaPrioridade(findViewById(R.id.confirmar));
        this.getBtnEscolhaPrioridade().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPrioridade = new Intent(EscolhaPrioridade.this, EscolhaAtendimento.class);

                startActivity(intentPrioridade);

            }
        });
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
        prioridadeSelecionada = valorPrioridade.getCheckedRadioButtonId();
        editorPrioridade = salvarPrioridade.edit();
        editorPrioridade.putInt("chave_radio", prioridadeSelecionada);
        editorPrioridade.commit();
    }
    public View getBtnEscolhaPrioridade() {
        return btnEscolhaPrioridade;
    }

    public void setBtnEscolhaPrioridade(View btnEscolhaPrioridade) {
        this.btnEscolhaPrioridade = btnEscolhaPrioridade;
    }

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
}