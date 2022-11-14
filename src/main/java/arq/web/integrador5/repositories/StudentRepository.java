package arq.web.integrador5.repositories;

import arq.web.integrador5.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    Student save(Student s);

    List<Student> findAllSortedByName();

    Student findByBookNumber(int bookNumber);

    List<Student> findByGender(String gender);

    void deleteAll();

}