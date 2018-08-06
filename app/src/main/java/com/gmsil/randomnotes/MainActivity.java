package com.gmsil.randomnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_anti_horario)
    Button btnAntiHorario;

    @BindView(R.id.btn_geral)
    Button btnGeral;

    @BindView(R.id.btn_horario)
    Button btnHorario;

    @BindView(R.id.reset)
    Button btnReset;

    @BindView(R.id.anti_horario)
    TextView antiHorario;

    @BindView(R.id.geral)
    TextView geral;

    @BindView(R.id.horario)
    TextView horario;

    List<String> listaHorario = new ArrayList<>();
    List<String> listaAntiHorario = new ArrayList<>();
    List<String> listaGeral = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        resetMethod();
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaHorario.size() != 0)
                    horario.setText(listaHorario.remove(new Random().nextInt(listaHorario.size())));
                else
                    horario.setText("END");
            }
        });

        btnAntiHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaAntiHorario.size() != 0)
                    antiHorario.setText(listaAntiHorario.remove(new Random().nextInt(listaAntiHorario.size())));
                else
                    antiHorario.setText("END");
            }
        });

        btnGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaGeral.size() != 0)
                    geral.setText(listaGeral.remove(new Random().nextInt(listaGeral.size())));
                else
                    geral.setText("END");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetMethod();
            }
        });
    }

    private void resetMethod(){
        setStringHorario();
        setStringAntiHorario();
        setStringGeral();
    }

    private void setStringGeral() {
        listaGeral.addAll(listaHorario);
        listaGeral.addAll(listaAntiHorario);
    }

    private void setStringHorario() {
        String aux = "";
        aux = "Do - Re - Mi - Fa - Sol - La - Si - Do";
        listaHorario.add(aux);

        aux = "Re - Mi - Fa - Sol - La - Si - Do - Re";
        listaHorario.add(aux);

        aux = "Mi - Fa - Sol - La - Si - Do - Re - Mi";
        listaHorario.add(aux);

        aux = "Fa - Sol - La - Si - Do - Re - Mi - Fa";
        listaHorario.add(aux);

        aux = "Sol - La - Si - Do - Re - Mi - Fa - Sol";
        listaHorario.add(aux);

        aux = "La - Si - Do - Re - Mi - Fa - Sol - La";
        listaHorario.add(aux);

        aux = "Si - Do - Re - Mi - Fa - Sol - La - Si";
        listaHorario.add(aux);


    }

    private void setStringAntiHorario() {
        String aux = "";
        aux = "Do - Si - La - Sol - Fa - Mi - Re - Do";
        listaAntiHorario.add(aux);

        aux = "Si - La - Sol - Fa - Mi - Re - Do - Si";
        listaAntiHorario.add(aux);

        aux = "La - Sol - Fa - Mi - Re - Do - Si - La";
        listaAntiHorario.add(aux);

        aux = "Sol - Fa - Mi - Re - Do - Si - La - Sol";
        listaAntiHorario.add(aux);

        aux = "Fa - Mi - Re - Do - Si - La - Sol - Fa";
        listaAntiHorario.add(aux);

        aux = "Mi - Re - Do - Si - La - Sol - Fa - Mi";
        listaAntiHorario.add(aux);

        aux = "Re - Do - Si - La - Sol - Fa - Mi - Re";
        listaAntiHorario.add(aux);
    }
}
