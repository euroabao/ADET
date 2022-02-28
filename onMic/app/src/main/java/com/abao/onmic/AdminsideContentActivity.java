package com.abao.onmic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdminsideContentActivity extends AppCompatActivity {

    LinearLayout viewOrder ,viewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminside_content);

        viewOrder = findViewById(R.id.viewOrder);
        viewUser = findViewById(R.id.viewUser);

        viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminsideContentActivity.this, ViewOrdersActivity.class);
                startActivity(intent);
            }
        });

        viewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminsideContentActivity.this, ViewUsersActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Admin")
                .setMessage("Are you sure want to logout?")

                .setPositiveButton("Yes", null)
                .setNegativeButton("No", null)
                .show();

        // Yes to Logout
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminsideContentActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminsideContentActivity.this, LobbyActivity.class);
                startActivity(intent);
            }
        });

        // No to Cancel
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}