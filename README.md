🏦 Bank Management System (Console-Based)

A console-based banking application built using Core Java, demonstrating strong understanding of Object-Oriented Programming, Collections, Exception Handling, File I/O, and Thread Safety.

This project simulates basic banking operations such as account creation, deposits, withdrawals, and transaction history tracking.

🚀 Features

✅ Create Bank Account

✅ Deposit Money

✅ Withdraw Money

✅ Check Account Balance

✅ View Transaction History (with timestamps)

✅ PIN-based Authentication

✅ Data Persistence using File Serialization

✅ Custom Exception Handling

✅ Thread-Safe Account Operations

🧠 Concepts Used

OOP Principles

Encapsulation

Abstraction

Object Modeling

Java Collections

HashMap (O(1) account lookup)

ArrayList (Transaction history)

Exception Handling

Custom Exception (InsufficientBalanceException)

Input validation

File Handling

Object Serialization

Persistent Data Storage

Thread Safety

synchronized methods

Collections.synchronizedMap()

🏗️ Project Structure
Bank-Management-System/
│
├── model/
│   └── BankAccount.java
│
├── util/
│   └── FileUtil.java
│
├── exception/
│   └── InsufficientBalanceException.java
│
└── BankManagementSystem.java

🖥️ How to Run
1️⃣ Clone the repository
git clone https://github.com/your-username/Bank-Management-System.git

2️⃣ Open in any IDE (IntelliJ / Eclipse / VS Code)
3️⃣ Compile and Run:
javac BankManagementSystem.java
java BankManagementSystem

📸 Sample Output
====== BANK MANAGEMENT SYSTEM ======
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. View Transaction History
6. Exit

🔒 Authentication Flow

Each account is protected with a PIN.

User must enter correct PIN to:

Deposit

Withdraw

Check balance

View transactions

💾 Data Persistence

Account data is saved into:

accounts.dat


Even after restarting the application, account data remains stored.

🧾 Example Transaction Log
12-02-2026 10:32:11 - Account created with ₹5000
12-02-2026 10:35:02 - Deposited ₹2000
12-02-2026 10:40:55 - Withdrawn ₹1500

🎯 Why This Project?

This project demonstrates the ability to:

Design a real-world system logically

Implement secure data handling

Write modular and maintainable Java code

Handle edge cases and validations

Apply proper software engineering practices

🔮 Future Enhancements

🔐 Password hashing (BCrypt)

🌐 Spring Boot REST API version

🗄️ Database integration (MySQL/PostgreSQL)

🖥️ GUI Version (Java Swing / JavaFX)

🧪 JUnit Testing

🐳 Docker Deployment

👨‍💻 Author

Lokesh Manickam
Java Developer | Core Java | OOP | Problem Solver
