package com.abao.onmic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

public class AdminAddItemActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView image;
    private ProgressBar loading;
    private Button chooseImage, addItem;
    private EditText desc1, desc2 ,desc3, desc4, desc5, desc6, desc7;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_item);

        image = findViewById(R.id.ivImage);
        loading = findViewById(R.id.pbLoading);
        chooseImage = findViewById(R.id.btnChooseImage);
        addItem = findViewById(R.id.btnAddItem);
        desc1 = findViewById(R.id.etDesc1);
        desc2 = findViewById(R.id.etDesc2);
        desc3 = findViewById(R.id.etDesc3);
        desc4 = findViewById(R.id.etDesc5);
        desc6 = findViewById(R.id.etDesc6);
        desc7 = findViewById(R.id.etDesc7);

        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && requestCode == RESULT_OK
                && data != null && data.getData() != null) {
            imageUri = data.getData();

            image.setImageURI(imageUri);
        }
    }
}