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
@Table(	name = "services",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
public class ServiceEntity extends BaseEntity{
    @Column
    private String label;

    @Column
    private String type;

    @Column
    @Lob
    private String description;

    @Column
    private int duration;

    @Column
    private int price;
}
