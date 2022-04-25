package io.liaojie1314.sectionedrecyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<String> sectionList = new ArrayList<>();
    HashMap<String, ArrayList<String>> itemList = new HashMap<>();
    MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        sectionList.add("Morning");
        sectionList.add("Afternoon");
        sectionList.add("Evening");
        sectionList.add("Night");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("05:00 AM");
        arrayList.add("06:00 AM");
        arrayList.add("07:00 AM");
        arrayList.add("08:00 AM");
        arrayList.add("09:00 AM");
        arrayList.add("10:00 AM");
        arrayList.add("11:00 AM");

        itemList.put(sectionList.get(0), arrayList);

        arrayList = new ArrayList<>();
        arrayList.add("12:00 PM");
        arrayList.add("01:00 PM");
        arrayList.add("02:00 PM");
        arrayList.add("03:00 PM");
        arrayList.add("04:00 PM");
        itemList.put(sectionList.get(1), arrayList);
        arrayList = new ArrayList<>();
        arrayList.add("05:00 PM");
        arrayList.add("06:00 PM");
        arrayList.add("07:00 PM");
        arrayList.add("08:00 PM");
        itemList.put(sectionList.get(2), arrayList);
        arrayList = new ArrayList<>();
        arrayList.add("09:00 PM");
        arrayList.add("10:00 PM");
        arrayList.add("11:00 PM");
        arrayList.add("12:00 AM");
        arrayList.add("01:00 AM");
        arrayList.add("02:00 AM");
        arrayList.add("03:00 AM");
        arrayList.add("04:00 AM");
        itemList.put(sectionList.get(3), arrayList);

        mAdapter = new MainAdapter(this, sectionList, itemList);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(manager);
        mAdapter.setLayoutManager(manager);
        mAdapter.shouldShowHeadersForEmptySections(false);
        mRecyclerView.setAdapter(mAdapter);
    }
}