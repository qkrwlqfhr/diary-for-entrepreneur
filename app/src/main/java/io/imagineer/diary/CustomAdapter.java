package io.imagineer.diary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Article> {
    private Context mContext;
    private ArrayList<Article> mArticles;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Article> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mArticles = (ArrayList<Article>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_row, parent, false);

        TextView titleView = (TextView)row.findViewById(R.id.titleView);
        TextView contentView = (TextView)row.findViewById(R.id.contentView);

        titleView.setText(mArticles.get(position).getTitle());
        contentView.setText(mArticles.get(position).getContent());

        return row;
    }
}
