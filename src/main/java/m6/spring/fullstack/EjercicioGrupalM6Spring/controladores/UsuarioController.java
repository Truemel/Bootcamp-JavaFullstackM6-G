package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Administrativo;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Cliente;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Profesional;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Usuario;
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

    public UsuarioController(UsuarioService service){
        this.service = service;
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
}
