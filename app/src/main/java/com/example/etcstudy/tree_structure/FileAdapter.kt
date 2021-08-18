package com.example.etcstudy.tree_structure

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.etcstudy.databinding.CellDirectoryBinding
import com.example.etcstudy.databinding.CellFileBinding

class FileAdapter(nodes: List<Node<Data>>) : TreeAdapter<Data, TreeViewHolder<Data>>(nodes) {

    override fun getItemViewType(position: Int): Int {
        val data = displayNodes[position]

        return if (data.content is Data.File) FILE else DIRECTORY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreeViewHolder<Data> {
        val layoutInflater = LayoutInflater.from(parent.context)

        return if (viewType == FILE)
            FileViewHolder(
                CellFileBinding.inflate(layoutInflater, null, false)
            )
        else
            DirectoryViewHolder(
                CellDirectoryBinding.inflate(layoutInflater, null, false)
            )
    }

    override fun onBindViewHolder(holder: TreeViewHolder<Data>, position: Int) {
        val data = displayNodes[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            toggle(data)
        }
    }

    companion object {
        private const val FILE = 0
        private const val DIRECTORY = 1
    }
}

class FileViewHolder(
    private val binding: CellFileBinding
) : TreeViewHolder<Data>(binding.root) {

    override fun bind(data: Node<Data>) {
        if (data.content !is Data.File) return

        setPaddingStart(data)

        binding.txtView.text = data.content.name
    }
}

class DirectoryViewHolder(
    private val binding: CellDirectoryBinding
) : TreeViewHolder<Data>(binding.root) {

    override fun bind(data: Node<Data>) {
        if (data.content !is Data.Directory) return

        setPaddingStart(data)

        binding.txtView.text = data.content.name
    }
}