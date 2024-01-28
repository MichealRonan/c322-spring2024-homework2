package iu.msronan.edu.c322spring2024homework2.repository;

import iu.msronan.edu.c322spring2024homework2.model.Guitar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {
    private InventoryRepository repository;

    @Test
    void addGuitar() {
        repository = new InventoryRepository();

        Guitar guitar = new Guitar("111", 1000.0, "Ford", "Model1", "Type1", "Wood1", "Wood2");
        repository.addGuitar(guitar);

        Guitar found = repository.getGuitar("111");
        assertNotNull(found);
        assertEquals("Ford", found.getBuilder());

        repository = new InventoryRepository();

        int initialSize = repository.search(new Guitar(null, 0, null, null, null, null, null)).size();
        repository.addGuitar(new Guitar("232", 1500.0, "Apple", "Model2", "Type2", "Wood3", "Wood4"));

        int newSize = repository.search(new Guitar(null, 0, null, null, null, null, null)).size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void getGuitar() {
        repository = new InventoryRepository();

        repository.addGuitar(new Guitar("423", 2000.0, "Adidas", "Model3", "Type3", "Wood5", "Wood6"));
        Guitar guitar = repository.getGuitar("423");

        assertNotNull(guitar);
        assertEquals("Adidas", guitar.getBuilder());
        assertEquals(2000.0, guitar.getPrice());
    }

    @Test
    void search() {
        repository = new InventoryRepository();

        repository.addGuitar(new Guitar("453", 2500.0, "Tesla", "Model4", "Type4", "Wood7", "Wood8"));
        repository.addGuitar(new Guitar("765", 3000.0, "Tesla", "Model5", "Type5", "Wood7", "Wood9"));

        List<Guitar> found = repository.search(new Guitar(null, 0, "Tesla", null, null, "Wood7", null));
        assertEquals(2, found.size());
        assertTrue(found.stream().allMatch(guitar -> guitar.getBuilder().equals("Tesla") && guitar.getBackWood().equals("Wood7")));
    }
}