/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comoba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Administrador
 */

@RestController

@RequestMapping("/api/pedidos")
public class PedidoController {
   
    @Autowired
    private PedidoRepository pedidoRepository;
    
    
    @GetMapping
    public List<Pedido> getAllPedidos() {
        // Llama al método findAll() del repositorio para obtener todas las personas
        return pedidoRepository.findAll();
    }
    

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
