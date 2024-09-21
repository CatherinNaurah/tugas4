package com.example.tugas4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KontakAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Kontak> kontaks;


    public KontakAdaptor(Context context, List<Kontak> kontaks){
        this.context = context;
        this.kontaks = kontaks;
    }

    public class VH extends RecyclerView.ViewHolder{

        private final TextView tvtelp;
        private final TextView tvnama;
        private final Button btdelete;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.tvnama = itemView.findViewById(R.id.tvnama);
            this.tvtelp = itemView.findViewById(R.id.tvtelp);
            this.btdelete = itemView.findViewById(R.id.btdelete);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(this.context)
                .inflate(R.layout.row_kontak, parent, false);
        return new VH(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Kontak h = this.kontaks.get(position);
        VH vh = (VH) holder;
        vh.tvtelp.setText(h.telepon.toString());
        vh.tvnama.setText(h.nama.toString());
        vh.btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.kontaks.size();
    }
    public void removeItem(int position) {
        kontaks.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, kontaks.size());
}
}