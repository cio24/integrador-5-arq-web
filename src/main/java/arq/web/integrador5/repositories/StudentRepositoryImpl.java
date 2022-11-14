package arq.web.integrador5.repositories;

import arq.web.integrador5.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private EntityManager em;

    public StudentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public Student save(Student s) {
        if (s.getBookNumber() == -1) {
            em.persist(s);
        }else {
            s = em.merge(s);
        }
        return s;
    }

    @Override
    public List<Student> findAllSortedByName() {
        List<Student> students;
        Query query = em.createQuery("SELECT s FROM Student s ORDER BY s.name");
        students = query.getResultList();
        return students;
    }

    @Override
    public Student findByBookNumber(int bookNumber) {
        return (Student) this.em.createQuery("SELECT s FROM Student s WHERE s.bookNumber = :bookNumber")
                .setParameter("bookNumber", bookNumber)
                .getSingleResult();
    }

    @Override
    public List<Student> findByGender(String gender) {
        return this.em.createQuery("SELECT s FROM Student s WHERE s.gender = :gender")
                .setParameter("gender", gender)
                .getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        this.em.createQuery("delete from Student").executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public List<Student> findAllByCareerAndCity(int careerId, String city) {
        return this.em.createQuery("select s from Inscription i join i.student s join i.career c where c.id = :careerId and s.city = :city")
                .setParameter("careerId", careerId)
                .setParameter("city",city)
                .getResultList();
    }
}