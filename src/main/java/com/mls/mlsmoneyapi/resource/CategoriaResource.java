package com.mls.mlsmoneyapi.resource;

import com.mls.mlsmoneyapi.event.RecursoCriadoEvent;
import com.mls.mlsmoneyapi.model.Categoria;
import com.mls.mlsmoneyapi.repository.CategoriaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Tag(name = "API Rest - Categorias")
@CrossOrigin(origins = "*")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @Operation(summary = "Listar Categorias")
    public List<Categoria> listar(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    @PostMapping
    @Operation(summary = "Criar uma nova Categoria")
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    @Operation(summary = "Buscar Categoria por Id")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        if(categoria.isPresent()){
            return ResponseEntity.ok(categoria.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}

