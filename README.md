# Android Calculator Automation Tests 📱✅

This project contains automated tests for the **Google Calculator app** on Android, developed using **Java**, **JUnit 5**, and **Appium**.

## 📌 Project Overview

The goal is to validate the core arithmetic operations of the Calculator app by simulating user interactions through Appium in a real or emulated Android device.

### ✅ Tested Operations

- Addition
- Subtraction
- Multiplication
- Division

Each operation is implemented as an individual test and validated using assertions to confirm that the correct result is displayed.

---

## 🧪 Technologies Used

- **Java 15+**
- **Appium Java Client**
- **JUnit 5**
- **Maven**
- **Appium Server v2**
- **Android Emulator or real device**

---

## 📁 Project Structure

calculator-project/
├── pom.xml
├── src/
│ └── test/
│ └── java/
│ ├── pages/
│ │ └── CalculatorPage.java
│ └── tests/
│ └── OperacoesTest.java
└── README.md


---

## 🚀 How to Run

1. Ensure you have **Appium Server running** (`appium` on terminal).
2. Start your **Android emulator** or connect a real device with USB debugging.
3. Run tests using Maven:

bash
mvn test

✅ Notes
This project assumes the Calculator app is already installed on the emulator/device.

Tested on Android 13 using the default Google Calculator app.
