package com.devlang.interpreter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow frontend to call this
public class DevLangController {

    private final Interpreter interpreter = new Interpreter();

    @PostMapping("/execute")
    public ResponseEntity<?> execute(@RequestBody CodeRequest request) {
        try {
            Scanner scanner = new Scanner(request.getCode());
            List<Token> tokens = scanner.scanTokens();

            Parser parser = new Parser(tokens);
            List<Stmt> statements = parser.parse();

            Devlang.output = new StringBuilder(); // Reset output
            interpreter.interpret(statements);

            return ResponseEntity.ok(new CodeResponse(Devlang.output.toString()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CodeResponse("Error: " + e.getMessage()));
        }
    }
}
