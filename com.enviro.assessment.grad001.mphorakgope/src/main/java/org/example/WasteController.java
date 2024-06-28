package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WasteController {
    private final WasteRepository repository;

    public WasteController(WasteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/waste")
    List<Waste> all(){
        return repository.findAll();
    }
    @PostMapping("/waste")
    Waste newWaste(@RequestBody Waste newWaste){
        return repository.save(newWaste);
    }

    @GetMapping("/waste/{id}")
    Waste one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new WasteNotFoundException(id));
    }
    @PutMapping("/waste/{id}")
    Waste replaceWaste(@RequestBody Waste newWaste, @PathVariable Long id){
        return repository.findById(id)
                .map(waste -> {
                    waste.setName(newWaste.getName());
                    waste.setManageWaste(newWaste.getManageWaste());
                    return repository.save(waste);
                })
                .orElseGet(() -> {
                    return repository.save(newWaste);
                });
    }
    @DeleteMapping("/waste/{id}")
    void deleteWaste(@PathVariable Long id){
        repository.deleteById(id);
    }
}
