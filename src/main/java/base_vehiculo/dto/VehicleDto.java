package base_vehiculo.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDto {

    @NotBlank
    private String id;                       // ej. "veh-001"

    @NotBlank
    private String plate;                    // ej. "ABC-1234"

    @NotBlank
    private String model;                    // ej. "EcoTruck EV"

    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private Double batteryStatusPercentage;  // 0 a 100

    @Pattern(regexp = "OK|WARNING|FAILURE")
    private String engineStatus;             // "OK", "WARNING", "FAILURE"

    private Double lastLatitude;             // última ubicación
    private Double lastLongitude;

    private LocalDate lastMaintenance;       // último mantenimiento
}
