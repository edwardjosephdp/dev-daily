package com.edwardjdp.common

interface Mapper<I, O> {

    fun from(i: I): O

    fun fromList(list: List<I>?): List<O> {
        return list?.mapNotNull { from(it) } ?: listOf()
    }
}
