package co.xintana.unionmagdalenafanapp.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import co.xintana.unionmagdalenafanapp.R;
import co.xintana.unionmagdalenafanapp.activities.MainActivity;
import co.xintana.unionmagdalenafanapp.data.ActualidadInfo;
import co.xintana.unionmagdalenafanapp.data.entities.Partido;
import co.xintana.unionmagdalenafanapp.databinding.FragmentActualidadBinding;
import co.xintana.unionmagdalenafanapp.utilities.DataUtilities;

public class NoticiasFragment extends UMAppFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.fragment_actualidad, container, false);
        ActualidadInfo info = ((MainActivity)getActivity()).mActualidadInfo;
        FragmentActualidadBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_actualidad, container, false);
        Context context = getContext();

        // Proximo Partido
        Partido siguiente = info.getSiguiente();
        boolean esLocal = DataUtilities.esLocal(siguiente);
        Date fecha = siguiente.getFecha();
        if (fecha != null) {
            binding.tvMesProximo.setText(DataUtilities.getMes(fecha));
            binding.tvDiaProximo.setText(DataUtilities.getDia(fecha));
            binding.tvHoraProximo.setText(DataUtilities.getHora(fecha));
        }
        binding.tvTorneoProximo.setText(siguiente.getTorneo() + ", " + context.getString(R.string.jornada) + " " + String.valueOf(siguiente.getJornada()));
        binding.tvEquipoProximo.setText( esLocal ? siguiente.getVisitante().getNombre() : siguiente.getLocal().getNombre());
        binding.ivIconProximo.setBackgroundResource(esLocal ? siguiente.getVisitante().getIcon() : siguiente.getLocal().getIcon());
        binding.tvProximoEstadio.setText(siguiente.getEstadio().getNombre());

        // Ultimo Partido
        Partido ultimo = info.getUltimo();
        fecha = ultimo.getFecha();

        if (fecha != null) {
            binding.tvMesUltimo.setText(DataUtilities.getMes(fecha));
            binding.tvDiaUltimo.setText(DataUtilities.getDia(fecha));
        }
        binding.tvEquipoLocalUltimo.setText(ultimo.getLocal().getNombre());
        String marcadorLocal = String.valueOf(ultimo.getMarcador()[0]);
        binding.tvEquipoVisitaUltimo.setText(ultimo.getVisitante().getNombre());
        String marcadorVisita = String.valueOf(ultimo.getMarcador()[1]);
        binding.tvGolesLocalUltimo.setText(marcadorLocal);
        binding.tvGolesVisitaUltimo.setText(marcadorVisita);
        binding.tvTorneoUltimo.setText(ultimo.getTorneo() + ", " + context.getString(R.string.jornada) + " " + String.valueOf(ultimo.getJornada()));

        return binding.getRoot();
    }
}
