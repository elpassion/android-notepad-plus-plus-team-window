package pl.elpassion.window.sql_lite_note_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import pl.elpassion.dmalantowicz.rest_client_example.adapter.NoteListAdapter
import java.util.*

class NotesViewActivity : AppCompatActivity() {
    val recyclerView by lazy { findViewById(R.id.notes_list) as RecyclerView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_list)

        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = NoteListAdapter(ArrayList())
    }
}
