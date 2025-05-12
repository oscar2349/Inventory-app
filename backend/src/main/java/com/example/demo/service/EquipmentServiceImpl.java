package com.example.inventory.service;

import com.example.inventory.model.Equipment;
import com.example.inventory.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment getEquipmentById(Long id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        return equipment.orElse(null);
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment updateEquipment(Long id, Equipment equipment) {
        Optional<Equipment> existingEquipment = equipmentRepository.findById(id);
        if (existingEquipment.isPresent()) {
            Equipment updatedEquipment = existingEquipment.get();
            updatedEquipment.setName(equipment.getName());
            updatedEquipment.setType(equipment.getType());
            updatedEquipment.setSerialNumber(equipment.getSerialNumber());
            return equipmentRepository.save(updatedEquipment);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
