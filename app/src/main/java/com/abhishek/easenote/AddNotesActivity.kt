package com.abhishek.easenote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm
import java.lang.Exception

class AddNotesActivity : AppCompatActivity() {

    private lateinit var et_title: EditText
    private lateinit var et_desc: EditText
    private lateinit var btn_saveNotes: Button
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        //Init views
        et_title = findViewById(R.id.et_title)
        et_desc = findViewById(R.id.et_desc)
        btn_saveNotes = findViewById(R.id.bt_SaveNote)
        realm = Realm.getDefaultInstance()

        btn_saveNotes.setOnClickListener{
            addNotesToDB()
        }



    }

    private fun addNotesToDB() {
        try {
            realm.beginTransaction()
            var currentIDNumber:Number? = realm.where(Notes::class.java).max("id")
            val nextId:Int

            nextId = if(currentIDNumber == null){
                1
            } else {
                currentIDNumber.toInt() + 1
            }

            val notes = Notes()

            notes.title = et_title.text.toString()
            notes.desc = et_desc.text.toString()
            notes.id = nextId

            //Send the parsed data to DB

            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()

            Toast.makeText(this, "Notes Added",Toast.LENGTH_LONG).show()

            startActivity(Intent(this, HomeActivity::class.java))
            finish()

        } catch (e:Exception) {
            Toast.makeText(this, "Uh Uho - Try Again! $e",Toast.LENGTH_LONG).show()
        }
    }
}
