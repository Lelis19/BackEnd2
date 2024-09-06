package br.com.tiagolelis.medicalconsult.demo.usuario.resources;

import br.com.tiagolelis.medicalconsult.demo.usuario.services.UsuarioService;
import br.com.tiagolelis.medicalconsult.demo.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @PutMapping(value = "atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuarioViaId(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuarioPorId(usuario, id);
        return ResponseEntity.ok().body(usuarioAtualizado);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable Long id) {
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}



