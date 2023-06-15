package restapi.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import restapi.data.*;

@RestController
@RequestMapping("data")
public class DataController {

    @Autowired
    private DataRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid jsonData json) {
        repository.save(new Data(json));
    }

    @GetMapping
    public Page<DataList> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        return repository.findAllByActiveTrue(page).map(DataList::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdate json) {
        var data = repository.getReferenceById(json.id());
        data.updateData(json);
    }

    /*
    // Hard delete, deleting from the database.
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
    */

    // Logical delete, data still in the database, but not shown to the people
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var data = repository.getReferenceById(id);
        data.delete();
    }

}
