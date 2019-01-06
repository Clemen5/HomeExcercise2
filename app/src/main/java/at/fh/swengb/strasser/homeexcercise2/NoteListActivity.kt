package at.fh.swengb.strasser.homeexcercise2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity () {

    lateinit var db: NoteRoomDatabase

    val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        db = NoteRoomDatabase.getDatabase(this)


        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("name",null)
        val savedInt = sharedPreferences.getInt("alter",-1)
        user_info.text = "Notes for ${savedString}, ${savedInt}"
        recycler_view.adapter = noteAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        db.noteDao.findAll()
        Log.i("Test", "test onResume")
        noteAdapter.updateList(db.noteDao.findAll())
        Log.i("Test", "toAdapter")
    }

    /*override fun onDestroy() {
        super.onDestroy()
        db.noteDao.deleteAllNotes()
        Log.i("Test", "delete DB")
    }*/


    fun nextPage(view: View) {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)

    }








}