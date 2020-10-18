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
@Table(	name = "serviceproviders",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class ServiceProviderEntity extends UserBaseEntity {

        @OneToMany(targetEntity = ServiceEntity.class, mappedBy = "serviceProvider")
        @JsonIgnoreProperties("serviceProvider")
        @JsonIgnore
        protected List<ServiceEntity> services;

        @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "serviceProvider")
        @JsonIgnoreProperties("serviceProvider")
        @JsonIgnore
        protected List<ReservationEntity> reservations;
}
