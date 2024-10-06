# Structure Map for Restaurant Management System

```
/src
  /main
    /java
      /com
        /example
          /restaurantapp
            Application.java (public class Application { public static void main(String[] args) })
            /controller
              MenuItemController.java (public class MenuItemController { public List<MenuItem> getMenuItems(); public MenuItem getMenuItemById(Long id); public MenuItem createMenuItem(MenuItem menuItem); public void deleteMenuItem(Long id); })
            /service
              MenuItemService.java (public class MenuItemService { public List<MenuItem> getMenuItems(); public MenuItem getMenuItemById(Long id); public MenuItem createMenuItem(MenuItem menuItem); public void deleteMenuItem(Long id); })
            /repository
              MenuItemRepository.java (public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {})
            /model
              MenuItem.java (public class MenuItem { private Long id; private String name; private String description; public Long getId(); public void setId(Long id); public String getName(); public void setName(String name); public String getDescription(); public void setDescription(String description); public MenuItem(); public MenuItem(Long id, String name, String description); })
/src
  /test
    /java
      /com
        /example
          /restaurantapp
            MenuItemControllerTest.java (public class MenuItemControllerTest { public void testGetMenuItems(); public void testGetMenuItemById(); public void testCreateMenuItem(); public void testDeleteMenuItem(); })
```