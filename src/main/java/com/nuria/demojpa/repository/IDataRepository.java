package com.nuria.demojpa.repository;

import com.nuria.demojpa.entity.DataEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDataRepository extends JpaRepository<DataEntity, Long>{

    List<DataEntity> findAllByField1(String field1, Pageable pageable);
    List<DataEntity> findAllByField2Containing(String x, Pageable pageable);

}
