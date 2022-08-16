package com.openwebinars._Controladores02.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Empleado {

    @Id
    @GeneratedValue
    @Min(value=0, message="{empleado.id.mayorquecero}")
    private long id;
    @Column(nullable=false)
    @NotEmpty
    private String nombre;
    @Email
    private String email;
    private String telefono;

    private String imagen;

    public Empleado() {}

    public Empleado(long id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Empleado(long id, String nombre, String email, String telefono, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id && nombre.equals(empleado.nombre) && email.equals(empleado.email) && telefono.equals(empleado.telefono) && imagen.equals(empleado.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, telefono, imagen);
    }

    @Override
    public String toString() {
        return "Empleado{}";
    }
}
