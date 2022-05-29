package com.example.giftlara;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class searchActivity extends AppCompatActivity {

    private RecyclerView giftRecyclerView;
    private LinearLayoutManager layoutManager;
    private List<ModelClass> userList;
    private GiftAdapter giftAdapter;
    private ImageButton sortMenu;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initData();
        initRecyclerView();

        // For Searching Feature
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        // For sorting feature
        sortMenu = findViewById(R.id.sort_gifts);
        // init popup menu
        PopupMenu popupMenu = new PopupMenu(
                this, // context
                sortMenu // where to click to show popup menu
        );

        // add menu.xml to our popup menu
        popupMenu.getMenuInflater().inflate(R.menu.sort_menu, popupMenu.getMenu());

        // handle menu items click for sorting
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                // get id of the menu item clicked
                int id = menuItem.getItemId();
                // handle clicks
                if (id == R.id.menu_asc){
                    Collections.sort(userList, ModelClass.modelClassNameAZComparator);
                    Toast.makeText(searchActivity.this, "Sort A to Z", Toast.LENGTH_SHORT).show();
                    giftAdapter.notifyDataSetChanged();
                    return true;
                }
                else if (id == R.id.menu_desc){
                    Collections.sort(userList, ModelClass.modelClassNameZAComparator);
                    Toast.makeText(searchActivity.this, "Sort Z to A", Toast.LENGTH_SHORT).show();
                    giftAdapter.notifyDataSetChanged();
                    return true;
                }
                else if (id == R.id.menu_asc_price){
                    Collections.sort(userList, ModelClass.modelClassPriceAscendingComparator);
                    Toast.makeText(searchActivity.this, "Sort Price in Ascending", Toast.LENGTH_SHORT).show();
                    giftAdapter.notifyDataSetChanged();
                    return true;
                }
                else if (id == R.id.menu_desc_price){
                    Collections.sort(userList, ModelClass.modelClassPriceDescendingComparator);
                    Toast.makeText(searchActivity.this, "Sort Price in Descending", Toast.LENGTH_SHORT).show();
                    giftAdapter.notifyDataSetChanged();
                    return true;
                }
                else if (id == R.id.menu_asc_rating){
                    Collections.sort(userList, ModelClass.modelClassRatingAscendingComparator);
                    Toast.makeText(searchActivity.this, "Sort Rating in Ascending", Toast.LENGTH_SHORT).show();
                    giftAdapter.notifyDataSetChanged();
                    return true;
                }
                else if (id == R.id.menu_desc_rating){
                    Collections.sort(userList, ModelClass.modelClassRatingDescendingComparator);
                    Toast.makeText(searchActivity.this, "Sort Rating in Descending", Toast.LENGTH_SHORT).show();
                    giftAdapter.notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });

        // handle button click to show menu
        sortMenu.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                popupMenu.show();
                popupMenu.setForceShowIcon(true);
            }
        });
    }

    private void filterList(String text) {
        List<ModelClass> filteredList = new ArrayList<>();
        for (ModelClass modelClass : userList) {
            if(modelClass.getGiftName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(modelClass);
            }
        }
        if(filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {
            giftAdapter.setFilteredList(filteredList);
        }
    }

    // init RecyclerView
    private void initRecyclerView() {
        giftRecyclerView =findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        giftRecyclerView.setLayoutManager(layoutManager);
        giftRecyclerView.setHasFixedSize(true);
        giftAdapter = new GiftAdapter(userList);
        giftRecyclerView.setAdapter(giftAdapter);

    }

    // init Gifts data
    private void initData() {
        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.greeting_card,"Greeting Cards",450,4900));

        userList.add(new ModelClass(R.drawable.astro_mug,"Astro Mug",550,4700));

        userList.add(new ModelClass(R.drawable.makeup,"Nykaa Make Up Kit",6000,4900));

        userList.add(new ModelClass(R.drawable.baby_toy,"Baby Toy",45,4300));

        userList.add(new ModelClass(R.drawable.teddy_bear,"Teddy Bear Toy",67,4900));

        userList.add(new ModelClass(R.drawable.plare_mug,"Plare Mug",300,4300));

        userList.add(new ModelClass(R.drawable.lakme,"Lakme Make Up Kit",9900,4900));

        userList.add(new ModelClass(R.drawable.kloss_toy,"Kloss Baby Toy",79,4600));

        userList.add(new ModelClass(R.drawable.man_perfume,"Schoro Men Perfume",678,4900));

        userList.add(new ModelClass(R.drawable.pika_toy,"Toys",101,4700));

        userList.add(new ModelClass(R.drawable.vostro_perfume,"Vostro Perfume",900,4900));

        userList.add(new ModelClass(R.drawable.gorr_makeup,"Gorr Make Up Kit",3400,4400));

        userList.add(new ModelClass(R.drawable.girl_perfume,"Indiana Girllz Perfume",1000,4900));

    }
}