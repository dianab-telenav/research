package com.telenav.research.jooq;

/**
 *
 *
 * @author dianabalan
 */
public class Participant {

    private final int id;
    private final String nume;
    private final String email;


    public Participant(final int id, final String nume, final String email) {
        this.id = id;
        this.nume = nume;
        this.email = email;

    }


    public String getEmail() {
        return email;
    }


    public int getId() {
        return id;
    }


    public String getNume() {
        return nume;
    }


}
