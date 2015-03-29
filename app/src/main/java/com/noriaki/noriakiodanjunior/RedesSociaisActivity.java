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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.noriaki.noriakiodanjunior.model.SiteBean;

import java.util.ArrayList;
import java.util.List;


public class RedesSociaisActivity extends ActionBarActivity {

    private ListView lvRedesSociais;
    private List<SiteBean> sites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociais);

        lvRedesSociais = (ListView) findViewById(R.id.lvRedesSociais);

        sites = new ArrayList<>();
        sites.add(new SiteBean(R.drawable.linkedin, "LinkedIn", "https://www.linkedin.com/in/noriakiodanjr", "linkedin://profile/320921428"));
        sites.add(new SiteBean(R.drawable.facebook, "Facebook", "https://m.facebook.com/noriaki.odan.jr", "fb://profile/100002138860368"));
        sites.add(new SiteBean(R.drawable.googleplus, "Google+", "https://plus.googleplus.com/+NoriakiOdanJunior/about", "https://plus.google.com/113938454933559230984"));

        RedesSociaisAdapter adapter = new RedesSociaisAdapter(sites, getApplicationContext());
        lvRedesSociais.setAdapter(adapter);

        lvRedesSociais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean ehGoogle = false;
                try {
                    if(sites.get(position).getName().equals("Google+"))
                        ehGoogle = true;

                    openBrowser(sites.get(position).getUrlApp(), ehGoogle);
                } catch (Exception e) {
                    openBrowser(sites.get(position).getUrl(), true);
                }
            }
        });
    }

    public void openBrowser(String url, boolean ehGoogle) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        if (ehGoogle) {
            intent.setPackage("com.google.android.apps.plus");
        }
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_redes_sociais, menu);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(RedesSociaisActivity.this);
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
