package com.tareas.tareas.service;

import com.tareas.tareas.entity.Tarea;

import java.util.List;

public interface TareaService {
    Tarea saveTarea(Tarea tarea);
    List<Tarea> getAllTareas();
    Tarea getTareaById(long id);
    Tarea actualizarTarea(Tarea tarea);
    void deleteTarea(Long id);

}
