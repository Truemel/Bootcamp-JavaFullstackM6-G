package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.*;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.CapacitacionService;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service;
    private CapacitacionService capaServ;

    public UsuarioController(UsuarioService service, CapacitacionService capaServ){
        this.service = service;
        this.capaServ = capaServ;
    }

    @GetMapping("/listar-usuarios")
    public String listarUsuarios(Model model){
        model.addAttribute("lista", service.getUsuarioList());
        return "listar-usuarios";
    }

    @GetMapping("/crear-usuario")
    public String getCrearUsuario(){
        return "crear-usuario";
    }

    @PostMapping("/crear-usuario/1")
    public String addCrearUsuario(@ModelAttribute Cliente usuario){
        if(capaServ.getCapacitacionById(usuario.getIdCapac()) != null)
            service.addCliente(usuario);
        return "crear-usuario";
    }

    @PostMapping("/crear-usuario/2")
    public String addCrearUsuario(@ModelAttribute Administrativo usuario){
        service.addAdministrativo(usuario);
        return "crear-usuario";
    }

    @PostMapping("/crear-usuario/3")
    public String addCrearUsuario(@ModelAttribute Profesional usuario){
        service.addProfesional(usuario);
        return "crear-usuario";
    }

    /*
    @PostMapping("/crear-usuario")
    public String addCrearUsuario(@ModelAttribute Usuario usuario){
        if(usuario.getClass() == Cliente.class) {
            System.out.println("Cliente add "+((Cliente)usuario).toString());
            service.addCliente((Cliente) usuario);
        } else if (usuario.getClass() == Profesional.class) {
            System.out.println("Profesional add "+((Profesional)usuario).toString());
            service.addProfesional((Profesional)usuario);
        } else if (usuario.getClass() == Administrativo.class) {
            System.out.println("Administrativo add "+((Administrativo)usuario).toString());
            service.addAdministrativo((Administrativo)usuario);
        }
        return "crear-usuario";
    }
     */
}
