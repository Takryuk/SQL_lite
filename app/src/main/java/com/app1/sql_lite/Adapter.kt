package com.app1.sql_lite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class Adapter(var context:Context, data: ArrayList<Subject>): RecyclerView.Adapter<Adapter.ViewHolder>(){


    var data: List<Subject>

    init {
        this.data = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.desc.text = data[position].desc
        holder.id.text = data[position].id

        holder.btn.setOnClickListener(View.OnClickListener { view ->
//            val context = view.context
            val DB = SQLhelper(context)
            println("holder.id.text" + holder.id.text)
            DB.Delete_Data(holder.id.text.toString())

            context.startActivity(Intent(context, MainActivity::class.java))


        })






    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(item: View): RecyclerView.ViewHolder(item){

        var title:TextView
        var id: TextView
        var desc: TextView
        var card: CardView
        var btn:Button

        init {
            title = item.findViewById(R.id.title_textview)
            id = item.findViewById(R.id.id_textview)
            desc = item.findViewById(R.id.desc_textview)
            card = item.findViewById(R.id.item_card)
            btn = item.findViewById(R.id.delete_btn)

        }
    }

}