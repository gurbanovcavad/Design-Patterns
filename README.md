# Design Patterns

## Creational: 

### 1. Builder Pattern is used to construct complex objects step by step. It allows an object to be created with different configurations without requiring large constructors with many parameters. The builder provides methods to set properties and then builds the final object. 

#### Example:
Source code: [`Builder.java`](src/main/java/org/example/creational/Builder.java)
```yaml
Explanation: In this example, the HttpRequest class uses the Builder design pattern through a static inner Builder class. 
The Builder class provides chained methods to set optional and required fields step by step. 
Once all desired values are set, the build() method is called, which creates a new immutable HttpRequest object using the builder’s current state. 
This allows flexible and readable object construction without needing a constructor with many parameters.
```    

### 2. Factory Pattern is used when a system needs to create different types of objects that belong to the same family or share a common interface. Instead of creating objects directly using constructors and writing multiple if-else or switch statements throughout the code, object creation is centralized in a factory class or method. The factory takes some input (such as a type or parameter) and returns the appropriate object instance.

#### Example: 
Source code: [`Factory.java`](src/main/java/org/example/creational/Factory.java)
```yaml
Explanation: This example demonstrates the Factory Design Pattern by centralizing the creation of PaymentService objects in a PaymentServiceFactory. 
Instead of instantiating CashPayment or CardPayment directly in the client code, the factory decides which implementation to return based on the input string. 
The client only depends on the PaymentService interface, not the concrete classes, which reduces coupling and improves extensibility.
```

### 3. Abstract Factory Pattern is used when a system needs to create families of related or dependent objects without specifying their concrete classes. Instead of creating objects directly, it provides a factory interface that produces multiple related objects that are designed to work together. This ensures consistency among created objects and allows the system to switch between different families of products easily (e.g., Windows UI vs Mac UI) without changing client code.

#### Example:
Source code: [`AbstractFactory.java`](src/main/java/org/example/creational/AbstractFactory.java)
```yaml
Explanation: This example demonstrates the Abstract Factory Design Pattern by defining a GUIFactory interface that creates a family of related objects (Button and CheckBox). 
Concrete factories (WindowsFactory and MacFactory) implement this interface and produce platform-specific implementations of these components. 
Instead of instantiating WindowsButton, MacButton, WindowsCheckBox, or MacCheckBox directly, the client code depends only on the GUIFactory interface. 
Based on user input, the appropriate factory is selected at runtime, and it generates a consistent set of UI components for that platform. 
This ensures that related objects (button and checkbox) always belong to the same family and improves scalability when adding new platforms.
```

### 4. Singleton Pattern is used when a class should have only one instance throughout the application and provide a global point of access to it. It ensures that the object is created only once and reused whenever it is needed. This is useful for shared resources like loggers, configuration managers, or database connections.

#### Example:
Source code: [`Singleton.java`](src/main/java/org/example/creational/Singleton.java)

```yaml
Explanation: This example demonstrates the Singleton Design Pattern using the Logger class. 
The Logger constructor is made private to prevent direct instantiation. 
The getInstance() method ensures that only one instance of Logger is created and reused for all future calls. 
If the instance is null, it creates a new Logger object; otherwise, it returns the already existing instance. 
This guarantees that the same Logger object is shared across the application, ensuring a single point of access and consistent behavior.
```

### 5. Prototype Pattern is used when creating new objects is expensive or complex, and instead of building objects from scratch, existing objects are cloned and modified as needed. It allows copying existing instances (prototypes) to create new objects efficiently, reducing the cost of repeated initialization.

#### Example:
Source code: [`Prototype.java`](src/main/java/org/example/creational/Prototype.java)

```yaml
Explanation: This example demonstrates the Prototype Design Pattern using different types of test cases (ApiTestCase and UiTestCase). 
Instead of creating new test case objects from scratch each time, the system stores predefined prototypes in a TestCaseRegistry. 
When a test case is needed, the cloneTestCase() method is used to create a copy of an existing object. This allows efficient object creation by reusing existing configurations. 
The cloned objects can also be modified independently, as shown when the browser field of a cloned UI test case is changed without affecting the original prototype. 
This pattern is useful when object creation is costly or when many similar objects are required with slight variations.
```