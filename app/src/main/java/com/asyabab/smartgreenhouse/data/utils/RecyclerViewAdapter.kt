package com.asyabab.endora.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter<T>(
            private val layout: Int,
    val onBind: (view: View, item: T, position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter<T>.ViewHolder<T>>() {
    var items = ArrayList<T>()
    var onItemClick: ((pos: Int, view: View, item: T) -> Unit)? = null

    companion object {
        var isSelectedAll=false
    }
    fun addItem(item: T) {
        this.items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun addItems(items: List<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun selectAll() {
        isSelectedAll = true
        notifyDataSetChanged()
    }


    fun unselectall() {
        isSelectedAll = false
        notifyDataSetChanged()
    }
    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun removeItem(pos: Int) {
        items.removeAt(pos)
        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos, items.size);
    }

    inner class ViewHolder<T>(
        private val view: View,
        val onBind: (view: View, item: T, position: Int) -> Unit
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        override fun onClick(p0: View?) {
            onItemClick?.invoke(adapterPosition, p0!!, items[adapterPosition])
        }

        fun bind(item: T, position: Int) {
            view.setOnClickListener(this)
            onBind(view, item, position)
        }
        fun selectCheck(): Boolean {
            return isSelectedAll
        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder<T> {
        return ViewHolder(p0.inflate(layout), onBind)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder<T>, pos: Int) {
        holder.bind(items[pos], pos)
    }

}
