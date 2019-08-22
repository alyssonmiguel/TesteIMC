package com.example.alyssonmgcorrea.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textViewResult = findViewById(R.id.textViewResultado);

        textViewResult.setText("");

    }

    public void calcula(View v) {

        String num1Text = editText1.getText().toString().replace(",", ".");
        String num2Text = editText2.getText().toString().replace(",", ".");

        Double num1 = Double.parseDouble(num1Text);
        Double num2 = Double.parseDouble(num2Text);

        Double resultado = num2 / (num1 * num1);
        String resultadoText = resultado.toString().replace(".", ",");

        DecimalFormat df = new DecimalFormat("#.##");
        String resultFormatter = df.format(resultado).replace(".", ",");

        textViewResult.setText(resultadoText);

        if (resultado < 18.5) {
            textViewResult.setText(resultFormatter + "   - Magreza");
        } else {
            if (resultado >= 18.5 && resultado <= 24.9) {
                textViewResult.setText(resultFormatter + "  - Saudável");
            } else {
                if (resultado >= 25.0 && resultado <= 29.9) {
                    textViewResult.setText(resultFormatter + "  - Sobrepeso");
                } else {
                    if (resultado >= 30.0 && resultado <= 34.9) {
                        textViewResult.setText(resultFormatter + "  - Obesidade Grau 1");
                    } else {
                        if (resultado >= 35.0 && resultado <= 39.9) {
                            textViewResult.setText(resultFormatter + "  - Obesidade Grau 2");
                        } else {
                            if (resultado > 40.0) {
                                textViewResult.setText(resultFormatter + "  - Obesidade Grau 3");
                            }

                        }


                    }

                }

            }

        }
    }
}
