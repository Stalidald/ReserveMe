package hu.elte.ReserveMeBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    protected long id;

    @Version
    protected int version;

    @Column
    @JsonIgnore
    protected Date createdAt;

    @Column
    @JsonIgnore
    protected Date modifiedAt;
}
