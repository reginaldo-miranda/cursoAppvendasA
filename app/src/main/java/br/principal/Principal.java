package br.principal;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import java.util.HashMap;
import java.util.Map;

import br.Model.SqliteParametroBean;
import br.Model.SqliteParametroDao;

import br.Util.CustomJsonObjectRequest;
import br.Util.Util;

public class Principal extends AppCompatActivity {

    private static final String TAG_REQUEST = "tag";
    private Map<String, String> params;
    private Button btn_registrar;
    private EditText txt_usuario;
    private EditText txt_senha;
    private RequestQueue rq;
    private final static String TAG_SUCESSO = "sucesso";
    private final static String TAG_MENSAGEM = "mensagem";
    private SqliteParametroBean parBean;
    private SqliteParametroDao parDao;
    private String URL_REGISTRO = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        declaraObjtos();

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validar_campos()) {


                    parBean = parDao.busca_parametros();

                    if (parBean != null) {


                        validar_usuario_entrar_no_sistema();


                    } else {


                        if (Util.checarConexaoCelular(getBaseContext())) {

                            registrar_usuarioWeb();

                            Toast.makeText(getBaseContext(), "Conexao com a Internet", Toast.LENGTH_LONG).show();


                        } else {

                            Intent i = new Intent(Settings.ACTION_WIFI_SETTINGS);
                            startActivity(i);
                            Toast.makeText(getBaseContext(), "Sem conexao com a Internet", Toast.LENGTH_LONG).show();

                        }


                    }


                }

            }

        });
    }


    public void validar_usuario_entrar_no_sistema() {

        declaraObjtos();
        String usuario_digitado = txt_usuario.getText().toString();
        String senha_digitada = txt_senha.getText().toString();
        if (usuario_digitado.trim().equals(parBean.getP_usuario()) && senha_digitada.trim().equals(parBean.getP_senha())) {

            //  entrar no sistema
        } else {

            // logim esta errado
        }


    }


    public boolean validar_campos() {

        declaraObjtos();
        if (txt_usuario.getText().toString().length() <= 4) {
            txt_usuario.setError("usuario com pouco caracteres");
            txt_usuario.requestFocus();
            return false;
        } else if (txt_senha.getText().toString().trim().length() <= 3) {
            txt_senha.setError("senha incorreta");
            txt_senha.requestFocus();
            return false;

        }

        return true;

    }


    public void registrar_usuarioWeb() {

        params = new HashMap<String, String>();

        params.put("usuario", txt_usuario.getText().toString());
        params.put("senha", txt_senha.getText().toString());

        CustomJsonObjectRequest request = new CustomJsonObjectRequest(
                Request.Method.POST,
                URL_REGISTRO,
                params, new Response.Listener<org.json.JSONObject>() {
            @Override
            public void onResponse(JsonObjectRequest response) {

                // obter resposta php

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        request.setTag(TAG_REQUEST);
        rq.add(request);
    }


    public void declaraObjtos() {

        URL_REGISTRO = "";
        txt_usuario = (EditText) findViewById(R.id.txt_usuario);
        txt_senha = (EditText) findViewById(R.id.txt_senha);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);

        //rq = Volley.newRequestQueue(Principal.this);

        parBean = new SqliteParametroBean();
        parDao = new SqliteParametroDao(getBaseContext());

    }

    @Override
    public void onStop() {

        super.onStop();
        rq.cancelAll(TAG_REQUEST);

    }
}










