package com.openwebinars._Controladores02.controladores;

import com.openwebinars._Controladores02.Servicios.EmpleadoService;
import com.openwebinars._Controladores02.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService servicio;

    @GetMapping({"/", "empleado/list"})
    public String listado(Model model) {
        model.addAttribute("listaEmpleados", servicio.findAll());
        return "list";
    }

    @GetMapping("/empleado/new")
    public String nuevoEmpleadoForm(Model model) {
        model.addAttribute("empleadoForm", new Empleado());
        return "form";
    }

    @PostMapping("/empleado/new/submit")
    public String nuevoEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm")
                                          Empleado nuevoEmpleado, BindingResult bindingResult,
                                      @RequestParam("filebutton") MultipartFile file) {

        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            if(!file.isEmpty()) {

            }

            servicio.add(nuevoEmpleado);
            return "redirect:/empleado/list";
        }

    }

    @GetMapping("/empleado/edit/{id}")
    public String editarEmpleadoForm(@PathVariable long id,  Model model) {

        Empleado empleado = servicio.findById(id);
        if (empleado != null) {
            model.addAttribute("empleadoForm", empleado);
            return "form";
        } else {
            return "redirect:/empleado/new";
        }

    }

    @PostMapping("/empleado/edit/submit")
    public String editarEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm")
                                           Empleado empleado, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            servicio.edit(empleado);
            return "redirect:/empleado/list";
        }

    }


}
