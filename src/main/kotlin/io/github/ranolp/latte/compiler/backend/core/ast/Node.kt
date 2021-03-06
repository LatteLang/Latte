package io.github.ranolp.latte.compiler.backend.core.ast

import io.github.ranolp.latte.compiler.backend.times
import io.github.ranolp.latte.compiler.core.Token

abstract class Node(val name: String, val token: Token) {
    internal open fun debug(depth: Int = 0): String = " " * depth + name + ": " + token.data

    internal fun String?.map(default: String = "", map: (String) -> String): String = if(this != null) map(this) else default
}