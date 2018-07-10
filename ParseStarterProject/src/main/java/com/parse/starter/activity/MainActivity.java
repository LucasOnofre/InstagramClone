/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.parse.starter.R;

import java.util.List;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /** Cadastra o usuário **/
//    ParseUser usuario = new ParseUser();
//    usuario.setUsername("lucasonofre");
//    usuario.setPassword("123456");
//    usuario.setEmail("jamiltoncursos@gmail.com");
//
//    usuario.signUpInBackground(new SignUpCallback() {
//      @Override
//      public void done(ParseException e) {
//
//        //Verifica se o erro é vazio, se for, é pq ta certo
//        if (e == null){
//          Log.i("cadastroUsuario","Erro ao cadastrar usuário - " + e.getMessage());
//        }
//      }
//    });

      /** verifica o usuário logado**/
//    //verifica se está logado
//    if(ParseUser.getCurrentUser() != null){
//      Log.i("Loginusuário","Usuário logado");
//    }else
//      Log.i("Loginusuário","Usuário não logado");
//

//    //logar
//    ParseUser.logInInBackground("lucasonofre", "14587", new LogInCallback() {
//      @Override
//      public void done(ParseUser user, ParseException e) {
//
//        if (e == null){
//          Log.i("verificaLoginUsuario "," Login sucesso ");
//        }else
//          Log.i("verificaLoginUsuario "," Erro ao fazer login" + e.getMessage());
//      }
//    });

    //deslogar
    //ParseUser.logOut();
  }
}