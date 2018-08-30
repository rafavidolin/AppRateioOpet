package com.example.opet.apprateioopet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private EditText editComanda, editPessoas;
    private TextView textRateio;
    private CheckBox checkService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editComanda = findViewById(R.id.editComanda);
        editPessoas = findViewById(R.id.editPessoas);
        textRateio = findViewById(R.id.textRateio);
        checkService = findViewById(R.id.checkService);

        checkService.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        //Toast.makeText(MainActivity.this, String.valueOf(isChecked),Toast.LENGTH_SHORT).show();
                        double comanda = Double.parseDouble(editComanda.getText().toString());
                        comanda *= 1.1;
                        editComanda.setText(new DecimalFormat(".00").format(comanda));
                    }
                });
    }

    public void calculaRateio(View view) {

        double comanda = Double.parseDouble(editComanda.getText().toString());
        double pessoas = Double.parseDouble(editPessoas.getText().toString());


        if (checkService.isChecked())
            comanda = comanda * 1.1;

        double rateio = comanda / pessoas;

        DecimalFormat mformat = new DecimalFormat(".00");
        mformat.format(rateio);
        String resultado = "Valor do rateio:" + mformat.format(rateio);

        textRateio.setText(resultado);
    }
}
