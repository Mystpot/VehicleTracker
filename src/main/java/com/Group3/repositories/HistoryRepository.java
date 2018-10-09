package com.Group3.repositories;

import com.Group3.domain.History;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Long>
{
    History findByInvoices(long id);

}
