package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EscolhaAtendimento extends AppCompatActivity {


    private View btnEscolhaAtendimento;
    private SharedPreferences salvarAtendimento;
    private SharedPreferences.Editor editorAtendimento;
    private RadioGroup valorAtendimento;
    private int atendimentoSelecionado;

    private SharedPreferences salvarPrioridade;
    private SharedPreferences.Editor editorPrioridade;
    private RadioGroup valorPrioridade;
    private int prioridadeSelecionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_atendimento);


        valorAtendimento = (RadioGroup) findViewById(R.id.radioGroupOpcoesAtendimento);
        salvarAtendimento = getSharedPreferences("save",MODE_PRIVATE);

        //Recupera o valor do indiceSelecionado
        atendimentoSelecionado = salvarAtendimento.getInt("chave_radio", 0);
        //Executa a condição abaixo para ver qual o ultimo ID que fora salvo, ou seja
        //qual o ultimo radioButton foi marcado


        if(atendimentoSelecionado == R.id.gerencia){
            valorAtendimento.check(R.id.prioridadeNormal);
        }else if (atendimentoSelecionado == R.id.caixa){
            valorAtendimento.check(R.id.prioridadePrioritaria);
        }







        this.setBtnEscolhaAtendimento(findViewById(R.id.confirmar));
        this.getBtnEscolhaAtendimento().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(EscolhaAtendimento.this, EscolhaAgencia.class);
                startActivity(intent);
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
        atendimentoSelecionado = valorAtendimento.getCheckedRadioButtonId();
        editorAtendimento = salvarAtendimento.edit();
        editorAtendimento.putInt("chave_radio", atendimentoSelecionado);
        editorAtendimento.commit();
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

    public RadioGroup getValorAtendimento() {
        return valorAtendimento;
    }

    public void setValorAtendimento(RadioGroup valorAtendimento) {
        this.valorAtendimento = valorAtendimento;
    }

    public int getAtendimentoSelecionado() {
        return atendimentoSelecionado;
    }

    public void setAtendimentoSelecionado(int atendimentoSelecionado) {
        this.atendimentoSelecionado = atendimentoSelecionado;
    }

}