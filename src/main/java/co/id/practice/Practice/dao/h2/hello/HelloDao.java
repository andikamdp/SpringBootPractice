package co.id.practice.practice.dao.h2.hello;

import co.id.practice.practice.model.HelloWorldModel;
import co.id.practice.practice.model.dto.HelloWorldPatchDto;
import co.id.practice.practice.model.dto.HelloWorldSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelloDao {

    private final HelloRepository helloRepository;

    @Autowired
    public HelloDao(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public void save(HelloWorldSaveDto helloWorld) {
        HelloWorldModel helloWorldModel = new HelloWorldModel();
        helloWorldModel.setMessage(helloWorld.getMessage());
        helloWorldModel.setSender(helloWorld.getSender());
        helloRepository.save(helloWorldModel);
    }

    public HelloWorldModel findById(Long id) {
        return helloRepository.findById(id).orElseThrow();
    }

    public List<HelloWorldModel> findAll() {
        return helloRepository.findAll();
    }

    public void delete(Long id) {
        HelloWorldModel helloWorldModel = findById(id);
        helloRepository.delete(helloWorldModel);
    }

    public void update(HelloWorldModel helloWorldUpdate) {
        findById(helloWorldUpdate.getId());
        helloRepository.save(helloWorldUpdate);
    }

    public void patch(HelloWorldPatchDto helloWorldPatch) {
        HelloWorldModel helloWorldModel = findById(helloWorldPatch.getId());
        helloWorldModel.setMessage(helloWorldPatch.getMessage());
        helloRepository.delete(helloWorldModel);
    }
}
