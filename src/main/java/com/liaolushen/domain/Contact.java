package com.liaolushen.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by liaolushen on 11/24/15.
 *
 * @author liaolushen
 */
@Entity
public class Contact {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    @Size(max = 64)
    @NotNull
    private String name;

    @Column(name = "phone_number", nullable = false)
    @Size(max = 20)
    @NotNull
    private String phoneNumber;

    protected Contact() {}

    public Contact(final String name, final String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "{'id'=%d, name='%s', 'phoneNumber'='%s'}",
                id, name, phoneNumber);
    }
}
