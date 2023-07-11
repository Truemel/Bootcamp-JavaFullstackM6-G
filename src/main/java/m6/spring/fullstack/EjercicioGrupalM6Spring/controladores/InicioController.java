package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InicioController {

    @GetMapping
    public String getInicio(){
        return "inicio";
    }
}
