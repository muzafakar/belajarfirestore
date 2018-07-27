package com.example.zulfakar.firesttore.presenter;

import com.example.zulfakar.firesttore.model.Customer;

import java.util.List;

/**
 * Created by zulfakar on 27/07/18.
 * For educational purposes
 */
public class Contract {
    public interface Presenter {
        void addNewCustomer(Customer customer);

        void getCustomer();

        void onFinishCall(List<Customer> customers);

        void onSuccess(String s);

        void onFailure(String s);
    }

    public interface view {
        void onComplete(String message);
        void getCustomers(List<Customer> customers);

    }

    public interface Interactor {
        void addNewCustomer(Customer customer);
        void getCustomers();
    }
}
