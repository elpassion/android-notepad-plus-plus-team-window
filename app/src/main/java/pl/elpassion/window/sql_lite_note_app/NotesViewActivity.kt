package pl.elpassion.window.sql_lite_note_app

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import de.greenrobot.event.EventBus
import pl.elpassion.dmalantowicz.rest_client_example.adapter.NoteListAdapter
import pl.elpassion.window.sql_lite_note_app.message.ItemDetailsMessageEvent
import java.util.*

class NotesViewActivity : AppCompatActivity() {
    val recyclerView by lazy { findViewById(R.id.notes_list) as RecyclerView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_list)
        setUpRecycleView()
    }

    private fun setUpRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = NoteListAdapter(ArrayList())
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this);
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop()
    }

    fun onEvent(event: ItemDetailsMessageEvent){
        Snackbar.make(recyclerView, event.id, Toast.LENGTH_SHORT).show();
        EditNoteActivity.start(this, event.id)
    }
}
