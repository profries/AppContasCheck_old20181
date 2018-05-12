package com.example.iossenac.appcontascheck;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{
    CheckBox checkAgua, checkLuz, checkTelefone, checkCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pagarConta(View v){
        checkAgua = (CheckBox) findViewById(R.id.checkAgua);
        checkLuz = (CheckBox) findViewById(R.id.checkLuz);
        checkTelefone = (CheckBox) findViewById(R.id.checkTelefone);
        checkCelular = (CheckBox) findViewById(R.id.checkCelular);

        int soma = 0;

        if(checkAgua.isChecked())
            soma+= Integer.parseInt(checkAgua.getTag().toString());

        if(checkLuz.isChecked())
            soma+= Integer.parseInt(checkLuz.getTag().toString());

        if(checkTelefone.isChecked())
            soma+= Integer.parseInt(checkTelefone.getTag().toString());

        if(checkCelular.isChecked())
            soma+= Integer.parseInt(checkCelular.getTag().toString());

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Pagamento");
        dialogo.setMessage("Valor total: "+soma);
        dialogo.setNeutralButton("OK",this);
        dialogo.setNegativeButton("Cancelar",this);
        dialogo.show();
    }


    @Override
    public void onClick(DialogInterface dialog, int tipo) {
        if(tipo==AlertDialog.BUTTON_NEUTRAL){
            Toast.makeText(this,"Pagamento realizado com sucesso!",
                    Toast.LENGTH_SHORT).show();

        }
        else if(tipo==AlertDialog.BUTTON_NEGATIVE)
        {
            Toast.makeText(this,"Pagamento cancelado!",
                    Toast.LENGTH_SHORT).show();
        }

        checkAgua.setChecked(false);
        checkLuz.setChecked(false);
        checkTelefone.setChecked(false);
        checkCelular.setChecked(false);
    }
}
