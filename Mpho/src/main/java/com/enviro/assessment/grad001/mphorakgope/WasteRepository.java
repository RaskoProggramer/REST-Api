package com.enviro.assessment.grad001.mphorakgope;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface WasteRepository extends JpaRepository<Waste, Long> {
    List<Waste> findAll();
    Optional<Waste> findById(Long id);

    Waste save(Waste newWaste);

    void deleteById(Long id);
}
