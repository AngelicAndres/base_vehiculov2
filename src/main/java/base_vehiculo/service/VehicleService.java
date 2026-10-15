package base_vehiculo.service;

import base_vehiculo.dto.VehicleDto;
import base_vehiculo.model.Vehicle;
import base_vehiculo.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repository;

    // Lista todos los vehículos
    public List<VehicleDto> findAll() {
        return repository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    // Busca un vehículo por id
    public Optional<VehicleDto> findById(String id) {
        return repository.findById(id).map(this::toDto);
    }

    // Crea un vehículo nuevo
    public VehicleDto create(VehicleDto dto) {
        if (repository.existsById(dto.getId())) {
            throw new IllegalArgumentException("Ya existe un vehículo con id " + dto.getId());
        }
        if (repository.existsByPlate(dto.getPlate())) {
            throw new IllegalArgumentException("Ya existe un vehículo con placa " + dto.getPlate());
        }
        Vehicle guardado = repository.save(toEntity(dto));
        return toDto(guardado);
    }

    // Entidad -> DTO
    private VehicleDto toDto(Vehicle v) {
        return VehicleDto.builder()
                .id(v.getId())
                .plate(v.getPlate())
                .model(v.getModel())
                .batteryStatusPercentage(v.getBatteryStatusPercentage())
                .engineStatus(v.getEngineStatus())
                .lastLatitude(v.getLastLatitude())
                .lastLongitude(v.getLastLongitude())
                .lastMaintenance(v.getLastMaintenance())
                .build();
    }

    // DTO -> Entidad
    private Vehicle toEntity(VehicleDto d) {
        return Vehicle.builder()
                .id(d.getId())
                .plate(d.getPlate())
                .model(d.getModel())
                .batteryStatusPercentage(d.getBatteryStatusPercentage())
                .engineStatus(d.getEngineStatus())
                .lastLatitude(d.getLastLatitude())
                .lastLongitude(d.getLastLongitude())
                .lastMaintenance(d.getLastMaintenance())
                .build();
    }
}