/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                     Controlador del layout main_activity.xml
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Shalom Isai Salazar Arguijo     20130805
:*  Fecha       : 02/oct/2023
:*  Compilador  : Android Studio Giraffe
:*  Descripción : En esta clase se controlan los códigos que operan los componentes del layout
:*                main_activity.xml
:*  Ultima modif:
:*  Fecha       Modific             Motivo
:*==========================================================================================

:*------------------------------------------------------------------------------------------*/


package mx.edu.itl.u3imcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    public static int modo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        modo=getDelegate().getLocalNightMode();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.opcion1){
            setDayNight();
        }
        return true;
    }

    public void setDayNight(){
        if(getDelegate().getLocalNightMode()==AppCompatDelegate.MODE_NIGHT_NO){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        modo=getDelegate().getLocalNightMode();
    }
    public void calcular(View v){
        EditText pesotxt=findViewById(R.id.txtNumPeso);
        EditText estaturatxt=findViewById(R.id.txtNumAltura);
        if(!pesotxt.getText().toString().equals("")&&!estaturatxt.getText().toString().equals("")){
            double peso=Double.parseDouble(pesotxt.getText().toString());
            double estatura=Double.parseDouble(estaturatxt.getText().toString());
            if(estatura>0 && peso>0) {
                double IMC = peso / Math.pow(estatura, 2);
                String estado = "a";
                if (IMC <= 15) {
                    estado = "Delgadez muy severa";
                } else if (IMC > 15 && IMC < 16) {
                    estado = "Delgadez severa";
                } else if (IMC >= 16 && IMC < 18.5) {
                    estado = "Delgadez";
                } else if (IMC >= 18.5 && IMC < 25) {
                    estado = "Peso Saludable";
                } else if (IMC >= 25 && IMC < 30) {
                    estado = "Obesidad Moderada";
                } else if (IMC >= 30 && IMC < 49) {
                    estado = "Obesidad Severa";
                } else {
                    estado = "Obesidad muy severa";
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("IMCApp")
                        .setMessage("IMC = " + IMC + "\nSu estado es: " + estado)
                        .setCancelable(true)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create().show();
            }
            else{
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                builder.setTitle("IMCApp")
                        .setMessage("Favor de poner una estatura y/o peso válido(s) (No valores iguales o menores a 0)")
                        .setCancelable(true)
                        .create().show();
            }
        }else{
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setTitle("IMCApp")
                    .setMessage("Favor de llenar todos los campos")
                    .setCancelable(true)
                    .create().show();
        }

    }

    public void acercade(View v){
        Intent intent = new Intent(this,AcercaDeActivity.class);
        startActivity(intent);
    }
}