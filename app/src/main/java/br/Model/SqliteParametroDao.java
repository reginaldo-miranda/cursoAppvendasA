package br.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class SqliteParametroDao {

    private Context ctx;
    private String sql;
    private boolean gravacao;
    private String valor;
    public SqliteParametroDao(Context ctx) {
        this.ctx = ctx;
    }


    public boolean gravar_parametros(SqliteParametroBean paran) {

        SQLiteDatabase db = new Db(ctx).getWritableDatabase();
        gravacao = false;

        sql = "insert into parametros  (" +
                "p_usu_codigo," +
                "p_importar_cliente," +
                "P_end_ip_local," +
                " p_end_ip_remoto," +
                "p_trabalhar_com_estoque_negatico," +
                "p_desconto_do_vendedor ," +
                "p_usuario," +
                " p_senha) " +
                "values (?,?,?,?,?,?,?,?) ";

        SQLiteStatement stmt = db.compileStatement(sql);


        try {

            stmt.bindLong(1, paran.getP_usu_codigo());
            stmt.bindString(2, paran.getP_importar_cliente());
            stmt.bindString(3, paran.getP_end_ip_local());
            stmt.bindString(4, paran.getP_end_ip_remoto());
            stmt.bindString(5, paran.getP_trabalhar_com_estoque_negatico());
            stmt.bindLong(6, paran.getP_desconto_do_vendedor());
            stmt.bindString(7, paran.getP_usuario());
            stmt.bindString(8, paran.getP_senha());

            if (stmt.executeInsert() > 0) {
                gravacao = true;
                sql = "";
            }
        } catch (SQLException e) {
            Log.d("Script", e.getMessage());
            gravacao = false;
        }

        return gravacao;
    }

    public SqliteParametroBean busca_parametros() {

        SQLiteDatabase db = new Db(ctx).getReadableDatabase();
        SqliteParametroBean parametro = null;

        sql = " select * from parametros";

        try {

            Cursor cursor = db.rawQuery(sql,null);

            if (cursor.moveToFirst()){

                parametro = new SqliteParametroBean();


                parametro.setP_usu_codigo(cursor.getInt(cursor.getColumnIndex(parametro.P_CODIGO_USUARIO)));
                parametro.setP_importar_cliente(cursor.getString(cursor.getColumnIndex(parametro.P_IMPORTAR_CLIENTE)));
                parametro.setP_end_ip_local(cursor.getString(cursor.getColumnIndex(parametro.P_ENDERECO_IP_LOCAL)));
                parametro.setP_end_ip_remoto(cursor.getString(cursor.getColumnIndex(parametro.P_ENDERECO_IP_REMOTO)));
                parametro.setP_trabalhar_com_estoque_negatico(cursor.getString(cursor.getColumnIndex(parametro.P_ESTOQUE_NEGATIVO)));
                parametro.setP_desconto_do_vendedor(cursor.getInt(cursor.getColumnIndex(parametro.P_DESCONTO_VENDEDOR)));
                parametro.setP_usuario(cursor.getString(cursor.getColumnIndex(parametro.P_USUARIO)));
                parametro.setP_senha(cursor.getString(cursor.getColumnIndex(parametro.P_SENHA)));

            }


        } catch (SQLException e) {
            Log.d("Script", e.getMessage());
        }
        return parametro;

    }

    public void autalizaparametro (SqliteParametroBean paran){
        SQLiteDatabase db = new Db(ctx).getWritableDatabase();

         sql = ("update PARAMENTROS set p_usu_codigo=?," +
                " p_importar_cliente=?," +
                " P_end_ip_local=?, " +
                "p_end_ip_remoto=?," +
                "p_trabalhar_com_estoque_negatico=?," +
                "p_desconto_do_vendedor =?, p_usuario=?, p_senha=? ");

        SQLiteStatement stmt = db.compileStatement(sql);

        try {


            stmt.bindLong(1, paran.getP_usu_codigo());
            stmt.bindString(2, paran.getP_importar_cliente());
            stmt.bindString(3, paran.getP_end_ip_local());
            stmt.bindString(4, paran.getP_end_ip_remoto());
            stmt.bindString(5, paran.getP_trabalhar_com_estoque_negatico());
            stmt.bindLong(6, paran.getP_desconto_do_vendedor());
            stmt.bindString(7,paran.getP_usuario());
            stmt.bindString(8,paran.getP_senha());


            stmt.executeUpdateDelete();
            stmt.clearBindings();


        }catch (SQLException e){
            Log.d("Script", e.getMessage());

        }finally {
            db.close();
            stmt.close();
        }
    }
} //fim
