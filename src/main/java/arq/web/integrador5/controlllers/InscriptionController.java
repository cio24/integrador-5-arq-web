package arq.web.integrador5.controlllers;

import arq.web.integrador5.DTO.CareerReportDTO;
import arq.web.integrador5.DTO.InscriptionDTO;
import arq.web.integrador5.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping()
    public InscriptionDTO save(@RequestBody InscriptionDTO iDTO){
        return inscriptionService.save(iDTO);
    }


    @GetMapping("/reports")
    public List<CareerReportDTO> getReports(){
            return inscriptionService.getReports();
    }
}
