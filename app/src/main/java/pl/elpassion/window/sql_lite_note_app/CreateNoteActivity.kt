package pl.elpassion.window.sql_lite_note_app

import android.app.Activity
import android.content.Intent

class CreateNoteActivity : NoteActivity() {

    companion object {
        fun start(activity: Activity, resultOK : Int) {
            val intent = Intent(activity, CreateNoteActivity::class.java)
            activity.startActivityForResult(intent, resultOK)
        }
    }

}