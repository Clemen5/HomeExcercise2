package at.fh.swengb.strasser.homeexcercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


    class MainActivity : AppCompatActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }

        fun store(view: View) {
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE) // from within activity
            sharedPreferences.edit().putString("name", main_name.text.toString()).apply()
            Log.i("Test", "stored name")
            sharedPreferences.edit().putInt("alter", main_age.text.toString().toIntOrNull()?: 0).apply()
            Log.i("Test", "stored age succesfully")

            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }

    }
