# Configuring KIE To Work With Jhipster 


##Config pom.xml

In pom.xml add the KIE version:<br/>

```
    <properties>
		.
		.

		<!-- KIE version -->
		<runtime.version>7.5.0.Final</runtime.version>        
    </properties>
```

Add the dependencies:<br/>

```
    <dependencies>
    	.
    	.
		<!-- KIE -->
		<dependency>
			<groupId>org.kie</groupId>
			<artifactId>kie-api</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		<dependency>
			<groupId>org.drools</groupId>
			<artifactId>drools-decisiontables</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		<dependency>
			<groupId>org.jbpm</groupId>
			<artifactId>jbpm-bpmn2</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		<dependency>
			<groupId>org.jbpm</groupId>
			<artifactId>jbpm-flow</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		<dependency>
			<groupId>org.jbpm</groupId>
			<artifactId>jbpm-shared-services</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		<dependency>
			<groupId>org.jbpm</groupId>
			<artifactId>jbpm-runtime-manager</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		<dependency>
			<groupId>org.jbpm</groupId>
			<artifactId>jbpm-human-task-workitems</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		<dependency>
			<groupId>org.jbpm</groupId>
			<artifactId>jbpm-persistence-jpa</artifactId>
			<version>${runtime.version}</version>
		</dependency>
		.
		.
    <dependencies>
```

Don't add the jbpm-test dependency. This is what is screwing the configuration:<br/>

```	
		<dependency>
			<groupId>org.jbpm</groupId>
			<artifactId>jbpm-test</artifactId>
			<version>${runtime.version}</version>
		</dependency>			
```


### Issue with KIE version 7.5.0:

```
Error: [com.aikiinc.bpmn.hello:7 - Begin:2] -- com.aikiinc.hello.domain.Message cannot be cast to com.aikiinc.hello.domain.Message
org.jbpm.workflow.instance.WorkflowRuntimeException: [com.aikiinc.bpmn.hello:7 - Begin:2] -- com.aikiinc.hello.domain.Message cannot be cast to com.aikiinc.hello.domain.Message
```

#####Solution:
Use version 7.23.0.Final or Greater. Change pom.xml version:

```
		<!-- KIE version -->
		<runtime.version>7.23.0.Final</runtime.version>        
```

