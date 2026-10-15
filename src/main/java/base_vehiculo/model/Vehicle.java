package base_vehiculo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    private String id;                       // ej. "veh-001"

    @Column(nullable = false, unique = true)
    private String plate;                    // ej. "ABC-1234"

    @Column(nullable = false)
    private String model;                    // ej. "EcoTruck EV"

    private Double batteryStatusPercentage;  // 0 a 100

    private String engineStatus;             // "OK", "WARNING", "FAILURE"

    private Double lastLatitude;             // última ubicación
    private Double lastLongitude;

    private LocalDate lastMaintenance;       // último mantenimiento
}