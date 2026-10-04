# Assignment 3 - Bridge Pattern

**Name:** Smat Zhangir  
**Group:** SE-2522  
**Topic:** A - Shape rendering  
**Repository:** https://github.com/smatD/Assignment3  
**Base commit:** 417058ff0dda5163032b4ed1c10f14a3bd4addcc

## About the project

This project is an example of the Bridge design pattern using different shapes and different ways of rendering them.

The main idea is that the shapes and the renderers are kept separate. This means that a shape such as Circle or Square can use different renderers without needing a separate class for every possible combination.

## Role map

| Role | Class | Source |
|---|---|---|
| Abstraction | `Shape` | `src/Shape.java` |
| A1 | `Circle` | `src/Circle.java` |
| A2 | `Square` | `src/Square.java` |
| Implementor | `Renderer` | `src/Renderer.java` |
| I1 | `VectorRenderer` | `src/VectorRenderer.java` |
| I2 | `RasterRenderer` | `src/RasterRenderer.java` |
| I3 | `AsciiRenderer` | `src/AsciiRenderer.java` |
| Client | `Main` | `src/Main.java` |

The bridge field is `Shape.renderer`.

`Shape.execute()` is the main abstraction operation, and `setImplementation(Renderer renderer)` changes the renderer.

The T5 runtime switching check is in `Main`.

## How the Bridge pattern is used

There are two parts that can change independently:

1. The shape being used, such as Circle or Square.
2. The renderer being used, such as VectorRenderer, RasterRenderer, or AsciiRenderer.

For example, the same Circle object can use VectorRenderer and then be switched to RasterRenderer.

This avoids having to create classes such as VectorCircle, RasterCircle, VectorSquare, RasterSquare, and so on.

## Running the project

The project uses Java 17.

From the project folder, compile the source files with:

```text
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
```

Then run the demo:

```text
java -cp out Main --demo
```

The demo should show:

```text
T1 PASS
T2 PASS
T3 PASS
T4 PASS
T5 PASS
T6 PASS
T7 PASS
SUMMARY: 7/7 PASS
```

The output from the submitted run is also saved in demo-output.txt.

## Tests

The tests check that the different combinations of shapes and renderers work correctly.

- T1 checks a `Circle` with `VectorRenderer`.
- T2 checks a `Circle` with `RasterRenderer`.
- T3 checks a `Square` with `VectorRenderer`.
- T4 checks a `Square` with `RasterRenderer`.
- T5 checks that the renderer can be changed without creating a new `Circle` object.
- T6 checks a `Circle` with `AsciiRenderer`.
- T7 checks a `Square` with `AsciiRenderer`.

For T5 in particular, the same `Circle` object is kept, but its renderer is changed from vector to raster.

## Bridge vs Adapter

I used the Bridge pattern because the shape and the renderer are two separate parts of the program that can change independently.

For example, a Circle can use different Renderer implementations without changing the Circle class.

The Adapter pattern is different. It is normally used when an existing class has an interface that does not match what the program expects, and the adapter converts it to the required interface.

There is no interface that needs to be translated in this project, so Bridge is a better fit.

## Sources

1. Gamma, E., Helm, R., Johnson, R., & Vlissides, J. *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley, 1994.
2. Oracle. *Java SE 17 API Documentation*. https://docs.oracle.com/en/java/javase/17/docs/api/
3. Course materials: Lecture 4, Bridge Pattern; Moodle Bridge reading; course syllabus 2026-2027.