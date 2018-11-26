package pe.edu.tecsup.jfabiant.arduinoapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.edu.tecsup.jfabiant.arduinoapp.fragments.MenuFragment;
import pe.edu.tecsup.jfabiant.arduinoapp.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuFragment()).commit();
    }

}
