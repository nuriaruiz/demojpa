package com.nuria.demojpa;

import com.nuria.demojpa.entity.DataEntity;
import com.nuria.demojpa.repository.IDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.IsNot.not;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@DataJpaTest(showSql = false)
@RunWith(SpringRunner.class)
public class DataRepositoryIntegrationTest {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private IDataRepository repository;

    @Before
    public void before() {
        entityManager.persist(DataEntity.from("field1a", "field2a", "field3a", "field4a"));
        entityManager.persist(DataEntity.from("field1b", "field2b", "field3b", "field4b"));
        entityManager.persist(DataEntity.from("field1c", "field2c", "field3c", "field4c"));
        entityManager.persist(DataEntity.from("field1d", "field2d", "field3d", "field4d"));
        entityManager.persist(DataEntity.from("field1e", "field2e", "field3e", "field4e"));
    }

    @Test
    public void givenDataEntity_OrderByField1Asc_theCorrectOrder(){
        entityManager.persist(DataEntity.from("field1a", "field2aa", "field3aa", "field4aa"));
        entityManager.persist(DataEntity.from("field1a", "field2bb", "field3bb", "field4bb"));
        entityManager.persist(DataEntity.from("field1a", "field2cc", "field3cc", "field4cc"));

        List<DataEntity> listDataEntity = repository.findAllByField1("field1a", PageRequest.of(0, 2));
        assertEquals(2, listDataEntity.size());
    }

    @Test
    public void givenDataEntities_FilterByField2Containing_theCorrectEntities_andSize(){
        entityManager.persist(DataEntity.from("field1a", "field2aa", "field3aa", "field4aa"));
        entityManager.persist(DataEntity.from("field1a", "field2bbx", "field3bb", "field4bb"));
        entityManager.persist(DataEntity.from("field1a", "field2cc", "field3cc", "field4cc"));

        List<DataEntity> listDataEntity = repository.findAllByField2Containing("x", PageRequest.of(0, 2));
        assertEquals(1, listDataEntity.size());
    }
}
