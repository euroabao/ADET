package com.abao.onmic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    ArrayList<Order> orderList;

    public MyAdapter(Context context, ArrayList<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Order order = orderList.get(position);
        holder.item.setText(order.getItemordered());
        holder.datetime.setText(order.getTime());
        holder.name.setText(order.getName());
        holder.address.setText(order.getAddress());
        holder.contact.setText(order.getPhonenumber());
        holder.total.setText(order.getTotal());

        holder.deleteOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase.getInstance().getReference("Order").child(order.id).removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(context,ViewOrdersActivity.class);
                                context.startActivity(intent);
                                Toast.makeText(context, "Order Deleted", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView item, datetime, name, address, contact, total;
        Button deleteOrder;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            deleteOrder = itemView.findViewById(R.id.btnDelete);

            item = itemView.findViewById(R.id.tvItem);
            datetime = itemView.findViewById(R.id.tvDateTime);
            name = itemView.findViewById(R.id.tvName);
            address = itemView.findViewById(R.id.tvAddress);
            contact = itemView.findViewById(R.id.tvContact);
            total = itemView.findViewById(R.id.tvTotal);

        }
    }

}
