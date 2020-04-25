package com.dicoding.picodiploma.pedulipanti.adapter;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.pedulipanti.R;
import com.dicoding.picodiploma.pedulipanti.model.panti;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListPantiAdapter extends RecyclerView.Adapter<ListPantiAdapter.ListViewHolder> {
    private ArrayList<panti> listpanti;

    public ListPantiAdapter(ArrayList<panti> list){
        this.listpanti = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_panti_asuhan,viewGroup,false);
        return new ListViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final panti Panti = listpanti.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Panti.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.ImgPanti);
        holder.NamaPanti.setText(Panti.getNamapanti());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listpanti.get(holder.getAdapterPosition()));
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("gambarpanti",Panti.getPhoto());
                intent.putExtra("namapanti", Panti.getNamapanti());
                intent.putExtra("alamatpanti",Panti.getAlamatpanti());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listpanti.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView ImgPanti;
        TextView NamaPanti;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            NamaPanti = itemView.findViewById(R.id.tv_item_name);
            ImgPanti = itemView.findViewById(R.id.item_photo_img);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(panti data);
    }
}
