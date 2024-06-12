/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comoba;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importa las anotaciones y clases necesarias de Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author jordi
 */

// Marca la clase como un controlador REST, lo que significa que manejará las solicitudes HTTP
@RestController
// Define la ruta base para las solicitudes HTTP manejadas por este controlador
@RequestMapping("/usuari")

public class UsuariController {
    
    // Inyecta una instancia de PersonRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private UsuariRepository usuariRepository;

    // Maneja las solicitudes GET a /persons para obtener una lista de todas las personas
    @GetMapping
    public List<Usuari> getAllUsuari() {
        // Llama al método findAll() del repositorio para obtener todas las personas
        return usuariRepository.findAll();
    }

    // Maneja las solicitudes GET a /persons/{id} para obtener una persona específica por su ID
    @GetMapping("/{idUsuari}")
    public ResponseEntity<Usuari> getPersonById(@PathVariable Long idUsuari) {
        // Busca una persona por su ID
        Optional<Usuari> usuari = usuariRepository.findById(idUsuari);
        // Si se encuentra la persona, devuelve una respuesta HTTP 200 (OK) con la persona encontrada
        if (usuari.isPresent()) {
            return ResponseEntity.ok(usuari.get());
        } else {
            // Si no se encuentra la persona, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    // Maneja las solicitudes POST a /usuari para crear una nou usuari
    @PostMapping
    public Usuari createUsuari(@RequestBody Usuari usuari) {
        // Guarda la nueva persona en la base de datos y la devuelve en la respuesta
        return usuariRepository.save(usuari);
    }

    // Maneja las solicitudes PUT a /persons/{id} para actualizar una persona existente
    @PutMapping("/{idUsuari}")
    public ResponseEntity<Usuari> updateUsuari(@PathVariable Long idUsuari, @RequestBody Usuari usuariDetails) {
        // Busca una persona por su ID
        Optional<Usuari> usuari = usuariRepository.findById(idUsuari);
        // Si se encuentra la persona, actualiza sus detalles y la guarda
        if (usuari.isPresent()) {
            Usuari usuariToUpdate = usuari.get();
            // Actualiza el nombre y la edad de la persona con los detalles proporcionados en la solicitud
            usuariToUpdate.setNom(usuariDetails.getNom());
            // Guarda la persona actualizada y devuelve una respuesta HTTP 200 (OK)
            return ResponseEntity.ok(usuariRepository.save(usuariToUpdate));
        } else {
            // Si no se encuentra la persona, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    // Maneja las solicitudes DELETE a /persons/{id} para eliminar una persona por su ID
    @DeleteMapping("/{idUsuari}")
    public ResponseEntity<Void> deleteusuari(@PathVariable Long idUsuari) {
        // Busca una persona por su ID
        Optional<Usuari> Usuari = usuariRepository.findById(idUsuari);
        // Si se encuentra la persona, la elimina de la base de datos
        if (Usuari.isPresent()) {
            usuariRepository.delete(Usuari.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
        } else {
            // Si no se encuentra la persona, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
}
