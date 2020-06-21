package com.abhishek.easenote

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()

        //Realm Initialize
        Realm.init(this)

        val configuration = RealmConfiguration.Builder()
            .name("Ease Note")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .build()

        Realm.setDefaultConfiguration(configuration)

    }
}