package com.mls.mlsmoneyapi.resource;

import com.mls.mlsmoneyapi.event.RecursoCriadoEvent;
import com.mls.mlsmoneyapi.model.Categoria;
import com.mls.mlsmoneyapi.repository.CategoriaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "API Rest - Categorias")
@CrossOrigin(origins = "*")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @ApiOperation(value = "Listar Categorias")
    public List<Categoria> listar(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    @PostMapping
    @ApiOperation(value = "Criar uma nova Categoria")
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    @ApiOperation(value = "Buscar Categoria por Id")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        if(categoria.isPresent()){
            return ResponseEntity.ok(categoria.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}

