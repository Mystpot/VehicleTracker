package com.Group3.services;

import com.Group3.domain.History;

import java.util.Optional;

public interface HistoryService
{
    History create(History history);
    Optional<History> read(long id);
    History update(History history);
    void delete(History id);
    Iterable<History> findAll();
    History findByInvoices(long id);
}
