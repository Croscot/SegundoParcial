package com.example.segundoparcial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ProductoController {
    private BaseDatos bd;
    private Context c;

    public ProductoController(Context c){
        this.bd = new BaseDatos(c,DefBD.nameDB,1);
        this.c = c;
    }

    public void agregarProducto(Producto p){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_id, p.getId());
            valores.put(DefBD.col_nombre, p.getNombre());
            valores.put(DefBD.col_precio, p.getPrecio());
            valores.put(DefBD.col_costo, p.getCosto());

            if (!buscarProducto(p)) {
                sql.insert(DefBD.tabla_pro, null, valores);
                Toast.makeText(c, "Registro exitosa", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(c, "El id del producto ya existe", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(c, "Error en la operacion " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    public boolean buscarProducto(Producto p){
        String[] arg = new String[] {p.getId()};

        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_pro, null,"id=?", arg,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            return false;
        }
    }

    public Producto buscarProducto(String id){
        String[] arg = new String[] {id};
        Producto p = null;
        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_pro, null,"id=?", arg,null,null,null);
        if (c.getCount()>0){
            while(c.moveToNext()) {
                p = new Producto(c.getString(0), c.getString(1), c.getString(2)
                        , c.getString(3));

            }
            return p;
        }
        else{
            return p;
        }
    }

    public void actualizarProducto(Producto p){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            String arg[] = {p.getId()};
            ContentValues values = new ContentValues();
            values.put(DefBD.col_nombre, p.getNombre());
            values.put(DefBD.col_precio, p.getPrecio());
            values.put(DefBD.col_costo, p.getCosto());
            sql.update(DefBD.tabla_pro, values,"id=?",arg);
            Toast.makeText(this.c, "Actualizacion exitosa", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(c, "Error en la operacion " + e.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarProducto(String id){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            String[] arg = new String[] {id};
            sql.delete(DefBD.tabla_pro,"id=?", arg);
            Toast.makeText(this.c, "Eliminación exitosa", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error en la operacion " + ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor allProducts(){
        Cursor cur;
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            cur = sql.rawQuery("select id as _id, nombre, precio, costo from producto order by " + DefBD.col_nombre, null);
            return cur;
        }
        catch (Exception e){
            Toast.makeText(c, "Error en la operacion " + e.getMessage() , Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
