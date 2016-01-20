package pl.elpassion.window.sql_lite_note_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText

/**
 * Created by dmalantowicz on 20.01.2016.
 */
open class NoteActivity : AppCompatActivity() {

    protected val noteTitle by lazy { findViewById(R.id.note_title) as EditText }
    protected val noteContent by lazy { findViewById(R.id.note_content) as EditText }
    protected var note : Note? = null

    companion object {
        private val noteItemIdKey: String = "noteItemId"
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_and_edit_layout)
        val noteId = intent.getIntExtra(noteItemIdKey, 0)
        note = getNoteFromDB(noteId)
        setUpNoteView(note!!)
    }

    private fun getNoteFromDB(noteId: Int): Note {
        return Note(0,"eqweq","eqweq")
    }

    private fun setUpNoteView(note: Note) {
        noteTitle.setText(note.title)
        noteContent.setText(note.content)
    }
}