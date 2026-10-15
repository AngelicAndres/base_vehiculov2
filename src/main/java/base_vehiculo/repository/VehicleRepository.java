package base_vehiculo.repository;

import base_vehiculo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    boolean existsByPlate(String plate);
}
