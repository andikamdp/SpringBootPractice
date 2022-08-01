package co.id.practice.practice.controller;

import co.id.practice.practice.dao.h2.hello.HelloDao;
import co.id.practice.practice.model.HelloWorldModel;
import co.id.practice.practice.model.dto.HelloWorldPatchDto;
import co.id.practice.practice.model.dto.HelloWorldSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hello-world")
public class HelloController {

    private final HelloDao helloDao;

    @Autowired
    public HelloController(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    @GetMapping
    public List<HelloWorldModel> getAllHelloWorld() {
        return this.helloDao.findAll();
    }

    @GetMapping("{id}")
    public HelloWorldModel getHelloWorld(@PathVariable("id") Long id) {
        return this.helloDao.findById(id);
    }

    @PostMapping
    public void addHelloWorld(@RequestBody HelloWorldSaveDto helloWorldModel) {
        helloDao.save(helloWorldModel);
    }

    @PutMapping
    public void updateHelloWorld(@RequestBody HelloWorldModel helloWorldModel) {
        helloDao.update(helloWorldModel);
    }

    @DeleteMapping("{id}")
    public void deleteHelloWorld(@PathVariable("id") Long id) {
        this.helloDao.delete(id);
    }

    @PatchMapping
    public void changeHelloWorld(@RequestBody HelloWorldPatchDto helloWorldPatchDto) {
        this.helloDao.patch(helloWorldPatchDto);
    }
}
