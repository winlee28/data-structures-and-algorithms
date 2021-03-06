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

    fun isEmpty(): Boolean {
        return size == 0
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

        if (index < 0 || index >= size) {
            throw java.lang.IllegalArgumentException("get fail. index must  >= 0 ||  < size")
        }

        return data[index]
    }

    fun set(index: Int, e: E) {

        if (index < 0 || index >= size) {
            throw java.lang.IllegalArgumentException("set fail. index must  >= 0 ||  < size")
        }

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

    fun removeFirst(): E {
        return remove(0)
    }

    fun removeLast(): E {
        return remove(size - 1)
    }

    fun remove(index: Int): E {

        if (index < 0 || index >= size) {
            throw java.lang.IllegalArgumentException("remove fail. index must  >= 0 ||  < size")
        }

        val e = get(index)

        for (i in index + 1 until size) {
            data[i - 1] = data[i]
        }
        size--

        if (size > 0 && getCapacity() / size == 4) {
            reSize(getCapacity() / 2)
        }

        return e
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