package com.example.springfundamentalsexam.service;

import com.example.springfundamentalsexam.domain.entity.Condition;
import com.example.springfundamentalsexam.domain.enums.ConditionName;
import com.example.springfundamentalsexam.repository.ConditionRepo;
import org.springframework.stereotype.Service;

@Service
public class ConditionServiceImpl implements ConditionService {
    private ConditionRepo conditionRepo;

    public ConditionServiceImpl(ConditionRepo conditionRepo) {
        this.conditionRepo = conditionRepo;
    }
    @Override
    public void seedAll() {
        if(this.conditionRepo.count()==0) {
            Condition excellent = new Condition();
            excellent.setConditionName(ConditionName.valueOf("EXCELLENT"));
            excellent.setDescription("In perfect condition");
            this.conditionRepo.save(excellent);
            Condition good = new Condition();
            good.setConditionName(ConditionName.valueOf("GOOD"));
            good.setDescription("Some signs of wear and tear or minor defects");
            this.conditionRepo.save(good);
            Condition acceptable = new Condition();
            acceptable.setConditionName(ConditionName.valueOf("ACCEPTABLE"));
            acceptable.setDescription("The item is fairly worn but continues to function properly");
            this.conditionRepo.save(acceptable);
        }
    }

    @Override
    public Condition findByConditionName(ConditionName conditionName) {
        return this.conditionRepo.findByConditionName(conditionName);
    }
}
