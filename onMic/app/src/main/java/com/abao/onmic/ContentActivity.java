package com.abao.onmic;

import androidx.appcompat.app.AlertDialog;
import  androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class ContentActivity extends AppCompatActivity {

    private long backPress;
    private Toast backToast;
    private LinearLayout shop, map, userinfo;
    private TextView acePrice, v8Price, wowPrice, videoPrice;
    private Button firstRent, secondRent, thirdRent, fourthRent;
    private Dialog dialog;
    private CardView larger1, larger2, larger3, larger4;

    public static final String EXTRA_TEXT = "com.abao.onmic.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        shop = findViewById(R.id.llShop);
        map = findViewById(R.id.llMap);
        userinfo = findViewById(R.id.llUser);
        firstRent = findViewById(R.id.btnFirstRent);
        secondRent = findViewById(R.id.btnSecondRent);
        thirdRent = findViewById(R.id.btnThirdRent);
        fourthRent = findViewById(R.id.btnFourthRent);

        larger1 = findViewById(R.id.cvLarger1);
        larger2 = findViewById(R.id.cvLarger2);
        larger3 = findViewById(R.id.cvLarger3);
        larger4 = findViewById(R.id.cvLarger4);

        acePrice = findViewById(R.id.tvAcePrice);
        v8Price = findViewById(R.id.tvV8Price);
        wowPrice = findViewById(R.id.tvWOWPrice);
        videoPrice = findViewById(R.id.tvVideoPrice);

        dialog = new Dialog(this);

        larger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.popupfirst);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        firstRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Passing the Item name in the next Window
                TextView itemName = findViewById(R.id.tvItemName1);
                String ITEMNAME = itemName.getText().toString();
                String PRICE = "600";
                Intent intent = new Intent(ContentActivity.this, RentActivity.class);
                intent.putExtra(EXTRA_TEXT, ITEMNAME);
                intent.putExtra("price", PRICE);
                startActivity(intent);
            }
        });

        larger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.popupsecond);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        secondRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView itemName = findViewById(R.id.tvItemName2);
                String ITEMNAME = itemName.getText().toString();
                String PRICE = "750";
                Intent intent = new Intent(ContentActivity.this, RentActivity.class);
                intent.putExtra(EXTRA_TEXT, ITEMNAME);
                intent.putExtra("price", PRICE);
                startActivity(intent);
            }
        });

        larger3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.popupthird);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        thirdRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView itemName = findViewById(R.id.tvItemName3);
                String ITEMNAME = itemName.getText().toString();
                String PRICE = "350";
                Intent intent = new Intent(ContentActivity.this, RentActivity.class);
                intent.putExtra(EXTRA_TEXT, ITEMNAME);
                intent.putExtra("price", PRICE);
                startActivity(intent);
            }
        });

        larger4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.popupfourth);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        fourthRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView itemName = findViewById(R.id.tvItemName4);
                String ITEMNAME = itemName.getText().toString();
                String PRICE = "700";
                Intent intent = new Intent(ContentActivity.this, RentActivity.class);
                intent.putExtra(EXTRA_TEXT, ITEMNAME);
                intent.putExtra("price", PRICE);
                startActivity(intent);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentActivity.this, ContentActivity.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentActivity.this, Map_Activity.class);
                startActivity(intent);
            }
        });

        userinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentActivity.this, UserInfo.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (backPress + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(), "Press again to exit", Toast.LENGTH_SHORT);
            backToast.show();

        }
        backPress = System.currentTimeMillis();

    }

}