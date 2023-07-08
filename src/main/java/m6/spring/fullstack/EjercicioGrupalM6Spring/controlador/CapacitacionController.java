package m6.spring.fullstack.EjercicioGrupalM6Spring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {

    @GetMapping
    public String getCrearCapacitacion(){
        return "crear-capacitacion";
    }

    @PostMapping("/crear-capacitacion")
    public String addCrearCapacitacion(){
        return "crear-capacitacion";
    }

    @GetMapping("/listar-capacitaciones")
    public String getListarCapacitaciones(){
        return "listar-capacitaciones";
    }
}
