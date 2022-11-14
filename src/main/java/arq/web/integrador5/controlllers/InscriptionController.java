package arq.web.integrador5.controlllers;

import arq.web.integrador5.DTO.CareerReportDTO;
import arq.web.integrador5.DTO.InscriptionDTO;
import arq.web.integrador5.services.InscriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "Inscripciones")
@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @ApiOperation(value = "crea una nueva inscripción de un estudiante en una carrera")
    @PostMapping()
    public InscriptionDTO save(@RequestBody InscriptionDTO iDTO){
        return inscriptionService.save(iDTO);
    }

    @ApiOperation(value = "obtiene un arreglo de reportes con información por año de cada carrera")
    @GetMapping("/reports")
    public List<CareerReportDTO> getReports(){
            return inscriptionService.getReports();
    }
}
