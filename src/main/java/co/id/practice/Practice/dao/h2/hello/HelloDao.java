package co.id.practice.practice.dao.h2.hello;

import co.id.practice.practice.model.HelloWorldModel;
import co.id.practice.practice.model.dto.HelloWorldPatchDto;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloDao {

    private final HelloRepository helloRepository;

    @Autowired
    public HelloDao(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public void save(HelloWorldModel helloWorld) {
        helloRepository.save(helloWorld);
    }

    public HelloWorldModel findById(Long id) {
        return helloRepository.findById(id).orElseThrow();
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
