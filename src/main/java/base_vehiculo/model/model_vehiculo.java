package base_vehiculo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class model_vehiculo {
     @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String plate;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Double batteryStatusPercentage;

    private String engineStatus;
    private Double lastLatitude;
    private Double lastLongitude;
    private LocalDate lastMaintenanceDate;
    
}
