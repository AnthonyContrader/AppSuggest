package it.contrader.dao;

import it.contrader.model.App;
import it.contrader.model.Apptype;
import it.contrader.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface AppRepository extends CrudRepository<App, Long> {

   // Apptype findBy(int id);
}
