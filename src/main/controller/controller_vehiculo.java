package base_vehiculo.controller;

import base_vehiculo.dto.VehicleDto;
import base_vehiculo.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class controller_vehiculo {

    private final VehicleService service;

    // GET http://localhost:8081/vehicles
    @GetMapping
    public List<VehicleDto> getAll() {
        return service.findAll();
    }

    // GET http://localhost:8081/vehicles/veh-001
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST http://localhost:8081/vehicles
    @PostMapping
    public ResponseEntity<VehicleDto> create(@Valid @RequestBody VehicleDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
}