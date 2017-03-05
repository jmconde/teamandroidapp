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
        Log.d(getLogTag(), info.fecha);

        SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd yyyy kk:mm:ss z", Locale.ENGLISH);
        SimpleDateFormat fechaSDF = new SimpleDateFormat("d MMM", Locale.getDefault());
        SimpleDateFormat diaSDF = new SimpleDateFormat("EEEE", Locale.getDefault());
        SimpleDateFormat horaSDF = new SimpleDateFormat("h:mm a", Locale.getDefault());

        String diaMes = "";
        String diaSemana = "";
        String hora = "";
        try {
            Date fecha = df.parse(info.fecha);
            diaMes = fechaSDF.format(fecha);
            diaSemana = diaSDF.format(fecha);
            hora = horaSDF.format(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e(getLogTag(), "fecha", e);
        }

        int idEstadioEquipo = info.local ? 33 : info.equipo;

        binding.tvTorneoProximo.setText(info.torneo + ", " + context.getString(R.string.jornada) + " " + String.valueOf(info.jornada));
        binding.tvLocalFlagProximo.setText((info.local) ? context.getString(R.string.local) : context.getString(R.string.visitante));
        binding.tvFechaProximo.setText(diaMes);
        binding.tvDiaProximo.setText(diaSemana);
        binding.tvHoraProximo.setText(hora);
        binding.tvEquipoProximo.setText(DataUtilities.getEquipoNombre(info.equipo));
        binding.ivIconProximo.setBackgroundResource(DataUtilities.getEquipoIcon(info.equipo));

        binding.tvProximoEstadio.setText(DataUtilities.getEstadio(idEstadioEquipo));
        Log.d(getLogTag(), ">>>" +info.estadio );


//            public String torneo;
//            public int jornada;
//            public String fecha;
//            public boolean local;
//            public String estadio;
//            public String equipo;

        return binding.getRoot();
    }
}
