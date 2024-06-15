package com.tareas.tareas.service;

import com.tareas.tareas.entity.Tarea;
import com.tareas.tareas.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TareaServiceImpl implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;
    @Override
    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea getTareaById(long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarea actualizarTarea(Tarea tarea) {
        if(tareaRepository.existsById((tarea.getId()))){
            return tareaRepository.save(tarea);
        }
        return null;
    }

    @Override
    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);

    }
}
