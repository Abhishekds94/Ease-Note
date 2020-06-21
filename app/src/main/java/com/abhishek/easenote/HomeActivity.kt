package com.abhishek.easenote

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.RealmResults

class HomeActivity : AppCompatActivity() {

    private lateinit var addNotes: FloatingActionButton
    private lateinit var notesRV: RecyclerView
    private lateinit var notesList: ArrayList<Notes>
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //View init
        addNotes = findViewById(R.id.addNotes)
        notesRV = findViewById(R.id.rv_notes)
        realm = Realm.getDefaultInstance()

        //AddButon onClick
        addNotes.setOnClickListener() {
            startActivity(Intent(this,AddNotesActivity::class.java))
            finish()
        }

        notesRV.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        getAllNotes()

    }

    private fun getAllNotes(){
        notesList = ArrayList()
        var results:RealmResults<Notes> = realm.where<Notes>(Notes::class.java).findAll()
        notesRV.adapter = NotesAdapter(this, results)
        notesRV.adapter!!.notifyDataSetChanged()
    }
}