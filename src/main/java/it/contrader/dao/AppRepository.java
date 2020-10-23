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

    @Query(value = "SELECT a.id,a.appname,b.tag as apptype FROM App a,Apptype b where a.apptype = b.id", nativeQuery = true)
    List<App> findByApptype();

    @Query(value = "SELECT a.id,a.appname,b.tag as apptype FROM App a,Apptype b where a.apptype = b.id AND a.id = ?", nativeQuery = true)
    App findByAppById(Long id);

}
