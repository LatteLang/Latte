package io.github.ranolp.latte.compiler.backend.howtomakeparser

import io.github.ranolp.latte.compiler.backend.core.ast.Node
import io.github.ranolp.latte.compiler.core.Token

class Syntax(val parts: List<SyntaxPart<*>>) : SyntaxPart<Syntax> {
    override var mapping: ((List<Token>) -> Node?)? = null
    override val self = this
    override var flag = 0

    constructor(left: SyntaxPart<*>, right: SyntaxPart<*>) : this(if (right is Syntax) {
        listOf(left) + right.parts
    } else listOf(left, right))


    override fun debug(): String = parts.joinToString(" ") { it.debug() }

    override fun plus(syntaxPart: SyntaxPart<*>): Syntax = Syntax(
            parts + syntaxPart)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Syntax) return false

        return parts == other.parts && flag == other.flag
    }

    override fun hashCode(): Int = 31 * parts.hashCode() + flag
}