import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModernJavaDemo {

    public static void main(String[] args) {
        SpringApplication.run(ModernJavaDemo.class, args);

        // Exemplo de Lambda Expressions
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        List<String> namesStartingWithC = names.stream()
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println("Names starting with C: " + namesStartingWithC);

        // Exemplo de Streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Exemplo de Optional
        String nullableString = null;
        String result = java.util.Optional.ofNullable(nullableString).orElse("Default Value");
        System.out.println("Result with Optional: " + result);

        // Exemplo de Data API
        java.time.LocalDate date = java.time.LocalDate.now();
        System.out.println("Current date: " + date);

        // Exemplo de varargs (rest)
        printNumbers(1, 2, 3, 4, 5);

        // Exemplo de CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello, World!";
        });

        CompletableFuture<String> combinedFuture = future.thenApply(msg -> msg + " Welcome to Java!");
        try {
            System.out.println("Async result: " + combinedFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Função para exemplo de varargs
    public static void printNumbers(int... numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    @RestController
    public static class AjaxController {
        @GetMapping("/api/message")
        public String getMessage() {
            return "Hello from the server!";
        }
    }
}
