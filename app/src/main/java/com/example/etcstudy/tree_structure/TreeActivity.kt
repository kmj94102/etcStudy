package com.example.etcstudy.tree_structure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.databinding.ActivityTreeBinding

class TreeActivity : AppCompatActivity() {

    private val binding : ActivityTreeBinding by lazy { ActivityTreeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = FileAdapter(makeSample())

    }


    private fun makeSample(): List<Node<Data>> {
        val dir1 = Node<Data>(Data.Directory("dir1"))
            .addChild(Node(Data.Directory("dir2")))
            .addChild(Node(Data.File("file1")))

        val dir4 = Node<Data>(Data.Directory("dir4"))
            .addChild(Node(Data.File("file2")))

        val dir5 = Node<Data>(Data.Directory("dir5"))
            .addChild(Node(Data.File("file3")))
            .addChild(Node(Data.File("file4")))

        val dir3 = Node<Data>(Data.Directory("dir3"))
            .addChild(dir4)
            .addChild(dir5)

        return listOf(dir1, dir3)
    }
}