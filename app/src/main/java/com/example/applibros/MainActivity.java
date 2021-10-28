package com.example.applibros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    //En onCreate metemos el código que queremos que se ejecute al iniciar la app

    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Llamamos al onCreate de la clase padre Activity
        super.onCreate(savedInstanceState);
        //Mostramos la interface gráfica que hemos creado previamente
        setContentView(R.layout.main); //R hace referencia a la carpeta res, ponemos el nombre del fichero del layout(main en este caso)

        ListView listView = (ListView) this.findViewById(R.id.lstLibros);
        //Cargamos la lista creada en el xml con el nombre que le dimos al recurso
        //Hacemos una conversión tipo cast porque findView nos devuelve un view pero no especifica de qué tipo
        //asi que mediante la transformación indicamos que lo trate como si fuera una lista
        //Este listView es un elemento del interfaz, una variable que almacena la lista

        /*
        String arrayDeEjemplo [] = new String[3];
        arrayDeEjemplo[0]="Hola mundo";
        arrayDeEjemplo[1]="Prueba";
        arrayDeEjemplo[2]="Otro elemento";

        ArrayAdapter<String> miNuevoAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayDeEjemplo);

        listView.setAdapter(miNuevoAdaptador);

        Esto es un ejemplillo para ver cómo se muestran datos en el array
         */
        //Rellenamos nuestro listView con un array de cadenas conteniendo los nombres de los libros
        //Creamos una clase (no activity) que almacenará los datos de dichos libros
        Datos datos = new Datos();

        String[] arrayDeNombreDeLibros = datos.getTitulos();

        ArrayAdapter<String> AdapatadorTitulos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayDeNombreDeLibros);

        listView.setAdapter(AdapatadorTitulos);


        //Crea un listener que espera en el sistema a que algo sea clicado
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            //Método que indica qué sucede al hacer dicho click
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //sout sale la información en la consola interna
                System.out.println("He pulsado en el elemento " + i + " de la lista");

                //Toast se muestra en un globo con la información indicada en la aplicación
                Toast.makeText(getApplicationContext(), "He pulsado en el elemento " + i + " de la lista", Toast.LENGTH_LONG).show();

                //Crea un objeto intent asociado a la activity que queremos
                //El intent es como una caja entre el main y las activities secundarias
                Intent intent = new Intent(getApplicationContext(), Details.class);

                //Podemos pasarle también datos. 1er parametro es donde vamos a guardarlo y el 2º parametro es el qué queremos pasar
                intent.putExtra("numlist", i);

                //Arranca la activity con lo que le hemos pasado al intent
                //Si no esperamos resultados :
                // startActivity(intent);

                //Si si que esperamos resultados:
                //Le pasamos el intent y a mayores un requestCode (lo que queramos)
                //que luego nos devolverá la activity hija junto con los resultados
                startActivityForResult(intent,0);

            }
        };
        //añadimos a la lista el evento del ItemClick
        listView.setOnItemClickListener(listener);

    }
    //Nuevo método que se activa al recibir un resultado del activity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent1){
       //Toast.makeText(getApplicationContext(), "He recibido resultados", Toast.LENGTH_LONG).show();

        //Recogemos el valor almacenado en el intent y lo imprimimos con un globo
        final String result = intent1.getStringExtra("informacion");
        Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG ).show();



    }
}

