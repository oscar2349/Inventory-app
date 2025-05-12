package main.java.com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Departamentos", description = "Operaciones relacionadas con departamentos")
public class DepartmentController {

    private List<String> departments = new ArrayList<>(Arrays.asList("Ventas", "Marketing", "TI"));

    @GetMapping
    @Operation(summary = "Obtener todos los departamentos")
    public List<String> getAllDepartments() {
        return departments;
    }

    @PostMapping
    @Operation(summary = "Agregar un nuevo departamento")
    public String addDepartment(@RequestBody String department) {
        departments.add(department);
        return department;
    }

    @DeleteMapping("/{index}")
    @Operation(summary = "Eliminar un departamento por índice")
    public String deleteDepartment(@PathVariable int index) {
        return departments.remove(index);
    }
}
