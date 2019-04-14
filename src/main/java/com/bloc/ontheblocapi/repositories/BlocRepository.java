package com.bloc.ontheblocapi.repositories;

import com.bloc.ontheblocapi.models.Bloc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends MongoRepository<Bloc, String> { }
