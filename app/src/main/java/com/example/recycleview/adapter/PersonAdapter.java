package com.example.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.ViewHolder.BusVH;
import com.example.recycleview.adapter.ViewHolder.PlaneVH;
import com.example.recycleview.models.Person;
import com.example.recycleview.R;
import com.example.recycleview.adapter.ViewHolder.PersonViewHolder;
import com.example.recycleview.adapter.ViewHolder.ViewHolderLoading;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // for load more
//    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_ITEM_BUS = 2;
    private final int VIEW_TYPE_ITEM_PLANE = 3;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener onLoadMoreListener;
    // The minimum amount of items to have below your current scroll position
    // before loading more.
    private boolean isLoading;
    private PersonAdapterClickListener listener;

    private ArrayList<Person> people;


    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public ArrayList<Person> getAdapterData() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(0, person);
        notifyItemInserted(0);
    }

    public void updatePeopleData(ArrayList<Person> persons) {
        isLoading = false;
        int pervSize = people.size();
        people.addAll(persons);
        notifyItemRangeInserted(pervSize, persons.size());
//        notifyDataSetChanged();
    }

    public PersonAdapter(OnLoadMoreListener mOnLoadMoreListener, PersonAdapterClickListener clickListener, ArrayList<Person> list) {
        this.onLoadMoreListener = mOnLoadMoreListener;
        this.listener = clickListener;
        people = list;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // create a new view
        //View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        if (viewType == VIEW_TYPE_ITEM_BUS) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bus, viewGroup, false);
            view.setLayoutParams(new LinearLayout.LayoutParams(viewGroup.getMeasuredWidth() / 2, LinearLayout.LayoutParams.WRAP_CONTENT));
            return new BusVH(view, listener);
        } else if (viewType == VIEW_TYPE_ITEM_PLANE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_plane, viewGroup, false);
            view.setLayoutParams(new LinearLayout.LayoutParams(viewGroup.getMeasuredWidth() / 2, LinearLayout.LayoutParams.WRAP_CONTENT));
            return new PlaneVH(view, listener);
        } else {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_loading, viewGroup, false);
            return new ViewHolderLoading(view);
        }
//        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BusVH) {
            ((BusVH) holder).bind(people.get(position));
        }
        if (holder instanceof PlaneVH) {
            ((PlaneVH) holder).bind(people.get(position));
        }

        if (!isLoading && (position == people.size() - 1)) {
            isLoading = true;
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMore();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < getItemCount() - 1) {
            if (people.get(position).getPreperence().equals("bus")) {
                return VIEW_TYPE_ITEM_BUS;
            }
            return VIEW_TYPE_ITEM_PLANE;
        }
        return VIEW_TYPE_LOADING;
    }

    // Return the size of your data (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return people.size() + 1;
    }
}
