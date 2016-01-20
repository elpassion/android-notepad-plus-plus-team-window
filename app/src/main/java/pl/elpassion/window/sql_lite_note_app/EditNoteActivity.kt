package pl.elpassion.window.sql_lite_note_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle


class EditNoteActivity : NoteActivity() {

    companion object {
        private val noteItemIdKey :String = "noteItemId"

        fun start(context: Context, noteItemId : Int) {
            val intent = Intent(context, EditNoteActivity::class.java)
            intent.putExtra(noteItemIdKey, noteItemId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

}