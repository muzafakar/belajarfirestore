package com.example.zulfakar.firesttore.presenter;

import com.example.zulfakar.firesttore.model.Customer;
import com.example.zulfakar.firesttore.util.Firebase;

import java.util.List;

/**
 * Created by zulfakar on 27/07/18.
 * For educational purposes
 */
public class Presenter implements Contract.Presenter {
    private Contract.Interactor interactor;
    private Contract.view view;

    public Presenter(Contract.view view) {
        this.view = view;
        interactor = new Firebase(this);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        interactor.addNewCustomer(customer);
    }

    @Override
    public void getCustomer() {
        interactor.getCustomers();
    }

    @Override
    public void onFinishCall(List<Customer> customers) {
        view.getCustomers(customers);
    }


    @Override
    public void onSuccess(String s) {
        view.onComplete(s);
    }

    @Override
    public void onFailure(String s) {
        view.onComplete(s);
    }
}
