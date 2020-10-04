package hu.elte.ReserveMeBackEnd.entities;

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
@Table(	name = "serviceproviders",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class ServiceProviderEntity extends UserBaseEntity {

        @Column
        @OneToMany
        private List<ServiceEntity> services;

        @Column
        @OneToMany
        private List<ReservationEntity> madeReservations;
}
