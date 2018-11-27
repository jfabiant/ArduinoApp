package pe.edu.tecsup.jfabiant.arduinoapp.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import pe.edu.tecsup.jfabiant.arduinoapp.fragments.MenuFragment;
import pe.edu.tecsup.jfabiant.arduinoapp.R;
import pe.edu.tecsup.jfabiant.arduinoapp.services.ApiService;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Show first fragment:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuFragment()).commit();
        //Show toolbar with icons:
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Arduino Aplication");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.btn_refresh) {
            //Toast.makeText(DashboardActivity.this, "Refrescando ... ", Toast.LENGTH_SHORT).show();

            final ProgressDialog progressDialog = new ProgressDialog(this,
                    R.style.AppTheme_Dark_Dialog);

            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Refrescando");
            progressDialog.show();

            // TODO: Implement your own authentication logic here.

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {

                            //Refrescar los fragmentos:



                            progressDialog.dismiss();
                        }
                    }, 2000);

            return true;
        }
        if(id == R.id.btn_exit){
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

}
