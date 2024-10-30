## Singleton Pattern

What is it ?
- It ensures that a particular class has only one object throughout the application.
- It also provides the global point of access to that object to simply plug and play.

To understand the problems we might run into implementing parts of code without single ton pattern, i'm building a Logger for a messaging application:

### Version-1 (The problematic code) - check [here](/src/com/designpatterns/singleton/logger_v1/LoggerV1.java):

```java
package com.designpatterns.singleton.logger_v1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerV1 {
    private final String fileName = "logger_v1.txt";
    private PrintWriter printWriter;

    public LoggerV1(){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            printWriter = new PrintWriter(fileWriter, true);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void logMeesageSent(String message, String recepiant){
        printWriter.println("Message " + message + " to " + recepiant + " \n ");
    }

    public void logReceived(String sender, String message){
        printWriter.println(sender + " says: " + message + " \n ");
    }
}
```

The result of performing the operations specified as V1 in [Main](/src/Main.java)

Output:
```declarative
00112231 says: Hello

!

Message 0123456 to Bye!
```

Expected Output:
```declarative
Message 00011221 to Nope
00011221 says: Like this!
00112231 says: Hello
Meesage 0123456 to Bye!
```

#### Why is this happeneing ?
- Creating multiple instances of the logger class is resulting in concurrent writes
  - Each logger object has its own printwriter, and each of them writing to the same file.
- Generally it is not a good practice to have multiple instances lying floating around in code. 

#### What can we do to avoid this?
- Make the constructor private. [ This will avoid the creating the instances of singleton class across the application.]
- Create a static variable of the singleton class inside the same.
- Create a method something similar to `getIntance` -> This should create the instance of the singleton class if one isn't already present. if not just return the created object.

### Updated Code (Version - 2 -> Singleton class)

```java
package com.designpatterns.singleton.logger_v2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerV2 {
    private final String fileName = "logger_singleton_v2.txt";
    private PrintWriter printWriter;
    private static LoggerV2 singletonLogger = null;

    private LoggerV2(){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            printWriter = new PrintWriter(fileWriter, true);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static LoggerV2 getInstance(){
        if(singletonLogger == null){
           singletonLogger = new LoggerV2();  // if the instance doesn't already exist then create a new instance
        }
        return singletonLogger;      // if the instance already exists, then just return the existing instance.
    }

    public void logMeesageSent(String message, String recepiant){
        printWriter.println("Message " + message + " to " + recepiant + " \n ");
    }

    public void logReceived(String sender, String message){
        printWriter.println(sender + " says: " + message + " \n ");
    }
}

```

Output:
```declarative
Message 00011221 to Nope 
 
00011221 says: Like this! 
 
00112231 says: Hello 
 
Message 0123456 to Bye! 
 
00011221 says: Yessssss! 
```

Principles of the singleton pattern:
- Singleton pattern ensures that only one instance of the singleton class exists throughout the application.
- It provides global access to the instance [ Static object ]
- Supports lazy or eager initialization: We can create the instance, either when needed or when the class is loaded.
- Making the constructor private will restrict the direct instantiation, forcing the use of the access point provided.
