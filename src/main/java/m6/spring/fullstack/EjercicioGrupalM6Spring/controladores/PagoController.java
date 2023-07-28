package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Pago;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.PagoService;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.UsuarioService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pago")
public class PagoController {

    private PagoService pServ;
    private UsuarioService usuServ;

    public PagoController(PagoService pServ, UsuarioService usuServ){
        this.pServ = pServ;
        this.usuServ = usuServ;
    }

    @GetMapping("/listar-pagos")
    public String listarPagos(Model model){
        model.addAttribute("lista", pServ.getPagoList());
        return "listar-pagos";
    }

    @GetMapping("/crear-pago")
    public String crearPago(){
        return "crear-pago";
    }

    @PostMapping("/crear-pago")
    public String crearPago(@ModelAttribute Pago pago){
        try {
            if(usuServ.getClienteById(pago.getIdCliente()) != null){
                pServ.addPago(pago);
                return "redirect:/pago/listar-pagos";
            }
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return "crear-pago";
    }
}