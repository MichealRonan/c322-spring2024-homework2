package iu.msronan.edu.c322spring2024homework2.repository;
import iu.msronan.edu.c322spring2024homework2.model.Guitar;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InventoryRepository {
    private List<Guitar> guitars = new ArrayList<>();

    public void addGuitar(Guitar guitar) {
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        return guitars.stream()
                .filter(guitar -> guitar.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElse(null);
    }

    public List<Guitar> search(Guitar searchCriteria) {
        return guitars.stream()
                .filter(guitar -> (searchCriteria.getSerialNumber() == null || guitar.getSerialNumber().equals(searchCriteria.getSerialNumber())) &&
                        (searchCriteria.getPrice() == 0 || guitar.getPrice() == searchCriteria.getPrice()) &&
                        (searchCriteria.getBuilder() == null || guitar.getBuilder() == searchCriteria.getBuilder()) &&
                        (searchCriteria.getModel() == null || guitar.getModel().equals(searchCriteria.getModel())) &&
                        (searchCriteria.getType() == null || guitar.getType() == searchCriteria.getType()) &&
                        (searchCriteria.getBackWood() == null || guitar.getBackWood() == searchCriteria.getBackWood()) &&
                        (searchCriteria.getTopWood() == null || guitar.getTopWood() == searchCriteria.getTopWood()))
                .collect(Collectors.toList());
    }
}