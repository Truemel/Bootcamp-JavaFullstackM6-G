package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Chequeo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Visita;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.ChequeoService;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.UsuarioService;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.VisitaService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visita")
public class VisitaController {

    private VisitaService service;
    private ChequeoService chServ;
    private UsuarioService usuServ;

    public VisitaController(VisitaService service, ChequeoService chServ, UsuarioService usuServ){
        this.service = service;
        this.chServ = chServ;
        this.usuServ = usuServ;
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
        try {
            if(service.getVisitaById(check.getIdVisit()) != null){
                chServ.addChequeo(check);
                return "redirect:/visita/responder-checklist";
            }
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
        }
        return "agregar-checklist";
    }

    @GetMapping("/nueva-visita")
    public String nuevaVisita(){
        return "nueva-visita";
    }

    @PostMapping("/nueva-visita")
    public String postNuevaVisita(@ModelAttribute Visita vis){
        try {
            if(usuServ.getClienteById(vis.getIdCliente()) != null && usuServ.getProfesionalById(vis.getIdProfe()) != null){
                service.addVisita(vis);
                return "redirect:/visita/listar-visitas";
            }
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
        }
        return "nueva-visita";
    }
}