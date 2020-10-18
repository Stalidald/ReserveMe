package hu.elte.ReserveMeBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "reservations",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
public class ReservationEntity extends BaseEntity {

    @NotNull
    @Column(name = "FROM", nullable = false)
    private Date from;

    @NotNull
    @Column(name = "UNTIL", nullable = false)
    private Date until;

    @ManyToOne(targetEntity = ServiceEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_ID")
    @JsonIgnoreProperties("reservations")
    protected ServiceEntity service;

    @ManyToOne(targetEntity = CustomerEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonIgnoreProperties("reservations")
    protected CustomerEntity customer;

    @ManyToOne(targetEntity = ServiceProviderEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_PROVIDER_ID")
    @JsonIgnoreProperties("reservations")
    protected ServiceProviderEntity serviceProvider;
}
