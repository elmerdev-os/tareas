package com.tareas.tareas.vista;

import com.tareas.tareas.entity.Tarea;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TareaVista {
    private long id;
    private String titulo;
    private String descripcion;



    public static TareaVista fromTarea(Tarea tarea) {
        TareaVista tareaVista = new TareaVista();
        tareaVista.setId(tarea.getId());
        tareaVista.setTitulo(tarea.getTitulo());
        tareaVista.setDescripcion(tarea.getDescripcion());
        return tareaVista;
    }

}
