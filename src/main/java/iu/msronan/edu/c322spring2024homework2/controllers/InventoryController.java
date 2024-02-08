package iu.msronan.edu.c322spring2024homework2.controllers;
import iu.msronan.edu.c322spring2024homework2.model.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import iu.msronan.edu.c322spring2024homework2.repository.InventoryRepository;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/search")
    public List<Guitar> searchGuitar(@RequestParam(required = false) String serialNumber,
                                     @RequestParam(required = false) Double price,
                                     @RequestParam(required = false) String builder,
                                     @RequestParam(required = false) String model,
                                     @RequestParam(required = false) String type,
                                     @RequestParam(required = false) String backWood,
                                     @RequestParam(required = false) String topWood) {
        return inventoryRepository.search(new Guitar(serialNumber, price, builder, model, type, backWood, topWood));
    }

    @PostMapping("/add")
    public Guitar addGuitar(@RequestBody Guitar guitar) {
        inventoryRepository.addGuitar(guitar);
        return guitar;
    }

    @GetMapping("/find/{serialNumber}")
    public Guitar findGuitar(@PathVariable String serialNumber) {
        return inventoryRepository.getGuitar(serialNumber);
    }
}