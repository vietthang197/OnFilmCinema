package tagroup.thangducanh.com.studiobackup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 1/25/2018.
 */

public class PhimAdapter extends RecyclerView.Adapter<PhimAdapter.ViewHolder> {

    private ArrayList<Phim> arrPhim;
    private Context context;

    public PhimAdapter(ArrayList<Phim> arrPhim, Context context) {
        this.arrPhim = arrPhim;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_phim,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtTen.setText(arrPhim.get(position).getTenphim());
        Picasso.with(context).load(arrPhim.get(position).getLink_image_phim()).into(holder.imgHinh);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailMoviesActivity.class);
                int id_phim = arrPhim.get(position).getId();
                intent.putExtra("id_phim",id_phim);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrPhim.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTen;
        ImageView imgHinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.txtTen);
            imgHinh = itemView.findViewById(R.id.imgHinh);
        }
    }
}
