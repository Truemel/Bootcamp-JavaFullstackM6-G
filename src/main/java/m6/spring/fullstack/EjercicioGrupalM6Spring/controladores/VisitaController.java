package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Chequeo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Visita;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.ChequeoService;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.VisitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/visita")
public class VisitaController {

    private VisitaService service;
    private ChequeoService chServ;

    public VisitaController(VisitaService service, ChequeoService chServ){
        this.service = service;
        this.chServ = chServ;
    }

    @GetMapping("/listar-visitas")
    public String listarVisitas(Model model){
        model.addAttribute("lista", service.getVisitaList());
        return "listar-visitas";
    }

    @GetMapping("/responder-checklist")
    public String responderChecklist(Model model){
        model.addAttribute("lista", chServ.getChequeoList());
        return "responder-checklist";
    }

    @GetMapping("/agregar-checklist")
    public String agregarChecklist(){
        return "agregar-checklist";
    }

    @PostMapping("/agregar-checklist")
    public String agregarCheckList(@ModelAttribute Chequeo check){
        chServ.addChequeo(check);
        return "redirect:/responder-checklist";
    }

    @GetMapping("/nueva-visita")
    public String nuevaVisita(){
        return "nueva-visita";
    }

    @PostMapping("/nueva-visita")
    public String postNuevaVisita(@ModelAttribute Visita vis){
        service.addVisita(vis);
        return "redirect:/listar-visitas";
    }
}