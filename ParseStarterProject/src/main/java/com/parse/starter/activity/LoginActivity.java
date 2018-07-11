package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.starter.R;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtSenha;
    private Button   btnLogar;
    private TextView txtCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = (EditText) findViewById(R.id.box_usuario_login_id);
        txtSenha = (EditText) findViewById(R.id.box_senha_login_id);
        btnLogar = (Button) findViewById(R.id.btn_logar_id);
        txtCriarConta = (TextView) findViewById(R.id.txt_faca_login_id);

        //Verifica se o usuário está logado
        verificaUsuarioLogado();
    }

    public void abrirCadastroUsuario(View view){
        Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }

    private void verificaUsuarioLogado(){

        if (ParseUser.getCurrentUser() != null){
            abrirTelaPrincipal();
        }
    }

    private void abrirTelaPrincipal(){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
