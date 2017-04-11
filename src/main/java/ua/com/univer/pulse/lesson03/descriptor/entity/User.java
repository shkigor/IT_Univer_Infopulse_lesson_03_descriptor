package ua.com.univer.pulse.lesson03.descriptor.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * В hibernate есть встроенные типы, которые мепятся в БД.
 */
@Entity
@Table(name = "myusers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    /**
     * Типа Address во встроенных типах hibernate нет. Если закоментировать аннотацию @Type, получим
     * org.hibernate.MappingException: Could not determine type for: ua.com.univer.pulse.lesson03.descriptor.entity.Address,
     * at table: myusers, for columns: [org.hibernate.mapping.Column(address)]
     *
     * Если мы используем нестандартный тип, тот который не встроен в hibernate
     * то мы должны объяснить hibernate на что его меппить,
     * например String hibernate меппит на Varchar,
     * т.е. мы должны рассказать, что будет соответствовать адресу в БД
     *
     * Аннотация @Type рассказывает hibernate где лежит описание типа Address. Это AddressType
     */
    @Type(type = "ua.com.univer.pulse.lesson03.descriptor.entity.AddressType")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

