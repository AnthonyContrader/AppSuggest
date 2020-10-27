package it.contrader.dao;

import it.contrader.model.Apptype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ApptypeRepository extends CrudRepository<Apptype, Long> {
   // Apptype findByTag(Long id);
   //@Query(value = "SELECT * FROM APPTYPE", nativeQuery = true)
   // @Query(value = "SELECT * FROM app", nativeQuery = true)

   List<Apptype> findAll();

   /*@Query(value = "SELECT tag FROM Apptype where id = ?", nativeQuery = true)
   List<Apptype> findByNameTag(Long id);
*/
}
