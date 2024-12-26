Цей проєкт демонструє використання класу CompletableFuture у Java для виконання асинхронних завдань. Програма демонструє наступні функції:

Функціональність


  - Отримання даних з бази даних (імітується із затримкою).

  - Обробка отриманих даних асинхронно.

  - Використання thenCompose() для зв'язування залежних завдань.

  - Використання thenCombine() для об'єднання результатів двох завдань.

  - Виконання кількох завдань паралельно за допомогою allOf().

  - Завершення при отриманні результату першого виконаного завдання за допомогою anyOf().

Основні методи

- thenCompose()

- thenCombine()

- allOf()

- anyOf()

Структура проєкту

Робочий процес

Отримання даних з бази даних:

Імітує отримання даних із затримкою.

Обробка даних:

- Обробляє отримані дані асинхронно та створює результат обробки.

Комбінація результатів:

- Об'єднує вихідні та оброблені дані для створення фінального результату.

Паралельне виконання завдань:

- Виконує три незалежні завдання паралельно.

- Очікує завершення всіх завдань за допомогою allOf().

- Отримує результат першого завершеного завдання за допомогою anyOf().

Приклад результату

Отримання даних з бази даних...

Результат першого виконаного завдання: Завдання 1 результат

Всі завдання виконанні:

Завдання 1 результат

Завдання 2 результат

Завдання 3 результат

Обробка даних: Дані з бази даних

Об'єднання результатів...

Кінцевий об'єднаний результат: Дані з бази даних | Оброблено Дані з бази даних

Process finished with exit code 0

Як це працює

Виконання асинхронних завдань

Крок 1: Отримання даних асинхронно за допомогою supplyAsync().

Крок 2: Обробка отриманих даних асинхронно за допомогою thenCompose().

Крок 3: Комбінація результатів кількох завдань за допомогою thenCombine().

Управління паралельними завданнями

Крок 1: Виконання кількох завдань паралельно за допомогою supplyAsync().

Крок 2: Використання allOf() для очікування завершення всіх завдань та отримання їх результатів.

Крок 3: Використання anyOf() для отримання результату першого завершеного завдання.

Фінальний результат

Об'єднує всі результати у зручний для користувача формат.

Реєструє результат першого завершеного завдання та всіх виконаних завдань.