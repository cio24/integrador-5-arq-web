package arq.web.integrador5.services;

import arq.web.integrador5.DTO.CareerReportDTO;
import arq.web.integrador5.DTO.InscriptionDTO;
import arq.web.integrador5.entities.Career;
import arq.web.integrador5.entities.Inscription;
import arq.web.integrador5.entities.Student;
import arq.web.integrador5.repositories.CareerRepository;
import arq.web.integrador5.repositories.InscriptionRepository;
import arq.web.integrador5.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CareerRepository careerRepository;

    public InscriptionDTO save(InscriptionDTO iDTO){
        Student s = studentRepository.findByBookNumber(iDTO.getStudentBookNumber());
        Career c = careerRepository.findById(iDTO.getCareerId());
        inscriptionRepository.save(new Inscription(s,c));
        return iDTO;
    }

    public List<CareerReportDTO> getReports(){
        List<CareerReportDTO> report = inscriptionRepository.getReports();
        return report;
    }
}
