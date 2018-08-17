package com.example.annis.apps.modal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annis.apps.DetailMonitoring;
import com.example.annis.apps.R;

import java.util.ArrayList;
/**
 * Created by annis on 04/05/2018.
 */

public class AdapterMonitoring  extends RecyclerView.Adapter<AdapterMonitoring.ViewHolder> {
    private ArrayList<DataMonitoring> datam;
    private Context context;

    public AdapterMonitoring(Context context, ArrayList<DataMonitoring> datam) {
        this.datam = datam;
        this.context = context;
    }

    @Override
    public AdapterMonitoring.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.isi_monitoring, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterMonitoring.ViewHolder viewHolder, int i) {
        viewHolder.idRekap.setText(datam.get(i).getIdRekap());
        viewHolder.idSungai.setText(datam.get(i).getNama_sungai());
        viewHolder.Ketinggian.setText(datam.get(i).getKetinggian());
    }

    @Override
    public int getItemCount() {
        return (datam == null) ? 0 : datam.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idRekap, idSungai, Ketinggian;

        public ViewHolder(View view) {
            super(view);

            idRekap = (TextView) view.findViewById(R.id.idRekap);
            idSungai = (TextView) view.findViewById(R.id.idSungai);
            Ketinggian = (TextView) view.findViewById(R.id.Ketinggian);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posisi = getAdapterPosition();

                    DataMonitoring clickedDataItem = datam.get(posisi);
                    Intent intent = new Intent(context, DetailMonitoring.class);
                    intent.putExtra("NamaSungai", datam.get(posisi).getNama_sungai());
                    intent.putExtra("Ketinggian", datam.get(posisi).getKetinggian());
                    intent.putExtra("Status", datam.get(posisi).getStatus());
                    intent.putExtra("Waktu", datam.get(posisi).getWaktu());

                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(view.getContext(), "You clicked " + clickedDataItem.getNama_sungai(), Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
}

