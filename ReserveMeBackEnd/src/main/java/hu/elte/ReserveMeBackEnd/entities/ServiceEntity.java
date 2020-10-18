package hu.elte.ReserveMeBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "services",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
public class ServiceEntity extends BaseEntity {
    @Column(name = "LABEL")
    private String label;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "DURATION")
    private int duration;

    @Column(name = "PRICE")
    private int price;

    @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "service")
    @JsonIgnoreProperties("service")
    @JsonIgnore
    protected List<ReservationEntity> reservations;

    @ManyToOne(targetEntity = ServiceProviderEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_PROVIDER_ID")
    @JsonIgnoreProperties("services")
    protected ServiceProviderEntity serviceProvider;
}
