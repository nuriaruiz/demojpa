package com.nuria.demojpa.repository;

import com.nuria.demojpa.entity.DataEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDataRepository extends JpaRepository<DataEntity, Long>{

    List<DataEntity> findAllByField1(String field1, Pageable pageable);
    List<DataEntity> findAllByField2Containing(String x, Pageable pageable);
    List<DataEntity> findDataEntityByField1EqualsOrField2EqualsOrField3EqualsOrField4Equals(String field1, String field2, String field3, String field4);

    @Query("select m from DataEntity m " +
            "where (:field1 is null or m.field1= :field1) " +
            " and " +
            " ( :field2 is null or m.field2= :field2) " +
            " and " +
            " ( :field3 is null or m.field3= :field3) " +
            " and " +
            " ( :field4 is null or m.field4= :field4) "
    )
    List<DataEntity> findDataEntitiesWithDemandesOnly(@Param("field1") String field1,
                                                     @Param("field2") String field2,
                                                     @Param("field3") String field3,
                                                     @Param("field4") String field4);
}
