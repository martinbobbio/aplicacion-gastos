package bobbio.martin.a00_agendagastos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {

    public BD(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase bd) {

        bd.execSQL("create table categorias (id integer primary key, categoria varchar(20), presupuesto integer)");
        bd.execSQL("create table tipo_pagos (id integer primary key, tipoPago varchar(20))");
        bd.execSQL("create table gasto (id integer primary key, categoria varchar(20), tipoPago varchar(20), fecha text, descripcion text,monto double )");

        bd.execSQL("insert into categorias (categoria, presupuesto) values ('Compras', 2500)");
        bd.execSQL("insert into categorias (categoria, presupuesto) values ('Futbol', 250)");
        bd.execSQL("insert into categorias (categoria, presupuesto) values ('Tenis', 1000)");

        bd.execSQL("insert into tipo_pagos (tipoPago) values ('Tarjeta de crédito')");
        bd.execSQL("insert into tipo_pagos (tipoPago) values ('Ahorros')");

        bd.execSQL("insert into gasto (categoria, tipoPago, fecha, descripcion, monto) values ('Tenis','Ahorros','26.06.2017','Torneo mixto', 750)");
        bd.execSQL("insert into gasto (categoria, tipoPago, fecha, descripcion, monto) values ('Tenis','Ahorros','18.05.2017','Torneo singles', 1000)");
        bd.execSQL("insert into gasto (categoria, tipoPago, fecha, descripcion, monto) values ('Tenis','Ahorros','20.04.2017','Torneo dobles', 500)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int vAnt, int vNueva) {

    }
}