package com.example.segundoparcial;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.Toast;

public class ListadoProductos extends AppCompatActivity {

    ListView listado;
    ProductoCursorAdapter pcur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);
        listado = (ListView) findViewById(R.id.lstlistado);
        ProductoController pc = new ProductoController(this);
        Cursor c = pc.allProducts();
        if (c.getCount()>0) {
            pcur = new ProductoCursorAdapter(this,c,false);
            listado.setAdapter(pcur);
            listado.setTextFilterEnabled(true);
            pcur.setFilterQueryProvider(new FilterQueryProvider() {
                @Override
                public Cursor runQuery(CharSequence constraint) {
                    return null;
                }
            });
        }
        else
            Toast.makeText(getApplicationContext(), "No hay datos",Toast.LENGTH_SHORT).show();
    }
}