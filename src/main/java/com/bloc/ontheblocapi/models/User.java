package com.bloc.ontheblocapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private List<BlocSummary> blocSummaries;

    public User(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BlocSummary> getBlocSummaries() {
        return blocSummaries;
    }

    public void setBlocSummaries(List<BlocSummary> blocSummaries) {
        this.blocSummaries = blocSummaries;
    }
}
