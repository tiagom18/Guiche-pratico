package com.example.guichepratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AcompanheTicket extends AppCompatActivity {

    public View getBtnMenuInicial() {
        return btnMenuInicial;
    }

    public void setBtnMenuInicial(View btnMenuInicial) {
        this.btnMenuInicial = btnMenuInicial;
    }

    private View btnMenuInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhe_ticket);
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