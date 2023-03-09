package com.example.springfundamentalsexam.init;


import com.example.springfundamentalsexam.service.ConditionServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private ConditionServiceImpl conditionService;

    public ConsoleRunner(ConditionServiceImpl conditionService) {
        this.conditionService=conditionService;
    }
    @Override
    public void run(String... args) throws Exception {
        this.conditionService.seedAll();
    }
}
