package com.devlang;

import com.devlang.interpreter.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DevLangCompilerApplication {

	public static void main(String[] args) {

		SpringApplication.run(DevLangCompilerApplication.class, args);

		String sourceCode = """
				 
    """;

		Scanner scanner = new Scanner(sourceCode);
		List<Token> tokens = scanner.scanTokens();




		Parser parser = new Parser(tokens);
		List<Stmt> statements = parser.parse();

		Interpreter interpreter = new Interpreter();
		interpreter.interpret(statements);
	}
}