package com.example.etcstudy.tree_structure

sealed class Data(val name: String) {
    class File(name: String): Data(name)
    class Directory(name: String): Data(name)
}