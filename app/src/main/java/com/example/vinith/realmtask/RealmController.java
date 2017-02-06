package com.example.vinith.realmtask;

/**
 * Created by sony on 20-Oct-16.
 */


import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Realm DB Instance
 */
public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    /**
     * instance for Fragment
     */
    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    /**
     * instance for activity
     */
    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    /**
     * instance for application
     */
    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    /***
     * Getting  Instance through static method
     *
     * @return
     */
    public static RealmController getInstance() {

        return instance;
    }

    /**
     * Getting Realm Instance
     *
     * @return
     */
    public Realm getRealm() {

        return realm;
    }

    /**
     * Refresh the realm istance
     */
    public void refresh() {

        realm.refresh();
    }

    /**
     * clear all objects from Student.class
     */
    public void clearAll() {

        realm.beginTransaction();
        realm.clear(Student.class);
        realm.commitTransaction();
    }

    /**
     * find all objects in the Student.class
     */
    public RealmResults<Student> getStudent() {

        return realm.where(Student.class).findAll();
    }

    /**
     * query a single item with the given id
     */
    public Student getStudent(String id) {

        return realm.where(Student.class).equalTo("id", id).findFirst();
    }

    /**
     * check if Student.class is empty
     */
    public boolean hasStudents() {

        return !realm.allObjects(Student.class).isEmpty();
    }


}