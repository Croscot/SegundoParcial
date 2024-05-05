package com.example.segundoparcial;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ProductoCursorAdapter extends CursorAdapter {
    public ProductoCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_producto,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id = view.findViewById(R.id.txtid);
        TextView nombre = view.findViewById(R.id.txtnombre);
        TextView precio = view.findViewById(R.id.txtprecio);
        TextView costo = view.findViewById(R.id.txtcosto);
        id.setText("ID: " + cursor.getString(0));
        nombre.setText("Producto: " + cursor.getString(1));
        precio.setText("Precio: " + cursor.getString(2));
        costo.setText("Costo: " + cursor.getString(3));
    }
}

