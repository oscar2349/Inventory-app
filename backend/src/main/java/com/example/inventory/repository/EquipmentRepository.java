package com.example.inventory.repository;

import com.example.inventory.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    boolean existsBySerial(String serial);
    List<Equipment> findByType(String type);
    List<Equipment> findByDepartmentId(Long deptId);
    List<Equipment> findByUser(String user);
    List<Equipment> findByActive(Boolean active);
}