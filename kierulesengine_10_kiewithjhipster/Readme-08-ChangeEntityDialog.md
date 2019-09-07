# Modify The Generated Entity Dialog

##  File: message-dialog.component.ts
##### Path: /kiewithjhipster-02-helloworld/src/main/webapp/app/entities/message/message-dialog.component.ts
Set default value while developing:

```		.
		.
    ngOnInit() {
        this.isSaving = false;
    	this.message.message = 'ABCDEF';
    	this.message.status = StatusType.HELLO;
    }
		.
		.
```



Add routing back to popup:

```
import { ActivatedRoute, Router } from '@angular/router';
		.
		.
    constructor(
        public activeModal: NgbActiveModal,
        private messageService: MessageService,
        private eventManager: JhiEventManager,
        private router: Router
    ) {
    }	
		.
		.
    private onSaveSuccess(result: Message) {
		.
		.		
		this.router.navigate([{ outlets: { popup:'message-new' }}], 
			{ replaceUrl: true, queryParamsHandling: 'merge' });
    }
		.
		.		
```


See the data, model, changes from the back-end service:<br/>


```		
		.
		.		
    private onSaveSuccess(result: Message) {
        this.eventManager.broadcast({ name: 'messageListModification', content: 'OK'});
        this.isSaving = false;
		
		console.log("onSaveSuccess");
		console.log("result:" + JSON.stringify(result) ); 
		console.log("result.message:" + result.message ); 
		console.log("onSaveSuccess");
		
    	this.message.message = result.message;
    	this.message.status = result.status;

		
		this.router.navigate([{ outlets: { popup:'message-new' }}], 
			{ replaceUrl: true, queryParamsHandling: 'merge' });
    }
		.
		.		
```

This set's the data back to the front-end:<br/>

```		.
		.
	
    	this.message.message = result.message;
    	this.message.status = result.status;
		.
		.
```

