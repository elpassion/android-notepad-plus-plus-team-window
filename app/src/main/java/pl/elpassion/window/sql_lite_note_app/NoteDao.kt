package pl.elpassion.window.sql_lite_note_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class NoteDAO(context: Context, name: String = "notepadPlusPlusDB", factory: SQLiteDatabase.CursorFactory?, version: Int = 1) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private val TABLE_NOTE = "note"
        private val KEY_NOTE_ID = "id"
        private val KEY_NOTE_TITLE = "noteTitle"
        private val KEY_NOTE_CONTENT = "noteContent"

        private var dao : NoteDAO? = null
        fun getInstance (context: Context) :NoteDAO{
            if (dao == null) dao = NoteDAO(context = context, factory = null)
            return dao!!
        }
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

    public fun save(note: Note) {
        val values = ContentValues()
        values.put(KEY_NOTE_TITLE, note.title)
        values.put(KEY_NOTE_CONTENT, note.content)

        if (note.id == null){
            writableDatabase.insert(TABLE_NOTE, null, values)
        } else {
            writableDatabase.update(TABLE_NOTE, values, "id = ? ",  arrayOf(note.id.toString()))
        }
    }

    public fun findAll() : List<Note>{
        val notes : MutableList<Note> = ArrayList<Note>()
        val res : Cursor =  readableDatabase.rawQuery( "select * from $TABLE_NOTE" , null )
        res.moveToFirst()
        while(res.isAfterLast == false){
            val title = res.getString(res.getColumnIndex(KEY_NOTE_TITLE))
            val content = res.getString(res.getColumnIndex(KEY_NOTE_CONTENT))
            val id = res.getInt(res.getColumnIndex(KEY_NOTE_ID))
            val note = Note(id, title, content)
            notes.add(note);
            res.moveToNext();
        }
        return notes
    }

    public fun findOne(id : Int) : Note{
        val res : Cursor =  readableDatabase.rawQuery("select * from $TABLE_NOTE where id = $id", null )
        res.moveToFirst()
        if(res.isAfterLast == false){
            val title = res.getString(res.getColumnIndex(KEY_NOTE_TITLE))
            val content = res.getString(res.getColumnIndex(KEY_NOTE_CONTENT))
            val id = res.getInt(res.getColumnIndex(KEY_NOTE_ID))
            return Note(id, title, content)
        }
        throw NoSuchElementException()
    }


}