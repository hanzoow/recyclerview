package com.example.recycleview.adapter.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.adapter.PersonAdapterClickListener;
import com.example.recycleview.models.Person;

public class PlaneVH extends RecyclerView.ViewHolder {
    ImageView ivPref;
    TextView tvName, tvSurname;
    private PersonAdapterClickListener listener;

    public PlaneVH(@NonNull View itemView, PersonAdapterClickListener listener) {
        super(itemView);
        this.listener = listener;

        tvName = itemView.findViewById(R.id.tvName);
        tvSurname = itemView.findViewById(R.id.tvSurname);
        ivPref = itemView.findViewById(R.id.ivPref);
    }


    public void bind(final Person person) {
        // - get element from your data at this position
        // - replace the contents of the view with that element
//        itemView.setTag(person);
        tvName.setText(person.getName());
        tvSurname.setText(person.getSurname());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                activity.onItemClicked(person.indexOf((Person) view.getTag()));
                listener.onPersonClick(person);
            }
        });
    }
}
