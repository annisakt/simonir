package com.example.annis.apps.modal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annis.apps.DetailSungai;
import com.example.annis.apps.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by annis on 04/05/2018
 */

public class AdapterSungai extends RecyclerView.Adapter<AdapterSungai.ViewHolder> {
    private ArrayList<DataSungai> datas;
    private Context context;

    public AdapterSungai(Context context, ArrayList<DataSungai> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public AdapterSungai.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.isi_sungai, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterSungai.ViewHolder viewHolder, int i) {
        viewHolder.idSungai.setText(datas.get(i).getIdSungai());
        viewHolder.NamaSungai.setText(datas.get(i).getNamaSungai());
        viewHolder.LokasiSungai.setText(datas.get(i).getLokasiSungai());
//        Picasso.with(context).load(datas.get(i).getGambar()).resize(150, 150).into(viewHolder.imageView);
        Picasso.with(context).load("http://simonir.com/foto/"+datas.get(i).getGambar()).resize(150, 150).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return (datas == null) ? 0 : datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idSungai, NamaSungai, LokasiSungai;
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            idSungai = (TextView) view.findViewById(R.id.idSungai);
            NamaSungai = (TextView) view.findViewById(R.id.NamaSungai);
            LokasiSungai = (TextView)view.findViewById(R.id.LokasiSungai);
            imageView =(ImageView)view.findViewById(R.id.img1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posisi = getAdapterPosition();

                    DataSungai clickedDataItem = datas.get(posisi);
                    Intent intent = new Intent(view.getContext(), DetailSungai.class);
                    intent.putExtra("NamaSungai", datas.get(posisi).getNamaSungai());
                    intent.putExtra("LokasiSungai", datas.get(posisi).getLokasiSungai());
                    intent.putExtra("PanjangSungai", datas.get(posisi).getPanjang());
                    intent.putExtra("LuasSungai", datas.get(posisi).getLuas());
                    intent.putExtra("Hilir", datas.get(posisi).getHilir());
                    intent.putExtra("Kemiringan", datas.get(posisi).getKemiringan());
                    intent.putExtra("Pengelola", datas.get(posisi).getPengelola());
                    intent.putExtra("Gambar", datas.get(posisi).getGambar());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(view.getContext(), "You clicked " + clickedDataItem.getNamaSungai(), Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
}