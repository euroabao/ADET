package com.abao.onmic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class RentActivity extends AppCompatActivity {

    private EditText showname, showaddress, showphonenumber;
    private TextView total, itemname;
    private Button checkout;
    RadioGroup radioGroup;
    RadioButton radioButton;
    FirebaseAuth auth;
    FirebaseUser fbuser;
    FirebaseDatabase db;
    DatabaseReference reference;

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        // Generate Random Number for database id
        final Random myRandom = new Random();
        String RANDOMID = String.valueOf(myRandom.nextInt(1000));

        showname = findViewById(R.id.etName);
        showaddress = findViewById(R.id.etAddress);
        showphonenumber = findViewById(R.id.etPhoneNumber);
        itemname = findViewById(R.id.tvItemOrdered);
        total = findViewById(R.id.tvTotal);

        checkout = findViewById(R.id.btnCheckout);

        String PRICE = getIntent().getStringExtra("price");
        total.setText("Php" + PRICE + ".00");

        // Item Ordered EXTRA
        Intent intent = getIntent();
        String itemName = intent.getStringExtra(ContentActivity.EXTRA_TEXT);
        TextView itemOrdered = findViewById(R.id.tvItemOrdered);
        itemOrdered.setText(itemName);

        // Displaying Credentials from Firebase Database
        auth = FirebaseAuth.getInstance();
        fbuser = auth.getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("User");
        userID = fbuser.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                if (user != null) {
                    String name, address, phonenumber;
                    name = user.name;
                    address = user.address;
                    phonenumber = user.phonenumber;

                    showname.setText(name);
                    showaddress.setText(address);
                    showphonenumber.setText(phonenumber);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(RentActivity.this, "There is an Error", Toast.LENGTH_LONG).show();
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating a Time and Data for order
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormatTIME = new SimpleDateFormat("hh:mm a");
                SimpleDateFormat simpleDateFormatDATE = new SimpleDateFormat("dd/MMM/yyyy");
                String time = simpleDateFormatTIME.format(calendar.getTime());
                String date = simpleDateFormatDATE.format(calendar.getTime());


                // Database Path
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("Order");

                // Passing all data to new variable
                String PASSEDNAME = showname.getText().toString().trim();
                String PASSEDADDRESS = showaddress.getText().toString().trim();
                String PASSEDPHONENUMBER = showphonenumber.getText().toString().trim();
                String PASSEDITEMNAME = itemname.getText().toString().trim();
                String TOTAL = total.getText().toString().trim();
                String ID = RANDOMID;
                String TIME = time + " (" + date + ")";
                String STATUS = "Pending";

                Order order = new Order(PASSEDNAME, PASSEDADDRESS, PASSEDPHONENUMBER, PASSEDITEMNAME, TOTAL, ID, TIME);

                reference.child(ID).setValue(order).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RentActivity.this, "Your order has been submitted", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RentActivity.this, ContentActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RentActivity.this, "Your order was not able to submit, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }
}