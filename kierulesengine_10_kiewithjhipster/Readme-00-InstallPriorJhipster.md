# Step - Setup Jhipster For Version 4.14.5

##Prerequsites
-------------
Node 8.12.0<br/>
NPM 6.4.1<br/>
yarn 1.17.3<br/>
Jhipster 4.14.5<br/>


##Install Jhipster Generator
sudo npm install -g generator-jhipster@4.14.5

Note:<br/> 
On linux, we have to use supereuser.<br/>
Change the created .git directory permission to chmod -R 777 .git.


##Create project directory:
kiewithjhipster-02-helloworld


##Install jhipster application in directory
jhipster

```
- Answer question for application:
? Which *type* of application would you like to create? Monolithic application (recommended for simple projects)
? What is the base name of your application? kiewithjhipster
? What is your default Java package name? com.aikiinc.hello
? Do you want to use the JHipster Registry to configure, monitor and scale your application? No
? Which *type* of authentication would you like to use? JWT authentication (stateless, with a token)
? Which *type* of database would you like to use? SQL (H2, MySQL, MariaDB, PostgreSQL, Oracle, MSSQL)
? Which *production* database would you like to use? MySQL
? Which *development* database would you like to use? H2 with disk-based persistence
? Do you want to use the Spring cache abstraction? Yes, with the Hazelcast implementation (distributed
 cache, for multiple nodes, supports rate-limiting for gateway applications)
? Do you want to use Hibernate 2nd level cache? Yes
? Would you like to use Maven or Gradle for building the backend? Maven
? Which other technologies would you like to use? WebSockets using Spring Websocket
? Which *Framework* would you like to use for the client? Angular 5
? Would you like to enable *SASS* support using the LibSass stylesheet preprocessor? (y/N) Y
? Would you like to use a Bootswatch theme (https://bootswatch.com/)? Cosmo
? Choose a Bootswatch variant navbar theme (https://bootswatch.com/)? Primary
? Would you like to enable internationalization support? Yes
? Please choose the native language of the application English
? Please choose additional languages to install (Press <space> to select, <a> to toggle all, <i> to invert select
ion) N
? Besides JUnit and Jest, which testing frameworks would you like to use? Protractor
? Would you like to install other generators from the JHipster Marketplace? (y/N) 
```

## Run application using springboot in maven:
./mvnw<br/>
- See application in browser:<br/>
localhost:8080


## Run application using yarn:
sudo yarn install<br/>
- See application in browser:<br/>
localhost:9000<br/>
** App came up, but backend DB was not loading


