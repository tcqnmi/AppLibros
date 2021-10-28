package com.example.applibros;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Details extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        //Anclamos la interfaz al activity
        setContentView(R.layout.screendetails);

        //Creamos referencia al textView y le damos el valor que queramos
        TextView textView = this.findViewById(R.id.lblInfoDetallada);

        //Cramos un objeto intent para poder acceder a lo que hemos guardado en este en el main
        Intent intent = this.getIntent();

        //Igual que con putExtra le metemos parametros con getExtra(tipo) sacamo los datos del tipo que deseamos
        //Tenemos que poner un valor por defecto por si acaso no recibe nada
        final int numLista = intent.getIntExtra("numlist",-1);

        Datos datos = new Datos();

        textView.setText(datos.getAutor(numLista)+" ha escrito : "+datos.getLibro(numLista));

        //Asignamos a nuestro nuevo botón la interfaz
        Button boton = (Button)this.findViewById(R.id.cmdVolver);

        //Llamamos al editText y lo almacenamos en un objeto
        EditText tx2 = (EditText) this.findViewById(R.id.txtVal2);

        //Creamos un listener que espera a que pulsen en el botón
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Creamos un nuevo intent
                Intent intent1 = new Intent();

                //Rellenamos con el contenido del textEdiT
                intent1.putExtra("informacion", tx2.getText().toString());

                //Devolvemos los resultados para decir que es un resultado válido en el resultCode
                //de la onActivityResult del main y enviar el intent
                setResult(RESULT_OK, intent1);

                //Finaliza la actividad
                finish();


            }
        };
        boton.setOnClickListener(listener);

    }

}
