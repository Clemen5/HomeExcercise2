package at.fh.swengb.strasser.homeexcercise2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Note(@PrimaryKey val title: String, val content: String)