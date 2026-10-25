# Java Coding Best Practices

A short checklist used when reviewing Java pull requests.

## Naming
- Classes, enums and records use `PascalCase` (`BankAccount`, `TransactionType`).
- Methods and variables use `camelCase` (`getBalance`, `openingBalance`).
- Constants use `UPPER_SNAKE_CASE`.
- Names describe intent. Avoid single-letter names except for short loop variables.

## Structure
- One top-level class per file, and the file name matches the class name.
- Every class lives in a package that matches its folder (`com.demo.bank`).
- Keep methods short and focused on a single job.
- Remove unused imports, variables and dead code.

## Encapsulation
- Make fields `private` and expose them through getters only when needed.
- Use `final` for fields and variables that should not change.
- Never return an internal mutable collection. Return an unmodifiable view instead.
- Prefer enums and records over loose strings and plain data holders.

## Validation and Errors
- Validate method arguments early and fail fast with a clear message.
- Throw specific exceptions (`IllegalArgumentException`, custom exceptions), never a bare `Exception` or `RuntimeException`.
- Never swallow exceptions with an empty `catch` block.
- Invalid user input must show a helpful message and must not crash the program.

## Style
- Always use braces `{}` for `if`, `else` and loops, even for one-line bodies.
- Keep formatting consistent: 4-space indentation, one statement per line.
- Add comments only where the code is not self-explanatory.
