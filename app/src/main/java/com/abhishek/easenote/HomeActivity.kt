package com.abhishek.easenote

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    private lateinit var addNotes: FloatingActionButton
    private lateinit var notesRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //View init
        addNotes = findViewById(R.id.addNotes)
        notesRV = findViewById(R.id.rv_notes)

        //AddButon onClick
        addNotes.setOnClickListener() {
            startActivity(Intent(this,AddNotesActivity::class.java))
            finish()
        }

    }
}