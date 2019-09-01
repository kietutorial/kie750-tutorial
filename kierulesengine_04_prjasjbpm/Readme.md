# Demonstrating The Basic Generated JBPM Rule As A (JBPM) Process

The Drools rule version processes the fact Message.java. It test its status to see if it is HELLO (0). If so it set the status to 1, GOODBYE and the message to "Goodbye Cruel World".

# Processing Task
We are going to do the same using a process flows with tasks:<br/>
Begin<br/>
Set GoodBye<br/> 
End<p/>

I always add a Begin and End to my processes to add pre and post processing. There is a convergent gateway that test if the status is 0. If it is zero, it goes to the END task by doing nothing. If it is not zero, it goes to the Set GoodBye task.<p/>

The GoodBye task sets the message "Goodbye Cruel World" and the status to 1.




