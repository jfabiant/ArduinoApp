package pe.edu.tecsup.jfabiant.arduinoapp.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.edu.tecsup.jfabiant.arduinoapp.R;
import pe.edu.tecsup.jfabiant.arduinoapp.activities.DashboardActivity;
import pe.edu.tecsup.jfabiant.arduinoapp.activities.MainActivity;
import pe.edu.tecsup.jfabiant.arduinoapp.fragments.FullscreenDialogFragment;
import pe.edu.tecsup.jfabiant.arduinoapp.fragments.MedidasFragment;
import pe.edu.tecsup.jfabiant.arduinoapp.models.Data;
import com.github.curioustechizen.ago.RelativeTimeTextView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Context mContext;

    private static final String TAG = DataAdapter.class.getSimpleName();

    private List<Data> datos;

    public DataAdapter () {
        this.datos = new ArrayList<>();
    }

    public void setDatos (Context context ,List<Data> datos) {
        mContext = context;
        this.datos = datos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public RelativeTimeTextView dateText;
        public TextView humedadText;
        public TextView temperaturaText;
        public TextView sensorLluviaText;
        public ImageView fotoImage;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.date_text);
            humedadText = itemView.findViewById(R.id.humedad_text);
            temperaturaText = itemView.findViewById(R.id.temperatura_text);
            sensorLluviaText = itemView.findViewById(R.id.sensor_lluvia_text);
            fotoImage = itemView.findViewById(R.id.foto_image);
            cardView = itemView.findViewById(R.id.cv);

        }
        
    }
    
    
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = ((FragmentActivity)mContext).getSupportFragmentManager();
                FullscreenDialogFragment newFragment = new FullscreenDialogFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.add(android.R.id.content, newFragment).addToBackStack(null).commit();

            }
        });
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, final int position) {
        
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
