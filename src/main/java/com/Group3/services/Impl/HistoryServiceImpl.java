package com.Group3.services.Impl;

import com.Group3.domain.History;
import com.Group3.repositories.HistoryRepository;
import com.Group3.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HistoryServiceImpl implements HistoryService
{
    @Autowired
    private HistoryRepository historyRepository;


    public History create(History history)
    {
        return historyRepository.save(history);
    }

    public Optional<History> read(long id)
    {
        return historyRepository.findById(id);
    }

    public History update(History history)
    {
        return historyRepository.save(history);
    }

    public void delete(History id)
    {
        historyRepository.delete(id);
    }

    public Iterable<History> findAll()
    {
        return  historyRepository.findAll();
    }

    public History findByInvoices(long id){
        return historyRepository.findByInvoices(id);
    }

}
