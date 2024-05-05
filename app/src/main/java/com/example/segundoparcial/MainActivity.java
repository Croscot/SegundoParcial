package com.example.segundoparcial;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, nombre, precio, costo;
    Button guardar, consultar, eliminar, listado, actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.edtidproducto);
        nombre = (EditText) findViewById(R.id.edtnombrepro);
        precio = (EditText) findViewById(R.id.edtprecio);
        costo = (EditText) findViewById(R.id.edtcosto);
        guardar = (Button) findViewById(R.id.btnguardar);
        consultar = (Button) findViewById(R.id.btnconsultar);
        actualizar = (Button) findViewById(R.id.btnactualizar);
        eliminar = (Button) findViewById(R.id.btneliminar);
        listado = (Button) findViewById(R.id.btnlistado);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarEntrada()) {
                    Producto p = new Producto(id.getText().toString(), nombre.getText().toString(),
                            precio.getText().toString(), costo.getText().toString());
                    ProductoController pc = new ProductoController(getApplicationContext());
                    pc.agregarProducto(p);
                    limpiarCampos();
                }
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().isEmpty()) {
                    ProductoController pc = new ProductoController(getApplicationContext());
                    Producto p = pc.buscarProducto(id.getText().toString());
                    if (p != null) {
                        nombre.setText(p.getNombre());
                        precio.setText(p.getPrecio());
                        costo.setText(p.getCosto());
                    } else {
                        Toast.makeText(getApplicationContext(), "Producto no encontrado", Toast.LENGTH_SHORT).show();
                        limpiarCampos();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese un ID de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().isEmpty()) {
                    ProductoController pc = new ProductoController(getApplicationContext());
                    pc.eliminarProducto(id.getText().toString());
                    limpiarCampos();
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese un ID de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListadoProductos.class);
                startActivity(i);
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarEntrada()) {
                    ProductoController pc = new ProductoController(getApplicationContext());
                    Producto p = new Producto(id.getText().toString(), nombre.getText().toString(),
                            precio.getText().toString(), costo.getText().toString());
                    pc.actualizarProducto(p);
                    limpiarCampos();
                }
            }
        });
    }

    private boolean validarEntrada() {
        if (id.getText().toString().isEmpty() || nombre.getText().toString().isEmpty() ||
                precio.getText().toString().isEmpty() || costo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        id.setText("");
        nombre.setText("");
        precio.setText("");
        costo.setText("");
    }
}