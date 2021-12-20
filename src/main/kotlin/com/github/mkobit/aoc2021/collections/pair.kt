package com.github.mkobit.aoc2021.collections

fun <T, U> Pair<T, U>.reverse(): Pair<U, T> = second to first