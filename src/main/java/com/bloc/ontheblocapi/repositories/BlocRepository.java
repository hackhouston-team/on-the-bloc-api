package com.bloc.ontheblocapi.repositories;

import com.bloc.ontheblocapi.models.Bloc;
import com.bloc.ontheblocapi.models.BlocIdentifiers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepository extends MongoRepository<Bloc, String> {
    @Query(value = "{ id : { $in : ?0 } }", fields = "{ id : 1, name : 1 }")
    List<BlocIdentifiers> findBlockIdentifiersByIds(List<String> ids);
}
