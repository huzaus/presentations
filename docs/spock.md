# Spock Framework
![spock](https://en.wikipedia.org/wiki/File:Zachary_Quinto_Comic-Con_2010.jpg)

## Groovy vs Java
![twins](https://en.wikipedia.org/wiki/File:Twins_Poster.jpg)

[Differences with Java](http://groovy-lang.org/differences.html)  
[groovy style-guide](http://groovy-lang.org/style-guide.html)  
[metaprogramming](http://groovy-lang.org/metaprogramming.html)  
[DSL](http://groovy-lang.org/dsls.html)  
[AST transformation](https://github.com/shekhargulati/52-technologies-in-2016/tree/master/32-groovy-ast-transformations) 


## Spock vs Junit  

**Specification**  
`MySpecification extends Specification` -> `Spec` // `Test`  

**Fixture Methods**  
`def setup() {}`         // run before every feature method `@Before`  
`def cleanup() {}`        // run after every feature method `@After`  
`def setupSpec() {}`     // run before the first feature method `@BeforeClass`  
`def cleanupSpec() {}`   // run after the last feature method `@AfterClass`  

**Test method**  
def "test/feature method name" () {} // `@Test`  
[blocks](http://spockframework.org/spock/docs/1.1-rc-4/all_in_one.html#_blocks)

### `assert` vs AssertJ/Hamcrest

### Spock vs Mockito/EasyMock

### Spock vs JUnitParams/Parameterized

## Configuration
