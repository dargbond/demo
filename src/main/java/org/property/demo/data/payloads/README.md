`.data.payloads` package contains wrappers for payload used in request.

Current implementation uses business objects to save time.
In real world scenario, I'd want to decouple data model used in APIs from internal business logic.

Instead of defining request/response in code, use Interface Definition Language to define the service model and 
generate code from it. 
