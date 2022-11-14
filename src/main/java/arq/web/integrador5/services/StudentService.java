package arq.web.integrador5.services;

import arq.web.integrador5.DTO.StudentDTO;
import arq.web.integrador5.entities.Student;
import arq.web.integrador5.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentDTO save(StudentDTO sDTO){
        Student s = studentRepository.save(
                new Student(sDTO.getDocumentNumber(),
                        sDTO.getName(), sDTO.getSurname(), sDTO.getBirthdate(),
                        sDTO.getGender(), sDTO.getCity()));

        sDTO.setBookNumber(s.getBookNumber());
        return sDTO;
    }

    public StudentDTO getByBookNumber(int bookNumber){
        Student s = studentRepository.findByBookNumber(bookNumber);
        return new StudentDTO(s.getDocumentNumber(),s.getName(),s.getSurname(),s.getBirthdate(),s.getGender(),s.getCity(),s.getBookNumber());
    }

    public List<StudentDTO> getAllSortedByName(){
        List<Student> students = studentRepository.findAllSortedByName();
        List<StudentDTO> studentsDTO = new ArrayList<>();

        for(Student s: students){
            studentsDTO.add(new StudentDTO(s.getDocumentNumber(),s.getName(),s.getSurname(),s.getBirthdate(),s.getGender(),s.getCity(),s.getBookNumber()));
        }
        return studentsDTO;
    }

    public List<StudentDTO> getAllByGender(String gender){
        List<Student> students = this.studentRepository.findByGender(gender);
        List<StudentDTO> studentsDTO = new ArrayList<>();

        for(Student s: students){
            studentsDTO.add(new StudentDTO(s.getDocumentNumber(),s.getName(),s.getSurname(),s.getBirthdate(),s.getGender(),s.getCity(),s.getBookNumber()));
        }
        return studentsDTO;
    }

    public List<StudentDTO> findAllByCareerAndCity(int careerId, String city){
        List<Student> students = this.studentRepository.findAllByCareerAndCity(careerId, city);
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student: students){
            studentDTOS.add(new StudentDTO(student.getDocumentNumber(), student.getName(), student.getSurname(),
                    student.getBirthdate(), student.getGender(), student.getCity()));
        }
        return studentDTOS;
    }
}