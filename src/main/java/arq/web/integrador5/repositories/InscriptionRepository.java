package arq.web.integrador5.repositories;

import arq.web.integrador5.DTO.CareerReportDTO;
import arq.web.integrador5.entities.Career;
import arq.web.integrador5.entities.Inscription;
import arq.web.integrador5.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository {
    /**
     * Enroll a student in a career
     * @param i inscription that contains the student and the career
     */
    Inscription save(Inscription i);

    /**
     * get reports with data of the careers
     */
    List<CareerReportDTO> getReports();

    void deleteAll();

    Inscription findByStudentAndCareer(Student cio, Career ingenieria);
}
