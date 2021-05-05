package com.prabisha.youngsplanet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    NavigationView navigationView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton flaoting_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        flaoting_cart=findViewById(R.id.floating_cart);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
//        recyclerView=findViewById(R.id.recycler_menu);
//        recyclerView.setHasFixedSize(true);
//        layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

        flaoting_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(HomeActivity.this,CartActivity.class);
                startActivity(intent5);

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_home:
                Intent intentHome=new Intent(HomeActivity.this,HomeActivity.class);
                startActivity(intentHome);
                return true;
            case R.id.nav_store:
                Intent intent=new Intent(HomeActivity.this,StoreActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_toys:
                Intent intent2=new Intent(HomeActivity.this,ToyActivity.class);
                startActivity(intent2);
                return true;
            case R.id.nav_books:
                Intent intent3=new Intent(HomeActivity.this,BooksActivity.class);
                startActivity(intent3);
                return true;
            case R.id.nav_clothes:
                Intent intent4=new Intent(HomeActivity.this,ClothesActivity.class);
                startActivity(intent4);
                return true;
            case R.id.nav_accounts:
                Intent intent5=new Intent(HomeActivity.this,AccountsActivity.class);
                startActivity(intent5);
                return true;
            case R.id.logout:
                AlertShowForLogout();
                return true;
            case R.id.share:
                Intent shareintent = new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                shareintent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                shareintent.putExtra(Intent.EXTRA_TEXT, "This is my text");
                startActivity(Intent.createChooser(shareintent, "choose one"));

                return true;
            case R.id.nav_about:
                String url = "https://www.greentoysplanet.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
        }
        return false;
    }

    private void AlertShowForLogout()
    {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Logout");
        alert.setMessage("Are You Sure");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
}