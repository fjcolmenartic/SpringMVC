package com.openwebinars._Controladores02.Servicios;

import com.openwebinars._Controladores02.modelo.Empleado;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpleadoService {

    private List<Empleado> repositorio = new ArrayList<>();

    public Empleado add(Empleado e) {
        repositorio.add(e);
        return e;
    }

    public List<Empleado> findAll() {

        return repositorio;
    }

    public Empleado findById(long id) {
        Empleado result = null;
        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < repositorio.size()) {
            if (repositorio.get(i).getId() == id) {
                encontrado = true;
                result = repositorio.get(i);
            } else {
                i++;
            }
        }

        return result;
    }

    public Empleado edit(Empleado e) {
        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < repositorio.size()) {
            if (repositorio.get(i).getId() == e.getId()) {
                encontrado = true;
                repositorio.remove(i);
                repositorio.add(i, e);
            } else {
                i++;
            }
        }

        if (!encontrado)
            repositorio.add(e);

        return e;
    }

    public int getNextId() {
        List<Empleado> totals = this.findAll();
        return totals.size() + 1;
    }

    @PostConstruct
    public void init() {
        repositorio.addAll(
                Arrays.asList(
                        new Empleado(1, "Antonio García", "antonio.garcia@openwebinars.com", "666999666"),
                        new Empleado(2, "María López", "maria.lopez@openwebinars.com", "666999666"),
                        new Empleado(3, "Ángel Antúnez", "angel.antunez@openwebinars.com", "666999666")
                )
        );
    }




}
