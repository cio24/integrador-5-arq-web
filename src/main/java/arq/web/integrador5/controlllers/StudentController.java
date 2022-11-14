package arq.web.integrador5.controlllers;

import arq.web.integrador5.DTO.StudentDTO;
import arq.web.integrador5.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentSerivce;

    @PostMapping()
    public StudentDTO save(@RequestBody StudentDTO s){
        return studentSerivce.save(s);
    }

    @GetMapping("/{id}")
    public StudentDTO getByBookName(@PathVariable String id){
        return studentSerivce.getByBookNumber(Integer.valueOf(id));
    }

    @GetMapping("/findSortedByName")
    public List<StudentDTO> findAllSortedByName(){
        return studentSerivce.getAllSortedByName();
    }

}
