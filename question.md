# CRUD Operations with Java Spring Boot

## Overview
In this task, you will implement a simple CRUD (Create, Read, Update, Delete) application using Java Spring Boot. The application will manage a collection of menu items, allowing users to create, read, and delete menu items via a REST API. You will be required to implement the necessary controllers, services, and repositories to achieve this functionality.

## Question Requirements
You are provided with a Spring initializer template. You need to add the following files, folders, and classes to complete the application. The estimated time to complete each requirement is mentioned alongside.

1. **Model Class (15 mins)**
    - Create a class `MenuItem` in the `model` package.
    - The class should have the following fields: `Long id`, `String name`, and `String description`.
    - Implement getters, setters, and constructors (default and parameterized) for the `MenuItem` class.

2. **Repository Interface (10 mins)**
    - Create an interface `MenuItemRepository` in the `repository` package.
    - Extend `JpaRepository<MenuItem, Long>` to provide CRUD operations for `MenuItem`.

3. **Service Class (20 mins)**
    - Create a class `MenuItemService` in the `service` package.
    - Implement the following methods:
        - `List<MenuItem> getMenuItems()`: Retrieves all menu items.
        - `MenuItem getMenuItemById(Long id)`: Retrieves a menu item by its ID.
        - `MenuItem createMenuItem(MenuItem menuItem)`: Creates a new menu item.
        - `void deleteMenuItem(Long id)`: Deletes a menu item by its ID.

4. **Controller Class (25 mins)**
    - Create a class `MenuItemController` in the `controller` package.
    - Implement the following REST endpoints:
        - `GET /menuItems`: Returns a list of all menu items.
        - `GET /menuItems/{id}`: Returns a menu item by its ID.
        - `POST /menuItems`: Creates a new menu item.
        - `DELETE /menuItems/{id}`: Deletes a menu item by its ID.
    - Ensure the endpoints return appropriate HTTP status codes:
        - `200 OK` for successful GET requests.
        - `201 Created` for successful POST requests.
        - `204 No Content` for successful DELETE requests.
        - `404 Not Found` for invalid menu item IDs.

## Example Scenarios
- **GET /menuItems**: Should return a list of all menu items with status `200 OK`.
- **GET /menuItems/{id}**: Should return the menu item with the given ID, or `404 Not Found` if the menu item does not exist.
- **POST /menuItems**: Should create a new menu item and return the created menu item with status `201 Created`.
- **DELETE /menuItems/{id}**: Should delete the menu item with the given ID and return status `204 No Content`, or `404 Not Found` if the menu item does not exist.