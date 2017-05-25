# Spock Framework
![spock](https://en.wikipedia.org/wiki/File:Zachary_Quinto_Comic-Con_2010.jpg)

## Groovy vs Java
![Groovy&Java](https://en.wikipedia.org/wiki/File:Twins_Poster.jpg)

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

* readability
* error reporting
https://yermilov.github.io/spock-talk/#spock_assertions  

### Spock vs Mockito/EasyMock

* stubbing
* mocking  
http://spockframework.org/spock/docs/1.1-rc-4/all_in_one.html#_interaction_based_testing  
http://spockframework.org/spock/docs/1.1-rc-4/all_in_one.html#GroovyMocks  

### Spock vs JUnitParams/Parameterized

https://github.com/Pragmatists/JUnitParams  
https://yermilov.github.io/spock-talk/#data_driven_tests  
 
@Mock (answer = Answers.RETURNS_DEEP_STUBS)  
https://idodevjobs.wordpress.com/2015/04/09/mockito-deep-stubs-example/  

## Configuration

* gmavenplus
* surefire

## Links
 [spock github](https://github.com/spockframework/spock)  
 [groovy old](https://github.com/groovy/groovy-core)  
 [groovy new](https://github.com/apache/groovy)
 [spock talk](https://yermilov.github.io/spock-talk)