/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comoba;

import java.sql.*;
import java.sql.Date;/*se usa para manejar fechas y horas*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author anto_
 */

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producto;
    private int cantidad;

    // Constructor vacío
    public Pedido() {
    }

    // Constructor con parámetros
    public Pedido(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
    
    
    
    
    /*    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;
    private int idUsuario;
    private int idTarjeta;
    private int cantidad_pedido;
    private double precioTotalPedido;
    private Timestamp estadoProcesando;
    private Timestamp estadoEnviado;
    private Timestamp estadoRecibido;
    private Timestamp estadoCancelado;
    private String fechaPedido;
    private String fechaEntrega;

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public int getCantidad_pedido() {
        return cantidad_pedido;
    }

    public double getPrecioTotalPedido() {
        return precioTotalPedido;
    }

    public Timestamp getEstadoProcesando() {
        return estadoProcesando;
    }

    public Timestamp getEstadoEnviado() {
        return estadoEnviado;
    }

    public Timestamp getEstadoRecibido() {
        return estadoRecibido;
    }

    public Timestamp getEstadoCancelado() {
        return estadoCancelado;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setCantidad_pedido(int cantidad_pedido) {
        this.cantidad_pedido = cantidad_pedido;
    }

    public void setPrecioTotalPedido(double precioTotalPedido) {
        this.precioTotalPedido = precioTotalPedido;
    }

    public void setEstadoProcesando(Timestamp estadoProcesando) {
        this.estadoProcesando = estadoProcesando;
    }

    public void setEstadoEnviado(Timestamp estadoEnviado) {
        this.estadoEnviado = estadoEnviado;
    }

    public void setEstadoRecibido(Timestamp estadoRecibido) {
        this.estadoRecibido = estadoRecibido;
    }

    public void setEstadoCancelado(Timestamp estadoCancelado) {
        this.estadoCancelado = estadoCancelado;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
    
   /* 
    public static void anadirProductoPedido(int id_pedido, int id_promocion, int id_producto, int cantidad){
        PedidoDAO.anadirProcuctoPedido(id_pedido, id_promocion, id_producto, cantidad);
        System.out.println("Producto con id: " + id_producto + " a�adido al pedido con id: " + id_pedido + " con la promoci�n id: " + id_promocion + " con la cantidad de " + cantidad + " productos.");
        
    }
    
    
    public static int calcularCantidadPedido(int id_pedido){
        return PedidoDAO.calcularCantidadPedido(id_pedido);
    }
    
    public static double calcularPrecioPedido(int id_pedido){
        return PedidoDAO.calcularPrecioPedido(id_pedido);

    }
    
    
    public static void procesarPedido(int id_pedido){
        PedidoDAO.procesarPedido(id_pedido);
    }
    */
}

