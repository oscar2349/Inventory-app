package com.example.inventory.controller;

import com.example.inventory.model.Equipment;
import com.example.inventory.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public Page<Equipment> getAll(Pageable pageable) {
        return equipmentService.getAll(pageable);
    }

    @GetMapping("/filter")
    public List<Equipment> filter(
        @RequestParam(required = false) String type,
        @RequestParam(required = false) Long departmentId,
        @RequestParam(required = false) String user,
        @RequestParam(required = false) Boolean active) {
        return equipmentService.filter(type, departmentId, user, active);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getById(@PathVariable Long id) {
        Equipment eq = equipmentService.getById(id);
        return ResponseEntity.ok(eq);
    }

    @PostMapping
    public Equipment create(@RequestBody Equipment equipment) {
        return equipmentService.create(equipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> update(@PathVariable Long id, @RequestBody Equipment equipment) {
        Equipment updated = equipmentService.update(id, equipment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        equipmentService.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}