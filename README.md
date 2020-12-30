# eventsystem
 Simple Java eventsystem.<br><br>
**_Calling_**
+ Call your event where it needs to be invoked<br>
  <code>EventManager.getInstance().call(new MyEvent());</code>
+ Another way if you need to access fields or methods in the event class<br>
  <code>MyEvent myEvent = new MyEvent();</code><br>
  <code>myEvent.doStuff();</code><br>
  <code>EventManager.getInstance().call(myEvent);</code>

**_Listening_**
+ Listen for events in the class<br>
  <code>EventManager.getInstance().register(this);</code>
+ Stop listening<br>
  <code>EventManager.getInstance().unregister(this);</code>
+ The listener will look for methods containing the Listener annotation<br>
  <code>@Listener</code><br>
  <code>public void onMyEvent(MyEvent event) {</code><br>
  <code>doStuff();</code><br>
  <code>}</code>
