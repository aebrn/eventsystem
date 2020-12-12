# eventsystem
 Simple Java eventsystem.<br><br>
**_Calling_**
+ Call your event where it needs to be invoked
  <code>EventManager.getInstance().call(new MyEvent());</code>
+ Another way if you need to access fields or methods in the event class
  <code>MyEvent myEvent = new MyEvent();<br>
  myEvent.doStuff();<br>
  EventManager.getInstance().call(myEvent);</code>

**_Listening_**
+ Listen for events in the class
  <code>EventManager.getInstance().register(this);</code>
+ Stop listening<br>
  <code>EventManager.getInstance().unregister(this);</code>
+ The listener will look for methods containing the Listener annotation<br>
  <code>@Listener<br>
  public void onMyEvent(MyEvent event) {<br>
  doStuff();<br>
  }</code>