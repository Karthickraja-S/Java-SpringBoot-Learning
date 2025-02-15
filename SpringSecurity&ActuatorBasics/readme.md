<u> Spring security Introduction </u>

1. If you integrate spring-web dependency in pom.xml , my default it will block all the request and ask for Login credentials.
<br> Also, it will give you a default password in the spring starting application console.

### How to override default username & password
1. By specifying username & password in appln.properties <br>
   spring.security.user.name , spring.security.user.password, spring.security.user.roles
2. By Providing a UserDetailsService Bean inside Security Configuration class.
   ( This can be either INMemory / From an DataBase... )
3. Creating a service class that implements UserDetailsService and providing the
   implemented details in AuthenticationProvider Bean.
   ( Here, we have to implement our own UserDetailService Impl which returns a 
     userDetails Object with user related information !!! )


## Reference

1. https://docs.spring.io/spring-security/reference/servlet/getting-started.html
2. https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#servlet-authentication-unpwd

### Actuator
1. https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/production-ready-endpoints.html
2. https://docs.spring.io/spring-boot/appendix/application-properties/index.html#application-properties.actuator.management.endpoints.web.exposure.include
    

