package com.example.myapplication.interfaces

interface IAdapter<T> {

    var onItemClick: ((T) -> Unit)?

    var items: List<T>
}