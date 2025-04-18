# BookVault 📚 (JDBC Edition)

A simple console-based Book Management System using Java and JDBC. This application allows users to manage a collection of books with options to add, update, delete, and view book details stored in a MySQL database.

## 🚀 Features

- ➕ Add new books  
- ❌ Remove books by name  
- ✏️ Update book details:
  - Name
  - Author
  - Price  
- 🔍 Search (view all) books  
- 📦 Menu-driven CLI for interaction  

## 🛠️ Tech Stack

- Java (Core)  
- JDBC (Java Database Connectivity)  
- MySQL  

## 🗄️ Database Setup

Ensure MySQL is installed and running.

### 1. Create a database
```sql
CREATE DATABASE batch1200;
```

### 2. (Optional) Create the `book` table manually  
> *This table is also created in the code when you select "Add book"*

```sql
CREATE TABLE book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name TEXT,
  price INT,
  author TEXT
);
```

## 🧑‍💻 How to Run

1. **Clone the repository**
```bash
git clone https://github.com/your-username/bookvault-jdbc.git
cd bookvault-jdbc
```

2. **Open the project in your preferred Java IDE**

3. **Update database credentials in `Book.java`:**
```java
String url = "jdbc:mysql://localhost:3306/batch1200";
String username = "root";
String password = "your_mysql_password";
```

4. **Run `Book.java`**

## 🖼️ CLI Preview

```text
Choose an operation:
1. Add book
2. Remove book
3. Update book name
4. Update book author
5. Update book price
6. Search book by name
7. Exit
```

## 🌱 Future Improvements

- GUI (Swing or JavaFX)  
- Login/authentication  
- Web version using Spring Boot  

## 🤝 Contributing

Contributions are welcome! Feel free to fork the project, create a branch, and open a pull request.

## 📄 License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).

