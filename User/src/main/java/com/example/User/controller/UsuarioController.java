package com.example.User.controller;

import org.springframework.web.bind.annotation.*;
import com.example.User.model.Usuario;
import com.example.User.service.UsuarioService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
@Tag(name = "Usuarios", description = "Operaciones CRUD para la gestión de usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(
        summary = "Obtener todos los usuarios",
        description = "Devuelve una lista de todos los usuarios registrados en el sistema."
    )
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/email/{email}")
    @Operation(
        summary = "Buscar usuario por email",
        description = "Obtiene un usuario específico usando su correo electrónico."
    )
    public Usuario buscarPorEmail(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email);
    }

    @PostMapping
    @Operation(
        summary = "Registrar un nuevo usuario",
        description = "Crea un nuevo usuario en el sistema con nombre, email, contraseña y rol."
    )
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }
}
