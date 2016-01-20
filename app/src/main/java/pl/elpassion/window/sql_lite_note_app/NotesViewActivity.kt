package pl.elpassion.window.sql_lite_note_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import de.greenrobot.event.EventBus
import pl.elpassion.dmalantowicz.rest_client_example.adapter.NoteListAdapter
import pl.elpassion.window.sql_lite_note_app.message.ItemDetailsMessageEvent

class NotesViewActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, NotesViewActivity::class.java)
            context.startActivity(intent)
        }
    }
    val recyclerView by lazy { findViewById(R.id.notes_list) as RecyclerView }
    protected val noteDao by lazy {  NoteDAO.getInstance(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_list)
        setUpRecycleView()
    }

    private fun setUpRecycleView() {
        val notes = noteDao.findAll()
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = NoteListAdapter(notes)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_create){
            CreateNoteActivity.start(this)
        }
        return super.onOptionsItemSelected(item)
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
        EditNoteActivity.start(this, event.id)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_notes_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
