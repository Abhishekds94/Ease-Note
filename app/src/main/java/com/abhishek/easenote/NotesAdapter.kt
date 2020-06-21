package com.abhishek.easenote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults
import kotlinx.android.synthetic.main.rv_notes_layout.view.*

class NotesAdapter(
    private val context: Context?, private val notesList: RealmResults<Notes>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_notes_layout, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_title.text = notesList[position]!!.title
        holder.itemView.tv_desc.text = notesList[position]!!.desc
        holder.itemView.tv_id.text = notesList[position]!!.id.toString()
    }

    class ViewHolder(v: View?): RecyclerView.ViewHolder(v!!){
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val desc = itemView.findViewById<TextView>(R.id.tv_desc)
        val id = itemView.findViewById<TextView>(R.id.tv_id)
    }

}