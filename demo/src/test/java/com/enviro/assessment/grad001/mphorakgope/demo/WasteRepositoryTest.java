package com.enviro.assessment.grad001.mphorakgope.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class WasteRepositoryTest {

    @Autowired
    private WasteRepository repository;

    @Test
    public void testFindAll() {
        Waste waste1 = new Waste("Plastic", "plastic recycle bin");
        Waste waste2 = new Waste("Paper", "paper bin for recycling");

        repository.save(waste1);
        repository.save(waste2);

        List<Waste> wastes = repository.findAll();
        assertThat(wastes).hasSize(2);
    }

    @Test
    public void testFindById() {
        Waste waste = new Waste("Glass", "glass recycle bin");
        Waste savedWaste = repository.save(waste);

        Optional<Waste> foundWaste = repository.findById(savedWaste.getId());
        assertThat(foundWaste.isPresent()).isTrue();
        assertThat(foundWaste.get().getName()).isEqualTo("Glass");
    }
}
