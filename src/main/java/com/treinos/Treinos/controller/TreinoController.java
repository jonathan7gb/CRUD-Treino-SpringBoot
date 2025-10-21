package com.treinos.Treinos.controller;

import com.treinos.Treinos.model.Treino;
import com.treinos.Treinos.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;

    @GetMapping
    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Treino findById(@PathVariable Long id) {
        return treinoRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Treino save(@RequestBody Treino treino) {
        return treinoRepository.save(treino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treino> update(@PathVariable Long id, @RequestBody Treino treinoDetails) {
        Optional<Treino> treino = treinoRepository.findById(id);

        if(treino.isPresent()){
            Treino treinoUpdate = treino.get();
            treinoUpdate.setNome(treinoDetails.getNome());
            treinoUpdate.setRepeticoes(treinoDetails.getRepeticoes());
            treinoUpdate.setSeries(treinoDetails.getSeries());
            treinoUpdate.setMusculo(treinoDetails.getMusculo());

            return ResponseEntity.ok(treinoRepository.save(treinoUpdate));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void>  delete(@PathVariable Long id) {
       if(treinoRepository.existsById(id)){
           treinoRepository.deleteById(id);
           return ResponseEntity.noContent().build();
       }else{
           return ResponseEntity.notFound().build();
       }
    }

}
