## State Design Pattern

### What is it ?
- This is a behavioural design pattern. 
- Allows objects to alter its behaviour when its internal state changes.
  - For instance: In the example application we used, we want the ticket to behave differently based on its current status.
  - When ticketStatus is TO_DO, we can't move it to `TO_DO` again, and we can move it to the other 3 states.
  - The same with the other three statuses. Each status transition can have its own side effects, ex: `DONE` to `TO_DO` should trigger emails to all the stakeholders. [ Because this is a weird transition to happen ]. The same behaviour isnt necessarily true for other transitions.

### When is it used ?
- This kind of design pattern is used to represent different states of an object.
- and Also to handle transitions between those states.

First version of code in `Ticket Service`:

```declarative
    public void changeTicketState(Ticket ticket, TicketStatus newState){
        TicketStatus oldTicketState = ticket.getTicketStatus();

        if (oldTicketState.equals(TicketStatus.TO_DO)) {
            if (newState.equals(TicketStatus.IN_PROGRESS)) {
                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
            } else if (newState.equals(TicketStatus.DONE)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
            } else if(newState.equals(TicketStatus.TO_DO)){
                System.out.println("What is this transition?");
            }
        } else if (oldTicketState.equals(TicketStatus.IN_PROGRESS)) {
            if (newState.equals(TicketStatus.IN_PROGRESS)) {
                System.out.println("What is this transition?");
            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
            } else if (newState.equals(TicketStatus.DONE)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
            } else if(newState.equals(TicketStatus.TO_DO)){
                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
            }
        } else if (oldTicketState.equals(TicketStatus.CODE_REVIEW)) {
            if (newState.equals(TicketStatus.IN_PROGRESS)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
                System.out.println("What is this transition?");
            } else if (newState.equals(TicketStatus.DONE)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
            } else if(newState.equals(TicketStatus.TO_DO)){
                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
            }
        } else if (oldTicketState.equals(TicketStatus.DONE)) {
            if (newState.equals(TicketStatus.IN_PROGRESS)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
            } else if (newState.equals(TicketStatus.DONE)) {
                System.out.println("What is this transition?");
            } else if(newState.equals(TicketStatus.TO_DO)){
                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
            }
        }
    }
```

### There are a bunch of problems with this code:
- High cognitive complexity and Unreadable -> Very difficult to maintain
- chance of a mistakes happening is very high
- Lot of Duplicate code
- Inflexible - Adding a new behaviour for one of the state becomes complicated and error prone
- Violates Single responsibility principle. (`changeTicketState` is doing a lot more than just changing the state of the ticket, the method is also validating if the state transition is valid. (The validation logic should be decoupled ideally.)

### The advantages with refactoring such code and using the State Design pattern:
- Flexible
  - When you want to add a new state, just create a new state and define behaviour corresponding to the state in the `com/design_patterns/STATE`
  - When you want to change the behaviour of one of the existing states, it is very easy, just navigate to the state you want to modify here `com/design_patterns/STATE` and change the behaviour, 
    - Doing this in the above `if-else` construct code is a night mare and very error prone.
- Maintenance (Choose smartly): Though it is a bit of work to set it up initially, it helps us down the line when the code base grows, and the states increases. ( We should be smart in choosing when to pivot to using the SDP. if we are fairly clear that we would only have 2 states, it might not make a lot of sense.)
- Follows **single responsibility principle.**
- Obvious!, it solves the first three problems i mentioned above. (Duplicate code is a bit arguable, if the behaviour is similar)
