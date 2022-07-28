package co.id.practice.practice.dao.h2.hello;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloDao {

    private final HelloRepository helloRepository;

    @Autowired
    public HelloDao(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }
}
