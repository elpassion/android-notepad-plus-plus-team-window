package pl.elpassion.window.sql_lite_note_app

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NoteDAO(context: Context, name: String, factory: SQLiteDatabase.CursorFactory, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private val DATABASE_NAME = "notepadPlusPlusDB"
        private val DATABASE_VERSION = 1
        private val TABLE_NOTE = "note"
        private val KEY_NOTE_ID = "id"
        private val KEY_NOTE_TITLE = "noteTitle"
        private val KEY_NOTE_CONTENT = "noteContent"
    }

    override fun onConfigure(db: SQLiteDatabase) {
        super.onConfigure(db)
        db.setForeignKeyConstraintsEnabled(true)
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_NOTE_TABLE = " CREATE TABLE $TABLE_NOTE($KEY_NOTE_ID INTEGER PRIMARY KEY, $KEY_NOTE_TITLE TEXT, $KEY_NOTE_CONTENT TEXT)"
        db.execSQL(CREATE_NOTE_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
    public fun addOrUpdateNote(note : Note):Long{

        return 1
    }
}