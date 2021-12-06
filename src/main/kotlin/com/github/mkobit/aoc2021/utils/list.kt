package com.github.mkobit.aoc2021.utils

fun <E> List<E>.update(index: Int, operation: (previous: E) -> E): List<E> =
    take(index) + operation(get(index)) + drop(index + 1)