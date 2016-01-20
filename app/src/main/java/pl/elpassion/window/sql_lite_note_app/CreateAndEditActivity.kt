package pl.elpassion.window.sql_lite_note_app

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText

/**
 * Created by jasiekpor on 20.01.2016.
 */


class CreateAndEditActivity : AppCompatActivity() {
    private val title by lazy { findViewById(R.id.note_title) as EditText }
    private val content by lazy { findViewById(R.id.note_content) as EditText }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.create_and_edit_layout)
    }
    private fun saveChanges(){

    }
}