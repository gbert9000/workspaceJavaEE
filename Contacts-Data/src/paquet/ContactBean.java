package paquet;

import javax.ejb.*;
import javax.persistence.*;
 
@Stateless
public class ContactBean {
   @PersistenceContext
   private EntityManager em;
 
   public void create(Contact... pers) {
       for(Contact per : pers) {
           em.persist(per);
       }
   }
 
}