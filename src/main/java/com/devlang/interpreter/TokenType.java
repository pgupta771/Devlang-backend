package com.devlang.interpreter;

public enum TokenType {
    // Single-character tokens
    LEFT_PAREN, RIGHT_PAREN,
    LEFT_BRACE, RIGHT_BRACE,
    PLUS, MINUS, STAR, SLASH,
    SEMICOLON, EQUAL,


    IF, ELSE, WHILE,

    AND,
    OR,
     // For !
     FUN,

    COMMA,
    MODULO,


    // One or two character tokens
    BANG, BANG_EQUAL,
    EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,

    // Literals
    IDENTIFIER, STRING, NUMBER,

    // Keywords
    PRINT, TRUE, FALSE, VAR, NIL, RETURN,
    // End of file
    EOF
}
