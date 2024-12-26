import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Перше завдання: імітація отримання даних з бази даних
        CompletableFuture<String> fetchData = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Отримання даних з бази даних...");
                Thread.sleep(2000); // Імітація затримки
                return "Дані з бази даних";
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, executor);

        // Друге завдання: обробка отриманих даних
        CompletableFuture<String> processData = fetchData.thenCompose(data -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Обробка даних: " + data);
            return "Оброблено " + data;
        }, executor));

        // Використання thenCombine для комбінації результатів двох задач
        CompletableFuture<String> combineResult = fetchData.thenCombine(processData, (data, processedData) -> {
            System.out.println("Об'єднання результатів...");
            return data + " | " + processedData;
        });

        // Імітація декількох асинхронних задач
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return "Завдання 1 результат";
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, executor);

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
                return "Завдання 2 результат";
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, executor);

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
                return "Завдання 3 результат";
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, executor);

        // Використання allOf для очікування завершення всіх задач
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.thenRun(() -> {
            try {
                System.out.println("Всі завдання виконанні:");
                System.out.println(task1.get());
                System.out.println(task2.get());
                System.out.println(task3.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }
        });

        // Використання anyOf для завершення при першій готовій задачі
        CompletableFuture<Object> anyTask = CompletableFuture.anyOf(task1, task2, task3);
        anyTask.thenAccept(result -> {
            System.out.println("Результат першого виконаного завдання: " + result);
        });

        // Очікування завершення основних задач
        try {
            System.out.println("Кінцевий об'єднаний результат: " + combineResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Завершення executor
        executor.shutdown();
    }
}