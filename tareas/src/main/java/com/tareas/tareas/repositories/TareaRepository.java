package com.tareas.tareas.repositories;

import com.tareas.tareas.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository  extends JpaRepository<Tarea,Long> {
}
