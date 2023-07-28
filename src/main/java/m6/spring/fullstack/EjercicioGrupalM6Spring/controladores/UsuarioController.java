package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Administrativo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Cliente;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Profesional;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.CapacitacionService;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/editar-cliente/{id}")
    public String editCliente(@PathVariable int id, Model model){
        model.addAttribute("cliente", service.getClienteByUserId(id));
        return "editar-cliente";
    }

    @GetMapping("/editar-profesional/{id}")
    public String editProfesional(@PathVariable int id, Model model){
        model.addAttribute("profes", service.getProfesionalByUserId(id));
        return "editar-profesional";
    }

    @GetMapping("/editar-administrativo/{id}")
    public String editAdministrativo(@PathVariable int id, Model model){
        model.addAttribute("admin", service.getAdministrativoByUserId(id));
        return "editar-administrativo";
    }

    @PostMapping("/editar-cliente")
    public String editCliente(@ModelAttribute Cliente cli){
        service.updateCliente(cli);
        return "redirect:/usuario/listar-usuarios";
    }

    @PostMapping("/editar-profesional")
    public String editProdesional(@ModelAttribute Profesional prof){
        service.updateProfesional(prof);
        return "redirect:/usuario/listar-usuarios";
    }

    @PostMapping("/editar-administrativo")
    public String editAdministrativo(@ModelAttribute Administrativo admin){
        service.updateAdministrativo(admin);
        return "redirect:/usuario/listar-usuarios";
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
