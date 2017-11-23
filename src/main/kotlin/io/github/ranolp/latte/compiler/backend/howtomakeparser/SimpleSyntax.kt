package io.github.ranolp.latte.compiler.backend.howtomakeparser

import io.github.ranolp.latte.compiler.backend.core.ast.Node
import io.github.ranolp.latte.compiler.core.Token
import io.github.ranolp.latte.compiler.core.TokenType

class SimpleSyntax(val tokenType: TokenType) : SyntaxPart<SimpleSyntax> {
    override var mapping: ((List<Token>) -> Node?)? = null
    override var name: String = "Unnamed"
    override val self by lazy {
        SimpleSyntax(tokenType).also {
            it.mapping = mapping
            it.name = name
            it.flag = flag
        }
    }
    override var flag = 0
    override fun debug(): String = "$tokenType$flagToString" + if (mapping != null) " → $name" else ""

    override fun plus(syntaxPart: SyntaxPart<*>): Syntax = Syntax(this, syntaxPart)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SimpleSyntax) return false

        return tokenType == other.tokenType && flag == other.flag
    }

    override fun hashCode(): Int = 31 * tokenType.hashCode() + flag
}