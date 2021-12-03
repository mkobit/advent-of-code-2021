package com.github.mkobit.aoc2021

import com.google.common.io.Resources
import java.nio.charset.StandardCharsets

fun resourceText(resourcePath: String): String =
    Resources.toString(Resources.getResource(resourcePath), StandardCharsets.UTF_8)
