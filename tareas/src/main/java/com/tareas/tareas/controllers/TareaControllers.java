package com.tareas.tareas.controllers;

import com.tareas.tareas.entity.Tarea;
import com.tareas.tareas.service.TareaService;
import com.tareas.tareas.vista.TareaVista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tareas")
public class TareaControllers {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<TareaVista> getAllTareas(){
        List<Tarea> tareas=tareaService.getAllTareas();
        return tareas.stream()
                .map(TareaVista::fromTarea)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable long id){
        Tarea tarea = tareaService.getTareaById(id);
        return tarea != null
                ? ResponseEntity.ok(tarea)
                :ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Tarea> createTarea(@RequestBody Tarea tarea){

        Tarea savedTarea = tareaService.saveTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTarea);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Tarea> actualizarTarea(@PathVariable long id, @RequestBody Tarea tarea){
        tarea.setId(id);
        Tarea actulizardTarea=tareaService.actualizarTarea(tarea);
        return  actulizardTarea != null
                ? ResponseEntity.ok(actulizardTarea)
                :ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteTarea(@PathVariable long id){
        tareaService.deleteTarea(id);
        return  ResponseEntity.noContent().build();
    }
}
