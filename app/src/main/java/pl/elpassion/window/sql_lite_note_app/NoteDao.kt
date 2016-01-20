package pl.elpassion.window.sql_lite_note_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

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

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    public fun addOrUpdateNote(note: Note): Long {
        val db = writableDatabase
        var noteId: Long = -1

        db.beginTransaction()
        try {
            val values = ContentValues()
            values.put(KEY_NOTE_ID, note.id)
            values.put(KEY_NOTE_TITLE, note.title)
            values.put(KEY_NOTE_CONTENT, note.content)

            val rows = db.update(TABLE_NOTE, values, KEY_NOTE_ID + "= ?", arrayOf(note.id.toString()))

            if (rows == 1) {
                val noteSelectQuery = "SELECT $KEY_NOTE_ID FROM $TABLE_NOTE WHERE $KEY_NOTE_ID = ?"
                val cursor = db.rawQuery(noteSelectQuery, arrayOf(note.id.toString()))
                try {
                    if (cursor.moveToFirst()) {
                        noteId = cursor.getLong(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                noteId = db.insertOrThrow(TABLE_NOTE, null, values);
                db.setTransactionSuccessful();
            }
            db.insertOrThrow(TABLE_NOTE, null, values)
            db.setTransactionSuccessful()
        } catch(e: Exception) {
            Log.d("", "")
        } finally {
            db.endTransaction()
        }

        return noteId
    }
}