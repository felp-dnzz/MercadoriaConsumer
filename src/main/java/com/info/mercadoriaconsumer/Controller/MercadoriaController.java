package com.info.mercadoriaconsumer.Controller;

import com.info.mercadoriaconsumer.Model.Mercadoria;
import com.info.mercadoriaconsumer.Service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mercadoria")
public class MercadoriaController {
    @Autowired
    private MercadoriaService mercadoriaService;

    @GetMapping("/new")
    public String newMercadoria(Model model) {
        model.addAttribute("mercadoria", new Mercadoria());
        return "mercadoria/form";
    }

    @GetMapping("")
    public String listMercadoria(Model model) {
        model.addAttribute("listMercadoria", mercadoriaService.findAll());
        return "mercadoria/list";
    }

    @GetMapping("/{codbarras}/edit")
    public String editMercadoria(@PathVariable("codbarras") String codbarras, Model model) {
        model.addAttribute("mercadoria", mercadoriaService.findById(codbarras));
        return "mercadoria/form";
    }

    @PostMapping("/save")
    public String saveMercadoria(@ModelAttribute("mercadoria") Mercadoria mercadoria) {
        mercadoriaService.save(mercadoria);
        return "redirect:/mercadoria";
    }

    @GetMapping("/{codbarras}/delete")
    public String deleteMercadoria(@PathVariable("codbarras") String codbarras) {
        mercadoriaService.delete(codbarras);
        return "redirect:/mercadoria";
    }
}
