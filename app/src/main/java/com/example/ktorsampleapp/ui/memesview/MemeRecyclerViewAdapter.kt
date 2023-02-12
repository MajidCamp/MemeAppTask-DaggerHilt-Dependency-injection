package com.example.ktorsampleapp.ui.memesview

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.ktorsampleapp.databinding.FragmentMemeBinding
import com.example.ktorsampleapp.model.meme.Meme
import com.example.ktorsampleapp.model.meme.MemeItem

class MemeRecyclerViewAdapter() : ListAdapter<Meme, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
        companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Meme>() {

            override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
                return oldItem.title == newItem.title || oldItem.author == newItem.author ||
                        oldItem.url == newItem.url
            }

        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                RecyclerView.ViewHolder {
            val  binding: FragmentMemeBinding =
                FragmentMemeBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (holder is ViewHolder){
                val item = getItem(position)
                holder.bind(item)
            }
        }


        inner class ViewHolder(val itemBinding: FragmentMemeBinding):
            RecyclerView.ViewHolder(itemBinding.root) {

            fun bind(item: Meme) {
                Log.d("adapter", "bind $adapterPosition")
                itemBinding.apply {
                    title.text = item.title
                    ivPicture.load(item.url)
                }
            }

        }
    }