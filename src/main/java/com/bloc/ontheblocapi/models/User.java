package com.bloc.ontheblocapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private List<BlocIdentifiers> blocIdentifiers;

    public User(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BlocIdentifiers> getBlocIdentifiers() {
        return blocIdentifiers;
    }

    public void setBlocIdentifiers(List<BlocIdentifiers> blocIdentifiers) {
        this.blocIdentifiers = blocIdentifiers;
    }
}
