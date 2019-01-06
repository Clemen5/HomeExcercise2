package at.fh.swengb.strasser.homeexcercise2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    lateinit var db: NoteRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = NoteRoomDatabase.getDatabase(this)
    }



    fun addNote(view: View) {
        val title = addnote_title.text.toString()
        val content = addnote_content.text.toString()
        val note = Note(title, content)


        db.noteDao.insert(note)
        Log.i("Test", "stored Note in DB")
        db.noteDao.findAll()
        Log.i("Test", "test 2")

        finish()

    }

    /*override fun onDestroy() {
        super.onDestroy()
        db.noteDao.deleteAllNotes()
        Log.i("Test", "delete DB")
    }*/



}
