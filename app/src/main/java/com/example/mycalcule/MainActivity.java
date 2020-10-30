package com.example.mycalcule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView btn_dote, btn_zero, btn_equal, btn_un, btn_deux, btn_trois, btn_plus, btn_moin, btn_six, btn_cinq, btn_quatre, btn_sept, btn_huit, btn_neuf, btn_fois, btn_ce, btn_parentese, btn_pct, btn_div;
    private ImageView btn_back;
    private TextView textExpresion, textResultat;
    private Boolean checkParentese = false;
    private String ch = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textExpresion = findViewById(R.id.textExpresion);
        textResultat = findViewById(R.id.textResultat);
        btn_dote = findViewById(R.id.btn_dote);
        btn_zero = findViewById(R.id.btn_zero);
        btn_back = findViewById(R.id.btn_back);
        btn_equal = findViewById(R.id.btn_equal);
        btn_un = findViewById(R.id.btn_un);
        btn_deux = findViewById(R.id.btn_deux);
        btn_trois = findViewById(R.id.btn_trois);
        btn_plus = findViewById(R.id.btn_plus);
        btn_moin = findViewById(R.id.btn_moin);
        btn_six = findViewById(R.id.btn_six);
        btn_cinq = findViewById(R.id.btn_cinq);
        btn_quatre = findViewById(R.id.btn_quatre);
        btn_sept = findViewById(R.id.btn_sept);
        btn_huit = findViewById(R.id.btn_huit);
        btn_neuf = findViewById(R.id.btn_neuf);
        btn_fois = findViewById(R.id.btn_fois);
        btn_ce = findViewById(R.id.btn_ce);
        btn_parentese = findViewById(R.id.btn_parentese_ouvert);
        btn_pct = findViewById(R.id.btn_pct);
        btn_div = findViewById(R.id.btn_div);
        //********************
        btn_dote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += ".";
                textExpresion.setText(ch.toString());
            }
        });
        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "0";
                textExpresion.setText(ch.toString());
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = delateLastCaracter(ch);
                textExpresion.setText(ch.toString());
            }
        });
        //*******************************
        btn_un.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "1";
                textExpresion.setText(ch.toString());
            }
        });
        btn_deux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "2";
                textExpresion.setText(ch.toString());
            }
        });
        btn_trois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "3";
                textExpresion.setText(ch.toString());
            }
        });

        //****************************
        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "6";
                textExpresion.setText(ch.toString());
            }
        });
        btn_cinq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "5";
                textExpresion.setText(ch.toString());
            }
        });
        btn_quatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "4";
                textExpresion.setText(ch.toString());
            }
        });
        ////**********************************
        btn_sept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "7";
                textExpresion.setText(ch.toString());
            }
        });
        btn_huit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "8";
                textExpresion.setText(ch.toString());
            }
        });
        btn_neuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "9";
                textExpresion.setText(ch.toString());
            }
        });
        //****************************************
        btn_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = "";
                //System.out.println(ch.toString());
                textExpresion.setText(ch.toString());
                textResultat.setText("");
            }
        });
        //********** opperation *****************************

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "+";
                textExpresion.setText(ch.toString());
            }
        });
        btn_moin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "-";
                textExpresion.setText(ch.toString());
            }
        });
        btn_fois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "X";
                textExpresion.setText(ch.toString());
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "/";
                textExpresion.setText(ch.toString());
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch.replaceAll("X", "*");
                ch = ch.replaceAll("%", "/100");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, ch, "javascript", 1, null).toString();
                } catch (Exception e) {
                    finalResult = "ERREUR";
                }
                textResultat.setText(finalResult);
            }
        });
        btn_parentese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkParentese == true) {
                    ch += ")";
                    textExpresion.setText(ch.toString());
                    checkParentese = false;
                } else {
                    ch += "(";
                    textExpresion.setText(ch.toString());
                    checkParentese = true;
                }
            }
        });
        btn_pct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch += "%";
                textExpresion.setText(ch.toString());
            }
        });
    }

    public static String delateLastCaracter(String ch) {
        String result = "";
        if ((ch != null) && (ch.length() > 0)) {
            result = ch.substring(0, ch.length() - 1);
        }
        return result;
    }

}