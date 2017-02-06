package com.example.vinith.realmtask;

/**
 * Created by sony on 20-Oct-16.
 */
import android.content.Context;
import io.realm.RealmResults;


public class RealmStudentAdapter extends RealmModelAdapter<Student> {

    public RealmStudentAdapter(Context context, RealmResults<Student> realmResults, boolean automaticUpdate) {

        super(context, realmResults, automaticUpdate);
    }
}


