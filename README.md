# 🧪 Automated Web Testing Project (Cucumber + Selenium)

This project demonstrates automated UI testing using **Java**, **Cucumber (BDD)**, and **Selenium**, following the **Page Object Model** design pattern, with **Maven** as the build tool.

## 📂 Project Structure

```
src
├── test
│   └── java
│       └── com.lsantana.CucumberSelenium
│           ├── RunCucumberTest.java
│           ├── steps
|           ├── pages
│           └── utils
└── resources
    ├── features
    └── config.properties   
```

## 🚀 Technologies Used
 - Java 8+
 - Maven
 - Selenium WebDriver
 - Cucumber
 - JUnit
 - ChromeDriver

## ⚙️ How to Run

1. **Clone the repository:**
```bash
git clone https://github.com/Ovzmwil/CucumberSelenium.git
cd CucumberSelenium
```
2. **Run tests using Maven:**
```bash
mvn clean test
```
3. **View the test report:**

After execution, a file named `cucumber-reports.html` will be generated in the project path `target/`, containing detailed test results.

## 📝 Notes
- The project uses Java 1.8, so it's necessary to have the JRE environment configured.
- The project runs with Apache Maven, so it's necessary to have Apache Maven configured.
- The project needs a ChromeDriver compatible with your browser's version; the ChromeDriver in this project is 135.0.7049.114.
