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

## 