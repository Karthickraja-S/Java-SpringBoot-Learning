### @Component 
```
When we specify this annotation, spring itself handles creation of object in the container. But as a singleton if scope is not defined.
If the object need to be created when we neeed to use, then annotate with @Lazy
```
### @Service
```
It is put on a service class to indicate it is a service class from a controller and internally it calls component annotation.
```
### @Repository 
```
  It is put on a repository class that fetches data from the DB. It is a best practice to include the repository,service annotations for better understanding.
```
### @Autowired 
```
It is used to inject the created object in your class. ( Dependency Injection ) and this vary as Field, Setter , Contructor Injection.
```
### @Bean
```
It is used in Soring FW to declare the object as Bean with name specifier and we can use in contexy object to get the instance of bean.
```
### @Primary
```
When we have 2 implementations of a interface/classes and when using Autowired on the super class, spring dont know which needs to be considered. So, @Primary
annotation is used in one impl classes so that it always prefers to that instance when injected. If we neeed to use other one, then @Qualifier will be helpful.
```
### @Qualifier
```
When we put @Primary to a implemented class, and what if we need another one implementation. Here this annotation is used with @Autowired annotations that will override the primary annotation and gives u what u needed.
Ex : @Qualifier("<Class_name_of_implemented_class OR the_name_u_put_in_component_annotation>")
```
### @Configuration
```
It declares the class as a configuration class and use this class as a startign point to create obj in container. So with @ComponentScan annotation, we can
specify what are the objects needs to be created in container. 
Ex : @ComponentScan("PKG_NAME");
```
### @Scope
```
It declares the object needs to be in which scope. By default it works in singleton and what if we need different objects when calling context.getBean(), so 
we have to declare scope as @Scope("prototype"). There are 6 scopes. ( singleton , prototype , request , session , Application , WebSocket )
  Ref : https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html
```
### @Value
```
We can use above the field to inject some values to that variable.
```
###  @SpringBootApplication
```
We can declare the current class as a spring boot application. It enabled u auto configuration of components,component scanning , container.
```
### @RequestMapping
```
We can give this @RequestMapping above to the method and we can route the url to this method and we can return some data to which the view needs to be shown to client. 
Ex : @RequestMapping("/api/v1/getData")
```
### @RequestParam
```
With RequestParam annotation, we can get the required data from the front end FORMS and we can process our logics here. We can also use @ModelAttribute annotations to map all the datas to the object class.
```
### GetMapping , PostMapping , DeleteMapping , PutMapping 
```
Used to defing HTTP Methods for the controller urls. In addition to this we can specify consumes,
produces with specific type only. 
Ex : @GetMapping( path = {"/","/home"} , consumes = {"application/json"} , produces = {"application/json"} )
```
### @RequestBody 
```
To accept a json and need to map to a POJO class, we have to use request body.
```
### @ResponseBody
```
To override a method saying that returning is not a view and it is a data in @Controller classes ,
we have to use @ResponseBody so that i returns a raw data.
```
### @RequestPart
```
This is used to split our form inputs to further objects OR file upload.
```
### @ControllerAdvice
```
This is used to specify the current class is used to handle exceptions that is thrown from webserver classes.
Ref : https://www.baeldung.com/exception-handling-for-rest-with-spring
```
### @ExceptionHandler
```
Exception Handler annotation is used to handle specific exceptions and will merge the execution to the annoted method.
Ex :     @ExceptionHandler({ AccessDeniedException.class })
```
