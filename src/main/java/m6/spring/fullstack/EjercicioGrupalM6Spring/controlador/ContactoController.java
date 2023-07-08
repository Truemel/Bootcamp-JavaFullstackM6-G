package m6.spring.fullstack.EjercicioGrupalM6Spring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @GetMapping
    public String getContacto(){
        return "contacto";
    }
}
