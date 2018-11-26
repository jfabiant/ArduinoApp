package pe.edu.tecsup.jfabiant.arduinoapp.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import pe.edu.tecsup.jfabiant.arduinoapp.R;
import pe.edu.tecsup.jfabiant.arduinoapp.adapters.DataAdapter;
import pe.edu.tecsup.jfabiant.arduinoapp.models.Data;
import pe.edu.tecsup.jfabiant.arduinoapp.services.ApiService;
import pe.edu.tecsup.jfabiant.arduinoapp.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedidasFragment extends Fragment {

    private static final String TAG = MedidasFragment.class.getSimpleName();
    private RecyclerView datosList;
    //Inicializando Progressbar
    private ProgressBar progressBar;
    private Handler handler;
    private Runnable runnable;
    private Timer timer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medidas, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {

        getView().setClickable(false);

        //Inicio progressbar:
        progressBar = getView().findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                //Mientras carga estara haciendo la peticion al servicio web.
                //Servira para evitar la espera del usuario mostrando la vista en blanco
                datosList = getView().findViewById(R.id.recycler_view);
                datosList.setLayoutManager(new LinearLayoutManager(getContext()));

                datosList.setAdapter(new DataAdapter());
                initialize();

                getView().setClickable(true);

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);

            }
        }, 1000, 1000);

    }

    private void initialize () {

        //Pido los datos al servidor y uso el adaptador para hacer las repeticiones adecuadas:
        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<List<Data>> call = service.getDatos();

        call.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                try {

                    if (response.isSuccessful()) {

                        List<Data> datos = response.body();
                        Log.d(TAG, "Datos: " + datos);

                        DataAdapter adapter = (DataAdapter) datosList.getAdapter();
                        adapter.setDatos(datos);
                        adapter.notifyDataSetChanged();

                        progressBar.setVisibility(View.GONE);
                        timer.cancel();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}

                }

            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Toast.makeText(getContext(), "Error: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
