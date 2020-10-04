package hu.elte.ReserveMeBackEnd.entities;

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
@Table(	name = "reservations",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
public class ReservationEntity extends BaseEntity{

    @Column
    private Date from;

    @Column
    private Date until;

    @Column
    @ManyToOne
    private ServiceEntity service;
}
