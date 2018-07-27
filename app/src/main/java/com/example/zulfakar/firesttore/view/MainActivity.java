package com.example.zulfakar.firesttore.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zulfakar.firesttore.R;
import com.example.zulfakar.firesttore.model.Customer;
import com.example.zulfakar.firesttore.presenter.Contract;
import com.example.zulfakar.firesttore.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.view {
    Contract.Presenter presenter;
    List<Customer> customers;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);

//        for (int i = 0; i < 10; i++) {
//            Customer customer = new Customer("muza-0" + i, "jangkong");
//            presenter.addNewCustomer(customer);
//        }
        listView = findViewById(R.id.lv);
        presenter.getCustomer();

    }

    @Override
    public void onComplete(String message) {
        Toast.makeText(this, "success\n" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCustomers(List<Customer> customers) {
        this.customers = customers;
        List<String> names = new ArrayList<>();
        for (int i = 0; i < this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            names.add(customer.getName());
        }
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1, names);
        listView.setAdapter(adapter);
    }
}
