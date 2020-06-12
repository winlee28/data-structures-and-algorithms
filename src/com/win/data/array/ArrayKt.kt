package com.win.data.array

class ArrayKt<E> constructor(capacity: Int) {

    private var data = arrayOfNulls<Any>(capacity) as Array<E>
    private var size = 0;

    fun getSize(): Int {
        return size
    }

    fun getCapacity(): Int {
        return data.size
    }

    fun addFirst(e: E) {
        add(0, e)
    }

    fun addLast(e: E) {
        add(size, e)
    }

    fun add(index: Int, e: E) {

        if (index < 0 || index > size) {
            throw IllegalArgumentException("add fail")
        }

        if (index == getCapacity()) {
            reSize(2 * getCapacity())
        }

        for (i in size downTo index + 1) {
            data[i] = data[i - 1]
        }
        data[index] = e
        size++
    }

    private fun reSize(newCapacity: Int) {

        val newData = arrayOfNulls<Any>(newCapacity) as Array<E>
        for (i in 0 until size) {
            newData[i] = data[i]
        }
        data = newData
    }

    fun get(index: Int): E {
        return data[index]
    }

    fun set(index: Int, e: E) {
        data[index] = e
    }

    fun contains(e: E): Boolean {

        for (i in 0 until size) {
            if (data[i] == e) {
                return true
            }
        }
        return false

    }

    fun find(e: E): Int {

        for (i in 0 until size) {
            if (data[i] == e) {
                return i
            }
        }
        return -1
    }

    fun removeFirst() {
        remove(0)
    }

    fun removeLast() {
        remove(size - 1)
    }

    fun remove(index: Int): E {

        val removeElement = data[index]
        for (i in index + 1 until size) {
            data[i - 1] = data[i]
        }
        size--

        if (getCapacity() / size == 4) {
            reSize(getCapacity() / 2)
        }

        return removeElement
    }


    fun printAll() {
        for (i in 0 until size) {
            print("${data[i]} ")
        }
        println("")
    }
}

fun main() {

    val s = ArrayKt<Int>(10)
    println(s.getCapacity())
    for (i in 0..15) {
        s.add(i, i)
    }
    println(s.getCapacity())
    s.printAll()

}