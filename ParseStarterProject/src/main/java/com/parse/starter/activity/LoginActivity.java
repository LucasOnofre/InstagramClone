package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
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

        txtUsuario    = (EditText) findViewById(R.id.box_usuario_login_id);
        txtSenha      = (EditText) findViewById(R.id.box_senha_login_id);
        btnLogar      = (Button) findViewById(R.id.btn_logar_id);
        txtCriarConta = (TextView) findViewById(R.id.txt_faca_login_id);

       //ParseUser.logOut();

        //Listener do botão logar
        btnLogar.setOnClickListener(listener_btn_logar);

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

    private View.OnClickListener listener_btn_logar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String usuario = txtUsuario.getText().toString();
            String senha   = txtSenha.getText().toString();

            verificarLogin(usuario,senha);

        }
    };

    private void verificarLogin(String usuario, String senha) {

        ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {

                //Sucesso no login
                if (e == null){
                    Toast.makeText(LoginActivity.this, "Login com sucesso", Toast.LENGTH_SHORT).show();
                    abrirTelaPrincipal();

                    //Erro ao logar
                }else{
                    Toast.makeText(LoginActivity.this, "Erro ao fazer login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
