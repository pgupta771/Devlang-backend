package com.devlang.interpreter;

public class Return extends RuntimeException {
    final Object value;

    public Return(Object value) {
        super(null, null, false, false); // disables stack trace
        this.value = value;
    }
}
