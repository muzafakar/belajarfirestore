package com.example.zulfakar.firesttore.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.zulfakar.firesttore.model.Customer;
import com.example.zulfakar.firesttore.presenter.Contract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zulfakar on 27/07/18.
 * For educational purposes
 */
public class Firebase implements Contract.Interactor {
    private Contract.Presenter presenter;
    private CollectionReference customerCol;

    public Firebase(Contract.Presenter presenter) {
        this.presenter = presenter;
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        customerCol = firestore.collection(Constants.CUSTOMER);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customerCol.add(customer)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        presenter.onSuccess(documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("FirebaseAddNewCustomer", "onFailure: " + e.getMessage());
                    }
                });

    }

    @Override
    public void getCustomers() {
        final List<Customer> customers = new ArrayList<>();
        customerCol.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                customers.add(document.toObject(Customer.class));
                            }
                            presenter.onFinishCall(customers);
                        }
                    }
                });
    }
}
