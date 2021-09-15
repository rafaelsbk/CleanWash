package solo.projeto.cleanwash.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import solo.projeto.cleanwash.model.Carro;
import solo.projeto.cleanwash.services.CarServices;

import javax.servlet.http.HttpServletResponse;


public class CarController {
    CarServices services;

    //ROTA LISTAR CARROS
    @RequestMapping(value = { "/listcar" }, method = RequestMethod.GET)
    public String getHome(Model model, HttpServletResponse response) {

        var listCar = services.findAll();
        model.addAttribute("listcar", listCar);
        return "index";
    }
    //ROTA CADASTRAR CARRO
    @RequestMapping("/carrocadastrar")
    public String getFormCadastrar(Model model) {
        Carro carro = new Carro();
        model.addAttribute("car", carro);
        return "carrocadastrar";
    }
    //ROTA EDITAR CARRO
    @RequestMapping("/carroeditar/{idCar}")
    public ModelAndView getFormEditar(@PathVariable(name = "idCar") Long idCar) {
        ModelAndView modelAndView = new ModelAndView("editar");
        Carro carro = services.findById(idCar);
        modelAndView.addObject("car", carro);
        return modelAndView;
    }
    //ROTA DELETAR CARRO
    @RequestMapping("/carrodeletar/{idCar}")
    public String doDelete(@PathVariable(name = "idCar") Long idCar) {
        services.delete(idCar);
        return "redirect:/";
    }

}
