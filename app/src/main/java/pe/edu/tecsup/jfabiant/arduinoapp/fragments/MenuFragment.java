package pe.edu.tecsup.jfabiant.arduinoapp.fragments;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pe.edu.tecsup.jfabiant.arduinoapp.R;

public class MenuFragment extends Fragment {

    private CardView cardMedidas;
    private CardView cardMedidasConLluvia;
    private CardView cardMedidasSinLluvia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        cardMedidas = getView().findViewById(R.id.card_medidas);
        cardMedidasConLluvia = getView().findViewById(R.id.card_medidas_con_lluvia_detectada);
        cardMedidasSinLluvia = getView().findViewById(R.id.card_medidas_sin_lluvia);

        cardMedidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MedidasFragment()).addToBackStack(null).commit();
            }
        });
        cardMedidasConLluvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MedidasConLluviaDetectadaFragment()).addToBackStack(null).commit();
            }
        });
        cardMedidasSinLluvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MedidasSinLluviaFragment()).addToBackStack(null).commit();
            }
        });
    }

}
