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
        Guitar guitar = new Guitar("111", 1000.0, Guitar.Builder.COLLINGS, "Model1", Guitar.Type.ACOUSTIC, Guitar.Wood.MAHOGANY, Guitar.Wood.ALDER);

        repository.addGuitar(guitar);

        Guitar found = repository.getGuitar("111");
        assertNotNull(found);
        assertEquals(Guitar.Builder.COLLINGS.toString(), found.getBuilder());

        repository = new InventoryRepository();

        int initialSize = repository.search(new Guitar(null, 0, null, null, null, null, null)).size();
        repository.addGuitar(new Guitar("232", 1500.0, Guitar.Builder.PRS, "Model2", Guitar.Type.ELECTRIC, Guitar.Wood.COCOBOLO, Guitar.Wood.CEDAR));

        int newSize = repository.search(new Guitar(null, 0, null, null, null, null, null)).size();
        assertEquals(initialSize , newSize);
    }

    @Test
    void getGuitar() {
        repository = new InventoryRepository();

        repository.addGuitar(new Guitar("423", 2000.0, Guitar.Builder.FENDER, "Model3", Guitar.Type.ACOUSTIC, Guitar.Wood.MAHOGANY, Guitar.Wood.INDIAN_ROSEWOOD));
        Guitar guitar = repository.getGuitar("423");

        assertNotNull(guitar);
        assertEquals(Guitar.Builder.FENDER.toString(), guitar.getBuilder());
        assertEquals(2000.0, guitar.getPrice());
    }

    @Test
    void search() {
        repository = new InventoryRepository();

        repository.addGuitar(new Guitar("453", 2500.0, Guitar.Builder.RYAN, "Model4", Guitar.Type.ACOUSTIC, Guitar.Wood.MAPLE, Guitar.Wood.SITKA));
        repository.addGuitar(new Guitar("765", 3000.0, Guitar.Builder.RYAN, "Model5", Guitar.Type.ELECTRIC, Guitar.Wood.MAPLE, Guitar.Wood.ADIRONDACK));

        List<Guitar> found = repository.search(new Guitar(null, 3000.0, Guitar.Builder.RYAN, null, null, Guitar.Wood.MAPLE, null));
        assertEquals(0, found.size());
        assertTrue(found.stream().allMatch(guitar -> guitar.getBuilder().equals(Guitar.Builder.RYAN) && guitar.getBackWood().equals(Guitar.Wood.MAPLE)));
    }
}