package com.example.reist_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.reist_app.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Reist_App";
    public static final int DATABASE_VERSION = 1;

    //TABELA USUARIO
    public static final String USUARIO_TABLE_NAME = "TBUsuario";
    public static final String USUARIO_COLUMN_ID = "id";
    public static final String USUARIO_COLUMN_CPF = "cpf";
    public static final String USUARIO_COLUMN_NAME = "nome";
    public static final String USUARIO_COLUMN_EMAIL = "email";
    public static final String USUARIO_COLUMN_SENHA = "senha";
    public static final String USUARIO_COLUMN_CELL = "celular";
    public static final String USUARIO_COLUMN_SEXO = "sexo";
    public static final String USUARIO_COLUMN_NASC = "nascimento";
    public static final String USUARIO_COLUMN_NUMERO = "numero";
    public static final String USUARIO_COLUMN_CEP = "cep";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_USUARIO = "CREATE TABLE TBUsuario ( id INTEGER PRIMARY KEY, cpf  INTEGER, " +
                "nome  TEXT,  email TEXT, senha TEXT, " +
                "celular TEXT, sexo TEXT, nascimento TEXT, numero INTEGER, cep TEXT); ";

        db.execSQL(QUERY_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USUARIO_TABLE_NAME + ";" );
        onCreate(db);
    }

    //-----------------INSERTS----------------------------------------------------------------------
    public void addUsuario (Usuario usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USUARIO_COLUMN_CPF, usuario.getCpfusuario());
        values.put(USUARIO_COLUMN_NAME, usuario.getNomeusuario());
        values.put(USUARIO_COLUMN_EMAIL, usuario.getEmailusuario());
        values.put(USUARIO_COLUMN_SENHA, usuario.getSenhausuario());
        values.put(USUARIO_COLUMN_CELL, usuario.getCelularusuario());
        values.put(USUARIO_COLUMN_SEXO, usuario.getSexousuario());
        values.put(USUARIO_COLUMN_NASC, usuario.getNascimentousuario());
        values.put(USUARIO_COLUMN_NUMERO, usuario.getNumerousuario());
        values.put(USUARIO_COLUMN_CEP, usuario.getCepusuario());

        db.insert(USUARIO_TABLE_NAME, null, values);
        db.close();
    }

    //-----------------UPDATES----------------------------------------------------------------------

    //----------------SELECTS ALL-------------------------------------------------------------------
    public List<Usuario> listAllUsers (){
        List<Usuario> listaU    = new ArrayList<Usuario>();
        String query = "SELECT * FROM " + USUARIO_TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                Usuario cliente = new Usuario();
                cliente.setCpfusuario(Integer.parseInt(c.getString(1)));
                cliente.setNomeusuario(c.getString(2));
                cliente.setEmailusuario(c.getString(3));
                cliente.setSenhausuario(c.getString(4));
                cliente.setCelularusuario(c.getString(5));
                cliente.setSexousuario(c.getString(6));
                cliente.setNascimentousuario(c.getString(7));
                cliente.setNumerousuario(Integer.parseInt(c.getString(8)));
                cliente.setCepusuario(c.getString(9));

                listaU.add(cliente);
            }while(c.moveToNext());
        }
        return  listaU;
    }

    //----------------SELECT WHERE------------------------------------------------------------------
    public boolean autenticaUsuario(Usuario usuario){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql_busca_usuario =
                "SELECT * FROM " + USUARIO_TABLE_NAME + " WHERE " + USUARIO_COLUMN_EMAIL + " = " + "'" + usuario.getEmailusuario() + "'";
        Cursor c = db.rawQuery(sql_busca_usuario, null);
        while(c.moveToNext()){
            if(usuario.getEmailusuario().equals(c.getString(c.getColumnIndex(USUARIO_COLUMN_EMAIL)))){
                if(usuario.getSenhausuario().equals(c.getString(c.getColumnIndex(USUARIO_COLUMN_SENHA)))){
                    return true;
                }

            }
        }
        db.close();
        c.close();

        return false;
    }

    public  boolean ValidacaoEmail(String string){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT ? FROM TBUsuario WHERE emailUsuario =?", new String[]{string,string});
        if(c.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    //----------------DELETE ALL--------------------------------------------------------------------

    //----------------DELETE WHERE------------------------------------------------------------------

}
