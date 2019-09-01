#Passing Fact Data Between Task

ProcessTest.java:<br/>
It initialized the Member.java as a fact.
Pass parameter to kieSession using a Map parameter. At the end of the process the modified fact is logged and displayed.


sample.bpmn Process:<br>
There are three script task: Begin, Hello and End. I always add a Begin and End to my processes to add pre and post processing.<br/> 

##Modification Of The Message Object As Fact
The Begin and Hello task modifies the Message object by adding the task node name and a message that is modified the Message object.<br/>

Finally the End task shows the modified Message along when the processing end and the fact is return after processing.

###There Is A Test ProcessUtil

It's used to show the information inside the JBPM processes. Information like:
showTaskBegin(ProcessContext)<br/>
showTaskEnd(ProcessContext)<br/>
showTask(ProcessContext)<br/>
showGateWay(ProcessContext)<br/>
showFact(T)<br/>
showMessage(String)<br/>
showGateWay(boolean, ProcessContext)<br/>
showTaskName(ProcessContext)<br/>




