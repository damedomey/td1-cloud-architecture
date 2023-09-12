package com.unice.politech.cloud.service;

import com.unice.politech.cloud.model.Counter;
import com.unice.politech.cloud.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounterService {
    @Autowired
    private CounterRepository counterRepository;

    public List<Counter> findAll(){
        return counterRepository.findAll();
    }

    /**
     * Increment the number of visit by one
     * Create entry in database if this [page] doesn't exist
     * @param page the name of page
     */
    public void increment(String page) {
        Optional<Counter> counterOptional = counterRepository.findByPageName(page);

        if (counterOptional.isPresent()) {
            Counter counter = counterOptional.get();
            counter.setTotal(counter.getTotal() + 1);
            counterRepository.flush();
        } else {
            Counter newCounter = new Counter();
            newCounter.setPageName(page);
            newCounter.setTotal(1L); // Set the initial total to 1
            counterRepository.save(newCounter);
        }
    }
}
