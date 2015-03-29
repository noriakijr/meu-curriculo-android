package com.noriaki.noriakiodanjunior;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btExpProfissional;
    private Button btEspecializacoes;
    private Button btFormacaoAcademica;
    private Button btRedesSociais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("App Noriaki");

        btExpProfissional = (Button) findViewById(R.id.btExpProfissional);
        btEspecializacoes = (Button) findViewById(R.id.btEspecializacoes);
        btFormacaoAcademica = (Button) findViewById(R.id.btFormacaoAcademica);
        btRedesSociais = (Button) findViewById(R.id.btRedesSociais);

        btExpProfissional.setOnClickListener(this);
        btEspecializacoes.setOnClickListener(this);
        btFormacaoAcademica.setOnClickListener(this);
        btRedesSociais.setOnClickListener(this);

        findViewById(R.id.ivGmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "jun.odan@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Enviar email..."));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btExpProfissional:
                startActivity(new Intent(this, ExpProfissionalActivity.class));
                break;
            case R.id.btEspecializacoes:
                startActivity(new Intent(this, EspecializacoesActivity.class));
                break;
            case R.id.btFormacaoAcademica:
                startActivity(new Intent(this, FormAcademicaActivity.class));
                break;
            case R.id.btRedesSociais:
                startActivity(new Intent(this, RedesSociaisActivity.class));
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_gmail:
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "jun.odan@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Enviar email..."));
                break;
            case R.id.action_sobre:
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = this.getLayoutInflater();

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                View view = inflater.inflate(R.layout.dialog_sobre, null);
                Button btContato = (Button) view.findViewById(R.id.btContato);
                btContato.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "jun.odan@gmail.com", null));
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Noriaki app");
                        startActivity(intent.createChooser(intent, "Enviar email..."));
                    }
                });
                builder.setTitle("Sobre");
                builder.setView(view);
                builder.create().show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
