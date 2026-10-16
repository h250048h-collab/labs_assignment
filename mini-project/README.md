# Object-Oriented Programming in Java: Lab Solutions

Worked code for the university OOP in Java lab manual (11 labs).

## Structure

```
labNN/
  examples/     programs printed in the manual (Labs 1 to 5)
  exercises/    solutions to that lab's graded exercises
  mini-project/ (lab11 only) Library Management System
```

Each `examples/` and `exercises/` folder is self-contained, because several labs
reuse class names such as `Student`, `Circle` and `Temperature`.

## Run

Requires JDK 17 or later.

```bash
cd lab01/exercises
javac *.java
java Car          # any class that has a main method
```

## Labs

| Lab | Topic |
| --- | --- |
| 01 | Classes and objects |
| 02 | Constructors, `this`, `static` |
| 03 | Encapsulation |
| 04 | Inheritance |
| 05 | Polymorphism |
| 06 | Abstraction, abstract classes and interfaces |
| 07 | Exception handling |
| 08 | Generics and collections |
| 09 | Nested types, enums, records |
| 10 | File I/O, lambdas, streams |
| 11 | Design patterns and mini-project (run `java LibraryApp`) |

## Main classes in each exercises folder

- lab01: Car, Rectangle, AliasDemo, Person
- lab02: Circle, Employee, BlockOrder, Temperature
- lab03: Student, BankAccount, ImmutablePerson, Temperature
- lab04: Student, Teacher, VehicleChain, SuperFail, StackDemo
- lab05: PrintOverload, AnimalDemo, PayrollDemo, FieldVsMethod, PaymentDemo
- lab06: ShapeDemo, FlyDemo, AccountDemo, StudentSort, DefaultConflict
- lab07: SafeDivide, ArrayAccess, AgeValidator, BankAccount, FinallyDemo
- lab08: ListStats, RemoveDuplicates, GenericStack, WordFrequency, BubbleSortDemo
- lab09: LevelDemo, RecordDemo, BookDemo, MyLinkedList, CoinDemo
- lab10: SaveLines, RemoveEvens, FileStats, AboveAverage, BandReports
