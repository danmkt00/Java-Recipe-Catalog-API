# 🍽️ Recipe Catalog API

A RESTful API for managing and searching recipes.  
Store recipes with a title, ingredients, and category, and perform text-based searches using **Spring Boot** and **Spring Data JPA**.  

This project is designed as a fully functional backend application, suitable for local development, learning, or extension into a larger app.

---

## 🚀 Features

- Add, list, and search recipes
- Search by title or category
- Simple REST API design
- PostgreSQL database integration
- Clean project structure with Controller, Service, DTO, and Repository layers

---

## 🧩 Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/recipes` | Get all recipes |
| `POST` | `/recipes` | Add a new recipe |
| `GET` | `/recipes/search?title=cake` | Search recipes by title |
| `GET` | `/recipes/category?category=dessert` | Search recipes by category |

