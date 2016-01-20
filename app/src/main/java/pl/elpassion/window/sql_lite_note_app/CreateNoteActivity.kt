package pl.elpassion.window.sql_lite_note_app

import android.content.Context
import android.content.Intent

class CreateNoteActivity : NoteActivity() {

    companion object {
        private val noteItemIdKey :String = "noteItemId"
        fun start(context: Context, noteItemId : Int) {
            val intent = Intent(context, CreateNoteActivity::class.java)
            intent.putExtra(noteItemIdKey, noteItemId)
            context.startActivity(intent)
        }
    }

}