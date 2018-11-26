package pe.edu.tecsup.jfabiant.arduinoapp.services;

import java.util.List;

import pe.edu.tecsup.jfabiant.arduinoapp.models.Data;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String API_BASE_URL = "https://arduino-api-jfabiantimoteotorres.c9users.io";

    @GET("/api/data/")
    public Call<List<Data>> getDatos();

    @GET("/api/data-lluvia-detectada/")
    public Call<List<Data>> getDatosLluviaDetectada();

    @GET("/api/data-lluvia-no-detectada/")
    public Call<List<Data>> getDatosLluviaNoDetectada();
}
