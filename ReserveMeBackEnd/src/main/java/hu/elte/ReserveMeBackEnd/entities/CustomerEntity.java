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
@Table(name = "customers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class CustomerEntity extends UserBaseEntity {

    @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    @JsonIgnore
    protected List<ReservationEntity> reservations;
}
