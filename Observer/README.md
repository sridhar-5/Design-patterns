## Observer Design Pattern

### What is it?
- It is a behavioural design pattern.
- It lets you define a subscription mechanism to notify multiple objects about any events that happens to the objects that they are observing.
- Applications typically use the observer pattern when, the change of state in one object may require changing other objects, and actual set of objects is unknown and changes dynamically.

### Why is it required?
- Assume that you have two entities, `Customer` and `Shop`, Lets say that the customer is interested in buying something from the shop, and the item is currently not available in the shop and it's expected to arrive soon.
- Now, A few ways in which the `Customer` gets to know when the item is back in stock:
  - Customer walks to the store everyday and enquires about the item availability.  [ **Inefficient, it wastes a lot of customer's time and energy.**]
  - The shop sends emails about each items availability to all the customers that shop has ever had.  [ **Waste of shops computational resources, and we would be spamming the customer who do not have the interest with unnecessary emails.**] 
  - The customers showcase their interest in the `Out of stock` items, the shop notes the customers emails and sends emails to the customers with interest when the product is back in stock. **[This approach seems efficient, broadcasts essential information to the customers that need the information.]**
- The third approach is similar to what the observer pattern tries to explain.

### Checkout the code: [here](/src)
#### Quick Summary of what i tried implementing:
- Implemented the above described scenario, where users are subscribed to the "Iphone" stock update related events.
  - I've only hardcoded two events here (But we can create more specific events with robust messaging to the subscribers):
    - Iphone restocked
    - Iphone Out of stock
  - Checkout the [Main.java](src/Main.java), user1 is subscribed to both the events and the user-2 is subscribed to only the restock event and hence my o/p:
  ```
    User Sridhar received notification:
    Event Type: Iphone stock refilled
    Message #id 200 : Iphone restocked, visit the store now and get yours!
    User Hello received notification:
    Event Type: Iphone stock refilled
    Message #id 200 : Iphone restocked, visit the store now and get yours!
    User Sridhar received notification:
    Event Type: Iphone out of stock
    Message #id 123 : Unfortunately, IPhone went out of stock
  ```
  
Some terms:
- **Publisher:** This the same subject class that publishes notifications to the classes that are subscribed to it.
- **Subscriber:** All objects that want to track changes to the publisher’s state are called subscribers.











References: 
- [Refactoring Guru](https://refactoring.guru/design-patterns/observer)