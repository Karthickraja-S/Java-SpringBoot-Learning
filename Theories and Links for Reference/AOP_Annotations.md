### @Aspect 
```
We use this annotation to specify the current class is aspect oriented.
```
### @Before 
```
When we specify this annotation, we have to specify with the execution where the before needs to be executed.
Ex :     @Before("execution(* com.enterprise.app.SpringBootAOPBasics.controller.ApartmentController.*(..))" )
```
### @After
```
When we specify this annotation, with the method, once the method completes the execution, this current method will gets executed. :)
Things also we have  : @AfterThrowing @AfterReturning
```
### @Around 
```
We can get the args which is passed to the method and we can do logging / performance monitoring / inputs manipulation to default value :)
```
