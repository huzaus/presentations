# Generics

## Definition
A generic type is a generic class or interface that is parameterized over types. The following Box class will be modified to demonstrate the concept.  

Non-generic:
```
public class Box {
    private Object object;
    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

Generic:
```
public class Box<T> {
    private T t;
    public void put(T t) { this.t = t; }
    public T get() { return t; }
}
```

## Usage

* as argument and return types of methods  
```public T get() { return t; }```
* as type of a field or local reference variable  
 ```private T t;```
* as type argument of other parameterized types  
```public void put(T t)```
* as target type in casts 
```(S) t```
* as explicit type argument of parameterized methods
```Box.<String>boxed(null).get()```
* Method example:
```
    public <S> S cast(T t) {
        return (S) t;
    } 
```
* Static method example:
```
    public static <T> Box<T> boxed(T t) {
        Box<T> box = new Box<>();
        box.put(t);
        return box;
    } 
```
* N types example:
```
public class MultiBox<X, Y, Z> {
    private X x;
    private Y y;
    private Z z;
}
```

## Benefits
* **Improved readability**  
An instantiation with type arguments is more informative and improves the readability of the source code.
 
* **Better tool support**  
Providing type arguments enables development tools to support you more effectively: IDEs (= integrated development environments) can offer more precise context-sensitive information; incremental compilers can flag type errors the moment you type in the incorrect source code.  Without providing type arguments the errors would  go undetected until you start testing your program.
 
* **Fewer ClassCastExceptions**  
Type arguments enable the compiler to perform static type checks to ensure type safety at compile time, as opposed to dynamic type checks performed by the virtual machine at runtime.  As a result there are fewer opportunities for the program to raise a ClassCastException .

* **Fewer casts**  
More specific type information is available when type arguments are provided, so that hardly any casts are needed compared to the substantial number of casts that clutter the source code when raw types are used.

* **No unchecked warnings**  
Raw types lead to "unchecked" warning, which can be prevented by use of type arguments.

* **No future deprecation**  
The Java Language Specification states that raw types might be deprecated in a future version of Java, and might ultimately be withdrawn as a language feature.

## Advanced generics: Wildcard, Recursive
* ```<? extends Something>```  Upper bound 
* ```<? super Something>``` Lower bound
* ```<?>``` Unknown 
* ```Something<A> extends BaseSomething<A, Something<A>>``` Recursive

## Erasure
* Information about generic *almost* is not available at runtime.  
```
<T> -> Object  
<T super Number> -> Object  
<T extends Number> -> Number  
<T extends Comparable<T>> -> Comparable
<T extends Cloneable & Comparable<T>> ->Cloneable
<T extends Object & Comparable<T>> -> Object
<S, T extends S> -> Object,Object
```
  
## Examples and Questions

* ```List<? extends Number> list; list.add(?)```
* ```List<? super Number> list; list.add(?)```
* ```List<?> list; list.add(?)```
  
* Where we should use super/extend ? (PECS)
  
## Links
* http://www.angelikalanger.com/GenericsFAQ/JavaGenericsFAQ.html
