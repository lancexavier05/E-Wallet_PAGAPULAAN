E-Wallet System
Overview

The E-Wallet System is a JavaFX desktop application developed as part of our Object-Oriented Programming project. It allows users to perform basic digital wallet transactions such as Cash In, Cash Out, Send Money, Pay Merchant, and viewing transaction history. The application also includes an Admin Panel for managing users and monitoring wallet information.

This version of the project adds Java Serialization to save the user's login session, allowing users to stay logged in even after closing and reopening the application.

Features
User Features
Register a new account
Login using phone number and PIN
Cash In
Cash Out
Send Money
Pay Merchant
View Transaction History
Automatic login session using Java Serialization
Admin Features
Admin Login
View registered users
Manage wallet information
Monitor transactions
Technologies Used
Java
JavaFX
MySQL
JDBC
Maven
Java Serialization
Git & GitHub
Project Structure
Login.java
MainApp.java
Dashboard.java
User.java
UserDAO.java
WalletDAO.java
TransactionDAO.java
Session.java
SessionManager.java
Java Serialization

This project uses Java Serialization to maintain the user's login session.

When a user logs in successfully, the application creates a file named session.dat. This file stores the user's session information.

Whenever the application starts, it checks if session.dat exists.

If a valid session is found, the application opens the Dashboard automatically.
If no session exists, the Login page is displayed.
When the user logs out, the session file is deleted automatically.

This feature improves the user experience by allowing users to continue their session without logging in every time they open the application.

SOLID Principles Applied
Single Responsibility Principle (SRP)

Each class in the project has a specific responsibility.

Examples:

Session stores the user's session information.
SessionManager handles saving, loading, and deleting the session file.
UserDAO is responsible for user-related database operations.
WalletDAO manages wallet-related database operations.

This separation makes the project easier to maintain and modify.

Separation of Concerns

The application separates the user interface from the database operations.

Controllers handle user interactions and navigation, while DAO classes communicate with the database. This keeps the code organized and easier to understand.

How to Run the Project
Clone or download the repository.
Open the project in IntelliJ IDEA.
Set up the required MySQL database.
Update the database credentials in Database.java.
Run MainApp.java.
Testing the Session Feature
Register a new account or log in.
Verify that session.dat is created.
Close the application.
Open the application again.
The Dashboard should open automatically.
Click Logout.
Verify that session.dat is deleted.
The Login page should appear.
Future Improvements
Remember Me feature
Password recovery
Email or SMS verification
Encrypted session storage
Multi-device login support
Developer

Lance Xavier Pagapulaan

Bachelor of Science in Information Technology
