package pl.elpassion.window.sql_lite_note_app

import android.content.Context
import android.content.Intent

class CreateNoteActivity : NoteActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, CreateNoteActivity::class.java)
            context.startActivity(intent)
        }
    }

}