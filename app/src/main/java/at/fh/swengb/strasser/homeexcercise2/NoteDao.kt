package at.fh.swengb.strasser.homeexcercise2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Query("SELECT * FROM Note")
    fun findAll(): List<Note>

    @Query("DELETE from Note")
    fun deleteAllNotes()



}