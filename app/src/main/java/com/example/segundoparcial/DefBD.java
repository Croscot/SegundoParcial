package com.example.segundoparcial;

public class DefBD {

    public static final String nameDB = "Productos";
    public static final String tabla_pro = "producto";
    public static final String col_id = "id";
    public static final String col_nombre = "nombre";
    public static final String col_precio = "precio";
    public static final String col_costo = "costo";

    public static final String crear_tabla = "CREATE TABLE IF NOT EXISTS "
            + DefBD.tabla_pro + "(" + DefBD.col_id + " text primary key," +
            DefBD.col_nombre + " text," +
            DefBD.col_precio + " text," +
            DefBD.col_costo + " text);";
}

