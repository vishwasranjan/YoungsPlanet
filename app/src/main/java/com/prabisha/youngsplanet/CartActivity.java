package com.prabisha.youngsplanet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    TextView cart_product_description;
    Button cart_product_pay,cart_product_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cart_product_description=findViewById(R.id.cart_product_description_txt);
        cart_product_pay=findViewById(R.id.cart_product_proceed_to_pay);
        cart_product_remove=findViewById(R.id.cart_item_remove);
        cart_product_description.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                cart_product_description.setText("Add your Product description here \n \n");
            }
        });
        cart_product_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CartActivity.this,PaymentActivity.class);
                startActivity(intent);

            }
        });
        cart_product_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertShowForLogout();
            }
        });

    }
    private void AlertShowForLogout()
    {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Remove Item");
        alert.setMessage("Are You Sure");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setTitle("Are you sure you want to leave");
        alert.show();
    }
}