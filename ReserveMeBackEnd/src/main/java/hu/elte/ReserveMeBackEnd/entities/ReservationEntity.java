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
    @Column(name = "BEGIN", nullable = false)
    private Date begin;

    @NotNull
    @Column(name = "END", nullable = false)
    private Date end;

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

    public ReservationEntity(Date begin, Date end) {
        this.begin = begin;
        this.end = end;
    }
}
