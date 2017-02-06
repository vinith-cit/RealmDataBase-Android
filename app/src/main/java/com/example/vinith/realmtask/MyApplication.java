package com.example.vinith.realmtask;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sony on 20-Oct-16.
 */


/**
 * Application class
 */
public class MyApplication extends Application {

    /**
     * Configuring Realm
     */
    @Override
    public void onCreate() {

        super.onCreate();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
