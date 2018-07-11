package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.starter.R;
import com.parse.starter.util.ParseErros;

public class CadastroActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtEmail;
    private EditText txtSenha;
    private TextView fazerLogin;
    private Button   btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        fazerLogin   = (TextView) findViewById(R.id.txt_faca_login_id);
        txtEmail     = (EditText) findViewById(R.id.box_senha_login_id);
        txtSenha     = (EditText) findViewById(R.id.box_senha_cadastro_id);
        txtUsuario   = (EditText) findViewById(R.id.box_usuario_login_id);
        btnCadastrar = (Button) findViewById(R.id.btn_logar_id);

        //Listener botão cadastrar
        btnCadastrar.setOnClickListener(listener_cadastrar);
        fazerLogin.setOnClickListener  (listener_cadastrar);
    }

    public void abrirLoginUsuario() {
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public View.OnClickListener listener_cadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            cadastrarUsuario();
        }
    };

    private void cadastrarUsuario() {

        //Cria objeto usuário
        final ParseUser usuario = new ParseUser();
        usuario.setUsername(txtUsuario.getText().toString());
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setPassword(txtSenha.getText().toString());

        //Salva dados do usuário
        usuario.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                //sucesso
                if (e == null) {
                    Toast.makeText(CadastroActivity.this, "Cadastro feito com sucesso", Toast.LENGTH_SHORT).show();
                    abrirLoginUsuario();
                }
                //erro
                else{
                    ParseErros parseErros = new ParseErros();
                    String erro = parseErros.getError(e.getCode());
                    Toast.makeText(CadastroActivity.this, erro, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
