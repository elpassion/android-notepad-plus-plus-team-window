package pl.elpassion.dmalantowicz.rest_client_example.adapter

import pl.elpassion.window.sql_lite_note_app.Note

/**
 * Created by dmalantowicz on 15.01.2016.
 */
class NoteListAdapter(val notes : List<Note> ) : BaseAdapter(){

    init{
        notes.forEach {
            adapters.add(NoteItemAdapter( it ))
        }
    }
}