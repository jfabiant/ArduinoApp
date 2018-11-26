package pe.edu.tecsup.jfabiant.arduinoapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.edu.tecsup.jfabiant.arduinoapp.R;
import pe.edu.tecsup.jfabiant.arduinoapp.activities.MainActivity;
import pe.edu.tecsup.jfabiant.arduinoapp.models.Data;
import com.github.curioustechizen.ago.RelativeTimeTextView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private static final String TAG = DataAdapter.class.getSimpleName();

    private List<Data> datos;

    public DataAdapter () {
        this.datos = new ArrayList<>();
    }

    public void setDatos (List<Data> datos) {
        this.datos = datos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public RelativeTimeTextView dateText;
        public TextView humedadText;
        public TextView temperaturaText;
        public TextView sensorLluviaText;
        public ImageView fotoImage;

        public ViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.date_text);
            humedadText = itemView.findViewById(R.id.humedad_text);
            temperaturaText = itemView.findViewById(R.id.temperatura_text);
            sensorLluviaText = itemView.findViewById(R.id.sensor_lluvia_text);
            fotoImage = itemView.findViewById(R.id.foto_image);

        }
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, final int position) {

        final Data data = this.datos.get(position);

        viewHolder.dateText.setReferenceTime(data.getCreated_at().getTime());
        viewHolder.humedadText.setText(data.getHumedad());
        viewHolder.temperaturaText.setText(data.getTemperatura());

        if (data.getSensor_lluvia().equals("True")) {
            viewHolder.fotoImage.setImageResource(R.drawable.ic_rain_black_24dp);
            viewHolder.sensorLluviaText.setText("Se detectó lluvia.");
        } else {
            viewHolder.fotoImage.setImageResource(R.drawable.ic_no_rain_black_24dp);
            viewHolder.sensorLluviaText.setText("No se detectó lluvia.");
        }
    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }

}
