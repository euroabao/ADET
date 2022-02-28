package com.abao.onmic;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Order> listOrder;

    public MyAdapter(Context context, ArrayList<Order> listOrder) {
        this.context = context;
        this.listOrder = listOrder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Order order = listOrder.get(position);

        holder.order.setText("(" + order.getSize() + ")" + " " + order.getFlavor());
        holder.addons.setText(order.getAddons());
        holder.quantity.setText(order.getQuantity());
        holder.total.setText("Php" + order.getPrice());
        holder.receiver.setText(order.getReceiver());
        holder.address.setText(order.getAddress());
        holder.phone.setText(order.getPhone());

        holder.deleteOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase.getInstance().getReference("Order").child(order.id).removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(context, "Order Deleted", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView order, addons, quantity, total, receiver, address, phone;
        ImageView deleteOrder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            deleteOrder = itemView.findViewById(R.id.btnDelete);

            order = itemView.findViewById(R.id.tvOrderNameAndSize);
            addons = itemView.findViewById(R.id.tvAddons);
            quantity = itemView.findViewById(R.id.tvQuantity);
            total = itemView.findViewById(R.id.tvPrice);
            receiver = itemView.findViewById(R.id.tvReceiver);
            address = itemView.findViewById(R.id.tvAddress);
            phone = itemView.findViewById(R.id.tvNumber);

        }
    }

}
