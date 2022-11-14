package arq.web.integrador5.controlllers;

import arq.web.integrador5.DTO.StudentDTO;
import arq.web.integrador5.services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Estudiantes")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentSerivce;

    @ApiOperation(value = "crea un nuevo estudiante")
    @PostMapping()
    public StudentDTO save(@RequestBody StudentDTO s){
        return studentSerivce.save(s);
    }

    @ApiOperation(value = "obtiene un estudiando filtrado por número de libreta")
    @GetMapping("/{id}")
    public StudentDTO getByBookName(@PathVariable String id){
        return studentSerivce.getByBookNumber(Integer.valueOf(id));
    }

    @ApiOperation(value = "obtiene un arreglo de estudiantes")
    @GetMapping()
    public List<StudentDTO> getMany(@RequestParam(required = false) String gender, @RequestParam(required = false) String sortBy,
                                    @RequestParam(required = false) Integer careerId, @RequestParam(required = false) String city){
        if(gender != null)
            return  studentSerivce.getAllByGender(gender);

        if(sortBy != null && sortBy.equals("name"))
            return studentSerivce.getAllSortedByName();

        if(city != null && careerId != 0)
            return studentSerivce.findAllByCareerAndCity(careerId, city);

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

}
