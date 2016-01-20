package pl.elpassion.window.sql_lite_note_app

import android.content.Context
import android.content.Intent
import android.os.Bundle


class EditNoteActivity : NoteActivity() {

    private val note : Note by lazy {
        noteDao.findOne(intent.getIntExtra(noteItemIdKey, -1))
    }

    companion object {
        fun start(context: Context, noteItemId : Int) {
            val intent = Intent(context, EditNoteActivity::class.java)
            intent.putExtra(noteItemIdKey, noteItemId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val noteId = intent.getIntExtra(noteItemIdKey, -1)
        id = if(noteId == -1) null else noteId
        setUpNoteView()
    }

    private fun setUpNoteView() {
        noteTitle.setText(note.title)
        noteContent.setText(note.content)
    }

}