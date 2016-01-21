package pl.elpassion.window.sql_lite_note_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

/**
 * Created by dmalantowicz on 20.01.2016.
 */
open class NoteActivity : AppCompatActivity() {

    protected val noteTitle by lazy { findViewById(R.id.note_title) as EditText }
    protected val noteContent by lazy { findViewById(R.id.note_content) as EditText }
    protected var id : Int? = null
    protected val noteDao by lazy {  NoteDAO.getInstance(applicationContext) }

    companion object {
        val noteKey: String = "noteKey"
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_and_edit_layout)
        val note = intent.getSerializableExtra(noteKey) as Note?
        if (note != null) id = note.id
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_and_edit_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val content = noteContent.text.toString()
        val title = noteTitle.text.toString()
        val note = Note(id, title, content)
        noteDao.save(note)
        setResult(RESULT_OK)
        finish()
        return super.onOptionsItemSelected(item)
    }

}