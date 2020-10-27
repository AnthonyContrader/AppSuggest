package it.contrader.dao;

import it.contrader.model.App;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AppRepository extends CrudRepository<App, Long> {

   // Apptype findBy(int id);
}
