package hu.elte.ReserveMeBackEnd.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", insertable = false)
    protected long id;

    @Version
    @Column(name = "VERSION", nullable = false)
    protected int version;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    protected Date createDate;

    @Column(name = "LAST_EDIT_TIME")
    @UpdateTimestamp
    protected Date lastEditTime;
}
