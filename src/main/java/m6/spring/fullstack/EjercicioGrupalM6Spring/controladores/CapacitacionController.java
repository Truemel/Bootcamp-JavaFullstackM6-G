package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.dao.CapacitacionDao;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Capacitacion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {

    private CapacitacionDao dao = new CapacitacionDao();

    @GetMapping("/crear-capacitacion")
    public String getCrearCapacitacion(){
        return "crear-capacitacion";
    }

    @PostMapping("/crear-capacitacion")
    public String addCrearCapacitacion(@ModelAttribute Capacitacion capacitacion){
        System.out.println(dao.crearCapacitacion(capacitacion));
        return "crear-capacitacion";
    }

    @GetMapping("/listar-capacitaciones")
    public String getListarCapacitaciones(Model model){
        model.addAttribute("lista", dao.obtenerCapacitaciones());
        return "listar-capacitaciones";
    }
}
