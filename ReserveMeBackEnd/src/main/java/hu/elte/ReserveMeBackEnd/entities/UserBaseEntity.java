package hu.elte.ReserveMeBackEnd.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
public class UserBaseEntity extends BaseEntity {

    @NotNull
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "NAME", nullable = true)
    protected String name;
}
