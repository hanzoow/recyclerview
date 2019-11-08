package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycleview.adapter.PersonAdapter;
import com.example.recycleview.adapter.PersonAdapterClickListener;
import com.example.recycleview.models.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapterClickListener, PersonAdapter.OnLoadMoreListener {

    RecyclerView recyclerView;
    PersonAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;
    EditText edtName, edtSurname, edtPT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtSurname = findViewById(R.id.edtSurname);
        edtPT = findViewById(R.id.edtPT);
        recyclerView = findViewById(R.id.list);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String surname = edtSurname.getText().toString().trim();
                String PT = edtPT.getText().toString().trim();

                myAdapter.addPerson(new Person(name, surname, PT));

                recyclerView.scrollToPosition(0);

            }
        });

        myAdapter = new PersonAdapter(this, this, fakeData());
        recyclerView.setAdapter(myAdapter);

        // use a linear layout manager
//        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        // use a linearlayout manager for HORIZONTAL
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        // Use a GridView
        //layoutManager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private ArrayList<Person> fakeData() {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Hoai", "Hanh", "bus"));
        people.add(new Person("Hoai", "Thien", "plane"));
        people.add(new Person("Hoai", "Khanh", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Hoai", "Hanh", "bus"));
        people.add(new Person("Hoai", "Thien", "bus"));
        people.add(new Person("Hoai", "Khanh", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Hoai", "Hanh", "bus"));
        people.add(new Person("Hoai", "Thien", "plane"));
        people.add(new Person("Hoai", "Khanh", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Hoai", "Hanh", "bus"));
        people.add(new Person("Hoai", "Thien", "plane"));
        people.add(new Person("Hoai", "Khanh", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Hoai", "Hanh", "bus"));
        people.add(new Person("Hoai", "Thien", "bus"));
        people.add(new Person("Hoai", "Khanh", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Hoai", "Hanh", "bus"));
        people.add(new Person("Hoai", "Thien", "plane"));
        people.add(new Person("Hoai", "Khanh", "plane"));
        return people;
    }

    @Override
    public void onPersonClick(Person person) {
        Toast.makeText(this, "Surname: " + person.getSurname(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore() {
//        if (!recyclerView.isComputingLayout())
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                myAdapter.updatePeopleData(fakeData());

            }
        }, 2000);
    }
}
