package pl.elpassion.dmalantowicz.rest_client_example.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pl.elpassion.window.sql_lite_note_app.Note
import pl.elpassion.window.sql_lite_note_app.R

/**
 * Created by dmalantowicz on 15.01.2016.
 */
class NoteItemAdapter(private val note: Note) : ItemAdapter {

    override val itemViewType = R.id.note_list_item

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.note_list_item, parent, false)
        return NameRateItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder) {
        val nameRateItemHolder = holder as NameRateItemHolder
        nameRateItemHolder.title.text = note.title
        nameRateItemHolder.content.text = note.content
    }

    private inner class NameRateItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById(R.id.list_item_title) as TextView
        val content = itemView.findViewById(R.id.list_item_content) as TextView

    }
}