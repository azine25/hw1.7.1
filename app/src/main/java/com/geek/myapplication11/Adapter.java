package com.geek.myapplication11;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.myapplication11.databinding.MyViewBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VievHolder> {

    private ArrayList<User> list = new ArrayList<>();
    OnClicks clicks;
    Adapter() {
    }

    public void add(ArrayList<User> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnClicks(OnClicks ons){
        this.clicks = ons;
    }

    public void setColor(int position, int color) {
        list.get(position).setColor(color);
        list.set(position,list.get(position));
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Adapter.VievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VievHolder(MyViewBinding.inflate
                (LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.VievHolder holder, int position) {
        holder.onBind(list.get(position));

        holder.itemView.setOnClickListener(v -> {
            clicks.clickOn(list.get(position),position);
        });


        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(v.getContext())
                    .setMessage("ВЫ действительно хотите удалить элемент?")
                    .setTitle("Удалить элемент")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            list.remove(position);
                            notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("NO", (dialog, which) -> dialog.cancel())
                    .show()
            ;
            return false;
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VievHolder extends RecyclerView.ViewHolder {
        private MyViewBinding binding;

        public VievHolder( MyViewBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(User user) {
            binding.num.setText(String.valueOf(user.getNum()+1));
            binding.num.setBackgroundColor(itemView.getResources().getColor(user.getColor()));
        }
    }
}
