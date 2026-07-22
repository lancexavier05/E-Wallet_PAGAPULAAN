E-Wallet System

 Overview

The E-Wallet System is a JavaFX desktop application developed as part of our Object-Oriented Programming project. It allows users to perform basic digital wallet transactions such as Cash In, Cash Out, Send Money, Pay Merchant, and viewing transaction history. The application also includes an Admin Panel for managing users and monitoring wallet information.

This version of the project adds Java Serialization to save the user's login session, allowing users to stay logged in even after closing and reopening the application. It also introduces three design patterns (Singleton, Facade, and Strategy) to improve the structure of the transaction-handling code, and updated UML diagrams for the main feature, **Send Money**.

 Features

 User Features
- Register a new account
- Login using phone number and PIN
- Cash In
- Cash Out
- Send Money
- Pay Merchant
- View Transaction History
- Automatic login session using Java Serialization

 Admin Features
- Admin Login
- View registered users
- Manage wallet information
- Monitor transactions

 Technologies Used
- Java
- JavaFX
- MySQL
- JDBC
- Maven
- Java Serialization
- Git & GitHub

## Project Structure
- Login.java
- MainApp.java
- Dashboard.java
- User.java
- UserDAO.java
- WalletDAO.java
- TransactionDAO.java
- Session.java
- SessionManager.java
- Database.java *(Singleton)*
- WalletTransactionFacade.java *(Facade)*
- TransactionStrategy.java, CashInStrategy.java, CashOutStrategy.java, SendMoneyStrategy.java, PayMerchantStrategy.java *(Strategy)*

## Java Serialization

This project uses Java Serialization to maintain the user's login session.

When a user logs in successfully, the application creates a file named `session.dat`. This file stores the user's session information.

Whenever the application starts, it checks if `session.dat` exists.

- If a valid session is found, the application opens the Dashboard automatically.
- If no session exists, the Login page is displayed.
- When the user logs out, the session file is deleted automatically.

This feature improves the user experience by allowing users to continue their session without logging in every time they open the application.

## Design Patterns Applied

As part of this activity, three design patterns were implemented in the transaction-handling part of the system: one Creational, one Structural, and one Behavioral.

### 1. Singleton (Creational) — `Database`

`Database` was refactored into a Singleton so that the whole application shares a single, consistent point of access to the database connection configuration (URL, username, password), instead of that configuration being duplicated or reconstructed by different classes.

- The constructor is private, so no other class can call `new Database()`.
- `Database.getInstance()` lazily creates the one shared instance the first time it's needed and returns that same instance on every later call.
- Existing DAO classes (`UserDAO`, `WalletDAO`, `TransactionDAO`, `AdminDAO`) still call `Database.getConnection()` as before; that static method simply routes through the singleton instance.

### 2. Facade (Structural) — `WalletTransactionFacade`

Before this change, `CashIn`, `CashOut`, `SendMoney`, and `PayMerchant` each called `WalletDAO` and `TransactionDAO` directly and repeated almost the same steps: check the wallet, check the balance, debit/credit, then record the transaction.

`WalletTransactionFacade` hides that coordination behind four simple, high-level methods:
- `cashIn(userId, amount)`
- `cashOut(userId, amount)`
- `sendMoney(userId, recipientPhone, amount)`
- `payMerchant(userId, merchantCode, amount)`

Each method returns a `TransactionResult` (success/failure with an error message), so the JavaFX controllers no longer need to know about `WalletDAO`/`TransactionDAO`/`UserDAO` internals or repeat the same validation and bookkeeping logic in four different places.

### 3. Strategy (Behavioral) — `TransactionStrategy`

`CashIn`, `CashOut`, `SendMoney`, and `PayMerchant` are all different "ways of moving money," differing mainly in which rule/DAO calls apply. The `TransactionStrategy` interface defines one common contract:

```java
WalletTransactionFacade.TransactionResult execute(int userId, BigDecimal amount, String extra);
```

Four concrete strategies implement it, each delegating to the Facade:
- `CashInStrategy`
- `CashOutStrategy`
- `SendMoneyStrategy` (uses `extra` as the recipient's phone number)
- `PayMerchantStrategy` (uses `extra` as the merchant code)

Each JavaFX controller now just holds the matching strategy and calls `execute(...)`, instead of containing an if/else chain or duplicating wallet/transaction logic.
 SOLID Principles Applied

 Single Responsibility Principle (SRP)

Each class in the project has a specific responsibility.

Examples:
- `Session` stores the user's session information.
- `SessionManager` handles saving, loading, and deleting the session file.
- `UserDAO` is responsible for user-related database operations.
- `WalletDAO` manages wallet-related database operations.
- `WalletTransactionFacade` is responsible only for coordinating a transaction's wallet and history-recording steps.
- Each `TransactionStrategy` implementation is responsible only for one transaction type's rules.

This separation makes the project easier to maintain and modify.

### Separation of Concerns

The application separates the user interface from the database operations.

Controllers handle user interactions and navigation, DAO classes communicate with the database, and the Facade/Strategy classes now handle the transaction business logic in between — keeping the code organized and easier to understand.

 UML Diagrams (Send Money — Main Feature)

The diagrams below were built using [app.diagrams.net](https://app.diagrams.net) and cover the **Send Money** feature, the app's main/core feature, showing how the Singleton, Facade, and Strategy patterns fit into the flow.

- **Class Diagram** — `class-diagram-sendmoney.drawio` — shows `SendMoney` controller → `TransactionStrategy` → `SendMoneyStrategy` → `WalletTransactionFacade` → DAOs → `Database` (Singleton).
- **Use Case Diagram** — `use-case-diagram.drawio` — shows the User and Recipient actors and the Send Money use case with its included sub-steps (enter recipient, enter amount, verify PIN, check balance, record transaction).
- **Activity Diagram** — `activity-diagram-sendmoney.drawio` — shows the step-by-step flow and validation decisions (fields filled, PIN correct, valid amount, recipient found, sufficient balance) leading to a successful transfer.
- **Sequence Diagram** — `sequence-diagram-sendmoney.drawio` — shows the message flow between `SendMoney`, `SendMoneyStrategy`, `WalletTransactionFacade`, `UserDAO`, `WalletDAO`, and `TransactionDAO`.
<img width="5608" height="3048" alt="image" src="https://github.com/user-attachments/assets/1b83adf7-417a-4991-ba52-cf9a26389523" />
<img width="3780" height="2524" alt="image" src="https://github.com/user-attachments/assets/5ae83ed5-84d7-41b3-be8c-f68d1163bd23" />
<img width="3356" height="4884" alt="image" src="https://github.com/user-attachments/assets/e262c58e-14a2-4a56-a86e-1343d8bc425b" />
<img width="5448" height="6436" alt="image" src="https://github.com/user-attachments/assets/3c9c74f7-2f62-4e53-aec2-5d6ce4f1d282" />







 How to Run the Project
1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Set up the required MySQL database.
4. Update the database credentials in `Database.java`.
5. Run `MainApp.java`.

## Testing the Session Feature
1. Register a new account or log in.
2. Verify that `session.dat` is created.
3. Close the application.
4. Open the application again.
5. The Dashboard should open automatically.
6. Click Logout.
7. Verify that `session.dat` is deleted.
8. The Login page should appear.

 Future Improvements
- Remember Me feature
- Password recovery
- Email or SMS verification
- Encrypted session storage
- Multi-device login support

 Developer

Lance Xavier Pagapulaan
Bachelor of Science in Information Technology
