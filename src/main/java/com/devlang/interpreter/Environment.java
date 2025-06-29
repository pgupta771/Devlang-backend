package com.devlang.interpreter;

import java.util.HashMap;
import java.util.Map;

class Environment {
    private final Map<String, Object> values = new HashMap<>();
    final Environment enclosing;

    // Constructor for global scope (no enclosing environment)
    Environment() {
        enclosing = null;
    }

    // Constructor for nested scope
    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    // Define a new variable
    void define(String name, Object value) {
        values.put(name, value);
    }

    // Get the value of a variable (searches enclosing environments too)
    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        if (enclosing != null) return enclosing.get(name);

        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    // Assign a value to an existing variable (searches outer scopes too)
    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            return;
        }

        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }
}
