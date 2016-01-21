package pl.elpassion.window.sql_lite_note_app

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jasiekpor on 20.01.2016.
 */
class Note(val id: Int? = null, val title: String, val content: String) : Parcelable {
    companion object {
        public fun createNoteFromParcel(parcel: Parcel): Note {
            val data = parcel.createStringArray()
            return Note(data[0].toInt(), data[1], data[2])
        }
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeStringArray(arrayOf(this.id.toString(), title, content))
    }

    override fun describeContents(): Int {
        throw UnsupportedOperationException()
    }
}