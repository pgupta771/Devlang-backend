package com.devlang.interpreter;

import java.util.List;

public interface DevLangCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}

