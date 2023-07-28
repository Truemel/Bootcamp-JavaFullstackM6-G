package m6.spring.fullstack.EjercicioGrupalM6Spring.controladores;

import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.Pago;
import m6.spring.fullstack.EjercicioGrupalM6Spring.modelo.service.PagoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pago")
public class PagoController {

    private PagoService pServ;

    public PagoController(PagoService pServ){
        this.pServ = pServ;
    }

    @GetMapping
    public String listarPagos(Model model){
        model.addAttribute("lista", pServ.getPagoList());
        return "listar-pagos";
    }

    @GetMapping("/crear-pago")
    public String crearPago(){
        return "crear-pago";
    }

    @PostMapping("/crear-pago")
    public String crearPago(@RequestBody Pago pago){
        pServ.addPago(pago);
        return "redirect:/listar-pagos";
    }
}