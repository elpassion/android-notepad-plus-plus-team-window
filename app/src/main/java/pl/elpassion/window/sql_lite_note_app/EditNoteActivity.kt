package pl.elpassion.window.sql_lite_note_app

import android.content.Context
import android.content.Intent
import android.os.Bundle


class EditNoteActivity : NoteActivity() {

    private val note : Note by lazy {
        intent.getSerializableExtra(noteKey) as Note
    }

    companion object {
        fun start(context: Context, note:Note) {
            val intent = Intent(context, EditNoteActivity::class.java)
            intent.putExtra(noteKey, note)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNoteView()
    }

    private fun setUpNoteView() {
        noteTitle.setText(note.title)
        noteContent.setText(note.content)
    }

}