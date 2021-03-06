package com.example.ngoxuanmanh.masoi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ngoxuanmanh.masoi.NguoiChoi;
import com.example.ngoxuanmanh.masoi.R;

import java.util.List;

/**
 * Created by NgoXuanManh on 7/23/2017.
 */

public class NguoiChoiAdapter extends RecyclerView.Adapter<NguoiChoiAdapter.MyViewHolder> {

    private Context context;
    private List<NguoiChoi> nguoiChois;

    public NguoiChoiAdapter(Context context, List<NguoiChoi> nguoiChois) {
        this.nguoiChois = nguoiChois;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.item_nguoichoi, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NguoiChoi nguoiChoi = nguoiChois.get(position);
        holder.textView.setText(nguoiChoi.getTenNguoiChoi());
    }

    @Override
    public int getItemCount() {
        return nguoiChois.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        private MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "On Click!", Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(context, "Long item clicked ", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }
}
