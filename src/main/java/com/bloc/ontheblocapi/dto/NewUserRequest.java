package com.bloc.ontheblocapi.dto;

import com.bloc.ontheblocapi.validation.BlocIdsExist;
import com.bloc.ontheblocapi.validation.UniqueId;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class NewUserRequest {
    @NotBlank
    @UniqueId
    private String id;

    @BlocIdsExist
    private List<String> blocIds;

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getBlocIds() {
        return blocIds;
    }

    public void setBlocIds(List<String> blocIds) {
        this.blocIds = blocIds;
    }
}
