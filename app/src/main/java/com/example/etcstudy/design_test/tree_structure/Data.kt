package com.example.etcstudy.design_test.tree_structure

sealed class Data(val name: String) {
    class File(name: String): Data(name)
    class Directory(name: String): Data(name)
}