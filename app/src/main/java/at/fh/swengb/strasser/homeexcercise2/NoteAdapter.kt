package at.fh.swengb.strasser.homeexcercise2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter: RecyclerView.Adapter<NoteViewHolder>() {
    var noteList = listOf<Note>()

    fun updateList(newList: List<Note>) {
        noteList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context) //parent ist eine Viewgroup
        val noteItemView = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(noteItemView)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        viewHolder.bindItem(note)
    }



}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItem(note: Note) {
        itemView.item_title.text = note.title
        itemView.item_content.text = note.content


    }
}