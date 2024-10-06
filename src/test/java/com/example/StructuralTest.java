
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StructuralTest {

    private static final String PROJECT_ROOT = System.getProperty("user.dir");

    @BeforeAll
    static void setUp() {
        // Ensure we're in the correct directory
        assertTrue(new File(PROJECT_ROOT, "src").exists(), "Project structure is incorrect. Make sure you're running the test from the project root.");
    }

    @Test
    void testDirectoryStructure() {
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp").exists(), "Main package directory doesn't exist");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/controller").exists(), "Controller package doesn't exist");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/service").exists(), "Service package doesn't exist");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/repository").exists(), "Repository package doesn't exist");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/model").exists(), "Model package doesn't exist");
        assertTrue(new File(PROJECT_ROOT, "src/test/java/com/example/restaurantapp").exists(), "Test package directory doesn't exist");
    }

    @Test
    void testRequiredFiles() {
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/Application.java").exists(), "Application.java is missing");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/controller/MenuItemController.java").exists(), "MenuItemController.java is missing");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/service/MenuItemService.java").exists(), "MenuItemService.java is missing");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/repository/MenuItemRepository.java").exists(), "MenuItemRepository.java is missing");
        assertTrue(new File(PROJECT_ROOT, "src/main/java/com/example/restaurantapp/model/MenuItem.java").exists(), "MenuItem.java is missing");
        assertTrue(new File(PROJECT_ROOT, "src/test/java/com/example/restaurantapp/MenuItemControllerTest.java").exists(), "MenuItemControllerTest.java is missing");
    }

    @Test
    void testApplicationClass() throws ClassNotFoundException {
        Class<?> applicationClass = Class.forName("com.example.restaurantapp.Application");
        assertTrue(Modifier.isPublic(applicationClass.getModifiers()), "Application class should be public");
        
        Method mainMethod = null;
        try {
            mainMethod = applicationClass.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("main method not found in Application class");
        }
        assertTrue(Modifier.isPublic(mainMethod.getModifiers()) && Modifier.isStatic(mainMethod.getModifiers()), "main method should be public and static");
    }

    @Test
    void testMenuItemControllerClass() throws ClassNotFoundException {
        Class<?> controllerClass = Class.forName("com.example.restaurantapp.controller.MenuItemController");
        assertTrue(Modifier.isPublic(controllerClass.getModifiers()), "MenuItemController class should be public");
        
        assertDoesNotThrow(() -> controllerClass.getMethod("getMenuItems"), "getMenuItems method not found in MenuItemController");
        assertDoesNotThrow(() -> controllerClass.getMethod("getMenuItemById", Long.class), "getMenuItemById method not found in MenuItemController");
        assertDoesNotThrow(() -> controllerClass.getMethod("createMenuItem", Class.forName("com.example.restaurantapp.model.MenuItem")), "createMenuItem method not found in MenuItemController");
        assertDoesNotThrow(() -> controllerClass.getMethod("deleteMenuItem", Long.class), "deleteMenuItem method not found in MenuItemController");
    }

    @Test
    void testMenuItemServiceClass() throws ClassNotFoundException {
        Class<?> serviceClass = Class.forName("com.example.restaurantapp.service.MenuItemService");
        assertTrue(Modifier.isPublic(serviceClass.getModifiers()), "MenuItemService class should be public");
        
        assertDoesNotThrow(() -> serviceClass.getMethod("getMenuItems"), "getMenuItems method not found in MenuItemService");
        assertDoesNotThrow(() -> serviceClass.getMethod("getMenuItemById", Long.class), "getMenuItemById method not found in MenuItemService");
        assertDoesNotThrow(() -> serviceClass.getMethod("createMenuItem", Class.forName("com.example.restaurantapp.model.MenuItem")), "createMenuItem method not found in MenuItemService");
        assertDoesNotThrow(() -> serviceClass.getMethod("deleteMenuItem", Long.class), "deleteMenuItem method not found in MenuItemService");
    }

    @Test
    void testMenuItemRepositoryInterface() throws ClassNotFoundException {
        Class<?> repositoryInterface = Class.forName("com.example.restaurantapp.repository.MenuItemRepository");
        assertTrue(Modifier.isPublic(repositoryInterface.getModifiers()) && repositoryInterface.isInterface(), "MenuItemRepository should be a public interface");
        assertTrue(org.springframework.data.jpa.repository.JpaRepository.class.isAssignableFrom(repositoryInterface), "MenuItemRepository should extend JpaRepository");
    }

    @Test
    void testMenuItemClass() throws ClassNotFoundException {
        Class<?> menuItemClass = Class.forName("com.example.restaurantapp.model.MenuItem");
        assertTrue(Modifier.isPublic(menuItemClass.getModifiers()), "MenuItem class should be public");
        
        assertDoesNotThrow(() -> menuItemClass.getDeclaredField("id"), "id field not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getDeclaredField("name"), "name field not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getDeclaredField("description"), "description field not found in MenuItem");
        
        assertDoesNotThrow(() -> menuItemClass.getMethod("getId"), "getId method not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getMethod("setId", Long.class), "setId method not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getMethod("getName"), "getName method not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getMethod("setName", String.class), "setName method not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getMethod("getDescription"), "getDescription method not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getMethod("setDescription", String.class), "setDescription method not found in MenuItem");
        
        assertDoesNotThrow(() -> menuItemClass.getConstructor(), "Default constructor not found in MenuItem");
        assertDoesNotThrow(() -> menuItemClass.getConstructor(Long.class, String.class, String.class), "Parameterized constructor not found in MenuItem");
    }

    @Test
    void testMenuItemControllerTestClass() throws ClassNotFoundException {
        Class<?> testClass = Class.forName("com.example.restaurantapp.MenuItemControllerTest");
        assertTrue(Modifier.isPublic(testClass.getModifiers()), "MenuItemControllerTest class should be public");
        
        assertDoesNotThrow(() -> testClass.getMethod("testGetMenuItems"), "testGetMenuItems method not found in MenuItemControllerTest");
        assertDoesNotThrow(() -> testClass.getMethod("testGetMenuItemById"), "testGetMenuItemById method not found in MenuItemControllerTest");
        assertDoesNotThrow(() -> testClass.getMethod("testCreateMenuItem"), "testCreateMenuItem method not found in MenuItemControllerTest");
        assertDoesNotThrow(() -> testClass.getMethod("testDeleteMenuItem"), "testDeleteMenuItem method not found in MenuItemControllerTest");
    }
}
