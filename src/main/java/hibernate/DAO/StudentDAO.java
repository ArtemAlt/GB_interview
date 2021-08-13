package hibernate.DAO;

import hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class StudentDAO {


    public StudentDAO() {
    }


    private EntityManagerFactory getFactory() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory() ;
    }

    private EntityManager getEntityManager() {
        return getFactory().createEntityManager() ;
    }


    public void persist(Student entity) {
      EntityManager em = getEntityManager();
      em.getTransaction().begin();
      em.merge(entity);
      em.getTransaction().commit();
      em.close();
    }

    public void persistList (List<Student> enList){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        for (Student s : enList){
            em.merge(s);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Student findById(Long id){
        return getEntityManager().find(Student.class,id);
    }

    public Student updateById (Long id, String name){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student s = em.find(Student.class,id);
        s.setName(name);
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        return s;
    }

    public String deleteById(Long id){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student s = em.find(Student.class,id);
        em.remove(s);
        em.getTransaction().commit();
        em.close();
        return "Student - "+s.toString()+" removed from DB";
    }

    public String deleteAll(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
       em.createNativeQuery("TRUNCATE schema_lesson_5.students");// не работает, через консоль работает(

        em.getTransaction().commit();
        em.close();
        return "Clear DB";
    }





}
