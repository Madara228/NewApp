package com.example.karag.newapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.line.view.*

class MainActivity : AppCompatActivity() {
    var a = listOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = MyAdapter(listOf(
                Person(0, "Vasya", 12,"https://cdn-images-1.medium.com/max/1600/1*n6D0iDnAUahn42u6ng5z1g.png"),
                Person(1,"TROUBLE",123,"https://cdn-images-1.medium.com/max/1600/1*n6D0iDnAUahn42u6ng5z1g.png")
        ))

    }

    class MyAdapter(val myList: List<Person>) : RecyclerView.Adapter<MyAdapter.PersonViewHolder>() {

        override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
            val currentElement = myList[position]
            Picasso.with(holder.imageView.context).load(currentElement.image).into(holder.imageView)
            holder.titleTv.text = currentElement.name
            holder.ageTv.text = currentElement.age.toString()
            holder.idTv.text = currentElement.id.toString()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.PersonViewHolder {
            return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.line, parent, false))
        }

        override fun getItemCount() = myList.size

        class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageView = view.imageView
            val titleTv = view.titleTv
            val ageTv = view.ageTv
            val idTv = view.idTv
        }

    }
}
