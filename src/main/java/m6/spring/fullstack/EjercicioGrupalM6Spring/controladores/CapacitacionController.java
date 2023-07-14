package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.dao.CapacitacionDao;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.CapacitacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {

    private CapacitacionService service;

    public CapacitacionController(CapacitacionService service){
        this.service = service;
    }

    @GetMapping("/crear-capacitacion")
    public String getCrearCapacitacion(){
        return "crear-capacitacion";
    }

    @PostMapping("/crear-capacitacion")
    public String addCrearCapacitacion(@ModelAttribute Capacitacion capacitacion){
        service.addCapacitacion(capacitacion);
        return "crear-capacitacion";
    }

    @GetMapping("/listar-capacitaciones")
    public String getListarCapacitaciones(Model model){
        model.addAttribute("lista", service.getCapacitacionList());
        return "listar-capacitaciones";
    }
}
