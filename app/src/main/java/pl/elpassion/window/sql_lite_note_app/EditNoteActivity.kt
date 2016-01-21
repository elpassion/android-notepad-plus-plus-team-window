package pl.elpassion.window.sql_lite_note_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle


class EditNoteActivity : NoteActivity() {

    companion object {
        fun start(activity: Activity, note:Note, resultOK: Int) {
            val intent = Intent(activity, EditNoteActivity::class.java)
            intent.putExtra(noteKey, note)
            activity.startActivityForResult(intent, resultOK)
        }
    }

    private val note : Note by lazy {
        intent.getSerializableExtra(noteKey) as Note
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