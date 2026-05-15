# 📘 Модуль 2. Java Core — полный гайд

> Цель модуля: после прохождения ты владеешь Java на уровне, нужном для junior-собеседования. Знаешь синтаксис, ООП, коллекции, лямбды, исключения, многопоточность.

**Время прохождения:** 8–10 недель при 2–3 часах в день.

**Подготовка:** ты должен уже иметь установленный JDK 21 и IntelliJ IDEA Community.

---

# Содержание

## Часть I. Основы языка
1. [Hello World и анатомия Java-программы](#1-hello-world-и-анатомия-java-программы)
2. [Переменные и примитивные типы](#2-переменные-и-примитивные-типы)
3. [Ссылочные типы и null](#3-ссылочные-типы-и-null)
4. [Преобразования типов](#4-преобразования-типов)
5. [Операторы](#5-операторы)
6. [Условные конструкции](#6-условные-конструкции)
7. [Циклы](#7-циклы)
8. [Массивы](#8-массивы)
9. [Ввод данных (Scanner)](#9-ввод-данных-scanner)

## Часть II. Методы
10. [Методы](#10-методы)
11. [Рекурсия](#11-рекурсия)

## Часть III. Строки
12. [String — основы и String Pool](#12-string--основы-и-string-pool)
13. [Методы String](#13-методы-string)
14. [StringBuilder и StringBuffer](#14-stringbuilder-и-stringbuffer)
15. [Форматирование и Text Blocks](#15-форматирование-и-text-blocks)

## Часть IV. ООП
16. [Классы и объекты](#16-классы-и-объекты)
17. [Конструкторы](#17-конструкторы)
18. [Инкапсуляция](#18-инкапсуляция)
19. [Наследование](#19-наследование)
20. [Полиморфизм](#20-полиморфизм)
21. [Абстрактные классы](#21-абстрактные-классы)
22. [Интерфейсы](#22-интерфейсы)
23. [Вложенные классы](#23-вложенные-классы)

## Часть V. Модификаторы и Object
24. [Модификаторы доступа, static, final](#24-модификаторы-доступа-static-final)
25. [Пакеты и импорты](#25-пакеты-и-импорты)
26. [Класс Object: equals, hashCode, toString](#26-класс-object-equals-hashcode-tostring)
27. [Enum](#27-enum)
28. [Record (Java 14+)](#28-record-java-14)

## Часть VI. Исключения и Generics
29. [Исключения](#29-исключения)
30. [Generics](#30-generics)

## Часть VII. Collections Framework
31. [Обзор и Iterable](#31-обзор-и-iterable)
32. [List: ArrayList и LinkedList](#32-list-arraylist-и-linkedlist)
33. [Set: HashSet, TreeSet, LinkedHashSet](#33-set-hashset-treeset-linkedhashset)
34. [Map: HashMap, TreeMap, LinkedHashMap](#34-map-hashmap-treemap-linkedhashmap)
35. [Queue, Deque, Stack](#35-queue-deque-stack)
36. [Comparator и сортировка](#36-comparator-и-сортировка)
37. [Как работает HashMap внутри](#37-как-работает-hashmap-внутри)

## Часть VIII. Функциональное программирование
38. [Лямбды и функциональные интерфейсы](#38-лямбды-и-функциональные-интерфейсы)
39. [Method references](#39-method-references)
40. [Stream API](#40-stream-api)
41. [Collectors](#41-collectors)
42. [Optional](#42-optional)

## Часть IX. Многопоточность
43. [Threads и Runnable](#43-threads-и-runnable)
44. [Проблемы конкурентности](#44-проблемы-конкурентности)
45. [synchronized и volatile](#45-synchronized-и-volatile)
46. [Atomic классы и Concurrent коллекции](#46-atomic-классы-и-concurrent-коллекции)
47. [ExecutorService](#47-executorservice)

## Часть X. Дополнительно
48. [Date/Time API](#48-datetime-api)
49. [JVM в общих чертах](#49-jvm-в-общих-чертах)
50. [Современные фичи Java (var, switch expression, pattern matching)](#50-современные-фичи-java)

## Mini-проекты
- [Mini-проект 1: Калькулятор зарплат](#mini-проект-1-калькулятор-зарплат)
- [Mini-проект 2: Банковская симуляция](#mini-проект-2-банковская-симуляция)
- [Mini-проект 3: Phone Book с файлом](#mini-проект-3-phone-book-с-файлом)

[Чек-лист готовности](#чек-лист-готовности)

---

# Часть I. Основы языка

# 1. Hello World и анатомия Java-программы

## 1.1 Первая программа

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

Что здесь:

| Конструкция | Что значит |
|---|---|
| `public class HelloWorld` | объявление публичного класса с именем `HelloWorld` |
| `{ ... }` | тело класса в фигурных скобках |
| `public static void main(String[] args)` | главный метод, точка входа в программу |
| `System.out.println(...)` | вывод в консоль с переводом строки |
| `;` в конце | каждое выражение завершается точкой с запятой |

⚠️ **Имя файла должно совпадать с именем публичного класса.** `HelloWorld.java` — правильно. `hello-world.java` — ошибка.

## 1.2 Как Java исполняет код

```
.java (исходник) ──[javac]──▶ .class (байт-код) ──[JVM]──▶ выполнение
```

- **`javac`** (compiler) — компилирует исходник в байт-код.
- **`java`** (JVM) — запускает байт-код. JVM есть для разных ОС, поэтому один `.class` работает везде.

Это даёт известный лозунг "Write Once, Run Anywhere".

```bash
# Из терминала
javac HelloWorld.java       # создастся HelloWorld.class
java HelloWorld             # запуск (без расширения)
```

В IDEA это всё делается одним нажатием Shift+F10.

## 1.3 main как точка входа

```java
public static void main(String[] args)
```

- `public` — JVM должна иметь доступ снаружи класса.
- `static` — метод можно вызвать без создания объекта класса.
- `void` — ничего не возвращает.
- `main` — фиксированное имя, которое JVM ищет.
- `String[] args` — массив аргументов командной строки.

Аргументы ты получаешь, если запускаешь:
```bash
java HelloWorld arg1 arg2
```
Тогда `args = ["arg1", "arg2"]`.

## 1.4 Комментарии

```java
// Однострочный комментарий

/*
 * Многострочный
 * комментарий
 */

/**
 * Javadoc — для документации классов и методов.
 * Используется автоматически IDE и инструментами.
 *
 * @param name имя пользователя
 * @return приветствие
 */
public String greet(String name) {
    return "Hello, " + name;
}
```

## Упражнение 1

1. Создай класс `Greeter` с методом main.
2. Программа должна выводить три строки: своё имя, город, год.
3. Программа должна также напечатать первый аргумент командной строки, если он есть, иначе — "no argument".

**Решение:**

```java
public class Greeter {
    public static void main(String[] args) {
        System.out.println("Aibek");
        System.out.println("Almaty");
        System.out.println("2026");

        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("no argument");
        }
    }
}
```

В IDEA для передачи аргументов: Run → Edit Configurations → Program arguments.

---

# 2. Переменные и примитивные типы

## 2.1 Объявление переменной

Переменная — именованная ячейка памяти. В Java она ВСЕГДА имеет тип, и тип нельзя менять.

```java
int age;              // объявление
age = 25;             // присваивание

int year = 2026;      // объявление + присваивание
final int PI_INT = 3; // final = константа, нельзя переприсвоить
```

⚠️ Java — **строго типизированный** язык. `int x = "hello"` не скомпилируется.

## 2.2 8 примитивных типов

| Тип | Размер | Диапазон | Default | Литерал |
|---|---|---|---|---|
| `byte` | 8 бит | -128 .. 127 | 0 | `byte b = 100;` |
| `short` | 16 бит | -32 768 .. 32 767 | 0 | `short s = 1000;` |
| `int` | 32 бит | ≈ ±2.1 млрд | 0 | `int i = 100_000;` |
| `long` | 64 бит | ≈ ±9.2 квинтиллиона | 0L | `long l = 100L;` |
| `float` | 32 бит | ≈ 7 знаков | 0.0f | `float f = 3.14f;` |
| `double` | 64 бит | ≈ 15 знаков | 0.0 | `double d = 3.14;` |
| `char` | 16 бит | 0 .. 65 535 (Unicode) | '\u0000' | `char c = 'A';` |
| `boolean` | 1 бит* | true / false | false | `boolean b = true;` |

*реально занимает больше из-за выравнивания памяти, это не страшно.

### Целочисленные литералы

```java
int decimal = 42;
int hex = 0xFF;             // шестнадцатеричный (= 255)
int octal = 010;            // восьмеричный (= 8)
int binary = 0b1010;        // двоичный (= 10)

int big = 1_000_000;        // подчёркивания для читаемости
long population = 8_000_000_000L;   // L обязателен для long, иначе int overflow
```

### Дробные литералы

```java
double pi = 3.14159;        // double по умолчанию
float pi2 = 3.14f;          // f обязателен для float
double sci = 6.022e23;      // экспоненциальная запись
```

### char

```java
char letter = 'A';
char digit = '7';
char unicode = '\u0410';    // 'А' кириллическая
char newline = '\n';        // escape-последовательность

// char это число!
int code = 'A';             // 65
char c = (char) 66;         // 'B'
```

Escape-последовательности:
```
\n   — newline
\t   — tab
\r   — carriage return
\\   — обратный слеш
\'   — апостроф
\"   — кавычка
\u0410 — Unicode-символ
```

### boolean

```java
boolean isReady = true;
boolean isDone = false;

// В отличие от C/Python, нельзя:
// boolean b = 1;           // ❌ ошибка компиляции
// if (1) { ... }           // ❌
```

Только `true` и `false`.

## 2.3 Underflow и overflow

Если результат не помещается в тип — возникает переполнение, **без ошибки**:

```java
int max = Integer.MAX_VALUE;        // 2147483647
int overflow = max + 1;              // -2147483648 (!)

byte b = 127;
b++;                                 // -128
```

Чтобы избежать — используй больший тип или `Math.addExact()` (бросает исключение):

```java
long bigResult = (long) a + b;
int safe = Math.addExact(a, b);     // ArithmeticException при overflow
```

## 2.4 Точность дробных чисел

⚠️ `double` и `float` **не точны** для дробей:

```java
System.out.println(0.1 + 0.2);   // 0.30000000000000004
```

Это особенность IEEE 754 (стандарт двоичных дробных). Для денег **никогда не используй double** — используй `BigDecimal`:

```java
import java.math.BigDecimal;

BigDecimal a = new BigDecimal("0.1");    // обязательно через String!
BigDecimal b = new BigDecimal("0.2");
System.out.println(a.add(b));            // 0.3
```

## 2.5 Имена переменных

Правила:
- Начинается с буквы, `_` или `$`.
- Дальше — буквы, цифры, `_`, `$`.
- Регистр имеет значение: `age` ≠ `Age`.
- Нельзя использовать ключевые слова: `class`, `int`, `for`, `if`, ...

Конвенции:
- `camelCase` для переменных и методов: `userName`, `calculateTotal`.
- `PascalCase` для классов: `UserService`, `OrderRepository`.
- `UPPER_SNAKE_CASE` для констант: `MAX_SIZE`, `PI`.
- Имена должны быть осмысленными: `age`, не `a`. `userCount`, не `uc`.

## 2.6 var (Java 10+)

Можно опустить тип, если он понятен из контекста:

```java
var name = "Aibek";              // String
var age = 25;                    // int
var price = 99.99;               // double
var list = new ArrayList<String>();  // ArrayList<String>
```

⚠️ `var`:
- **Только для локальных переменных** (внутри методов).
- **Не для полей класса**, не для параметров методов.
- Тип всё ещё статический, его просто выводит компилятор.

```java
var x;        // ❌ ошибка — нечего вывести
var y = null; // ❌ ошибка — null можно присвоить любому типу
```

## Упражнения 2

### Задача 2.1
Объяви все 8 примитивов с любыми значениями. Выведи их все одной строкой через `+`.

### Задача 2.2
Программа считает площадь круга. Радиус — захардкоди 5.0. Используй `Math.PI`.

### Задача 2.3
Что выведет программа:
```java
int a = 10;
int b = 3;
System.out.println(a / b);
System.out.println(a % b);
System.out.println((double) a / b);
```

### Задача 2.4
Программа выводит средний возраст трёх человек (числа захардкоди), результат — с десятичной точкой.

### Решения

```java
// 2.1
public class AllTypes {
    public static void main(String[] args) {
        byte b = 1; short s = 2; int i = 3; long l = 4L;
        float f = 5.5f; double d = 6.6; char c = 'A'; boolean bool = true;
        System.out.println(b + " " + s + " " + i + " " + l + " " +
                f + " " + d + " " + c + " " + bool);
    }
}

// 2.2
double radius = 5.0;
double area = Math.PI * radius * radius;
System.out.println("Area: " + area);

// 2.3
// Вывод:
// 3            (целочисленное деление)
// 1            (остаток)
// 3.3333333333333335

// 2.4
int age1 = 20, age2 = 25, age3 = 30;
double avg = (age1 + age2 + age3) / 3.0;        // важно 3.0!
System.out.println("Average: " + avg);
```

---

# 3. Ссылочные типы и null

## 3.1 Чем ссылочные отличаются от примитивов

```java
int n = 5;                  // переменная содержит само значение 5
String name = "Aibek";      // переменная содержит ССЫЛКУ на объект "Aibek"
```

Графически:

```
Стек (stack):              Куча (heap):
┌─────────┐                ┌─────────────┐
│ n  = 5  │                │             │
│ name ───┼────────────────▶│  "Aibek"   │
└─────────┘                └─────────────┘
```

- Примитивы лежат прямо в стеке.
- Объекты создаются в куче. В переменной — только ссылка (адрес).

## 3.2 null

Ссылочная переменная может быть `null` — "ни на что не указывает":

```java
String name = null;
System.out.println(name);          // null
System.out.println(name.length()); // ⚠️ NullPointerException (NPE)!
```

**NPE** — самое частое исключение в Java. Возникает, когда вызываешь метод/поле у `null`.

⚠️ Примитивы НЕ могут быть null:
```java
int n = null;     // ❌ ошибка компиляции
```

## 3.3 Wrappers — обёртки над примитивами

Для каждого примитива есть класс-обёртка:

| Примитив | Обёртка |
|---|---|
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

Зачем они нужны:
- В коллекции (List, Map) можно складывать только объекты, не примитивы.
- Wrapper может быть `null`.
- У них есть полезные методы.

```java
Integer i = 42;            // Autoboxing — int → Integer автоматически
int j = i;                 // Unboxing — Integer → int

List<Integer> list = new ArrayList<>();   // только Integer, не int
list.add(5);                // autoboxing

// Полезные методы
int max = Integer.MAX_VALUE;           // 2147483647
int parsed = Integer.parseInt("42");   // String → int
String hex = Integer.toHexString(255); // "ff"
```

⚠️ Осторожно с unboxing'ом null:
```java
Integer x = null;
int y = x;          // NullPointerException!
```

## 3.4 Сравнение ссылочных типов

`==` сравнивает **ссылки** (один и тот же объект?), не содержимое.

```java
String a = new String("hello");
String b = new String("hello");
System.out.println(a == b);          // false — разные объекты в куче
System.out.println(a.equals(b));     // true — содержимое одинаковое
```

**Правило:** для проверки равенства ссылочных типов всегда используй `.equals()`.

Исключение — `==` имеет смысл для проверки "это один и тот же объект", или для сравнения примитивов и `enum`.

## 3.5 String pool — зачем `==` иногда даёт true

```java
String a = "hello";          // литерал — берётся из String Pool
String b = "hello";          // тот же литерал — та же ссылка
System.out.println(a == b);  // true (!)
```

Java оптимизирует строковые литералы: одинаковые помещаются в общий пул. Но это деталь реализации, на которую **нельзя полагаться**. Всегда `equals`.

```java
String c = new String("hello");   // явный new — новый объект
System.out.println(a == c);       // false
```

---

# 4. Преобразования типов

## 4.1 Расширяющее преобразование (widening) — автоматически

Когда меньший тип помещается в больший:

```java
int i = 100;
long l = i;           // int → long автоматически
double d = l;         // long → double автоматически
```

Иерархия: `byte → short → int → long → float → double`

`char → int` — тоже автоматически (`char` — это, по сути, число).

## 4.2 Сужающее преобразование (narrowing) — явный cast

Когда больший тип нужно "втиснуть" в меньший:

```java
double d = 9.99;
int i = (int) d;          // 9 (отбрасывает дробную часть, не округляет!)

long l = 5_000_000_000L;
int j = (int) l;          // получим какую-то ерунду — overflow

byte b = (byte) 200;       // -56 (overflow)
```

⚠️ Cast может потерять данные. Java заставляет тебя писать `(int)` явно, чтобы ты осознанно делал это.

Округление вместо отбрасывания:
```java
int rounded = (int) Math.round(9.6);   // 10
```

## 4.3 Преобразование к строке и обратно

```java
// → String
String s1 = String.valueOf(42);        // "42"
String s2 = Integer.toString(42);      // "42"
String s3 = "" + 42;                    // "42" — но не идиоматично

// String →
int i = Integer.parseInt("42");
double d = Double.parseDouble("3.14");
boolean b = Boolean.parseBoolean("true");

// Если строка некорректна — NumberFormatException:
int bad = Integer.parseInt("abc");      // ⚠️ NumberFormatException
```

## Упражнения 3-4

### Задача
Программа принимает 3 строки в массиве `args`: имя, возраст, рост. Выведи приветствие в формате:
```
Hello, Aibek! You are 25 years old, your height is 1.78m.
```

Если аргументов не хватает или они некорректны — выведи "Invalid arguments".

### Решение

```java
public class GreetingApp {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Invalid arguments");
            return;
        }
        try {
            String name = args[0];
            int age = Integer.parseInt(args[1]);
            double height = Double.parseDouble(args[2]);
            System.out.println("Hello, " + name + "! You are " + age +
                    " years old, your height is " + height + "m.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid arguments");
        }
    }
}
```

---

# 5. Операторы

## 5.1 Арифметические

```java
int a = 10, b = 3;
System.out.println(a + b);    // 13
System.out.println(a - b);    // 7
System.out.println(a * b);    // 30
System.out.println(a / b);    // 3   ← целочисленное!
System.out.println(a % b);    // 1   ← остаток
System.out.println((double) a / b);  // 3.333...
```

### Инкремент и декремент

```java
int i = 5;
int x = i++;     // постфикс: x = 5, потом i = 6
int y = ++i;     // префикс: i = 7, потом y = 7
```

На собесе любят такое:
```java
int i = 5;
int result = i++ + ++i;        // ???
// Шаг 1: i++ возвращает 5, i становится 6
// Шаг 2: ++i делает i = 7, возвращает 7
// result = 5 + 7 = 12
// итого: i = 7, result = 12
```

⚠️ В реальном коде такие конструкции — зло. Не пиши.

## 5.2 Присваивание

```java
int x = 10;
x += 5;        // x = x + 5 → 15
x -= 3;        // 12
x *= 2;        // 24
x /= 4;        // 6
x %= 4;        // 2
```

## 5.3 Сравнение

```java
==   равно
!=   не равно
<    меньше
>    больше
<=   меньше или равно
>=   больше или равно
```

Возвращают `boolean`.

```java
int a = 5;
boolean isPositive = a > 0;          // true
boolean isEqual = (a == 5);           // true
```

⚠️ Для строк и других объектов — не `==`, а `.equals()`.

## 5.4 Логические

```java
&&   AND (короткое замыкание)
||   OR (короткое замыкание)
!    NOT
&    AND (без короткого замыкания)
|    OR (без короткого замыкания)
^    XOR
```

**Короткое замыкание (short-circuit):**
```java
String s = null;
if (s != null && s.length() > 0) {     // если s == null, второе НЕ вычисляется
    System.out.println(s);
}
```

Если бы было `&` вместо `&&`, второе условие выполнилось бы и упало с NPE.

## 5.5 Битовые

```java
&    битовое AND
|    битовое OR
^    битовое XOR
~    битовое NOT
<<   сдвиг влево
>>   сдвиг вправо со знаком
>>>  сдвиг вправо без знака
```

Используются редко (флаги, оптимизации). Запоминать не обязательно — гугл по ситуации.

## 5.6 Тернарный оператор

```java
String result = (age >= 18) ? "adult" : "minor";
int max = (a > b) ? a : b;
```

Удобно для коротких выражений, но не злоупотребляй — для сложной логики используй `if`.

## 5.7 Приоритеты

Простое правило: используй скобки, если сомневаешься. Никто не помнит порядок наизусть.

```java
boolean result = a > 0 && b > 0 || c < 0;
// Лучше:
boolean result = (a > 0 && b > 0) || c < 0;
```

## Упражнения 5

### Задача 5.1
Дан возраст человека. Программа выводит:
- "child" если < 13
- "teen" если 13–17
- "adult" если 18–64
- "senior" если ≥ 65

Через тернарный оператор (одно выражение).

### Задача 5.2
Дан год. Определи, високосный ли он.
Правило: год високосный, если делится на 4, но не делится на 100, **или** делится на 400.

### Задача 5.3
Что выведет код?
```java
int a = 10, b = 5;
boolean result = (a > 5) && (b++ > 3);
System.out.println(b);

int c = 10, d = 5;
boolean result2 = (c > 100) && (d++ > 3);
System.out.println(d);
```

### Решения

```java
// 5.1
int age = 25;
String category = age < 13 ? "child"
                : age < 18 ? "teen"
                : age < 65 ? "adult"
                : "senior";
System.out.println(category);

// 5.2
int year = 2024;
boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
System.out.println(leap);   // true

// 5.3
// Первое: a > 5 = true, поэтому b++ выполняется → b = 6
//   Печатает: 6
// Второе: c > 100 = false, второе условие НЕ выполняется → d остаётся 5
//   Печатает: 5
```

---

# 6. Условные конструкции

## 6.1 if / else if / else

```java
int score = 75;

if (score >= 90) {
    System.out.println("A");
} else if (score >= 75) {
    System.out.println("B");
} else if (score >= 60) {
    System.out.println("C");
} else {
    System.out.println("F");
}
```

⚠️ Всегда пиши блок `{}`, даже для одной строки. Без него легко ошибиться:

```java
// ПЛОХО
if (x > 0)
    System.out.println("positive");
    System.out.println("here");      // выполнится ВСЕГДА, не зависит от if!

// ХОРОШО
if (x > 0) {
    System.out.println("positive");
    System.out.println("here");
}
```

## 6.2 switch (классический)

```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
    case 4:
    case 5:
        System.out.println("Midweek");
        break;
    default:
        System.out.println("Weekend");
}
```

⚠️ **Без `break` будет fall-through** — выполнение продолжится на следующий case:

```java
int x = 1;
switch (x) {
    case 1: System.out.println("one");      // выполнится
    case 2: System.out.println("two");      // выполнится тоже!
    case 3: System.out.println("three");    // и это!
}
```

Это часто становится источником багов. **Современный switch (Java 14+) не имеет этой проблемы** (см. ниже).

## 6.3 switch expression (Java 14+) — современный

```java
String name = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3, 4, 5 -> "Midweek";       // несколько значений
    default -> "Weekend";
};
System.out.println(name);
```

Преимущества:
- Возвращает значение (можно присвоить переменной).
- Нет fall-through.
- Компилятор требует покрыть все случаи (или иметь default).

С блоком и `yield`:
```java
String result = switch (day) {
    case 1, 2, 3, 4, 5 -> "weekday";
    case 6, 7 -> {
        System.out.println("It's weekend!");
        yield "weekend";              // yield — возврат значения из блока
    }
    default -> throw new IllegalArgumentException("Invalid day: " + day);
};
```

Switch может работать со строками, числами, `enum`, и (с Java 21) с **pattern matching**:

```java
Object obj = "hello";
String description = switch (obj) {
    case Integer i -> "int: " + i;
    case String s -> "string of length " + s.length();
    case null -> "null";
    default -> "unknown";
};
```

## Упражнения 6

### Задача 6.1
Калькулятор: программа принимает 2 числа и оператор (`+`, `-`, `*`, `/`), выводит результат. Используй switch expression.

### Задача 6.2
По дню недели (1–7) выведи "weekday" или "weekend". Через switch expression.

### Задача 6.3
Задача FizzBuzz: вывести числа от 1 до 100. Числа кратные 3 заменить на "Fizz", кратные 5 — на "Buzz", кратные обоим — на "FizzBuzz".

### Решения

```java
// 6.1
double a = 10, b = 3;
char op = '+';
double result = switch (op) {
    case '+' -> a + b;
    case '-' -> a - b;
    case '*' -> a * b;
    case '/' -> {
        if (b == 0) throw new ArithmeticException("Division by zero");
        yield a / b;
    }
    default -> throw new IllegalArgumentException("Unknown operator: " + op);
};
System.out.println(result);

// 6.2
int day = 6;
String type = switch (day) {
    case 1, 2, 3, 4, 5 -> "weekday";
    case 6, 7 -> "weekend";
    default -> "invalid";
};

// 6.3
for (int i = 1; i <= 100; i++) {
    if (i % 15 == 0) System.out.println("FizzBuzz");
    else if (i % 3 == 0) System.out.println("Fizz");
    else if (i % 5 == 0) System.out.println("Buzz");
    else System.out.println(i);
}
```

---

# 7. Циклы

## 7.1 for

Самый частый цикл:

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

Структура:
```
for (инициализация; условие; шаг) {
    тело
}
```

- Инициализация выполняется один раз в начале.
- Условие проверяется перед каждой итерацией. Если false — цикл завершается.
- Шаг выполняется после каждой итерации.

Можно опускать части:
```java
for (;;) {  // бесконечный цикл
    if (someCondition) break;
}
```

## 7.2 while

```java
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}
```

Используй, когда количество итераций заранее неизвестно:

```java
Scanner sc = new Scanner(System.in);
String line;
while (!(line = sc.nextLine()).equals("quit")) {
    System.out.println("Echo: " + line);
}
```

## 7.3 do-while

Выполняется хотя бы один раз:

```java
int n;
do {
    n = readUserInput();   // как минимум один раз спросим
} while (n < 0);
```

## 7.4 for-each (enhanced for)

Для коллекций и массивов:

```java
int[] nums = {1, 2, 3, 4, 5};
for (int n : nums) {
    System.out.println(n);
}

List<String> names = List.of("Aibek", "Madi", "Aiman");
for (String name : names) {
    System.out.println(name);
}
```

⚠️ Без индекса. Если нужен — используй классический `for`.

## 7.5 break и continue

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;          // выйти из цикла
    if (i % 2 == 0) continue;   // перейти к следующей итерации
    System.out.println(i);       // печатает только нечётные < 5: 1, 3
}
```

### Метки (labels) для вложенных циклов

```java
outer:
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        if (i * j > 50) {
            break outer;     // выйти из ВНЕШНЕГО цикла
        }
    }
}
```

⚠️ Используй метки редко — они ухудшают читаемость. Часто лучше вынести в отдельный метод.

## Упражнения 7

### Задача 7.1
Сумма чисел от 1 до 100 (== 5050).

### Задача 7.2
Факториал N через цикл.

### Задача 7.3
Найти все простые числа от 2 до 100.
Простое число — делится только на 1 и на себя.

### Задача 7.4
Печать таблицы умножения (от 1×1 до 10×10).

### Задача 7.5
Числа Фибоначчи: 1, 1, 2, 3, 5, 8, 13... Вывести первые 20.

### Решения

```java
// 7.1
int sum = 0;
for (int i = 1; i <= 100; i++) sum += i;
System.out.println(sum);

// 7.2
int n = 10;
long fact = 1;
for (int i = 1; i <= n; i++) fact *= i;
System.out.println(fact);   // 3628800

// 7.3
for (int n = 2; n <= 100; n++) {
    boolean isPrime = true;
    for (int d = 2; d * d <= n; d++) {     // оптимизация: до √n
        if (n % d == 0) {
            isPrime = false;
            break;
        }
    }
    if (isPrime) System.out.println(n);
}

// 7.4
for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {
        System.out.printf("%4d", i * j);
    }
    System.out.println();
}

// 7.5
int a = 1, b = 1;
System.out.print(a + " " + b);
for (int i = 0; i < 18; i++) {
    int next = a + b;
    System.out.print(" " + next);
    a = b;
    b = next;
}
```

---

# 8. Массивы

Массив — фиксированной длины упорядоченная коллекция элементов одного типа.

## 8.1 Создание

```java
// Способ 1: создать пустой массив
int[] nums = new int[5];               // массив из 5 элементов, все 0
String[] names = new String[3];        // 3 элемента, все null

// Способ 2: с литералом
int[] primes = {2, 3, 5, 7, 11};
String[] cities = {"Almaty", "Astana", "Shymkent"};

// Способ 3: явно
int[] arr = new int[]{1, 2, 3};
```

## 8.2 Доступ

```java
int[] nums = {10, 20, 30, 40, 50};

System.out.println(nums[0]);    // 10
System.out.println(nums[4]);    // 50
nums[2] = 99;                    // изменение
System.out.println(nums.length); // 5

// Выход за границы
System.out.println(nums[10]);   // ⚠️ ArrayIndexOutOfBoundsException
```

Индексы — от 0 до `length - 1`.

## 8.3 Перебор

```java
int[] nums = {10, 20, 30};

// Классический for (нужен индекс)
for (int i = 0; i < nums.length; i++) {
    System.out.println(i + ": " + nums[i]);
}

// for-each (индекс не нужен)
for (int n : nums) {
    System.out.println(n);
}

// Через Arrays
System.out.println(Arrays.toString(nums));    // [10, 20, 30]
```

## 8.4 Многомерные массивы

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matrix[1][2]);    // 6 (вторая строка, третий столбец)
System.out.println(matrix.length);   // 3 — кол-во строк
System.out.println(matrix[0].length);// 3 — кол-во столбцов в первой строке

// Перебор
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

Массив массивов — каждая строка может быть разной длины:
```java
int[][] jagged = new int[3][];
jagged[0] = new int[]{1, 2};
jagged[1] = new int[]{3, 4, 5, 6};
jagged[2] = new int[]{7};
```

## 8.5 Класс Arrays

Утилита со множеством полезных методов:

```java
import java.util.Arrays;

int[] arr = {5, 2, 8, 1, 9};

Arrays.sort(arr);                    // [1, 2, 5, 8, 9]
System.out.println(Arrays.toString(arr));

int[] copy = Arrays.copyOf(arr, 3);          // [1, 2, 5] — первые 3
int[] slice = Arrays.copyOfRange(arr, 1, 4); // [2, 5, 8] — индексы 1..3

int[] filled = new int[5];
Arrays.fill(filled, 7);              // [7, 7, 7, 7, 7]

int idx = Arrays.binarySearch(arr, 5);   // 2 (только для отсортированного!)

int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
System.out.println(a == b);                  // false
System.out.println(Arrays.equals(a, b));     // true

List<Integer> list = Arrays.asList(1, 2, 3);     // вернёт List
                                                  // ⚠️ фиксированный размер!
```

## 8.6 Копирование массива

```java
int[] original = {1, 2, 3};
int[] copy1 = original;          // ⚠️ это НЕ копия — обе ссылаются на тот же массив
copy1[0] = 99;
System.out.println(original[0]); // 99 — изменилось

// Правильно
int[] copy2 = original.clone();
int[] copy3 = Arrays.copyOf(original, original.length);
int[] copy4 = new int[original.length];
System.arraycopy(original, 0, copy4, 0, original.length);
```

## 8.7 Минусы массивов

- **Фиксированный размер.** Нельзя добавить элемент после создания.
- Неудобный API.

В реальной разработке вместо массивов в 90% случаев используют `ArrayList` (см. Collections).

## Упражнения 8

### Задача 8.1
Создай массив из 10 случайных чисел от 1 до 100. Найди max, min, среднее.

### Задача 8.2
Разверни массив (на месте, без создания нового).

### Задача 8.3
Найти второй по величине элемент в массиве.

### Задача 8.4
Дан массив. Удалить из него все нули (создать новый массив без них).

### Задача 8.5
Транспонирование матрицы N×M в M×N.

### Решения

```java
import java.util.Arrays;
import java.util.Random;

// 8.1
int[] nums = new int[10];
Random rnd = new Random();
for (int i = 0; i < nums.length; i++) {
    nums[i] = rnd.nextInt(100) + 1;
}
int max = nums[0], min = nums[0], sum = 0;
for (int n : nums) {
    if (n > max) max = n;
    if (n < min) min = n;
    sum += n;
}
double avg = (double) sum / nums.length;
System.out.println(Arrays.toString(nums));
System.out.println("max=" + max + " min=" + min + " avg=" + avg);

// 8.2
int[] arr = {1, 2, 3, 4, 5};
for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
// {5, 4, 3, 2, 1}

// 8.3
int[] arr = {3, 1, 5, 9, 2, 9, 7};
int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
for (int n : arr) {
    if (n > max) {
        second = max;
        max = n;
    } else if (n > second && n != max) {
        second = n;
    }
}
System.out.println("Second max: " + second);   // 7

// 8.4
int[] in = {1, 0, 2, 0, 3, 0, 0, 4};
int count = 0;
for (int n : in) if (n != 0) count++;
int[] out = new int[count];
int idx = 0;
for (int n : in) {
    if (n != 0) out[idx++] = n;
}
System.out.println(Arrays.toString(out));   // [1, 2, 3, 4]

// 8.5
int[][] m = {
    {1, 2, 3},
    {4, 5, 6}
};
int rows = m.length, cols = m[0].length;
int[][] t = new int[cols][rows];
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        t[j][i] = m[i][j];
    }
}
// t = [[1,4],[2,5],[3,6]]
```

---

# 9. Ввод данных (Scanner)

Scanner — стандартный способ читать ввод от пользователя.

## 9.1 Базовое использование

```java
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Имя: ");
        String name = sc.nextLine();

        System.out.print("Возраст: ");
        int age = sc.nextInt();

        System.out.print("Рост: ");
        double height = sc.nextDouble();

        System.out.println("Hello, " + name + "! Age: " + age + ", height: " + height);

        sc.close();
    }
}
```

## 9.2 Методы Scanner

```java
sc.nextLine()         // вся строка до Enter
sc.next()             // одно "слово" (до пробела/перевода строки)
sc.nextInt()          // int
sc.nextLong()         // long
sc.nextDouble()       // double
sc.nextBoolean()      // boolean

sc.hasNext()          // есть ли ещё ввод
sc.hasNextInt()       // есть ли int дальше
```

## 9.3 Грабли с nextLine после nextInt

```java
int age = sc.nextInt();         // прочитал число, но НЕ съел \n
String name = sc.nextLine();    // получит пустую строку!
```

**Решение:** добавить `sc.nextLine()` после `nextInt()`:
```java
int age = sc.nextInt();
sc.nextLine();                  // съесть остаток строки
String name = sc.nextLine();    // теперь корректно
```

Или использовать только `nextLine()` и парсить вручную:
```java
int age = Integer.parseInt(sc.nextLine());
String name = sc.nextLine();
```

Это надёжнее.

## Упражнение 9

Программа спрашивает у пользователя:
- Имя
- Возраст
- 3 любимых цвета (через пробел)

Затем выводит:
```
Hello, <имя>! You are <возраст> y.o.
Your favorite colors:
  - <цвет1>
  - <цвет2>
  - <цвет3>
```

### Решение

```java
import java.util.Scanner;

public class FavoriteColors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("3 favorite colors (space-separated): ");
        String[] colors = sc.nextLine().split("\\s+");

        System.out.println("Hello, " + name + "! You are " + age + " y.o.");
        System.out.println("Your favorite colors:");
        for (String c : colors) {
            System.out.println("  - " + c);
        }
    }
}
```

---

# 10. Методы

Метод — именованный блок кода, который можно вызывать.

## 10.1 Объявление

```java
public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void greet(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) {
        int sum = add(2, 3);
        greet("Aibek");
    }
}
```

Структура:
```
[модификаторы] [тип возврата] [имя](параметры) {
    тело
}
```

- `public static int add(int a, int b)`:
  - `public` — доступен везде.
  - `static` — принадлежит классу, не объекту.
  - `int` — возвращает int.
  - `add` — имя.
  - `int a, int b` — параметры.
- Если нет возврата — `void`.

## 10.2 return

```java
public static int max(int a, int b) {
    if (a > b) return a;
    return b;
}

public static void printIfPositive(int n) {
    if (n <= 0) return;       // ранний выход
    System.out.println(n);
}
```

## 10.3 Параметры передаются по значению

В Java **всё передаётся по значению**. Для примитивов это значит копию значения, для объектов — копию ссылки.

```java
public static void modifyPrimitive(int x) {
    x = 100;
}

public static void modifyArray(int[] arr) {
    arr[0] = 100;        // изменит исходный массив (та же ссылка)
    arr = new int[]{1, 2, 3};   // не повлияет на вызывающего
                                 // (локальная переменная переключилась)
}

public static void main(String[] args) {
    int n = 5;
    modifyPrimitive(n);
    System.out.println(n);          // 5

    int[] a = {0, 0, 0};
    modifyArray(a);
    System.out.println(a[0]);       // 100
}
```

⚠️ Это часто путает. Запомни: **в Java нет передачи по ссылке** (как в C++). Только по значению. Но если значение — это ссылка, ты можешь изменить объект, на который она указывает.

## 10.4 Перегрузка методов (overloading)

Несколько методов с одним именем, но разными параметрами:

```java
public static int add(int a, int b) {
    return a + b;
}

public static double add(double a, double b) {
    return a + b;
}

public static int add(int a, int b, int c) {
    return a + b + c;
}

public static String add(String a, String b) {
    return a + b;        // конкатенация
}
```

Компилятор выбирает по типу и количеству аргументов. **Имя возврата для разрешения перегрузки не учитывается**:

```java
// ❌ ошибка: только разный тип возврата — нельзя
public static int foo() { return 1; }
public static double foo() { return 1.0; }
```

## 10.5 Varargs (переменное число аргументов)

```java
public static int sum(int... nums) {       // три точки
    int total = 0;
    for (int n : nums) total += n;
    return total;
}

sum();              // 0
sum(1);             // 1
sum(1, 2, 3);       // 6
sum(1, 2, 3, 4, 5); // 15
```

Внутри метода `nums` — это массив `int[]`.

⚠️ Varargs должен быть **последним** параметром:
```java
public static void log(String level, String... messages) { ... }     // OK
public static void log(String... messages, String level) { ... }     // ❌
```

## 10.6 Хорошие практики

✅ **Один метод — одно действие.** Если описание метода требует слова "и" — разбей.

✅ **Имена-глаголы:** `calculateTotal()`, `findUser()`, `isEmpty()`, `hasPermission()`.

✅ **Короткие методы.** Если метод больше 20–30 строк — подумай, как разбить.

✅ **Минимум параметров.** Идеал — 0–2. Если 5+ — оберни в объект.

```java
// ПЛОХО
createUser(String name, String email, int age, String city, String phone, boolean isAdmin)

// ХОРОШО
createUser(UserCreateRequest request)
```

## Упражнения 10

### Задача 10.1
Метод `isEven(int n)`, возвращает true если число чётное.

### Задача 10.2
Метод `factorial(int n)`, возвращает n!. Проверь, что n ≥ 0, иначе бросай `IllegalArgumentException`.

### Задача 10.3
Перегрузи метод `area`:
- `area(double radius)` — площадь круга
- `area(double a, double b)` — площадь прямоугольника
- `area(double a, double b, double c)` — площадь треугольника по трём сторонам (формула Герона)

### Задача 10.4
Метод `printArray(int... nums)` использует varargs. Печатает все числа в одну строку через запятую.

### Задача 10.5
Метод `swap` для двух элементов массива (по индексам).

### Решения

```java
// 10.1
public static boolean isEven(int n) {
    return n % 2 == 0;
}

// 10.2
public static long factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative");
    long result = 1;
    for (int i = 2; i <= n; i++) result *= i;
    return result;
}

// 10.3
public static double area(double radius) {
    return Math.PI * radius * radius;
}
public static double area(double a, double b) {
    return a * b;
}
public static double area(double a, double b, double c) {
    double p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
}

// 10.4
public static void printArray(int... nums) {
    for (int i = 0; i < nums.length; i++) {
        if (i > 0) System.out.print(", ");
        System.out.print(nums[i]);
    }
    System.out.println();
}

// 10.5
public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
```

---

# 11. Рекурсия

Рекурсия — это когда метод вызывает сам себя.

## 11.1 Классический пример: факториал

```java
public static long factorial(int n) {
    if (n <= 1) return 1;          // базовый случай
    return n * factorial(n - 1);    // рекурсивный вызов
}

factorial(5);
// = 5 * factorial(4)
// = 5 * 4 * factorial(3)
// = 5 * 4 * 3 * factorial(2)
// = 5 * 4 * 3 * 2 * factorial(1)
// = 5 * 4 * 3 * 2 * 1 = 120
```

Каждая рекурсия должна иметь:
1. **Базовый случай** — условие выхода (без него — бесконечная рекурсия → `StackOverflowError`).
2. **Рекурсивный шаг** — приводит к базовому.

## 11.2 Фибоначчи

```java
public static long fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

⚠️ Этот вариант **очень медленный**: для `fib(40)` будет ~2 миллиарда вызовов, потому что одно и то же считается много раз. Это типичная задача, решаемая мемоизацией или итеративно.

## 11.3 Когда использовать рекурсию

Хорошо подходит для:
- Деревьев, графов (обход).
- Задач "разделяй и властвуй" (merge sort, quick sort).
- Природно-рекурсивных задач (факториал, поиск файлов в папке).

Плохо подходит для:
- Простых линейных задач (просто пиши цикл).
- Задач с большой глубиной (стек вылетит).

## 11.4 StackOverflowError

```java
public static void infinite() {
    infinite();      // нет базового случая
}
// java.lang.StackOverflowError
```

JVM выделяет каждому потоку фиксированный стек (обычно ~512 КБ — 1 МБ). Каждый вызов метода кладёт на стек "фрейм". Слишком глубоко — переполнение.

## Упражнения 11

### Задача 11.1
Рекурсивная сумма чисел от 1 до n.

### Задача 11.2
Рекурсивный разворот строки.

### Задача 11.3
Возведение в степень (a^n).

### Задача 11.4
Подсчёт количества цифр в числе.

### Задача 11.5
Поиск максимума в массиве через рекурсию.

### Решения

```java
// 11.1
public static int sumTo(int n) {
    if (n == 0) return 0;
    return n + sumTo(n - 1);
}

// 11.2
public static String reverse(String s) {
    if (s.length() <= 1) return s;
    return reverse(s.substring(1)) + s.charAt(0);
}

// 11.3
public static long power(int a, int n) {
    if (n == 0) return 1;
    return a * power(a, n - 1);
}

// 11.4
public static int countDigits(int n) {
    if (n < 10) return 1;
    return 1 + countDigits(n / 10);
}

// 11.5
public static int max(int[] arr, int start) {
    if (start == arr.length - 1) return arr[start];
    int restMax = max(arr, start + 1);
    return Math.max(arr[start], restMax);
}
// вызов: max(arr, 0)
```

---

# Часть III. Строки

# 12. String — основы и String Pool

## 12.1 Что такое String

`String` — это объект, представляющий **последовательность символов**. В отличие от C, это полноценный класс, не просто массив байтов.

```java
String s = "Hello";              // литерал
String t = new String("Hello");  // явное создание объекта
char[] arr = {'H', 'i'};
String u = new String(arr);      // из массива char
```

## 12.2 Immutable — неизменяемая

⚠️ **`String` нельзя изменить.** Любая операция возвращает новый `String`.

```java
String s = "Hello";
s.toUpperCase();              // вернёт "HELLO", но s не изменится!
System.out.println(s);        // "Hello"

s = s.toUpperCase();          // теперь s = "HELLO"
```

Зачем неизменяемая:
- **Безопасность.** Передаёшь строку в метод — не боишься, что он её изменит.
- **Можно кэшировать hashCode.** Один раз посчитал — навсегда.
- **String Pool работает.** Можно безопасно делиться одним объектом между потоками.

## 12.3 String Pool

Java хранит литералы строк в **общем пуле** — в области памяти, где одинаковые строки представлены одним объектом.

```java
String a = "hello";
String b = "hello";
System.out.println(a == b);          // true — одна и та же ссылка из пула
```

Но `new` всегда создаёт **новый объект**:
```java
String c = new String("hello");
System.out.println(a == c);          // false — c в куче, не в пуле
System.out.println(a.equals(c));     // true
```

`intern()` — добавляет строку в пул и возвращает ссылку из него:
```java
String d = c.intern();
System.out.println(a == d);          // true
```

## 12.4 == vs .equals()

⚠️ **Самая частая ошибка джунов:**

```java
String a = "hello";
String b = "hello";
String c = new String("hello");

a == b           // true (оба из пула)
a == c           // false (c — отдельный объект)
a.equals(c)      // true (одинаковое содержимое)
```

**Правило:** для сравнения содержимого строк — **всегда `.equals()`.**

```java
String input = sc.nextLine();
if (input.equals("yes")) { ... }                    // ✅
if (input.equalsIgnoreCase("yes")) { ... }          // ✅ без учёта регистра

// Защита от NPE если input может быть null:
if ("yes".equals(input)) { ... }                    // ✅✅ литерал слева
```

## 12.5 String.length()

```java
String s = "Hello";
System.out.println(s.length());      // 5
System.out.println(s.isEmpty());     // false
System.out.println("".isEmpty());    // true
System.out.println("   ".isBlank()); // true (только пробелы)
```

⚠️ `length` для массива — **поле** (без скобок): `arr.length`.
   `length()` для строки — **метод** (со скобками).

---

# 13. Методы String

## 13.1 Самые часто используемые

```java
String s = "  Hello, World!  ";

s.length()                       // 17
s.trim()                         // "Hello, World!" (убирает пробелы по краям)
s.strip()                        // как trim, но понимает Unicode whitespace
s.toUpperCase()                  // "  HELLO, WORLD!  "
s.toLowerCase()                  // "  hello, world!  "

s.charAt(2)                      // 'H'
s.indexOf('l')                   // 4
s.indexOf("World")               // 9
s.indexOf('z')                   // -1 (нет такого)
s.lastIndexOf('l')               // 12

s.substring(2, 7)                // "Hello" (с 2 включительно по 6 включительно)
s.substring(9)                   // "World!  " (с 9 до конца)

s.contains("World")              // true
s.startsWith("  Hello")          // true
s.endsWith("!  ")                // true

s.replace('l', 'L')              // "  HeLLo, WorLd!  "
s.replace("World", "Java")       // "  Hello, Java!  "
s.replaceAll("\\s+", " ")        // " Hello, World! " (regex)

s.split(",")                     // ["  Hello", " World!  "]

s.equals("hello")                // false
s.equalsIgnoreCase("  HELLO, WORLD!  ")  // true

s.isEmpty()                      // false
s.isBlank()                      // false
"".isEmpty()                     // true
"  ".isBlank()                   // true

s.toCharArray()                  // массив char
s.chars()                        // IntStream символов
```

## 13.2 Соединение строк

```java
String a = "Hello";
String b = "World";

// Конкатенация
String c = a + ", " + b + "!";   // "Hello, World!"

// String.concat()
String d = a.concat(", ").concat(b);

// String.join() — со разделителем
String e = String.join(", ", "a", "b", "c");           // "a, b, c"
String f = String.join(" - ", List.of("x", "y", "z")); // "x - y - z"
```

## 13.3 Строковая конкатенация в цикле — анти-паттерн

```java
// ПЛОХО — каждый += создаёт новый String
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;
}

// ХОРОШО — StringBuilder
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String result = sb.toString();
```

Подробно про StringBuilder в разделе 14.

## 13.4 Сравнение строк

```java
String a = "apple", b = "banana";

a.equals(b)               // false
a.compareTo(b)            // отрицательное число (a < b лексикографически)
a.compareToIgnoreCase(b)  // то же без учёта регистра
```

`compareTo`:
- 0 — равны
- < 0 — текущая меньше
- > 0 — текущая больше

Полезно для сортировки.

## Упражнения 13

### Задача 13.1
Метод `isPalindrome(String s)`. Игнорирует регистр и пробелы.
Примеры: `"madam"` → true, `"A man a plan a canal Panama"` → true.

### Задача 13.2
Метод `countVowels(String s)`. Считает гласные (английские: a, e, i, o, u).

### Задача 13.3
Метод `reverseWords(String s)`. Разворачивает порядок слов.
`"Hello World Java"` → `"Java World Hello"`.

### Задача 13.4
Метод `removeDuplicates(String s)`. Удаляет повторные символы, сохраняя порядок.
`"banana"` → `"ban"`, `"hello"` → `"helo"`.

### Задача 13.5
Метод `mostFrequentChar(String s)`. Возвращает самый частый символ. Если несколько — любой.

### Решения

```java
// 13.1
public static boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("\\s+", "");
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) return false;
        left++; right--;
    }
    return true;
}

// 13.2
public static int countVowels(String s) {
    int count = 0;
    String vowels = "aeiouAEIOU";
    for (char c : s.toCharArray()) {
        if (vowels.indexOf(c) >= 0) count++;
    }
    return count;
}

// 13.3
public static String reverseWords(String s) {
    String[] words = s.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
        if (sb.length() > 0) sb.append(' ');
        sb.append(words[i]);
    }
    return sb.toString();
}

// 13.4
public static String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder();
    Set<Character> seen = new HashSet<>();
    for (char c : s.toCharArray()) {
        if (seen.add(c)) {           // add возвращает false, если уже есть
            sb.append(c);
        }
    }
    return sb.toString();
}

// 13.5
public static char mostFrequentChar(String s) {
    Map<Character, Integer> count = new HashMap<>();
    for (char c : s.toCharArray()) {
        count.merge(c, 1, Integer::sum);
    }
    char result = ' ';
    int max = 0;
    for (var e : count.entrySet()) {
        if (e.getValue() > max) {
            max = e.getValue();
            result = e.getKey();
        }
    }
    return result;
}
```

---

# 14. StringBuilder и StringBuffer

## 14.1 Зачем нужны

`String` immutable. Конкатенация в цикле создаёт лавину новых объектов. `StringBuilder` — изменяемая последовательность символов.

## 14.2 StringBuilder

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(", ");
sb.append("World");
sb.append('!');
sb.append(42);          // принимает любые типы

System.out.println(sb);              // Hello, World!42
System.out.println(sb.length());     // 15

// Цепочка методов (chaining)
StringBuilder sb2 = new StringBuilder()
    .append("a")
    .append("b")
    .append(123);

// Преобразование в String
String result = sb.toString();
```

### Часто используемые методы

```java
sb.append("xxx")              // добавить в конец
sb.insert(0, "yyy")           // вставить по индексу
sb.delete(2, 5)               // удалить подстроку (от 2 до 4)
sb.deleteCharAt(0)            // удалить один символ
sb.replace(0, 5, "Hi")        // заменить подстроку
sb.reverse()                  // развернуть

sb.charAt(0)
sb.length()
sb.setLength(0)               // очистить (быстрый способ)

sb.indexOf("Hello")
sb.substring(2, 5)
```

## 14.3 StringBuilder vs StringBuffer

`StringBuffer` — то же самое, но **потокобезопасный** (методы `synchronized`).

В однопоточном коде используй `StringBuilder` — он быстрее. `StringBuffer` нужен только если несколько потоков пишут в одну строку, что в реальной разработке очень редко.

## 14.4 Когда String а когда StringBuilder

✅ **String** — для коротких операций, когда строк немного.

✅ **StringBuilder** — для построения строки в цикле или при многих операциях.

```java
// String — нормально
String greeting = "Hello, " + name + "!";

// StringBuilder — обязательно
StringBuilder sql = new StringBuilder("SELECT ");
for (String column : columns) {
    sql.append(column).append(", ");
}
```

## Упражнение 14

### Задача
Метод `repeat(String s, int n)` — повторяет строку n раз.
`repeat("ab", 3)` → `"ababab"`.

С Java 11+ есть `s.repeat(n)`, но напиши сам через StringBuilder.

### Решение

```java
public static String repeat(String s, int n) {
    if (n < 0) throw new IllegalArgumentException();
    StringBuilder sb = new StringBuilder(s.length() * n);
    for (int i = 0; i < n; i++) sb.append(s);
    return sb.toString();
}
```

---

# 15. Форматирование и Text Blocks

## 15.1 String.format

Похоже на `printf` из C:

```java
String s = String.format("Hello, %s! You are %d years old.", "Aibek", 25);
System.out.println(s);
// Hello, Aibek! You are 25 years old.

System.out.printf("Pi = %.2f%n", Math.PI);
// Pi = 3.14
```

Спецификаторы:
| Что | Спецификатор |
|---|---|
| Строка | `%s` |
| Число | `%d` |
| Дробь | `%f` (`%.2f` — 2 знака) |
| Символ | `%c` |
| Boolean | `%b` |
| Перевод строки | `%n` |
| Знак % | `%%` |
| Hex | `%x` |
| Заполнение | `%5d`, `%-5d`, `%05d` |

```java
System.out.printf("%-10s %5d%n", "name", 42);
// name           42
```

## 15.2 String.formatted (Java 15+)

```java
String s = "Hello, %s!".formatted("Aibek");
```

То же самое, удобнее.

## 15.3 Text Blocks (Java 15+)

Многострочные строки без \n и кавычек:

```java
String json = """
        {
            "name": "Aibek",
            "age": 25
        }
        """;

String sql = """
        SELECT u.id, u.name
        FROM users u
        WHERE u.age > 18
        """;

String html = """
        <html>
            <body>
                <h1>Hello</h1>
            </body>
        </html>
        """;
```

Удобно: не нужно `\n`, не нужно эскейпить кавычки.

⚠️ Отступ слева от наименьшего отступа в блоке вырезается. То есть форматирование сохраняется относительно.

## Упражнение 15

### Задача
Программа печатает таблицу:
```
Name        Age   Salary
==========================
Aibek        25  500000.00
Madi         30  750000.50
Aiman        28  650000.00
```

Используй `String.format` и `printf`.

### Решение

```java
String[][] data = {
    {"Aibek", "25", "500000.00"},
    {"Madi", "30", "750000.50"},
    {"Aiman", "28", "650000.00"}
};

System.out.printf("%-10s %5s %10s%n", "Name", "Age", "Salary");
System.out.println("=".repeat(30));
for (String[] row : data) {
    System.out.printf("%-10s %5s %10s%n", row[0], row[1], row[2]);
}
```

---

# Часть IV. ООП

ООП — главный концепт Java. Без него нельзя двигаться дальше. На собесе спрашивают почти все вопросы из этой части.

# 16. Классы и объекты

## 16.1 Что такое класс

Класс — это **шаблон** для создания объектов. Описывает, какие у объекта поля (данные) и методы (поведение).

```java
public class Person {
    // Поля (атрибуты, состояние)
    String name;
    int age;

    // Методы (поведение)
    void greet() {
        System.out.println("Hi, I'm " + name);
    }
}
```

## 16.2 Создание объекта

```java
Person p = new Person();   // создаём объект
p.name = "Aibek";          // присваиваем поля
p.age = 25;
p.greet();                  // Hi, I'm Aibek
```

`new Person()` делает:
1. Выделяет память в куче.
2. Заполняет поля значениями по умолчанию (0, null, false).
3. Вызывает конструктор.
4. Возвращает ссылку на новый объект.

## 16.3 this

`this` — ссылка на текущий объект.

```java
public class Person {
    String name;

    void setName(String name) {
        this.name = name;     // this.name — поле, name — параметр
    }
}
```

Без `this` Java не понимала бы, какому `name` присваивать.

## 16.4 Класс vs объект

- **Класс** — описание (что есть у Person в принципе).
- **Объект** — конкретный экземпляр (Aibek с возрастом 25).

```java
Person p1 = new Person();   // объект 1
Person p2 = new Person();   // объект 2 — отдельная память, отдельные поля

p1.name = "Aibek";
p2.name = "Madi";

p1.greet();   // Hi, I'm Aibek
p2.greet();   // Hi, I'm Madi
```

## 16.5 Один файл — один публичный класс

Файл `Person.java` может содержать только один `public class`, и его имя должно совпадать с именем файла:

```java
// Файл Person.java
public class Person { ... }      // ✅ имена совпадают
class Helper { ... }              // ✅ непубличный — можно
public class Animal { ... }       // ❌ только один публичный
```

## Упражнение 16

Создай класс `Book` с полями `title` (String), `author` (String), `pages` (int). Метод `info()`, который печатает информацию о книге.

В main создай 2 книги, заполни поля, вызови info().

### Решение

```java
public class Book {
    String title;
    String author;
    int pages;

    void info() {
        System.out.println("\"" + title + "\" by " + author + " (" + pages + " pages)");
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.title = "Effective Java";
        b1.author = "Joshua Bloch";
        b1.pages = 412;
        b1.info();

        Book b2 = new Book();
        b2.title = "Clean Code";
        b2.author = "Robert Martin";
        b2.pages = 464;
        b2.info();
    }
}
```

---

# 17. Конструкторы

## 17.1 Что такое конструктор

Конструктор — **специальный метод**, который вызывается при создании объекта. Имя совпадает с именем класса. Не имеет типа возврата.

```java
public class Person {
    String name;
    int age;

    // Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Использование
Person p = new Person("Aibek", 25);   // вместо ручного присваивания
```

## 17.2 Default конструктор

Если ты **не написал** ни одного конструктора, Java создаст **пустой по умолчанию**:

```java
public class Person {
    String name;
    // Java добавит:
    // public Person() {}
}

Person p = new Person();   // работает
```

⚠️ Как только ты написал свой конструктор, default исчезает:

```java
public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

Person p = new Person();      // ❌ ошибка компиляции — нет такого конструктора
Person p = new Person("Aibek"); // ✅
```

Если хочешь иметь оба — пиши явно:

```java
public Person() {}
public Person(String name) { this.name = name; }
```

## 17.3 Перегрузка конструкторов

Несколько конструкторов с разными параметрами:

```java
public class Point {
    int x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {        // copy constructor
        this.x = other.x;
        this.y = other.y;
    }
}

Point p1 = new Point();
Point p2 = new Point(3, 4);
Point p3 = new Point(p2);
```

## 17.4 this(...) — вызов другого конструктора

Чтобы избежать дублирования:

```java
public class Person {
    String name;
    int age;

    public Person() {
        this("Unknown", 0);          // вызов другого конструктора
    }

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

⚠️ `this(...)` должен быть **первой строкой** конструктора.

## 17.5 Зачем нужен конструктор

- Объект сразу попадает в **корректное состояние** (нельзя забыть что-то заполнить).
- Можно **валидировать** данные при создании.

```java
public class Account {
    String owner;
    double balance;

    public Account(String owner, double initialBalance) {
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Owner is required");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Balance can't be negative");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }
}
```

## Упражнение 17

Создай класс `Rectangle` с полями `width`, `height`. Конструкторы:
1. Без параметров — создаёт квадрат 1×1.
2. С одним параметром — квадрат `n×n`.
3. С двумя параметрами — прямоугольник.

Все размеры должны быть > 0, иначе `IllegalArgumentException`.

Метод `area()` возвращает площадь.

### Решение

```java
public class Rectangle {
    double width;
    double height;

    public Rectangle() {
        this(1, 1);
    }

    public Rectangle(double side) {
        this(side, side);
    }

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Sizes must be positive");
        }
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
```

---

# 18. Инкапсуляция

Инкапсуляция — **скрытие данных** и предоставление контролируемого доступа через методы.

## 18.1 Зачем

Открытые поля — плохо:
```java
public class Account {
    public double balance;
}

Account a = new Account();
a.balance = -1_000_000;        // ничто не мешает!
```

Скрытые поля + методы — хорошо:
```java
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        if (amount > balance) throw new IllegalStateException("Insufficient funds");
        balance -= amount;
    }
}
```

Преимущества:
- Контроль над состоянием (нельзя установить мусор).
- Можно изменить реализацию (формат хранения), не сломав внешний код.
- Можно добавить логирование, валидацию.

## 18.2 private + public методы

Стандартный паттерн:

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);              // используем сеттер для валидации
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        this.age = age;
    }
}
```

В IDEA: правый клик → Generate → Getter and Setter — сгенерирует автоматически.

## 18.3 Когда сеттер не нужен

Не каждое поле должно иметь сеттер. Если значение задаётся при создании и не меняется:

```java
public class Order {
    private final long id;            // final, без сеттера
    private final LocalDateTime createdAt;
    private String status;            // меняется

    public Order(long id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public long getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getStatus() { return status; }

    // Сеттер нет, есть осмысленные методы:
    public void approve() { this.status = "APPROVED"; }
    public void cancel() { this.status = "CANCELLED"; }
}
```

## Упражнение 18

Перепиши `Account` (выше) с правильной инкапсуляцией. Добавь:
- Поле `accountNumber` (final, задаётся в конструкторе).
- Поле `holder` (имя владельца).
- Метод `transfer(Account other, double amount)` — списать с этого, зачислить на other.

### Решение

```java
public class Account {
    private final String accountNumber;
    private String holder;
    private double balance;

    public Account(String accountNumber, String holder) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("accountNumber required");
        }
        this.accountNumber = accountNumber;
        setHolder(holder);
        this.balance = 0;
    }

    public String getAccountNumber() { return accountNumber; }

    public String getHolder() { return holder; }
    public void setHolder(String holder) {
        if (holder == null || holder.isBlank()) {
            throw new IllegalArgumentException("holder required");
        }
        this.holder = holder;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        if (amount > balance) throw new IllegalStateException("Insufficient funds");
        balance -= amount;
    }

    public void transfer(Account other, double amount) {
        if (other == null) throw new IllegalArgumentException();
        if (this == other) throw new IllegalArgumentException("same account");
        this.withdraw(amount);
        other.deposit(amount);
    }
}
```

---

# 19. Наследование

Наследование — механизм, позволяющий одному классу **унаследовать поля и методы** другого.

## 19.1 Зачем

Если у тебя несколько классов с похожим поведением — выноси общее в родительский класс:

```java
// Без наследования — копипаста
public class Dog {
    String name; int age;
    void eat() { System.out.println(name + " eats"); }
    void sleep() { System.out.println(name + " sleeps"); }
    void bark() { System.out.println("Woof!"); }
}

public class Cat {
    String name; int age;       // дублируется
    void eat() { ... }           // дублируется
    void sleep() { ... }         // дублируется
    void meow() { System.out.println("Meow!"); }
}
```

С наследованием:

```java
public class Animal {
    String name;
    int age;
    void eat() { System.out.println(name + " eats"); }
    void sleep() { System.out.println(name + " sleeps"); }
}

public class Dog extends Animal {        // Dog наследует от Animal
    void bark() { System.out.println("Woof!"); }
}

public class Cat extends Animal {
    void meow() { System.out.println("Meow!"); }
}

Dog d = new Dog();
d.name = "Rex";
d.eat();           // унаследованный метод
d.bark();          // свой метод
```

## 19.2 super — обращение к родителю

```java
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " eats");
    }
}

public class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);          // вызов конструктора родителя — ОБЯЗАТЕЛЕН
        this.breed = breed;
    }

    @Override
    void eat() {
        super.eat();          // вызов метода родителя
        System.out.println("...and wags tail");
    }
}
```

⚠️ Если ты не вызовешь `super(...)` явно, Java попытается вызвать `super()` (без параметров). Если у родителя нет такого конструктора — ошибка компиляции.

## 19.3 @Override

`@Override` — аннотация, говорящая компилятору "я переопределяю метод родителя". Это страховка:

```java
public class Dog extends Animal {
    @Override
    void eatt() {           // опечатка — это новый метод, не override
        ...
    }
}
// С @Override компилятор скажет: "не нашёл такого метода в родителе"
// Без @Override — пройдёт, и ты будешь думать, почему не работает
```

**Всегда пиши `@Override`** — IDEA сама подскажет.

## 19.4 Только одиночное наследование

Java **не поддерживает множественное наследование классов**:

```java
public class A { }
public class B { }
public class C extends A, B { }   // ❌ нельзя
```

Множественность достигается через **интерфейсы** (см. дальше).

## 19.5 Object — родитель всех классов

Если класс не наследуется явно — он наследуется от `Object`:

```java
public class Person { }       // implicit: extends Object

Person p = new Person();
p.toString();        // унаследовано от Object
p.hashCode();        // унаследовано
p.equals(other);     // унаследовано
p.getClass();        // ...
```

`Object` — корень иерархии. Имеет важные методы (см. раздел 26).

## 19.6 Композиция vs наследование

⚠️ Наследование — мощно, но используй **только когда есть реальные отношения "is-a"** (является):
- `Dog is an Animal` — ✅
- `Manager is an Employee` — ✅

Если отношение "has-a" (имеет) — используй **композицию** (поля), не наследование:

```java
// ПЛОХО — у машины нет "является" двигателя
public class Car extends Engine { }

// ХОРОШО — у машины ЕСТЬ двигатель
public class Car {
    private Engine engine;
}
```

В современной разработке **композицию предпочитают наследованию.**

## Упражнение 19

Иерархия:
- `Vehicle` — базовый, поля `brand`, `year`. Метод `start()` печатает "Starting...".
- `Car extends Vehicle` — добавляет `seats`. Метод `honk()`.
- `Truck extends Vehicle` — добавляет `loadCapacity` (тонн). Метод `loadCargo(double tons)`.

Все классы имеют конструктор с правильным `super`.

### Решение

```java
public class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void start() {
        System.out.println(brand + " starting...");
    }
}

public class Car extends Vehicle {
    private int seats;

    public Car(String brand, int year, int seats) {
        super(brand, year);
        this.seats = seats;
    }

    public void honk() {
        System.out.println("Beep beep!");
    }
}

public class Truck extends Vehicle {
    private double loadCapacity;
    private double currentLoad;

    public Truck(String brand, int year, double loadCapacity) {
        super(brand, year);
        this.loadCapacity = loadCapacity;
    }

    public void loadCargo(double tons) {
        if (currentLoad + tons > loadCapacity) {
            throw new IllegalStateException("Overload!");
        }
        currentLoad += tons;
        System.out.println("Loaded " + tons + " tons. Total: " + currentLoad);
    }
}
```

---

# 20. Полиморфизм

Полиморфизм — один и тот же метод **по-разному ведёт себя** для разных типов.

## 20.1 Полиморфизм через переопределение

```java
public class Animal {
    public void sound() {
        System.out.println("Some sound");
    }
}

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow!");
    }
}

// Полиморфизм в действии:
Animal[] animals = { new Dog(), new Cat(), new Animal() };
for (Animal a : animals) {
    a.sound();   // Woof! Meow! Some sound
}
```

Магия: переменная типа `Animal`, но JVM выбирает реализацию по реальному типу объекта (**dynamic dispatch**).

## 20.2 Upcasting и Downcasting

**Upcasting** — приведение к родителю — автоматическое:

```java
Dog d = new Dog();
Animal a = d;           // upcasting — без cast
```

**Downcasting** — приведение к потомку — явное и опасное:

```java
Animal a = new Dog();
Dog d = (Dog) a;         // downcasting — нужен cast

Animal a2 = new Cat();
Dog d2 = (Dog) a2;       // ⚠️ ClassCastException на runtime!
```

Чтобы не упасть, проверь через `instanceof`:

```java
if (a instanceof Dog) {
    Dog d = (Dog) a;
    d.bark();
}
```

С Java 16+ — pattern matching:

```java
if (a instanceof Dog d) {        // d создаётся автоматически если match
    d.bark();
}
```

## 20.3 Зачем нужен полиморфизм

Реальный пример: у тебя есть метод, обрабатывающий разные платежи:

```java
public abstract class Payment {
    public abstract void process();
}

public class CardPayment extends Payment {
    @Override
    public void process() {
        // Charge card
    }
}

public class CryptoPayment extends Payment {
    @Override
    public void process() {
        // Transfer crypto
    }
}

// Сервис не знает деталей — работает с любой Payment:
public class PaymentService {
    public void payAll(List<Payment> payments) {
        for (Payment p : payments) {
            p.process();         // вызовется правильная реализация
        }
    }
}
```

Добавишь `BankTransferPayment` — `PaymentService` менять не нужно. Это **открытый/закрытый принцип** (OCP) из SOLID.

## 20.4 Static binding vs dynamic dispatch

```java
public class Parent {
    public static void staticMethod() { System.out.println("Parent"); }
    public void instanceMethod() { System.out.println("Parent"); }
}

public class Child extends Parent {
    public static void staticMethod() { System.out.println("Child"); }
    public void instanceMethod() { System.out.println("Child"); }
}

Parent p = new Child();
p.staticMethod();      // Parent (static — по типу переменной)
p.instanceMethod();    // Child (instance — по реальному типу)
```

Static-методы **не переопределяются** — они привязываются по типу переменной, а не объекта.

⚠️ На собесе любят спрашивать.

## Упражнение 20

Иерархия фигур:
- `Shape` — абстрактный (см. следующий раздел про абстрактные классы) или обычный с методом `area()` возвращающим 0.
- `Circle`, `Square`, `Rectangle`, `Triangle` — наследуются и переопределяют `area()`.

Метод `totalArea(Shape[] shapes)` считает сумму площадей.

### Решение

```java
public class Shape {
    public double area() { return 0; }
}

public class Circle extends Shape {
    private double radius;
    public Circle(double r) { this.radius = r; }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double width, height;
    public Rectangle(double w, double h) { width = w; height = h; }

    @Override
    public double area() {
        return width * height;
    }
}

public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

public class Triangle extends Shape {
    private double base, height;
    public Triangle(double b, double h) { base = b; height = h; }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

public class ShapeCalculator {
    public static double totalArea(Shape[] shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.area();
        return sum;
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Square(3),
            new Triangle(4, 5)
        };
        System.out.println("Total area: " + totalArea(shapes));
    }
}
```

---

# 21. Абстрактные классы

## 21.1 Что это

**Абстрактный класс** — класс, который **нельзя инстанцировать** (`new` не работает). Используется как база для других.

```java
public abstract class Shape {
    public abstract double area();        // абстрактный метод — без тела
    public abstract double perimeter();

    public void describe() {              // обычный метод
        System.out.println("Area: " + area() + ", perimeter: " + perimeter());
    }
}

Shape s = new Shape();    // ❌ ошибка компиляции
```

## 21.2 Абстрактный метод

Объявляется без тела. Любой потомок **обязан** его реализовать (если только не сам абстрактный):

```java
public class Circle extends Shape {
    private double radius;
    public Circle(double r) { this.radius = r; }

    @Override
    public double area() { return Math.PI * radius * radius; }

    @Override
    public double perimeter() { return 2 * Math.PI * radius; }
}
```

## 21.3 Зачем абстрактный класс

Когда есть общая база, но смысла создавать "просто Shape" нет:

```java
Shape s = new Shape();    // что это вообще?
```

Все Shape — это что-то конкретное (круг, квадрат). Абстрактность это формализует.

## 21.4 Абстрактный класс может иметь:
- Поля.
- Конструкторы (вызываются из потомков через `super`).
- Обычные методы с реализацией.
- Абстрактные методы.

## Упражнение 21

Абстрактный `Employee` с полями `name`, `id`. Абстрактный метод `calculateSalary()`. Метод `printInfo()`.

Реализации:
- `FullTimeEmployee` — фиксированная зарплата.
- `Contractor` — почасовая оплата (`hoursWorked`, `hourlyRate`).
- `SalesPerson extends FullTimeEmployee` — фикс + комиссия с продаж.

### Решение

```java
public abstract class Employee {
    protected String name;
    protected long id;

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateSalary();

    public void printInfo() {
        System.out.println(id + " " + name + ": $" + calculateSalary());
    }
}

public class FullTimeEmployee extends Employee {
    protected double monthlySalary;

    public FullTimeEmployee(long id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

public class Contractor extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public Contractor(long id, String name, int hours, double rate) {
        super(id, name);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class SalesPerson extends FullTimeEmployee {
    private double sales;
    private double commission;

    public SalesPerson(long id, String name, double base, double sales, double commission) {
        super(id, name, base);
        this.sales = sales;
        this.commission = commission;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + sales * commission;
    }
}
```

---

# 22. Интерфейсы

## 22.1 Что это

Интерфейс — **контракт**. Описывает, какие методы класс **обязан реализовать**, не задавая реализацию.

```java
public interface Drawable {
    void draw();         // публичный абстрактный метод (по умолчанию)
}

public class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}
```

## 22.2 Класс может реализовать несколько интерфейсов

```java
public interface Drawable { void draw(); }
public interface Movable { void move(int dx, int dy); }
public interface Resizable { void resize(double factor); }

public class Sprite implements Drawable, Movable, Resizable {
    @Override public void draw() { ... }
    @Override public void move(int dx, int dy) { ... }
    @Override public void resize(double factor) { ... }
}
```

Это решает проблему "множественного наследования": класс может иметь много контрактов, но только одного родителя.

## 22.3 default методы (Java 8+)

Чтобы не ломать существующий код, в интерфейсы можно добавлять методы с реализацией:

```java
public interface Vehicle {
    void start();

    default void honk() {              // реализация по умолчанию
        System.out.println("Beep!");
    }
}

public class Car implements Vehicle {
    @Override
    public void start() { ... }
    // honk() наследуется автоматически
}
```

Можно переопределить default:
```java
public class Truck implements Vehicle {
    @Override public void start() { ... }
    @Override public void honk() { System.out.println("HONK HONK!"); }
}
```

## 22.4 static методы в интерфейсе (Java 8+)

```java
public interface Calculator {
    int calculate(int a, int b);

    static Calculator adder() {
        return (a, b) -> a + b;
    }
}

Calculator c = Calculator.adder();
```

## 22.5 private методы (Java 9+)

Для общего кода между default-методами:

```java
public interface Logger {
    default void info(String msg) { log("INFO", msg); }
    default void error(String msg) { log("ERROR", msg); }

    private void log(String level, String msg) {
        System.out.println("[" + level + "] " + msg);
    }
}
```

## 22.6 Поля в интерфейсе

Все поля в интерфейсе автоматически `public static final` — это **константы**:

```java
public interface Constants {
    int MAX_USERS = 100;       // implicit public static final
}
```

Использование: `Constants.MAX_USERS`.

## 22.7 Абстрактный класс vs интерфейс

| | Абстрактный класс | Интерфейс |
|---|---|---|
| Множественное наследование | нет | да |
| Поля состояния | да | нет (только константы) |
| Конструкторы | да | нет |
| Реализация методов | да | да (default, static) |
| Когда использовать | общее состояние и поведение | контракт, возможность |

**Правило выбора:**
- Описываешь **возможность** ("умеет рисоваться", "сравнимый") → **интерфейс**.
- Описываешь **базовый класс** для группы родственных классов с общим состоянием → **абстрактный класс**.

В современной разработке **интерфейсы используются гораздо чаще.** В Spring всё построено на интерфейсах.

## Упражнение 22

Интерфейс `Sortable<T>` с методом `compare(T other)`.
Интерфейс `Printable` с default методом `print()` (печатает `toString()`).

Класс `Product implements Sortable<Product>, Printable` с полями `name`, `price`. Сравнение — по цене.

### Решение

```java
public interface Sortable<T> {
    int compare(T other);
}

public interface Printable {
    default void print() {
        System.out.println(this);
    }
}

public class Product implements Sortable<Product>, Printable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compare(Product other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + ": $" + price;
    }
}

// Использование
Product p1 = new Product("Apple", 1.5);
Product p2 = new Product("Bread", 2.0);
p1.print();
System.out.println(p1.compare(p2));    // отрицательное
```

---

# 23. Вложенные классы

## 23.1 Виды

```java
public class Outer {
    // 1. Static nested class
    static class StaticNested { }

    // 2. Inner class (non-static)
    class Inner { }

    void method() {
        // 3. Local class
        class Local { }

        // 4. Anonymous class
        Runnable r = new Runnable() {
            @Override public void run() { ... }
        };
    }
}
```

Для джуна важны: **static nested** и **anonymous**.

## 23.2 Static nested class

Это просто класс внутри класса. Используется для логического группирования:

```java
public class Tree {
    public static class Node {
        int value;
        Node left, right;
    }

    private Node root;
}

// Использование извне
Tree.Node node = new Tree.Node();
```

## 23.3 Anonymous class

Создаёт объект класса "на месте". Используется для коллбэков:

```java
Runnable task = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running!");
    }
};

new Thread(task).start();
```

С Java 8+ часто заменяется на лямбду (раздел 38):
```java
Runnable task = () -> System.out.println("Running!");
```

## 23.4 Inner class — на джуниор-уровне нужно редко

Не-static inner class имеет ссылку на внешний объект. На практике в Java реже используется (создаёт утечки памяти).

---

# Часть V. Модификаторы и Object

# 24. Модификаторы доступа, static, final

## 24.1 Модификаторы доступа

Контролируют, кто может видеть поле/метод/класс.

| Модификатор | Тот же класс | Тот же пакет | Подкласс | Везде |
|---|---|---|---|---|
| `private` | ✅ | ❌ | ❌ | ❌ |
| package-private (без модификатора) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

```java
public class Bank {
    public String name;              // видно везде
    protected double rate;            // в пакете и наследникам
    String address;                   // в пакете
    private double secretKey;         // только внутри Bank
}
```

**Правило:** делай минимально доступным. Поля → `private`. Методы → `public` если для API, `private` если внутренние.

## 24.2 static — принадлежит классу, не объекту

```java
public class Counter {
    private static int totalCount = 0;     // одно на весь класс
    private int instanceId;                 // у каждого объекта своё

    public Counter() {
        totalCount++;
        instanceId = totalCount;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public int getInstanceId() {
        return instanceId;
    }
}

new Counter();
new Counter();
System.out.println(Counter.getTotalCount());   // 2 — без объекта!
```

### Когда static

✅ **Утилитные методы** — функции без состояния:
```java
public class MathUtils {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}

MathUtils.max(5, 3);
```

✅ **Константы:**
```java
public static final double PI = 3.14159;
```

✅ **Фабричные методы:**
```java
public static Person createDefault() {
    return new Person("Unknown", 0);
}
```

❌ **Не делай static** все подряд. В нормальном ООП-коде static-методов мало.

### static block

Выполняется один раз при загрузке класса:

```java
public class Config {
    public static final Map<String, String> CACHE;

    static {
        CACHE = new HashMap<>();
        CACHE.put("default", "value");
        // загрузка из файла, например
    }
}
```

В реальной разработке используется редко.

## 24.3 final

`final` запрещает изменения.

### final на переменной

```java
final int MAX = 100;
MAX = 200;       // ❌ ошибка

final List<Integer> list = new ArrayList<>();
list = new ArrayList<>();   // ❌ нельзя переприсвоить ссылку
list.add(1);                 // ✅ можно изменять сам объект
```

⚠️ `final` — про неизменность **ссылки**, не про неизменность объекта.

### final на параметре метода

```java
public void process(final int x) {
    x = 5;       // ❌
}
```

В JDK-кодах часто пишут `final` для параметров — для чёткости.

### final на поле

```java
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // нет сеттеров — immutable!
}
```

### final на методе

```java
public class Parent {
    public final void method() { ... }
}

public class Child extends Parent {
    @Override public void method() { ... }   // ❌ нельзя переопределить
}
```

### final на классе

```java
public final class String { ... }    // нельзя наследовать
public class MyString extends String { }   // ❌
```

`String`, `Integer` и другие обёртки — final.

## 24.4 final + static = константа

```java
public class Config {
    public static final String APP_NAME = "MyApp";
    public static final int MAX_USERS = 1000;
}

// Использование без объекта
Config.APP_NAME
```

Конвенция — `UPPER_SNAKE_CASE`.

## Упражнение 24

Класс `IdGenerator` с `private static long nextId = 1`. Метод `static long getNext()` возвращает текущий и инкрементирует.

Класс `Order` использует генератор для назначения id. Поле `id` — final.

### Решение

```java
public class IdGenerator {
    private static long nextId = 1;

    private IdGenerator() {}      // приватный конструктор — не создавать объекты

    public static long getNext() {
        return nextId++;
    }
}

public class Order {
    private final long id;
    private String description;

    public Order(String description) {
        this.id = IdGenerator.getNext();
        this.description = description;
    }

    public long getId() { return id; }
    public String getDescription() { return description; }
}

// Тест
new Order("First");    // id = 1
new Order("Second");   // id = 2
```

---

# 25. Пакеты и импорты

## 25.1 Что такое пакет

Пакет — папка с классами. Используется для:
- Организации кода.
- Уникальности имён (две `User` в разных пакетах — разные классы).
- Контроля доступа (package-private).

## 25.2 Объявление и структура

```java
// Файл src/com/example/shop/model/Product.java
package com.example.shop.model;

public class Product { ... }
```

Папка должна совпадать с именем пакета: `src/com/example/shop/model/`.

Конвенция: имя пакета — обратное доменное имя. Если у компании `example.com`, пакеты начинаются с `com.example`.

## 25.3 Импорты

Чтобы использовать классы из других пакетов:

```java
package com.example.shop.service;

import com.example.shop.model.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductService {
    private List<Product> products = new ArrayList<>();
}
```

### Wildcard import

```java
import java.util.*;     // все классы из java.util
```

⚠️ Не рекомендуется. Лучше явные импорты — IDE сама управит.

### Static import

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

double r = 5;
double area = PI * sqrt(r);   // без Math.
```

### Не нужен импорт для:
- `java.lang.*` — `String`, `Object`, `Integer` импортируются автоматически.
- Классов из того же пакета.

## 25.4 Стандартная структура Java-проекта

```
src/main/java/
└── com/
    └── example/
        └── shop/
            ├── ShopApplication.java       # main
            ├── controller/
            ├── service/
            ├── repository/
            ├── model/
            └── dto/
```

---

# 26. Класс Object: equals, hashCode, toString

`Object` — корень всех классов. У него есть методы, которые часто нужно переопределять.

## 26.1 toString()

По умолчанию печатает мусор: `Person@1b6d3586`. Переопределяй:

```java
public class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

Person p = new Person("Aibek", 25);
System.out.println(p);              // Person{name='Aibek', age=25}
```

`println(p)` неявно вызывает `p.toString()`.

В IDEA: правый клик → Generate → toString().

## 26.2 equals()

По умолчанию `equals` сравнивает ссылки (как `==`):

```java
Person a = new Person("Aibek", 25);
Person b = new Person("Aibek", 25);
a.equals(b);    // false — без переопределения
```

Переопределяем:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;                          // та же ссылка
    if (o == null || getClass() != o.getClass()) return false;
    Person other = (Person) o;
    return age == other.age && Objects.equals(name, other.name);
}
```

`Objects.equals(a, b)` — null-safe сравнение: если оба null — true, если один null — false, иначе `a.equals(b)`.

### Контракт equals

Реализация **обязана** соблюдать:
- **Рефлексивность:** `a.equals(a) == true`.
- **Симметричность:** если `a.equals(b)` то `b.equals(a)`.
- **Транзитивность:** если `a.equals(b)` и `b.equals(c)` то `a.equals(c)`.
- **Согласованность:** многократные вызовы возвращают одно и то же.
- **`a.equals(null)` → false.**

## 26.3 hashCode()

Возвращает int — "хэш" объекта. Используется в `HashMap` и `HashSet`.

```java
@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

### Контракт hashCode

⚠️ **Самый важный вопрос на собесе:**

**Если `a.equals(b) == true`, то `a.hashCode() == b.hashCode()`.**

Обратное **не обязательно** — два объекта могут иметь одинаковый hashCode, но не быть equal (это коллизия, она нормальна).

**Если переопределяешь `equals`, ты ОБЯЗАН переопределить `hashCode`.** Иначе твой объект будет криво работать в HashMap/HashSet.

В IDEA: Generate → equals() and hashCode() — сразу оба.

## 26.4 Полный пример

```java
import java.util.Objects;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person other)) return false;     // pattern matching
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// Тест
Person a = new Person("Aibek", 25);
Person b = new Person("Aibek", 25);
Person c = new Person("Madi", 30);

a.equals(b);          // true
a.hashCode() == b.hashCode();   // true (контракт соблюдён)
a.equals(c);          // false

Set<Person> set = new HashSet<>();
set.add(a);
set.contains(b);      // true (нашёл по hashCode + equals)
```

## 26.5 Прочие методы Object

```java
p.getClass();         // вернёт Class<?> — рефлексия
p.hashCode();
p.equals(other);
p.toString();

// Для многопоточности (раздел 43+):
p.notify();
p.notifyAll();
p.wait();
```

## Упражнение 26

Класс `Book` с полями `isbn`, `title`, `author`. Два Book равны, если у них одинаковый ISBN.

Создай 3 книги. Положи в HashSet. Проверь `contains`.

### Решение

```java
public class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn; this.title = title; this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book b)) return false;
        return Objects.equals(isbn, b.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" + isbn + " '" + title + "' by " + author + "}";
    }
}

Set<Book> set = new HashSet<>();
set.add(new Book("123", "Java", "Aibek"));
set.add(new Book("456", "SQL", "Madi"));
set.add(new Book("123", "Java (2nd ed)", "Aibek"));   // дубликат по ISBN — не добавится

System.out.println(set.size());   // 2
```

---

# 27. Enum

`enum` — специальный тип для **фиксированного набора** значений.

## 27.1 Базовый enum

```java
public enum Status {
    PENDING, APPROVED, REJECTED, CANCELLED
}

Status s = Status.APPROVED;

if (s == Status.APPROVED) {        // == работает для enum (синглтоны)
    System.out.println("OK");
}

switch (s) {
    case PENDING -> System.out.println("Waiting");
    case APPROVED -> System.out.println("Done");
    case REJECTED, CANCELLED -> System.out.println("Failed");
}
```

## 27.2 Зачем enum

✅ Безопаснее, чем строки или числа:
```java
// Плохо — magic string
order.setStatus("APPROVED");
order.setStatus("APPROVE");   // опечатка — компилятор не заметит

// Хорошо
order.setStatus(Status.APPROVED);
order.setStatus(Status.APPROVE);   // ❌ ошибка компиляции
```

## 27.3 Полезные методы

```java
Status.values();                    // массив всех значений
Status.valueOf("APPROVED");          // строку → enum (NPE если нет)
Status.APPROVED.name();              // "APPROVED"
Status.APPROVED.ordinal();           // 1 — порядковый номер

for (Status s : Status.values()) {
    System.out.println(s);
}
```

## 27.4 Enum с полями и методами

Enum — это, по сути, класс. Можно добавлять конструкторы, поля, методы:

```java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private final double mass;
    private final double radius;

    Planet(double mass, double radius) {       // конструктор всегда private
        this.mass = mass;
        this.radius = radius;
    }

    public double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}

System.out.println(Planet.EARTH.surfaceGravity());
```

## 27.5 Где enum в реальности

- Статусы заказов (`PENDING`, `SHIPPED`, `DELIVERED`).
- Роли пользователей (`USER`, `ADMIN`).
- Дни недели.
- Типы платежей.

## Упражнение 27

Enum `Day`. Метод `isWeekend()` возвращает true для SATURDAY и SUNDAY.

### Решение

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

System.out.println(Day.MONDAY.isWeekend());     // false
System.out.println(Day.SUNDAY.isWeekend());     // true
```

---

# 28. Record (Java 14+)

`record` — короткая запись для **immutable классов-данных**.

## 28.1 Зачем

Стандартный класс с 2 полями — много кода:

```java
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() { return x; }
    public int y() { return y; }

    @Override public boolean equals(Object o) { /* ... */ }
    @Override public int hashCode() { /* ... */ }
    @Override public String toString() { /* ... */ }
}
```

С record — одна строка:

```java
public record Point(int x, int y) {}
```

Java сама генерирует:
- Конструктор `Point(int, int)`.
- Геттеры `x()` и `y()` (без `get`!).
- `equals`, `hashCode` (на основе всех полей).
- `toString` — "Point[x=3, y=4]".

```java
Point p = new Point(3, 4);
System.out.println(p.x());          // 3
System.out.println(p);              // Point[x=3, y=4]

Point p2 = new Point(3, 4);
p.equals(p2);                       // true
```

## 28.2 Кастомные методы и compact constructor

```java
public record Point(int x, int y) {

    // Compact constructor — для валидации
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative");
        }
    }

    // Обычный метод
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Static
    public static Point origin() {
        return new Point(0, 0);
    }
}
```

## 28.3 Ограничения

- Record **immutable** — все поля final.
- Нельзя `extends` другой класс (но можно implements интерфейсы).
- Нельзя добавлять instance-поля помимо тех, что в заголовке.

## 28.4 Когда использовать

✅ DTO (Data Transfer Object) для API.
✅ Value-объекты (Point, Money, Range).
✅ Возврат нескольких значений из метода (вместо массива).

❌ Не используй record там, где нужно изменяемое состояние или сложная логика.

## Упражнение 28

Record `Range(int from, int to)` с валидацией `from <= to`. Метод `contains(int n)` и `length()`.

### Решение

```java
public record Range(int from, int to) {
    public Range {
        if (from > to) {
            throw new IllegalArgumentException("from > to");
        }
    }

    public boolean contains(int n) {
        return n >= from && n <= to;
    }

    public int length() {
        return to - from + 1;
    }
}

Range r = new Range(1, 10);
System.out.println(r.contains(5));   // true
System.out.println(r.length());      // 10
```

---

# Часть VI. Исключения и Generics

# 29. Исключения

Исключение — это объект, представляющий ошибку или нестандартную ситуацию.

## 29.1 Иерархия

```
Throwable
├── Error                        (системные, не ловить)
│   ├── OutOfMemoryError
│   └── StackOverflowError
└── Exception
    ├── IOException              (checked)
    ├── SQLException             (checked)
    ├── ...
    └── RuntimeException         (unchecked)
        ├── NullPointerException
        ├── IllegalArgumentException
        ├── IndexOutOfBoundsException
        ├── ClassCastException
        ├── ArithmeticException
        └── ...
```

## 29.2 Checked vs Unchecked

**Checked** — компилятор требует обработать или declare:
```java
public void readFile() throws IOException {           // declare
    Files.readString(Path.of("file.txt"));
}

public void readFileSafe() {
    try {
        Files.readString(Path.of("file.txt"));        // обработать
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

**Unchecked** (RuntimeException и его потомки) — компилятор не требует:
```java
public void divide(int a, int b) {
    int result = a / b;       // может бросить ArithmeticException
                               // компилятор молчит
}
```

⚠️ В современной Java **многие склоняются к unchecked-исключениям** для бизнес-логики. Spring почти все исключения делает unchecked.

## 29.3 try-catch-finally

```java
try {
    // код, который может бросить исключение
    int[] arr = {1, 2, 3};
    System.out.println(arr[10]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index out of bounds: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Other error: " + e.getMessage());
} finally {
    System.out.println("Always runs");
}
```

`finally` выполнится **всегда** — даже если в try был return или новое исключение.

## 29.4 Multi-catch

```java
try {
    ...
} catch (IOException | SQLException e) {
    log.error("IO or SQL", e);
}
```

## 29.5 try-with-resources

Автоматически закрывает ресурсы (реализующие `AutoCloseable`):

```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(reader.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
// reader.close() вызовется автоматически
```

Несколько ресурсов:
```java
try (FileInputStream in = new FileInputStream("a");
     FileOutputStream out = new FileOutputStream("b")) {
    // ...
}
```

## 29.6 throw

```java
public int divide(int a, int b) {
    if (b == 0) {
        throw new ArithmeticException("Division by zero");
    }
    return a / b;
}
```

## 29.7 throws

```java
public void readFile(String path) throws IOException {
    Files.readString(Path.of(path));
}

// Несколько
public void process() throws IOException, SQLException {
    ...
}
```

## 29.8 Свои исключения

```java
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Использование
public void withdraw(double amount) {
    if (amount > balance) {
        throw new InsufficientFundsException("Balance: " + balance + ", needed: " + amount);
    }
    balance -= amount;
}
```

Лучше наследоваться от `RuntimeException` — не нужно declare в throws.

## 29.9 Best practices

✅ Лови **конкретные** исключения, не `Exception`.
✅ Не глотай: пустой catch — ошибка.
✅ Логируй с контекстом.
✅ Перебрасывай с дополнительным контекстом:

```java
try {
    callExternalApi();
} catch (HttpException e) {
    throw new ServiceException("Failed to load user " + userId, e);
}
```

❌ Не используй исключения для управления потоком:
```java
// ПЛОХО
try {
    int n = Integer.parseInt(s);
    if (n > 0) ...;
} catch (NumberFormatException e) {
    // используем catch как if
}
```

## Упражнение 29

Класс `BankAccount` (по мотивам `Account`). Бросает:
- `InsufficientFundsException` — если withdraw > balance.
- `InvalidAmountException` — если amount <= 0.

Оба наследуют `RuntimeException`. Демонстрация в main с try-catch.

### Решение

```java
public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String msg) { super(msg); }
}

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String msg) { super(msg); }
}

public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount <= 0) throw new InvalidAmountException("Amount must be positive: " + amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new InvalidAmountException("Amount must be positive: " + amount);
        if (amount > balance) throw new InsufficientFundsException("Balance: " + balance);
        balance -= amount;
    }

    public double getBalance() { return balance; }

    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        a.deposit(100);

        try {
            a.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println("Cannot withdraw: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Bad amount: " + e.getMessage());
        }
    }
}
```

---

# 30. Generics

Generics — параметризованные типы. Позволяют писать код, работающий с разными типами без потери типобезопасности.

## 30.1 Зачем

Без generics:
```java
List list = new ArrayList();
list.add("hello");
list.add(42);              // компилятор молчит
String s = (String) list.get(1);   // ⚠️ ClassCastException на runtime
```

С generics:
```java
List<String> list = new ArrayList<>();
list.add("hello");
list.add(42);              // ❌ ошибка компиляции
String s = list.get(0);     // без cast
```

## 30.2 Generic-классы

```java
public class Box<T> {
    private T content;

    public void set(T content) { this.content = content; }
    public T get() { return content; }
}

Box<String> stringBox = new Box<>();
stringBox.set("Hello");
String s = stringBox.get();           // тип известен компилятору

Box<Integer> intBox = new Box<>();
intBox.set(42);
```

`<>` — diamond operator (Java 7+). Не нужно повторять тип справа.

## 30.3 Несколько параметров

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) { this.key = key; this.value = value; }
    public K getKey() { return key; }
    public V getValue() { return value; }
}

Pair<String, Integer> p = new Pair<>("age", 25);
```

Конвенции:
- `T` — Type
- `E` — Element
- `K`, `V` — Key, Value
- `R` — Return type

## 30.4 Generic-методы

```java
public class Util {
    public static <T> T firstElement(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }

    public static <T> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}

String s = Util.firstElement(List.of("a", "b"));
Integer i = Util.firstElement(List.of(1, 2));
```

## 30.5 Bounded type parameter

Ограничение типа:

```java
public static <T extends Number> double sum(List<T> list) {
    double total = 0;
    for (T n : list) total += n.doubleValue();    // могу вызвать методы Number
    return total;
}

sum(List.of(1, 2, 3));          // OK
sum(List.of(1.0, 2.5));         // OK
sum(List.of("a", "b"));         // ❌ String не extends Number
```

Несколько ограничений:
```java
<T extends Number & Comparable<T>>
```

## 30.6 Wildcards

`?` — "неизвестный тип".

```java
public static void printList(List<?> list) {
    for (Object o : list) System.out.println(o);
}

printList(List.of(1, 2, 3));        // OK
printList(List.of("a", "b"));       // OK
```

### `? extends T` — upper bound (можно читать)

```java
public static double sum(List<? extends Number> list) {
    double total = 0;
    for (Number n : list) total += n.doubleValue();
    return total;
}

sum(List.of(1, 2, 3));           // List<Integer> — extends Number — OK
sum(List.of(1.0, 2.0));          // List<Double> — OK
```

### `? super T` — lower bound (можно писать)

```java
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}

List<Number> numbers = new ArrayList<>();
addNumbers(numbers);              // Number — super Integer — OK

List<Object> objects = new ArrayList<>();
addNumbers(objects);              // Object — super — OK
```

## 30.7 PECS — мнемоника

**P**roducer **E**xtends, **C**onsumer **S**uper.

- Если коллекция **производит** значения (читаешь из неё) → `extends`.
- Если коллекция **потребляет** значения (пишешь в неё) → `super`.

```java
public static <T> void copy(List<? extends T> src,    // читаем из src
                            List<? super T> dst) {    // пишем в dst
    for (T item : src) dst.add(item);
}
```

## 30.8 Type erasure

⚠️ В runtime информация о generics стирается. После компиляции `List<String>` становится просто `List`.

```java
List<String> list1 = new ArrayList<>();
List<Integer> list2 = new ArrayList<>();
System.out.println(list1.getClass() == list2.getClass());  // true!
```

Следствия:
- Нельзя сделать `new T()` или `new T[5]`.
- Нельзя `if (obj instanceof List<String>)` — только `instanceof List`.

Для большинства задач джуна это не критично, просто помни.

## Упражнение 30

1. Generic-класс `Stack<T>` с методами `push`, `pop`, `peek`, `isEmpty`, `size`. Хранит элементы в `ArrayList<T>`.

2. Generic-метод `<T> List<T> reverse(List<T> list)` — возвращает новый список в обратном порядке.

3. Generic-метод `<T extends Comparable<T>> T max(List<T> list)` — находит максимум.

### Решение

```java
public class Stack<T> {
    private final List<T> data = new ArrayList<>();

    public void push(T item) { data.add(item); }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data.remove(data.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() { return data.isEmpty(); }
    public int size() { return data.size(); }
}

public static <T> List<T> reverse(List<T> list) {
    List<T> result = new ArrayList<>(list.size());
    for (int i = list.size() - 1; i >= 0; i--) {
        result.add(list.get(i));
    }
    return result;
}

public static <T extends Comparable<T>> T max(List<T> list) {
    if (list.isEmpty()) throw new IllegalArgumentException("empty");
    T max = list.get(0);
    for (T item : list) {
        if (item.compareTo(max) > 0) max = item;
    }
    return max;
}
```

---

# Часть VII. Collections Framework

Самая важная часть для собеса. Без коллекций — никуда.

# 31. Обзор и Iterable

## 31.1 Иерархия

```
Iterable<E>
└── Collection<E>
    ├── List<E>              упорядоченные, дубликаты разрешены
    │   ├── ArrayList
    │   └── LinkedList
    ├── Set<E>               без дубликатов
    │   ├── HashSet
    │   ├── LinkedHashSet
    │   └── TreeSet
    └── Queue<E>             очередь
        ├── LinkedList
        ├── ArrayDeque
        └── PriorityQueue

Map<K, V>                    ключ → значение, отдельная иерархия
├── HashMap
├── LinkedHashMap
├── TreeMap
└── ConcurrentHashMap
```

## 31.2 Iterable

Интерфейс `Iterable<E>` — "по мне можно пройтись циклом for-each":

```java
for (String s : list) {        // работает потому что List → Collection → Iterable
    ...
}
```

Свой класс можешь сделать iterable, реализовав `Iterable<E>` и метод `iterator()`. Это редко.

## 31.3 Создание immutable коллекции (Java 9+)

```java
List<Integer> list = List.of(1, 2, 3);
Set<String> set = Set.of("a", "b", "c");
Map<String, Integer> map = Map.of("a", 1, "b", 2);

// Большие
Map<String, Integer> bigMap = Map.ofEntries(
    Map.entry("a", 1),
    Map.entry("b", 2),
    Map.entry("c", 3)
);
```

⚠️ `List.of(...)` возвращает **immutable** коллекцию — `add` бросит `UnsupportedOperationException`.

Чтобы получить mutable копию:
```java
List<Integer> mutable = new ArrayList<>(List.of(1, 2, 3));
```

---

# 32. List: ArrayList и LinkedList

## 32.1 Общий API List

```java
List<String> list = new ArrayList<>();

list.add("apple");                 // добавить в конец
list.add(0, "cherry");             // вставить по индексу
list.addAll(List.of("a", "b"));    // добавить много

list.get(0);                        // по индексу
list.set(1, "blueberry");          // заменить
list.remove(0);                     // удалить по индексу
list.remove("apple");               // удалить по значению (первое совпадение)
list.removeIf(s -> s.startsWith("a"));   // условное удаление

list.size();
list.isEmpty();
list.contains("banana");
list.indexOf("banana");
list.lastIndexOf("banana");

list.clear();                       // очистить

// Перебор
for (String s : list) System.out.println(s);

list.forEach(System.out::println);   // через лямбду

for (int i = 0; i < list.size(); i++) {
    System.out.println(i + ": " + list.get(i));
}
```

## 32.2 ArrayList

Под капотом — **массив** с автоматическим увеличением.

| Операция | Сложность |
|---|---|
| `get(i)` | **O(1)** |
| `add(end)` | O(1) amortized |
| `add(i)` | O(n) — нужно сдвинуть |
| `remove(i)` | O(n) |
| `contains(x)` | O(n) |

Когда увеличивает:
- Начальный размер — 10.
- При заполнении создаёт новый массив **в 1.5 раза больше**, копирует.

Если знаешь размер заранее:
```java
List<Integer> list = new ArrayList<>(1000);   // initial capacity
```

## 32.3 LinkedList

Двусвязный список:

```
[head] ← node1 ↔ node2 ↔ node3 → [tail]
```

| Операция | Сложность |
|---|---|
| `get(i)` | O(n) — идти от начала |
| `add(end)`, `addFirst()` | O(1) |
| `add(i)` | O(n) поиск + O(1) вставка |
| `remove(i)` | O(n) поиск + O(1) удаление |

Также реализует `Deque` (двустороннюю очередь), есть методы `addFirst`, `addLast`, `removeFirst`, `removeLast`.

## 32.4 ArrayList vs LinkedList — что выбрать

**Почти всегда — ArrayList.** Он быстрее на практике, занимает меньше памяти.

LinkedList имеет смысл только если очень часто добавляешь/удаляешь в начало или середину **и** редко делаешь get по индексу. Но для "очереди" лучше `ArrayDeque`, а не LinkedList.

## 32.5 Особенности

### List.subList

```java
List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
List<Integer> sub = nums.subList(1, 4);    // [2, 3, 4]
```

⚠️ `subList` — это **view** на оригинал. Изменения в нём отражаются в исходном!

### Сортировка

```java
List<Integer> nums = new ArrayList<>(List.of(3, 1, 4, 1, 5));
Collections.sort(nums);                              // [1, 1, 3, 4, 5]
nums.sort(Comparator.naturalOrder());                // то же
nums.sort(Comparator.reverseOrder());                // [5, 4, 3, 1, 1]
```

Для своих классов нужен `Comparable` или `Comparator` (раздел 36).

## Упражнения 32

### 32.1
Дан List<Integer>. Удалить все чётные числа (in place).

### 32.2
Слить два отсортированных списка в третий отсортированный (без `Collections.sort`).

### 32.3
Найти пересечение двух списков (элементы, есть в обоих).

### Решения

```java
// 32.1
List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
nums.removeIf(n -> n % 2 == 0);
// [1, 3, 5]

// 32.2
public static List<Integer> merge(List<Integer> a, List<Integer> b) {
    List<Integer> result = new ArrayList<>(a.size() + b.size());
    int i = 0, j = 0;
    while (i < a.size() && j < b.size()) {
        if (a.get(i) <= b.get(j)) result.add(a.get(i++));
        else result.add(b.get(j++));
    }
    while (i < a.size()) result.add(a.get(i++));
    while (j < b.size()) result.add(b.get(j++));
    return result;
}

// 32.3
List<Integer> a = List.of(1, 2, 3, 4, 5);
List<Integer> b = List.of(3, 4, 5, 6, 7);
Set<Integer> setA = new HashSet<>(a);
List<Integer> intersection = new ArrayList<>();
for (Integer x : b) {
    if (setA.contains(x)) intersection.add(x);
}
// [3, 4, 5]
```

---

# 33. Set: HashSet, TreeSet, LinkedHashSet

`Set` — коллекция **без дубликатов**. Нет порядка (зависит от реализации).

## 33.1 Общий API

```java
Set<String> set = new HashSet<>();

set.add("apple");
set.add("apple");           // дубликат — не добавится
set.contains("apple");      // true
set.remove("apple");
set.size();
set.isEmpty();

// Множественные операции
set.addAll(other);          // объединение
set.retainAll(other);       // пересечение (this ∩ other, in place)
set.removeAll(other);       // разность (this \ other, in place)
```

## 33.2 HashSet

Под капотом — `HashMap`. Самый быстрый.

| Операция | Сложность |
|---|---|
| `add` | O(1) |
| `contains` | O(1) |
| `remove` | O(1) |

⚠️ **Порядок не гарантирован.** Может меняться даже между запусками.

Требует **корректные `equals` и `hashCode`** у элементов.

## 33.3 TreeSet

Хранит элементы **отсортированно**.

| Операция | Сложность |
|---|---|
| `add` | O(log n) |
| `contains` | O(log n) |

```java
Set<Integer> set = new TreeSet<>();
set.add(5); set.add(1); set.add(3);
// Перебор: 1, 3, 5

TreeSet<Integer> ts = new TreeSet<>();
ts.first();      // минимум
ts.last();       // максимум
ts.headSet(3);   // элементы < 3
ts.tailSet(3);   // элементы >= 3
ts.subSet(1, 4); // [1, 4)
```

Элементы должны быть `Comparable` или нужен `Comparator` в конструкторе.

## 33.4 LinkedHashSet

`HashSet` + сохраняет **порядок добавления**.

```java
Set<Integer> set = new LinkedHashSet<>();
set.add(5); set.add(1); set.add(3); set.add(1);
// Перебор: 5, 1, 3 (1 второй раз игнорируется)
```

Удобно, когда хочешь дедупликацию **с сохранением порядка**.

## 33.5 Когда что использовать

| Нужно | Используй |
|---|---|
| Просто без дубликатов, быстро | `HashSet` |
| Без дубликатов, с порядком вставки | `LinkedHashSet` |
| Отсортированно | `TreeSet` |

## Упражнение 33

Дан List<String>. Получить уникальные строки **в порядке появления**.

```java
List<String> input = List.of("apple", "banana", "apple", "cherry", "banana");
// Ожидание: ["apple", "banana", "cherry"]
```

### Решение

```java
Set<String> seen = new LinkedHashSet<>(input);
List<String> unique = new ArrayList<>(seen);
// или одной строкой:
List<String> unique = new ArrayList<>(new LinkedHashSet<>(input));
```

---

# 34. Map: HashMap, TreeMap, LinkedHashMap

Map — отображение ключ → значение. Самая часто используемая структура в реальной разработке.

## 34.1 Общий API

```java
Map<String, Integer> ages = new HashMap<>();

ages.put("Aibek", 25);
ages.put("Madi", 30);
ages.put("Aibek", 26);              // перезапишет

ages.get("Aibek");                  // 26
ages.get("NotExisting");            // null
ages.getOrDefault("NotExisting", 0); // 0

ages.containsKey("Aibek");
ages.containsValue(30);

ages.remove("Aibek");
ages.size();
ages.isEmpty();
ages.clear();

// Перебор
for (Map.Entry<String, Integer> e : ages.entrySet()) {
    System.out.println(e.getKey() + " -> " + e.getValue());
}

for (String key : ages.keySet()) { ... }
for (Integer val : ages.values()) { ... }

ages.forEach((k, v) -> System.out.println(k + " -> " + v));
```

## 34.2 Полезные методы Java 8+

### putIfAbsent

```java
ages.putIfAbsent("Aibek", 25);    // только если ещё нет
```

### compute, computeIfAbsent, computeIfPresent

```java
// Создать/обновить значение через функцию
ages.compute("Aibek", (k, v) -> (v == null) ? 1 : v + 1);

// Создать только если нет
Map<String, List<String>> groups = new HashMap<>();
groups.computeIfAbsent("group1", k -> new ArrayList<>()).add("user1");

// Обновить только если есть
ages.computeIfPresent("Aibek", (k, v) -> v + 1);
```

### merge — частая операция при счётчиках

```java
Map<String, Integer> count = new HashMap<>();
String[] words = {"apple", "banana", "apple", "cherry", "apple"};
for (String w : words) {
    count.merge(w, 1, Integer::sum);
    // если ключа нет — поставит 1
    // если есть — старое значение + 1
}
// {apple=3, banana=1, cherry=1}
```

## 34.3 HashMap

Самая частая. O(1) для get/put/remove.

⚠️ **Порядок не гарантирован.**

## 34.4 TreeMap

Отсортированная по ключам. O(log n).

```java
TreeMap<String, Integer> tm = new TreeMap<>();
tm.put("c", 3); tm.put("a", 1); tm.put("b", 2);
// Перебор: a, b, c

tm.firstKey();          // "a"
tm.lastKey();            // "c"
tm.floorKey("b");        // "b" (≤ b)
tm.ceilingKey("b");      // "b" (≥ b)
```

## 34.5 LinkedHashMap

`HashMap` + сохраняет порядок вставки. O(1).

```java
Map<String, Integer> map = new LinkedHashMap<>();
map.put("c", 3); map.put("a", 1); map.put("b", 2);
// Перебор: c, a, b
```

Используется для построения LRU-кэша.

## 34.6 Когда что

| Нужно | Используй |
|---|---|
| Просто, быстро | `HashMap` |
| Сохранить порядок вставки | `LinkedHashMap` |
| Отсортированные ключи | `TreeMap` |

## 34.7 Null'ы в Map

| Map | null key | null value |
|---|---|---|
| `HashMap` | да (один) | да |
| `LinkedHashMap` | да | да |
| `TreeMap` | нет (NPE) | да |
| `Hashtable` (legacy) | нет | нет |

## Упражнения 34

### 34.1
Дан текст. Подсчитай частоту каждого слова. Слова — через пробел.

### 34.2
Дан список заказов `Order(userId, amount)`. Сгруппируй по userId, посчитай сумму.

### 34.3
Удали из Map все записи, где значение < 10.

### Решения

```java
// 34.1
String text = "apple banana apple cherry banana apple";
Map<String, Integer> count = new HashMap<>();
for (String word : text.split("\\s+")) {
    count.merge(word, 1, Integer::sum);
}
// {apple=3, banana=2, cherry=1}

// 34.2
record Order(long userId, double amount) {}

List<Order> orders = List.of(
    new Order(1, 100),
    new Order(1, 200),
    new Order(2, 500),
    new Order(2, 50)
);

Map<Long, Double> totals = new HashMap<>();
for (Order o : orders) {
    totals.merge(o.userId(), o.amount(), Double::sum);
}
// {1=300.0, 2=550.0}

// 34.3
Map<String, Integer> map = new HashMap<>();
map.put("a", 5); map.put("b", 15); map.put("c", 8);
map.entrySet().removeIf(e -> e.getValue() < 10);
// {b=15}
```

---

# 35. Queue, Deque, Stack

## 35.1 Queue — очередь (FIFO)

First In First Out — первый вошёл, первый вышел.

```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);     // добавить
queue.offer(2);
queue.offer(3);

queue.peek();        // 1 — посмотреть голову, не удаляя
queue.poll();        // 1 — удалить и вернуть голову
queue.poll();        // 2
queue.size();        // 1
```

`offer` vs `add`: `offer` возвращает false если очередь полная, `add` бросает исключение.

## 35.2 Deque — двусторонняя очередь

```java
Deque<Integer> dq = new ArrayDeque<>();

dq.offerFirst(1);
dq.offerLast(2);
dq.peekFirst();
dq.peekLast();
dq.pollFirst();
dq.pollLast();
```

## 35.3 Stack — стек (LIFO)

Last In First Out. В Java для стека **используй `Deque`**, не legacy `Stack`:

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);
stack.push(2);
stack.push(3);

stack.peek();    // 3 — верх
stack.pop();     // 3
stack.pop();     // 2
```

⚠️ Класс `java.util.Stack` существует, но он legacy и медленный. Не используй.

## 35.4 PriorityQueue

Очередь с приоритетом — выходит **минимум** (по компаратору).

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(3); pq.offer(1); pq.offer(2);
pq.poll();       // 1
pq.poll();       // 2
pq.poll();       // 3

// С компаратором — обратный порядок
PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
```

Используется для алгоритмов "топ-K", Dijkstra и т.п.

## Упражнение 35

Реализуй простой парсер скобок: проверка, корректные ли скобки в строке.
`"(()())"` → true, `"(()"` → false, `"([)]"` → false.

### Решение

```java
public static boolean isBalanced(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else if (c == ')' || c == ']' || c == '}') {
            if (stack.isEmpty()) return false;
            char open = stack.pop();
            if (c == ')' && open != '(') return false;
            if (c == ']' && open != '[') return false;
            if (c == '}' && open != '{') return false;
        }
    }
    return stack.isEmpty();
}
```

---

# 36. Comparator и сортировка

## 36.1 Comparable

Интерфейс с одним методом `compareTo(T other)`. Реализуй, если есть **естественный порядок**:

```java
public class Product implements Comparable<Product> {
    private String name;
    private double price;

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
}

List<Product> list = new ArrayList<>();
Collections.sort(list);            // по compareTo
list.sort(null);                    // то же
```

`compareTo` возвращает:
- 0 — равны
- < 0 — текущий меньше
- > 0 — текущий больше

⚠️ Не используй `this.price - other.price` для double / для int с возможностью переполнения. Используй `Double.compare`, `Integer.compare`.

## 36.2 Comparator

Внешний компаратор. Используется, когда:
- Класс не реализует `Comparable`.
- Нужна **другая** сортировка, не "естественная".

```java
Comparator<Product> byName = (p1, p2) -> p1.getName().compareTo(p2.getName());
list.sort(byName);
```

## 36.3 Comparator.comparing — современный способ

```java
list.sort(Comparator.comparing(Product::getName));
list.sort(Comparator.comparing(Product::getPrice).reversed());

// Несколько критериев
list.sort(Comparator
    .comparing(Product::getCategory)
    .thenComparing(Product::getPrice)
    .thenComparing(Product::getName));

// Null-safe
list.sort(Comparator.comparing(Product::getName, Comparator.nullsLast(Comparator.naturalOrder())));
```

## 36.4 Стабильная сортировка

`Collections.sort` и `list.sort` — **стабильные**. То есть равные по компаратору элементы остаются в том же порядке.

## Упражнение 36

Класс `Employee` с `name`, `salary`, `department`. Отсортируй:
1. По зарплате (по возрастанию).
2. По department, затем по зарплате (убывание).
3. По длине имени.

### Решение

```java
record Employee(String name, double salary, String department) {}

List<Employee> employees = ...;

// 1
employees.sort(Comparator.comparingDouble(Employee::salary));

// 2
employees.sort(Comparator
    .comparing(Employee::department)
    .thenComparing(Comparator.comparingDouble(Employee::salary).reversed()));

// 3
employees.sort(Comparator.comparingInt(e -> e.name().length()));
```

---

# 37. Как работает HashMap внутри

Самый частый вопрос на собесе. Разбираем.

## 37.1 Структура

```
buckets:                    bucket — это связный список (или дерево)
[ 0 ] → null
[ 1 ] → Node{key, value, next} → Node → null
[ 2 ] → null
[ 3 ] → Node
...
[15] → Node → Node
```

В Java 8+ `HashMap` — массив `Node[]`, где Node:
```java
class Node<K, V> {
    final int hash;
    final K key;
    V value;
    Node<K, V> next;     // для цепочки при коллизии
}
```

## 37.2 put(key, value)

```
1. Считается hash от key:           int h = key.hashCode();
                                     hash = h ^ (h >>> 16);   // дополнительное перемешивание
2. Бакет:                            int index = (table.length - 1) & hash;
3. Если в бакете пусто               кладём Node
4. Если бакет занят (коллизия):
   - Ищем по цепочке Node с таким же ключом (через .equals())
   - Если нашли — заменяем value
   - Если нет — добавляем в конец цепочки
5. Если bucket стал слишком длинным (>= 8 элементов и таблица >= 64)
   — связный список превращается в КРАСНО-ЧЁРНОЕ ДЕРЕВО (treeify)
6. Если общая загрузка >= 0.75 (load factor) — RESIZE:
   - Создаётся таблица в 2 раза больше
   - Все элементы перехэшируются
```

## 37.3 get(key)

```
1. Считается hash от key.
2. Находится индекс бакета.
3. Если бакет пуст — null.
4. Если занят — ищется по цепочке через .equals().
   - Если первый сразу подошёл — возврат за O(1).
   - Если коллизий много — за O(длина цепочки).
   - Если уже дерево — за O(log n).
```

## 37.4 Сложность

| Случай | Время |
|---|---|
| Лучший / средний | **O(1)** |
| Худший (все коллизии в один бакет) | O(log n) — благодаря treeify |

В реальности почти всегда O(1).

## 37.5 Зачем equals + hashCode

```java
// Если у Person кривой hashCode, который всегда возвращает одно число:
Map<Person, String> map = new HashMap<>();
map.put(new Person("Aibek"), "a");
map.put(new Person("Madi"), "b");
// Все попадают в один бакет — производительность O(n)
```

```java
// Если у Person кривой equals (всегда true):
map.put(new Person("Aibek"), "a");
map.put(new Person("Madi"), "b");
map.size();   // 1 — Madi затёр Aibek (потому что equals считает их одинаковыми)
```

**Контракт:** equal-объекты должны иметь равный hashCode. Не наоборот.

## 37.6 Initial capacity и load factor

```java
new HashMap<>();              // initial capacity = 16, load factor = 0.75
new HashMap<>(64);            // initial capacity = 64
new HashMap<>(64, 0.5f);       // capacity 64, load factor 0.5
```

Load factor — когда заполнено на 75% — таблица удваивается. Это компромисс между памятью и скоростью.

Если знаешь количество элементов:
```java
int expected = 1000;
Map<String, String> map = new HashMap<>(expected * 4 / 3);  // чтобы избежать resize
```

## 37.7 Concurrent

⚠️ **HashMap НЕ потокобезопасный.** Если используешь из нескольких потоков — `ConcurrentHashMap` (раздел 46).

---

# Часть VIII. Функциональное программирование

# 38. Лямбды и функциональные интерфейсы

## 38.1 Что такое лямбда

Лямбда — короткая запись для **анонимной функции**.

До Java 8:
```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};
new Thread(r).start();
```

С Java 8 (лямбда):
```java
Runnable r = () -> System.out.println("Hello");
new Thread(r).start();
```

## 38.2 Синтаксис лямбды

```java
() -> 42                                     // без параметров
x -> x * 2                                    // один параметр (скобки опциональны)
(x, y) -> x + y                               // несколько параметров

// С блоком и явным return
(x, y) -> {
    int sum = x + y;
    return sum;
}

// С указанием типов
(int x, int y) -> x + y                       // обычно тип выводится
```

## 38.3 Функциональный интерфейс

Лямбда работает только там, где ожидается **функциональный интерфейс** — интерфейс с **одним абстрактным методом**.

```java
@FunctionalInterface
public interface Action {
    void execute();
}

Action a = () -> System.out.println("running");
a.execute();
```

`@FunctionalInterface` — опциональная аннотация, проверяющая что у интерфейса ровно один абстрактный метод.

## 38.4 Стандартные функциональные интерфейсы

В пакете `java.util.function`:

| Интерфейс | Метод | Назначение |
|---|---|---|
| `Function<T, R>` | `R apply(T t)` | T → R |
| `BiFunction<T, U, R>` | `R apply(T t, U u)` | T, U → R |
| `Predicate<T>` | `boolean test(T t)` | T → boolean |
| `BiPredicate<T, U>` | `boolean test(T, U)` | T, U → boolean |
| `Consumer<T>` | `void accept(T t)` | T → ничего |
| `BiConsumer<T, U>` | `void accept(T, U)` | T, U → ничего |
| `Supplier<T>` | `T get()` | ничего → T |
| `UnaryOperator<T>` | `T apply(T t)` | T → T |
| `BinaryOperator<T>` | `T apply(T, T)` | T, T → T |

## 38.5 Примеры

```java
import java.util.function.*;

// Function<T, R>
Function<String, Integer> length = s -> s.length();
System.out.println(length.apply("Hello"));        // 5

// Predicate<T>
Predicate<Integer> isPositive = n -> n > 0;
System.out.println(isPositive.test(5));            // true
System.out.println(isPositive.test(-1));           // false

// Consumer<T>
Consumer<String> print = s -> System.out.println(s);
print.accept("Hello");

// Supplier<T>
Supplier<Double> rnd = () -> Math.random();
System.out.println(rnd.get());

// BiFunction<T, U, R>
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
System.out.println(add.apply(2, 3));               // 5
```

## 38.6 Композиция

```java
Function<Integer, Integer> plus3 = x -> x + 3;
Function<Integer, Integer> times2 = x -> x * 2;

// andThen — сначала this, потом аргумент
Function<Integer, Integer> f = plus3.andThen(times2);
System.out.println(f.apply(5));    // (5 + 3) * 2 = 16

// compose — наоборот
Function<Integer, Integer> g = plus3.compose(times2);
System.out.println(g.apply(5));    // (5 * 2) + 3 = 13

// Predicate
Predicate<Integer> isPositive = n -> n > 0;
Predicate<Integer> isEven = n -> n % 2 == 0;
Predicate<Integer> isPosEven = isPositive.and(isEven);
Predicate<Integer> isPosOrEven = isPositive.or(isEven);
Predicate<Integer> isNotPositive = isPositive.negate();
```

## 38.7 Захват переменных

Лямбда может использовать переменные из окружающего scope, **но они должны быть effectively final** (не должны меняться после захвата):

```java
int x = 10;
Runnable r = () -> System.out.println(x);   // OK
// x = 20;   // ❌ если раскомментить, лямбда сломается

List<Integer> list = new ArrayList<>();
Runnable r2 = () -> list.add(1);            // OK — изменяем содержимое, не саму ссылку
```

---

# 39. Method references

`::` — короткая запись для лямбды, которая просто вызывает метод.

## 39.1 Виды

```java
// 1. Static method reference
Function<String, Integer> parse = Integer::parseInt;
// эквивалент: s -> Integer.parseInt(s)

// 2. Instance method of specific object
String s = "Hello";
Supplier<Integer> len = s::length;
// эквивалент: () -> s.length()

// 3. Instance method of arbitrary object of class
Function<String, Integer> length = String::length;
// эквивалент: s -> s.length()

// 4. Constructor reference
Supplier<List<String>> listSupplier = ArrayList::new;
// эквивалент: () -> new ArrayList<String>()

Function<Integer, List<String>> sized = ArrayList::new;
// эквивалент: cap -> new ArrayList<>(cap)
```

## 39.2 Когда использовать

✅ Когда лямбда — это просто прямой вызов метода:

```java
list.forEach(System.out::println);            // вместо x -> System.out.println(x)
list.stream().map(String::trim);              // вместо s -> s.trim()
list.stream().mapToInt(Integer::parseInt);    // вместо s -> Integer.parseInt(s)
```

❌ Когда лямбда делает что-то сложнее — пиши лямбду.

---

# 40. Stream API

Stream API — мощный инструмент для **обработки коллекций**. Часто заменяет циклы.

## 40.1 Что такое Stream

**НЕ коллекция.** Это последовательность элементов с операциями над ними.

- Не хранит данные.
- Не изменяет источник.
- Lazy — операции выполняются только при terminal-операции.
- Можно использовать **только один раз**.

## 40.2 Создание стрима

```java
// Из коллекции
list.stream();
list.parallelStream();         // параллельный

// Из массива
Arrays.stream(arr);

// Литералы
Stream.of(1, 2, 3);

// Бесконечные
Stream.iterate(1, n -> n + 1);     // 1, 2, 3, ...
Stream.generate(Math::random);      // случайные

// Из строки
"abc".chars();                  // IntStream

// Range
IntStream.range(0, 10);         // 0..9
IntStream.rangeClosed(1, 10);   // 1..10
```

## 40.3 Pipeline: source → intermediate → terminal

```
source         intermediate ops                    terminal op
list.stream()  .filter(...)  .map(...)  .sorted()  .toList()
```

Промежуточные (intermediate) — возвращают Stream, lazy.
Терминальные (terminal) — возвращают результат, запускают pipeline.

## 40.4 Intermediate-операции

### filter — оставить элементы по условию

```java
List<Integer> evens = List.of(1, 2, 3, 4, 5).stream()
    .filter(n -> n % 2 == 0)
    .toList();    // [2, 4]
```

### map — преобразовать каждый элемент

```java
List<Integer> lengths = List.of("apple", "banana").stream()
    .map(String::length)
    .toList();    // [5, 6]

List<String> upper = List.of("hello", "world").stream()
    .map(String::toUpperCase)
    .toList();    // ["HELLO", "WORLD"]
```

### flatMap — превращает Stream<Stream<T>> в Stream<T>

```java
List<List<Integer>> nested = List.of(
    List.of(1, 2, 3),
    List.of(4, 5),
    List.of(6, 7, 8, 9)
);

List<Integer> flat = nested.stream()
    .flatMap(List::stream)
    .toList();    // [1, 2, 3, 4, 5, 6, 7, 8, 9]
```

### distinct — уникальные

```java
List<Integer> unique = List.of(1, 2, 2, 3, 3, 3).stream()
    .distinct()
    .toList();    // [1, 2, 3]
```

### sorted — сортировка

```java
List<Integer> sorted = List.of(3, 1, 4, 1, 5).stream()
    .sorted()
    .toList();    // [1, 1, 3, 4, 5]

List<String> sortedByLength = List.of("ccc", "a", "bb").stream()
    .sorted(Comparator.comparingInt(String::length))
    .toList();    // ["a", "bb", "ccc"]
```

### limit, skip

```java
Stream.iterate(1, n -> n + 1)
    .skip(5)
    .limit(3)
    .toList();    // [6, 7, 8]
```

### peek — подсмотреть (для отладки)

```java
list.stream()
    .peek(x -> System.out.println("before: " + x))
    .map(...)
    .peek(x -> System.out.println("after: " + x))
    .toList();
```

## 40.5 Terminal-операции

### toList, toSet, toArray

```java
List<Integer> list = stream.toList();              // immutable
Set<Integer> set = stream.collect(Collectors.toSet());
Integer[] arr = stream.toArray(Integer[]::new);
```

### collect — гибкая сборка (раздел 41)

### count

```java
long n = list.stream().filter(x -> x > 0).count();
```

### anyMatch, allMatch, noneMatch

```java
boolean any = list.stream().anyMatch(x -> x > 10);
boolean all = list.stream().allMatch(x -> x > 0);
boolean none = list.stream().noneMatch(x -> x < 0);
```

### findFirst, findAny

```java
Optional<Integer> first = list.stream()
    .filter(x -> x > 5)
    .findFirst();
```

### reduce — свёртка

```java
// Сумма
int sum = list.stream().reduce(0, Integer::sum);
// или
int sum = list.stream().mapToInt(Integer::intValue).sum();

// Максимум
Optional<Integer> max = list.stream().reduce(Integer::max);

// Конкатенация
String result = words.stream().reduce("", (a, b) -> a + b);
```

### forEach

```java
list.stream().forEach(System.out::println);
```

### min, max

```java
Optional<Integer> max = list.stream().max(Integer::compareTo);
Optional<Product> mostExpensive = products.stream()
    .max(Comparator.comparing(Product::getPrice));
```

## 40.6 Специализированные Stream'ы

`IntStream`, `LongStream`, `DoubleStream` — для примитивов, без auto-boxing:

```java
int sum = IntStream.rangeClosed(1, 100).sum();      // 5050
double avg = IntStream.of(1, 2, 3).average().getAsDouble();
int max = IntStream.of(1, 2, 3).max().getAsInt();

// Stream<Integer> → IntStream
list.stream().mapToInt(Integer::intValue).sum();

// IntStream → Stream<Integer>
IntStream.rangeClosed(1, 10).boxed();
```

## 40.7 Параллельные стримы

```java
list.parallelStream()
    .filter(...)
    .map(...)
    .toList();
```

⚠️ Не используй просто потому что "может быть быстрее". У parallel Stream много подводных камней:
- Накладные расходы на распараллеливание могут перевесить выигрыш.
- Не работает с коллекциями, чувствительными к порядку.
- Может багать с shared state.

---

# 41. Collectors

`Collectors` — утилитный класс для terminal-операции `collect()`.

## 41.1 Базовые

```java
import static java.util.stream.Collectors.*;

// В список
List<Integer> list = stream.collect(toList());        // изменяемый
List<Integer> list2 = stream.toList();                // immutable (Java 16+)

// В set
Set<Integer> set = stream.collect(toSet());

// В Map
Map<Long, Product> byId = products.stream()
    .collect(toMap(Product::getId, p -> p));

// Если ключ может повторяться — обработка коллизий
Map<String, Double> totalByCategory = products.stream()
    .collect(toMap(
        Product::getCategory,
        Product::getPrice,
        Double::sum));     // если ключ повторился — суммировать значения
```

## 41.2 joining

```java
String joined = words.stream().collect(joining());                // "abcdef"
String csv = words.stream().collect(joining(", "));               // "a, b, c"
String pretty = words.stream().collect(joining(", ", "[", "]"));  // "[a, b, c]"
```

## 41.3 groupingBy — самый частый

```java
// По одному ключу
Map<String, List<Product>> byCategory = products.stream()
    .collect(groupingBy(Product::getCategory));

// С counting
Map<String, Long> countByCategory = products.stream()
    .collect(groupingBy(Product::getCategory, counting()));

// С summing
Map<String, Double> totalByCategory = products.stream()
    .collect(groupingBy(Product::getCategory, summingDouble(Product::getPrice)));

// С averaging
Map<String, Double> avgByCategory = products.stream()
    .collect(groupingBy(Product::getCategory, averagingDouble(Product::getPrice)));

// Двойная группировка
Map<String, Map<Boolean, List<Product>>> doubled = products.stream()
    .collect(groupingBy(
        Product::getCategory,
        groupingBy(p -> p.getPrice() > 100)));
```

## 41.4 partitioningBy — групирует на 2 части

```java
Map<Boolean, List<Integer>> parts = nums.stream()
    .collect(partitioningBy(n -> n > 0));
// {true=[positive], false=[non-positive]}
```

## 41.5 Прочие

```java
// Сумма
int sum = nums.stream().collect(summingInt(Integer::intValue));

// Среднее
double avg = nums.stream().collect(averagingInt(Integer::intValue));

// Мин/Макс
Optional<Integer> max = nums.stream().collect(maxBy(Integer::compareTo));
```

## 41.6 Полный пример

```java
record Order(long userId, String category, double amount) {}

List<Order> orders = List.of(
    new Order(1, "books", 100),
    new Order(1, "books", 50),
    new Order(1, "tech", 1000),
    new Order(2, "books", 200),
    new Order(2, "tech", 500)
);

// Сумма по userId
Map<Long, Double> totalByUser = orders.stream()
    .collect(groupingBy(Order::userId, summingDouble(Order::amount)));
// {1=1150.0, 2=700.0}

// Категория -> топ-3 заказа
Map<String, List<Order>> top3 = orders.stream()
    .collect(groupingBy(
        Order::category,
        collectingAndThen(
            toList(),
            list -> list.stream()
                .sorted(Comparator.comparingDouble(Order::amount).reversed())
                .limit(3)
                .toList()
        )
    ));
```

## Упражнения 40-41

### 40.1
Дан список Integer. Найти сумму квадратов чётных чисел.

### 40.2
Дан List<String>. Получить список длин уникальных слов, отсортированных по убыванию.

### 40.3
Дан `List<Order>` (см. выше). Найти топ-3 пользователей по сумме заказов.

### 40.4
Дан List<String>. Получить Map: длина → список слов этой длины.

### Решения

```java
// 40.1
int result = nums.stream()
    .filter(n -> n % 2 == 0)
    .mapToInt(n -> n * n)
    .sum();

// 40.2
List<Integer> result = words.stream()
    .distinct()
    .map(String::length)
    .sorted(Comparator.reverseOrder())
    .toList();

// 40.3
List<Long> top3 = orders.stream()
    .collect(groupingBy(Order::userId, summingDouble(Order::amount)))
    .entrySet().stream()
    .sorted(Map.Entry.<Long, Double>comparingByValue().reversed())
    .limit(3)
    .map(Map.Entry::getKey)
    .toList();

// 40.4
Map<Integer, List<String>> byLength = words.stream()
    .collect(groupingBy(String::length));
```

---

# 42. Optional

`Optional<T>` — обёртка над значением, которое **может быть null**. Помогает избежать NPE.

## 42.1 Создание

```java
Optional<String> some = Optional.of("hello");          // если null — NPE
Optional<String> nullable = Optional.ofNullable(null); // ОК, будет empty
Optional<String> empty = Optional.empty();
```

## 42.2 Использование

```java
Optional<String> name = findUserName();

// Проверка
if (name.isPresent()) {
    System.out.println(name.get());
}

// ifPresent
name.ifPresent(System.out::println);

// orElse — fallback
String s = name.orElse("Anonymous");

// orElseGet — fallback через Supplier (lazy — вычисляется только если нужно)
String s2 = name.orElseGet(() -> computeDefault());

// orElseThrow
String s3 = name.orElseThrow();    // NoSuchElementException
String s4 = name.orElseThrow(() -> new RuntimeException("Not found"));

// map — преобразование
Optional<Integer> length = name.map(String::length);

// flatMap — если функция возвращает Optional
Optional<User> user = findUser(id).flatMap(this::findManager);

// filter
Optional<String> filtered = name.filter(s -> s.length() > 3);
```

## 42.3 Когда использовать

✅ **Возврат из метода**, который может не найти результат:
```java
public Optional<User> findById(long id) { ... }
```

❌ **Не используй как поле класса** или параметр метода. Optional только для возвратов.

❌ **Не используй для коллекций** — они уже имеют пустое состояние:
```java
public Optional<List<User>> findAll() { ... }   // ❌ верни просто List
```

## 42.4 Цепочки

```java
public String getCity(Long userId) {
    return findUser(userId)
        .map(User::getAddress)
        .map(Address::getCity)
        .orElse("Unknown");
}
```

Сравни с императивным эквивалентом — много короче.

## Упражнение 42

Метод `findEmailDomain(String email)` возвращает `Optional<String>` — домен из email. Если email невалидный или null — empty.

`"aibek@gmail.com"` → `Optional["gmail.com"]`
`null` → `Optional.empty()`
`"invalid"` → `Optional.empty()`

### Решение

```java
public static Optional<String> findEmailDomain(String email) {
    return Optional.ofNullable(email)
        .filter(e -> e.contains("@"))
        .map(e -> e.substring(e.indexOf('@') + 1))
        .filter(d -> !d.isEmpty());
}
```

---

# Часть IX. Многопоточность

⚠️ Это самая сложная часть. У джунов спрашивают **базу**: что такое поток, race condition, synchronized, ExecutorService. Не убивайся, изучи основные понятия.

# 43. Threads и Runnable

## 43.1 Что такое поток

Поток (thread) — независимая последовательность выполнения внутри программы. JVM запускает программу в одном потоке (`main`), но можно запускать дополнительные.

Зачем:
- Параллельная обработка (несколько ядер CPU).
- Не блокировать UI / основную логику долгими операциями.
- Обработка нескольких клиентов на сервере одновременно.

## 43.2 Создание потока

### Через Runnable (предпочтительно)

```java
Runnable task = () -> {
    System.out.println("Running in: " + Thread.currentThread().getName());
};

Thread t = new Thread(task);
t.start();    // ⚠️ start, не run!
t.join();     // ждём завершения
```

⚠️ `t.start()` запускает в новом потоке. `t.run()` просто вызовет метод в текущем потоке (это ошибка).

### Через extends Thread (устарело)

```java
class MyThread extends Thread {
    @Override public void run() { ... }
}
new MyThread().start();
```

Не используй — занимает наследование, а composition (Runnable) гибче.

## 43.3 Жизненный цикл

```
NEW → RUNNABLE → BLOCKED / WAITING / TIMED_WAITING → RUNNABLE → TERMINATED
```

- **NEW** — создан, ещё не start.
- **RUNNABLE** — выполняется или готов выполняться.
- **BLOCKED** — ждёт монитор (synchronized).
- **WAITING** — ждёт notify (через `wait()`, `join()`).
- **TIMED_WAITING** — ждёт с таймаутом (`sleep()`, `wait(timeout)`).
- **TERMINATED** — завершён.

## 43.4 Sleep, interrupt, join

```java
Thread.sleep(1000);     // спать 1 секунда (бросает InterruptedException)

t.interrupt();          // запрос прерывания
Thread.currentThread().isInterrupted();   // проверить флаг

t.join();               // ждать завершения t
t.join(1000);           // ждать максимум 1 секунду
```

## 43.5 Daemon threads

Daemon-поток не препятствует завершению JVM. Когда все non-daemon потоки завершены — JVM завершается, даже если daemon ещё работают.

```java
Thread t = new Thread(task);
t.setDaemon(true);       // ОБЯЗАТЕЛЬНО до start
t.start();
```

Используется для фоновых задач (логгер, GC).

## Упражнение 43

Запусти 5 потоков. Каждый печатает свой номер 5 раз с задержкой 100мс. main ждёт всех.

### Решение

```java
public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
        final int id = i;
        Thread t = new Thread(() -> {
            for (int j = 1; j <= 5; j++) {
                System.out.println("Thread " + id + ": " + j);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });
        threads.add(t);
        t.start();
    }
    for (Thread t : threads) t.join();
    System.out.println("All done");
}
```

---

# 44. Проблемы конкурентности

## 44.1 Race condition

Когда несколько потоков обращаются к общим данным, и результат зависит от порядка их выполнения:

```java
public class Counter {
    private int count = 0;

    public void increment() {
        count++;     // НЕ атомарная операция!
    }

    public int get() { return count; }
}

Counter c = new Counter();
List<Thread> threads = new ArrayList<>();
for (int i = 0; i < 1000; i++) {
    Thread t = new Thread(c::increment);
    threads.add(t);
    t.start();
}
for (Thread t : threads) t.join();
System.out.println(c.get());    // ⚠️ может быть < 1000!
```

Почему. `count++` — это:
1. Прочитать `count`.
2. Прибавить 1.
3. Записать обратно.

Между шагами другой поток может вмешаться:
```
Thread A: читает 5
Thread B: читает 5
Thread A: записывает 6
Thread B: записывает 6   ← должно было быть 7!
```

## 44.2 Visibility problem

Без синхронизации один поток может **не увидеть** изменений, сделанных другим (из-за кэшей CPU):

```java
private boolean stop = false;

// Thread 1
while (!stop) { /* работает */ }

// Thread 2
stop = true;     // Thread 1 может не увидеть!
```

## 44.3 Deadlock

Два потока ждут друг друга:

```java
Thread A: захватил lock1, ждёт lock2
Thread B: захватил lock2, ждёт lock1
// Висят навечно
```

Решение: захватывать ресурсы в **одинаковом порядке**.

## 44.4 Livelock

Потоки активно меняют состояние, но не прогрессируют. Реже встречается.

## 44.5 Starvation

Один поток никогда не получает доступ к ресурсу (другие постоянно его берут).

---

# 45. synchronized и volatile

## 45.1 synchronized

Запрещает другим потокам войти в блок, пока его не покинет текущий.

### На методе

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int get() {
        return count;
    }
}
```

Внутри `synchronized` метода блокируется монитор `this`.

### На блоке

```java
public void increment() {
    synchronized (this) {
        count++;
    }
}
```

Можно блокировать любой объект (часто специальный):

```java
private final Object lock = new Object();

public void increment() {
    synchronized (lock) {
        count++;
    }
}
```

### Static synchronized

Блокирует монитор `Class`:

```java
public static synchronized void method() {
    // блокировка по Counter.class
}
```

## 45.2 volatile

Гарантирует **видимость** изменений между потоками. **Не гарантирует атомарность.**

```java
private volatile boolean stop = false;

// Thread 1
while (!stop) { /* работает */ }

// Thread 2
stop = true;     // Thread 1 ТОЧНО увидит
```

`volatile` подходит для **флагов** (bool, простое чтение/запись). Не подходит для счётчиков (`count++` всё равно не атомарно).

## 45.3 wait / notify

Позволяет потокам ждать события:

```java
private final Object lock = new Object();
private boolean ready = false;

// Producer
synchronized (lock) {
    ready = true;
    lock.notifyAll();
}

// Consumer
synchronized (lock) {
    while (!ready) {
        lock.wait();      // отпускает lock и ждёт notify
    }
    // Работаем
}
```

⚠️ Сложно. На практике используй `BlockingQueue` или `CountDownLatch` (см. дальше).

---

# 46. Atomic классы и Concurrent коллекции

## 46.1 Atomic классы

Пакет `java.util.concurrent.atomic`. Атомарные операции без блокировки (через CAS — compare-and-swap).

```java
import java.util.concurrent.atomic.AtomicInteger;

AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet();     // атомарно ++
count.decrementAndGet();
count.addAndGet(5);
count.get();
count.set(0);

// Compare and Set
count.compareAndSet(5, 10);  // если == 5, установить 10
```

Также: `AtomicLong`, `AtomicBoolean`, `AtomicReference<T>`.

## 46.2 Counter с AtomicInteger

```java
public class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }
}
// Теперь thread-safe без synchronized
```

## 46.3 Concurrent коллекции

Стандартные `ArrayList`, `HashMap` **не thread-safe**.

### ConcurrentHashMap

Заменяет `HashMap` для многопоточной работы:

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("a", 1);
map.computeIfAbsent("b", k -> 0);
```

### CopyOnWriteArrayList

Каждое изменение создаёт **новый массив**. Хорошо, когда много чтений и редко изменения.

```java
List<String> list = new CopyOnWriteArrayList<>();
```

### BlockingQueue

Очередь с блокировкой при `take` (если пусто) и `put` (если полная).

```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
queue.put(1);    // блокируется если полная
queue.take();    // блокируется если пустая
```

Идеально для producer-consumer паттерна.

---

# 47. ExecutorService

В реальной разработке потоки руками не создают. Используют **пулы потоков** через `ExecutorService`.

## 47.1 Зачем

- Создание потока — дорого. Лучше переиспользовать.
- Управление количеством потоков (не запустить 10000 одновременно).

## 47.2 Создание

```java
import java.util.concurrent.*;

ExecutorService executor = Executors.newFixedThreadPool(4);   // 4 потока
ExecutorService cached = Executors.newCachedThreadPool();      // динамический
ExecutorService single = Executors.newSingleThreadExecutor();  // один поток
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
```

## 47.3 Запуск задач

### Runnable (без результата)

```java
executor.submit(() -> {
    System.out.println("Running");
});
```

### Callable (с результатом)

```java
Future<Integer> future = executor.submit(() -> {
    Thread.sleep(1000);
    return 42;
});

Integer result = future.get();    // блокирует до завершения
result = future.get(2, TimeUnit.SECONDS);  // с таймаутом
```

## 47.4 Завершение

```java
executor.shutdown();          // не принимает новые задачи, ждёт завершения текущих
executor.shutdownNow();       // прерывает текущие задачи

executor.awaitTermination(10, TimeUnit.SECONDS);
```

⚠️ Без shutdown JVM не завершится — потоки в пуле живут.

## 47.5 CompletableFuture

Современный способ — асинхронный pipeline:

```java
CompletableFuture<Integer> future = CompletableFuture
    .supplyAsync(() -> loadFromDb())                    // в пуле
    .thenApply(data -> transform(data))                  // преобразуем
    .thenApply(result -> result * 2);

future.thenAccept(System.out::println);                  // когда готово

// Ждать
Integer value = future.get();

// Объединить две асинхронные операции
CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> loadName());
CompletableFuture<Integer> age = CompletableFuture.supplyAsync(() -> loadAge());
CompletableFuture<String> result = name.thenCombine(age, (n, a) -> n + ":" + a);
```

## Упражнение 47

Используя ExecutorService с 4 потоками, посчитай сумму квадратов от 1 до 1_000_000 параллельно (разбей на 4 части).

### Решение

```java
ExecutorService executor = Executors.newFixedThreadPool(4);

List<Future<Long>> futures = new ArrayList<>();
int total = 1_000_000;
int chunkSize = total / 4;

for (int i = 0; i < 4; i++) {
    final int start = i * chunkSize + 1;
    final int end = (i == 3) ? total : (i + 1) * chunkSize;
    futures.add(executor.submit(() -> {
        long sum = 0;
        for (int n = start; n <= end; n++) {
            sum += (long) n * n;
        }
        return sum;
    }));
}

long total_sum = 0;
for (Future<Long> f : futures) {
    total_sum += f.get();
}
System.out.println(total_sum);

executor.shutdown();
```

---

# Часть X. Дополнительно

# 48. Date/Time API

С Java 8 появился новый Date/Time API в `java.time`. Старые `Date`, `Calendar`, `SimpleDateFormat` — **не используй**, они кривые и не thread-safe.

## 48.1 Основные классы

```java
import java.time.*;

LocalDate date = LocalDate.now();              // 2026-05-01
LocalTime time = LocalTime.now();              // 14:30:25.123
LocalDateTime dt = LocalDateTime.now();        // 2026-05-01T14:30:25
ZonedDateTime zdt = ZonedDateTime.now();       // с таймзоной
Instant now = Instant.now();                   // UTC временная точка

// Конкретные значения
LocalDate birthday = LocalDate.of(2000, 1, 15);
LocalDate parsed = LocalDate.parse("2026-05-01");
```

## 48.2 Операции

```java
LocalDate today = LocalDate.now();

LocalDate tomorrow = today.plusDays(1);
LocalDate nextMonth = today.plusMonths(1);
LocalDate lastYear = today.minusYears(1);

today.getYear();
today.getMonthValue();
today.getDayOfWeek();         // DayOfWeek.SATURDAY

today.isBefore(otherDate);
today.isAfter(otherDate);
today.equals(otherDate);
```

## 48.3 Period и Duration

```java
Period p = Period.between(startDate, endDate);
p.getYears();
p.getMonths();
p.getDays();

Duration d = Duration.between(startTime, endTime);
d.toMinutes();
d.toSeconds();
```

## 48.4 Форматирование

```java
import java.time.format.DateTimeFormatter;

LocalDate date = LocalDate.now();
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
String s = date.format(fmt);                      // "01.05.2026"

LocalDate parsed = LocalDate.parse("01.05.2026", fmt);

// Стандартные форматы
DateTimeFormatter.ISO_DATE                         // 2026-05-01
DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL) // Friday, May 1, 2026
```

## 48.5 Immutable

⚠️ Все классы **immutable**! Любая операция возвращает новый объект:

```java
LocalDate date = LocalDate.now();
date.plusDays(1);             // вернёт новую дату — date НЕ изменится!
date = date.plusDays(1);      // вот так правильно
```

---

# 49. JVM в общих чертах

Минимум для собеса.

## 49.1 Что такое JVM

JVM (Java Virtual Machine) — программа, которая выполняет байт-код (`.class` файлы).

```
.java   → javac →   .class   → JVM →   выполнение
исходник           байт-код          
```

## 49.2 Области памяти

```
JVM Memory:
├── Heap (куча)                — общая, объекты
│   ├── Young Generation
│   │   ├── Eden               — новые объекты
│   │   └── Survivor S0, S1    — пережили GC
│   └── Old Generation         — долгоживущие объекты
├── Metaspace                  — метаданные классов (вместо PermGen в старых версиях)
└── Stack (стек)               — для каждого потока, локальные переменные, фреймы методов
```

## 49.3 Garbage Collector

GC — автоматическое управление памятью. JVM сама удаляет неиспользуемые объекты.

**Когда объект может быть удалён:** на него нет ссылок ни из чего.

```java
Person p = new Person("Aibek");
p = null;                            // объект больше не доступен
// в какой-то момент GC удалит
```

Сборщики:
- **Serial GC** — для маленьких приложений.
- **Parallel GC** — старый default.
- **G1 GC** — default в Java 9+, баланс throughput и latency.
- **ZGC**, **Shenandoah** — низкая latency, для больших heap.

Для джуна достаточно знать: GC есть, освобождать память руками не нужно, явно вызывать `System.gc()` — плохая практика.

## 49.4 Class loading

JVM загружает классы лениво — только когда они используются.

Загрузчики:
- **Bootstrap** — `java.lang.*`, `java.util.*`.
- **Platform** — модули JDK.
- **Application** — твои классы из classpath.

## 49.5 JIT компиляция

Сначала JVM **интерпретирует** байт-код. Часто исполняемый код **JIT** (Just-In-Time) компилирует в нативный машинный код — становится быстрее.

---

# 50. Современные фичи Java

## 50.1 var (Java 10+)

Уже знаком (раздел 2.6).

## 50.2 Text blocks (Java 15+)

Уже знаком (раздел 15.3).

## 50.3 Records (Java 14+)

Уже знаком (раздел 28).

## 50.4 Pattern matching for instanceof (Java 16+)

```java
// Старо
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.length());
}

// Ново
if (obj instanceof String s) {
    System.out.println(s.length());
}
```

## 50.5 Switch expression (Java 14+)

Уже знаком (раздел 6.3).

## 50.6 Pattern matching for switch (Java 21)

```java
Object obj = ...;
String result = switch (obj) {
    case Integer i when i > 0 -> "positive int: " + i;
    case Integer i -> "non-positive int: " + i;
    case String s -> "string: " + s;
    case null -> "null";
    default -> "other";
};
```

## 50.7 Sealed classes (Java 17+)

Ограничение, кто может наследоваться:

```java
public sealed class Shape permits Circle, Square, Triangle {}

public final class Circle extends Shape {}
public final class Square extends Shape {}
public final class Triangle extends Shape {}

// Нельзя:
public class Rectangle extends Shape {}    // ❌ не в permits
```

Используется вместе с pattern matching, чтобы компилятор требовал покрыть все случаи.

---

# Mini-проекты

После изучения теории — обязательно сделай эти проекты. Без них знание не закрепится.

## Mini-проект 1: Калькулятор зарплат

**Цель:** применить ООП, наследование, интерфейсы, коллекции.

### Требования

Иерархия сотрудников:
- `Employee` (абстрактный): `id`, `name`, `email`. Метод `calculateMonthlySalary()`.
- `FullTimeEmployee`: фиксированный `monthlySalary`.
- `Contractor`: `hourlyRate`, `hoursPerMonth`.
- `SalesPerson extends FullTimeEmployee`: + `salesAmount`, `commissionRate`.

Класс `Company` с `List<Employee>`. Методы:
- `hire(Employee)`, `fire(long id)`.
- `getTotalPayroll()` — общий ФЗП.
- `getEmployeesByType()` — Map<String, List<Employee>>.
- `getTopPaid(int n)` — топ-N по зарплате.
- `getAverageSalary()`.

В main: создай компанию, найми 10 человек разных типов, выполни все методы.

### Решение (каркас)

```java
public abstract class Employee {
    private final long id;
    private final String name;
    private final String email;

    public Employee(long id, String name, String email) {
        this.id = id; this.name = name; this.email = email;
    }

    public abstract double calculateMonthlySalary();

    public long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + id + ", " + name +
               ", $" + calculateMonthlySalary() + "}";
    }
}

public class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    public FullTimeEmployee(long id, String name, String email, double salary) {
        super(id, name, email);
        if (salary < 0) throw new IllegalArgumentException("Salary < 0");
        this.monthlySalary = salary;
    }

    @Override
    public double calculateMonthlySalary() {
        return monthlySalary;
    }
}

public class Contractor extends Employee {
    private final double hourlyRate;
    private final int hoursPerMonth;

    public Contractor(long id, String name, String email, double rate, int hours) {
        super(id, name, email);
        this.hourlyRate = rate;
        this.hoursPerMonth = hours;
    }

    @Override
    public double calculateMonthlySalary() {
        return hourlyRate * hoursPerMonth;
    }
}

public class SalesPerson extends FullTimeEmployee {
    private final double salesAmount;
    private final double commissionRate;

    public SalesPerson(long id, String name, String email, double base,
                       double sales, double commission) {
        super(id, name, email, base);
        this.salesAmount = sales;
        this.commissionRate = commission;
    }

    @Override
    public double calculateMonthlySalary() {
        return super.calculateMonthlySalary() + salesAmount * commissionRate;
    }
}

public class Company {
    private final List<Employee> employees = new ArrayList<>();

    public void hire(Employee e) {
        if (employees.stream().anyMatch(emp -> emp.getId() == e.getId())) {
            throw new IllegalArgumentException("Duplicate id: " + e.getId());
        }
        employees.add(e);
    }

    public void fire(long id) {
        boolean removed = employees.removeIf(e -> e.getId() == id);
        if (!removed) throw new IllegalArgumentException("Not found: " + id);
    }

    public double getTotalPayroll() {
        return employees.stream()
            .mapToDouble(Employee::calculateMonthlySalary)
            .sum();
    }

    public Map<String, List<Employee>> getEmployeesByType() {
        return employees.stream()
            .collect(Collectors.groupingBy(e -> e.getClass().getSimpleName()));
    }

    public List<Employee> getTopPaid(int n) {
        return employees.stream()
            .sorted(Comparator.comparingDouble(Employee::calculateMonthlySalary).reversed())
            .limit(n)
            .toList();
    }

    public double getAverageSalary() {
        return employees.stream()
            .mapToDouble(Employee::calculateMonthlySalary)
            .average()
            .orElse(0);
    }

    public static void main(String[] args) {
        Company c = new Company();
        c.hire(new FullTimeEmployee(1, "Aibek", "aibek@c.kz", 500_000));
        c.hire(new FullTimeEmployee(2, "Madi", "madi@c.kz", 700_000));
        c.hire(new Contractor(3, "Aiman", "aiman@c.kz", 5000, 160));
        c.hire(new SalesPerson(4, "Asel", "asel@c.kz", 300_000, 2_000_000, 0.05));

        System.out.println("Total payroll: " + c.getTotalPayroll());
        System.out.println("Average: " + c.getAverageSalary());
        System.out.println("\nBy type:");
        c.getEmployeesByType().forEach((k, v) -> System.out.println(k + ": " + v.size()));
        System.out.println("\nTop 3:");
        c.getTopPaid(3).forEach(System.out::println);
    }
}
```

### Расширения для практики
1. Добавить отдел (department). Метод `getPayrollByDepartment()`.
2. Метод `giveRaise(long id, double percent)`.
3. Сохранить компанию в файл (через `PrintWriter`) и загрузить.

---

## Mini-проект 2: Банковская симуляция (с многопоточностью)

**Цель:** ООП, исключения, коллекции, многопоточность.

### Требования

Класс `Account`:
- `id` (final), `holder`, `balance`.
- `deposit(amount)`, `withdraw(amount)`, `transfer(other, amount)`.
- Бросает `InsufficientFundsException`, `InvalidAmountException`.
- **Thread-safe** — все методы корректны при многопоточном доступе.

Класс `Bank`:
- Хранит `Map<Long, Account>`.
- `createAccount(holder, initialBalance)` — возвращает Account.
- `getAccount(id)`.
- `getTotalAssets()` — сумма балансов всех счетов.

Симуляция:
- Создаёшь 10 счетов с балансом 1000 каждый.
- Запускаешь 100 потоков, каждый делает 100 случайных переводов между случайными счетами.
- В конце сумма всех балансов должна остаться 10_000 (если потокобезопасность работает).

### Решение (каркас)

```java
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String m) { super(m); }
}

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String m) { super(m); }
}

public class Account {
    private final long id;
    private final String holder;
    private double balance;
    private final Object lock = new Object();

    public Account(long id, String holder, double initialBalance) {
        if (initialBalance < 0) throw new InvalidAmountException("negative initial");
        this.id = id;
        this.holder = holder;
        this.balance = initialBalance;
    }

    public long getId() { return id; }
    public String getHolder() { return holder; }

    public double getBalance() {
        synchronized (lock) { return balance; }
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new InvalidAmountException("amount <= 0");
        synchronized (lock) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new InvalidAmountException("amount <= 0");
        synchronized (lock) {
            if (amount > balance) throw new InsufficientFundsException("balance: " + balance);
            balance -= amount;
        }
    }

    public void transfer(Account other, double amount) {
        if (this == other) throw new IllegalArgumentException("same account");
        // ВАЖНО: захватываем lock'и в одинаковом порядке (по id) — чтобы избежать deadlock
        Account first = this.id < other.id ? this : other;
        Account second = this.id < other.id ? other : this;
        synchronized (first.lock) {
            synchronized (second.lock) {
                this.withdraw(amount);    // внутри уже synchronized но это re-entrant
                other.deposit(amount);
            }
        }
    }
}

public class Bank {
    private final Map<Long, Account> accounts = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Account createAccount(String holder, double initialBalance) {
        long id = nextId.getAndIncrement();
        Account a = new Account(id, holder, initialBalance);
        accounts.put(id, a);
        return a;
    }

    public Account getAccount(long id) {
        Account a = accounts.get(id);
        if (a == null) throw new IllegalArgumentException("Not found: " + id);
        return a;
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public double getTotalAssets() {
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        List<Account> accs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accs.add(bank.createAccount("User" + i, 1000));
        }
        System.out.println("Initial total: " + bank.getTotalAssets());

        ExecutorService executor = Executors.newFixedThreadPool(20);
        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    Account from = accs.get(rnd.nextInt(accs.size()));
                    Account to;
                    do { to = accs.get(rnd.nextInt(accs.size())); } while (to == from);
                    double amount = 1 + rnd.nextInt(100);
                    try {
                        from.transfer(to, amount);
                    } catch (InsufficientFundsException ignored) {}
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final total: " + bank.getTotalAssets());
        // Должно быть 10_000.0
    }
}
```

### Эксперимент
Убери `synchronized` из методов и запусти. Увидишь — total изменится. Это **race condition** в действии.

---

## Mini-проект 3: Phone Book с файлом

**Цель:** работа с файлами, исключения, коллекции, ввод-вывод.

### Требования

Консольная программа — записная книжка.

Команды:
- `add <name> <phone>` — добавить
- `list` — все контакты
- `search <name>` — поиск (содержит)
- `update <name> <new_phone>` — обновить
- `delete <name>` — удалить
- `save` — сохранить в `contacts.txt`
- `load` — загрузить
- `quit`

При запуске пытается load. При quit — save.

Хранение: `Map<String, String>` (name → phone). Имя — уникальный ключ.

### Решение

```java
public class PhoneBook {
    private final Map<String, String> contacts = new HashMap<>();
    private static final String FILE = "contacts.txt";

    public void add(String name, String phone) {
        if (contacts.containsKey(name)) {
            System.out.println("Already exists. Use update.");
            return;
        }
        contacts.put(name, phone);
        System.out.println("Added.");
    }

    public void list() {
        if (contacts.isEmpty()) { System.out.println("Empty."); return; }
        contacts.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    public void search(String query) {
        contacts.entrySet().stream()
            .filter(e -> e.getKey().toLowerCase().contains(query.toLowerCase()))
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    public void update(String name, String phone) {
        if (!contacts.containsKey(name)) { System.out.println("Not found."); return; }
        contacts.put(name, phone);
        System.out.println("Updated.");
    }

    public void delete(String name) {
        if (contacts.remove(name) == null) System.out.println("Not found.");
        else System.out.println("Deleted.");
    }

    public void save() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (var e : contacts.entrySet()) {
                pw.println(e.getKey() + "\t" + e.getValue());
            }
            System.out.println("Saved " + contacts.size() + " contacts.");
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    public void load() {
        Path p = Path.of(FILE);
        if (!Files.exists(p)) return;
        try {
            for (String line : Files.readAllLines(p)) {
                String[] parts = line.split("\t", 2);
                if (parts.length == 2) contacts.put(parts[0], parts[1]);
            }
            System.out.println("Loaded " + contacts.size() + " contacts.");
        } catch (IOException e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.load();

        Scanner sc = new Scanner(System.in);
        System.out.println("Commands: add, list, search, update, delete, save, load, quit");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 3);
            String cmd = parts[0];

            try {
                switch (cmd) {
                    case "add" -> pb.add(parts[1], parts[2]);
                    case "list" -> pb.list();
                    case "search" -> pb.search(parts[1]);
                    case "update" -> pb.update(parts[1], parts[2]);
                    case "delete" -> pb.delete(parts[1]);
                    case "save" -> pb.save();
                    case "load" -> pb.load();
                    case "quit" -> {
                        pb.save();
                        return;
                    }
                    default -> System.out.println("Unknown command.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong arguments.");
            }
        }
    }
}
```

---

# Чек-лист готовности

После прохождения всех частей и проектов проверь себя.

## Основы языка
- [ ] Знаю все 8 примитивных типов и их размер.
- [ ] Понимаю разницу между примитивами и ссылочными типами.
- [ ] Знаю про String Pool и почему `==` не работает для строк.
- [ ] Использую `var`, понимаю его ограничения.
- [ ] Знаю, что в Java передача всегда **по значению**.
- [ ] Уверенно пишу циклы, switch (классический и expression).
- [ ] Использую `BigDecimal` для денег.

## Методы
- [ ] Понимаю перегрузку и varargs.
- [ ] Знаю про рекурсию и StackOverflowError.
- [ ] Пишу методы с правильными именами и без побочных эффектов.

## Строки
- [ ] Знаю основные методы String.
- [ ] Понимаю, почему String **immutable**.
- [ ] Использую StringBuilder в циклах.
- [ ] Использую text blocks и String.format.

## ООП (главное!)
- [ ] Уверенно объясняю **инкапсуляцию, наследование, полиморфизм, абстракцию**.
- [ ] Использую конструкторы, `this`, `super`.
- [ ] Понимаю разницу между **абстрактным классом** и **интерфейсом**.
- [ ] Знаю, что в Java только **одиночное** наследование классов, но множественная реализация интерфейсов.
- [ ] Пишу `@Override`.
- [ ] Использую default-методы интерфейса.
- [ ] Знаю про композицию vs наследование.
- [ ] Понимаю static binding vs dynamic dispatch.

## Модификаторы и Object
- [ ] Делаю поля `private`, методы `public/private` по необходимости.
- [ ] Использую `static` для утилит и констант.
- [ ] Использую `final` для immutable-полей и констант.
- [ ] Корректно переопределяю `equals` и `hashCode` (контракт!).
- [ ] Использую `enum` вместо magic-string.
- [ ] Знаю про `record`.

## Исключения
- [ ] Понимаю checked vs unchecked.
- [ ] Использую try-with-resources.
- [ ] Создаю свои исключения от RuntimeException.
- [ ] Не глотаю исключения.

## Generics
- [ ] Создаю generic-классы и методы.
- [ ] Понимаю PECS (Producer Extends, Consumer Super).
- [ ] Знаю про type erasure.

## Коллекции (один из главных вопросов!)
- [ ] Знаю иерархию: Collection (List, Set, Queue), Map.
- [ ] Понимаю разницу `ArrayList` vs `LinkedList`, выбираю первый.
- [ ] Знаю `HashSet` / `TreeSet` / `LinkedHashSet`.
- [ ] Знаю `HashMap` / `TreeMap` / `LinkedHashMap`.
- [ ] **Могу объяснить, как HashMap работает внутри** (бакеты, hash, collision, treeify, resize).
- [ ] Использую `Comparable` и `Comparator`.

## Stream API
- [ ] Использую `filter`, `map`, `flatMap`, `sorted`, `distinct`, `limit`.
- [ ] Использую terminal: `toList`, `count`, `reduce`, `findFirst`, `anyMatch`.
- [ ] Использую `Collectors.groupingBy`, `toMap`, `joining`.
- [ ] Использую `Optional` правильно (только для возврата).

## Многопоточность (базово)
- [ ] Знаю, как создать поток через `Runnable`.
- [ ] Понимаю race condition.
- [ ] Использую `synchronized` или `Atomic*` для thread-safety.
- [ ] Знаю про `volatile` (visibility, не атомарность).
- [ ] Использую `ExecutorService`.
- [ ] Слышал про `ConcurrentHashMap`, `BlockingQueue`, `CompletableFuture`.

## Проекты
- [ ] Сделал mini-проект 1 (Калькулятор зарплат).
- [ ] Сделал mini-проект 2 (Банк с многопоточностью).
- [ ] Сделал mini-проект 3 (PhoneBook с файлом).
- [ ] Все проекты на GitHub с осмысленными коммитами.

## Топ-вопросы для подготовки к собесу

1. Чем отличаются `String`, `StringBuilder`, `StringBuffer`?
2. Что такое immutable объект?
3. Как переопределить `equals` и `hashCode` правильно?
4. Зачем переопределять `hashCode` если есть `equals`?
5. `==` vs `.equals()`?
6. Как работает HashMap внутри? (load factor, treeify, resize)
7. `ArrayList` vs `LinkedList`?
8. Что такое generics? Что такое type erasure?
9. PECS — что это?
10. Checked vs unchecked исключения?
11. Что такое `try-with-resources`?
12. Что такое лямбда? Что такое функциональный интерфейс?
13. Stream API: lazy evaluation, intermediate vs terminal.
14. `Optional` — зачем и как использовать?
15. Чем отличается абстрактный класс от интерфейса?
16. Почему в Java нет множественного наследования классов?
17. Что такое статический полиморфизм (overloading) и динамический (overriding)?
18. Что такое race condition? Как её избежать?
19. `synchronized` vs `volatile`?
20. Что такое `Runnable` vs `Callable`?

---

# Что дальше

Когда чек-лист закрыт:

1. **Закрепи проектами.** Сделай ещё что-нибудь своё — кафе-симулятор, библиотека, простая игра.
2. **Алгоритмы.** Решай 1–2 задачи в день на LeetCode (Easy → Medium).
3. **Готовься к Spring Boot** — следующий модуль курса. Там Java Core применяется в "боевом" режиме.

Удачи! У тебя получилось пройти самый сложный модуль.
