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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyUserAdapter extends RecyclerView.Adapter<MyUserAdapter.MyUserViewHolder> {

    Context context;
    ArrayList<User> userList;

    public MyUserAdapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyUserAdapter.MyUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_layout,parent,false);
        return new MyUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyUserAdapter.MyUserViewHolder holder, int position) {

        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.address.setText(user.getAddress());
        holder.contact.setText(user.getPhonenumber());
        holder.email.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class MyUserViewHolder extends RecyclerView.ViewHolder{

        TextView name, address, contact, email;

        public MyUserViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            address = itemView.findViewById(R.id.tvAddress);
            contact = itemView.findViewById(R.id.tvContact);
            email = itemView.findViewById(R.id.tvEmail);

        }
    }
}
