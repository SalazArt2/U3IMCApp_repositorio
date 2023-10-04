/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                     Controlador del layout splash_activity.xml
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Shalom Isai Salazar Arguijo     20130805
:*  Fecha       : 02/oct/2023
:*  Compilador  : Android Studio Giraffe
:*  Descripción : En esta clase se maneja el proceso para que el splash_activity.xml
:*                cambie después de cierto tiempo para pasar al main_activity.xml
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

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);



        //Hacer la transición al MainActivity después de 2 bseg

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //crear el Intent para llamar a MainActivity
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000 );
    }
}