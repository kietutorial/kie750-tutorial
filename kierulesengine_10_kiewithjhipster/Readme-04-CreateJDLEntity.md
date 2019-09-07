# Create Jhipster's JDL  

## Simple JDL

The file name is Message.jh:<br>

```
entity Message {
	message String,
	status StatusType
}

enum StatusType {
	HELLO, GOODBYE
}
```

* Note<br>
For some reason we could not add <b>paging, filter and services</b> to the JDL.

 
## Create Entity

```
jhipster import-jdl Message.jh

```
