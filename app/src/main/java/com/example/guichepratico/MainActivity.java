package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View btnNovoTicket;
    private View btnAcompanheTicket;
    private View btnHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setBtnNovoTicket(findViewById(R.id.NovoTicket));
        this.getBtnNovoTicket().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NovoTicket.class);
                startActivity(intent);
            }
        });
        this.setBtnAcompanheTicket(findViewById(R.id.acompanhe_seu_ticket));
        this.getBtnAcompanheTicket().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AcompanheTicket.class);
                startActivity(intent);
            }
        });
        this.setBtnHistorico(findViewById(R.id.angry_btn));
        this.getBtnHistorico().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Historico.class);
                startActivity(intent);
            }
        });
    }

    public View getBtnNovoTicket() {
        return btnNovoTicket;
    }

    public void setBtnNovoTicket(View btnNovoTicket) {
        this.btnNovoTicket = btnNovoTicket;
    }

    public View getBtnAcompanheTicket() {
        return btnAcompanheTicket;
    }

    public void setBtnAcompanheTicket(View btnAcompanheTicket) {
        this.btnAcompanheTicket = btnAcompanheTicket;
    }

    public View getBtnHistorico() {
        return btnHistorico;
    }

    public void setBtnHistorico(View btnHistorico) {
        this.btnHistorico = btnHistorico;
    }
}