# ByteBank: A Console-Based ATM Simulator

![Language](https://img.shields.io/badge/Language-Java-blue.svg)

ByteBank is a robust and easy-to-understand ATM machine simulator that runs entirely in the console. This project was built to demonstrate core Object-Oriented Programming (OOP) principles and robust exception handling in Java. It provides a clean and modular architecture for simulating essential banking operations.

## ✨ Key Features

*   **Secure User Authentication:** Validates users based on a unique User ID and PIN.
*   **Core Banking Operations:**
    *   Check Account Balance
    *   Withdraw Cash
    *   Deposit Funds
    *   Transfer Funds between accounts
*   **Robust Exception Handling:** Gracefully manages common errors such as:
    *   Incorrect PIN or User ID
    *   Insufficient funds for withdrawal
    *   Invalid numeric/non-numeric inputs
    *   Attempts to transfer to a non-existent account
*   **User-Friendly Interface:** Simple and intuitive menu-driven navigation in the console.
*   **Graceful Exit:** Allows users to exit the application from the login screen or log out from the main menu.

## 🏛️ Project Architecture

The project is intentionally designed with a minimalist and modular structure, making it easy to understand the flow of logic and the separation of concerns.

*   **`ByteBank.java`**: Acts as the main application driver and the user interface controller (`ATM` class). It handles all user input and output, and orchestrates the calls to the backend logic.
*   **`Bank.java`**: Represents the bank itself. It acts as a database for storing and managing all user accounts, and is responsible for user authentication and account lookups.
*   **`Account.java`**: The data model. This class represents a single user's bank account, holding sensitive data like the PIN and balance. It contains the core business logic for transactions (e.g., rules for withdrawing and depositing).

## 🛠️ Technologies Used

*   **Java**: The core programming language.
*   **JDK (Java Development Kit)**: Required to compile and run the source code.

## 🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

You must have the Java Development Kit (JDK) installed on your system. To check if you have it installed, open your terminal or command prompt and run:

```sh
java -version
```

If you see a version number (e.g., `11.0.12` or higher), you are ready to go.

### Execution Steps

1.  **Clone the Repository**

    Open your terminal and clone this repository to your local machine:

    ```sh
    git clone https://github.com/Mhatreyash/ByteBank.git
    ```

2.  **Navigate to the Project Directory**

    ```sh
    cd ByteBank
    ```

3.  **Compile the Java Code**

    From the root `ByteBank` directory, run the Java compiler. This command targets all `.java` files inside the `src` folder.

    ```sh
    javac src/*.java
    ```
    This will create the necessary `.class` files in the `src` directory.

4.  **Run the Application**

    Now, execute the compiled code. The `-cp src` flag tells Java where to find the compiled classes, and `ByteBank` is the main class to run.

    ```sh
    java -cp src ByteBank
    ```

You should now see the "Welcome to ByteBank!" message and be prompted for your User ID.

## 📖 How to Use the Application

The application starts with a login prompt. You can use one of the two pre-loaded dummy accounts to test the system:

| User ID   | PIN   | Initial Balance |
| --------- | ----- | --------------- |
| `user123` | `1234`| $1200.50        |
| `user456` | `5678`| $350.75         |

*   At the login prompt, you can also type `exit` to quit the application.
*   Once logged in, a menu will appear with options from `1` to `5`.
*   Simply enter the number corresponding to the action you wish to perform.

## 🎓 OOP Concepts Demonstrated

This project is a practical implementation of the following Object-Oriented principles:

*   **Encapsulation**: The `Account` class hides its data (like `balance` and `pin`) from the outside world, exposing it only through public methods (`getBalance()`, `withdraw()`, etc.). This protects the data integrity.
*   **Modularity**: The system is broken down into logical components (`ATM`, `Bank`, `Account`), where each class has a single, well-defined responsibility.
*   **Abstraction**: The `ATM` class provides a simple interface (e.g., a menu) to the user, hiding the complex underlying logic of account validation, database lookups, and transaction processing.