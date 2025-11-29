// Archivo: src/main/java/com/example/Productos/controller/ProductoController.java (Modificado)

package com.example.Productos.controller;

import org.springframework.web.bind.annotation.*;
import com.example.Productos.model.Producto;
import com.example.Productos.service.ProductoService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation; // Importa esto
import io.swagger.v3.oas.annotations.tags.Tag; // Importa esto

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
@Tag(name = "Productos", description = "Operaciones CRUD para la gestión de productos") // Agregado
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista de todos los productos disponibles.") // Agregado
    public List<Producto> listarProductos() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID", description = "Busca un producto por su identificador único.") // Agregado
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Registra un nuevo producto en la base de datos.") // Agregado
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crear(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto existente", description = "Modifica los detalles de un producto usando su ID.") // Agregado
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto de la base de datos por su ID.") // Agregado
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
