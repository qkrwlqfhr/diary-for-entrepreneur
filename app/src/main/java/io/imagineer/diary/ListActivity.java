package io.imagineer.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final String[] sampleArray = {"hello","thid","is","test"};

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, R.layout.list_item, sampleArray);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("item",sampleArray[position]);
                startActivity(intent);
            }
        });
    }
}
