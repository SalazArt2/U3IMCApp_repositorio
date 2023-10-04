/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                     Controlador del layout acercade_activity.xml
:*
:*  Archivo     : AcercaDeACtivity.java
:*  Autor       : Shalom Isai Salazar Arguijo     20130805
:*  Fecha       : 02/oct/2023
:*  Compilador  : Android Studio Giraffe
:*  Descripción : En esta clase se maneja el proceso para que el acercade_activity.xml
:*                cambie después de cierto tiempo, regresando al main_activity.xml
:*  Ultima modif:
:*  Fecha       Modific             Motivo
:*==========================================================================================

:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.u3imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade_activity);
        getDelegate().setLocalNightMode(MainActivity.modo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },2000 );
    }
}