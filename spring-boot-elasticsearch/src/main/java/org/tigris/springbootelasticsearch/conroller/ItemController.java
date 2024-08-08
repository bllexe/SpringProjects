package org.tigris.springbootelasticsearch.conroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tigris.springbootelasticsearch.model.Item;
import org.tigris.springbootelasticsearch.repos.ItemRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        return new ResponseEntity<>(itemRepository.save(item), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findByID(@PathVariable String id){
        return new ResponseEntity<>(itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Item>> findAll(){
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id){
        itemRepository.deleteById(id);
    }


}
