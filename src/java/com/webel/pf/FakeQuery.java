package com.webel.pf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author darrenkelly
 */
public class FakeQuery implements Serializable {

    public FakeQuery() {
        initEntities();
    }

    static private Map<Long, FakeEntity> entities = new HashMap<>();

    /**
     * Fake detached query.
     */
    public List<FakeEntity> getEntities() {
        List<FakeEntity> l = new ArrayList<>();
        for (Long id : entities.keySet()) {
            l.add(entities.get(id));
        }
        return l;
    }

    static private Long id = 0L;

    public void persist(FakeEntity fe) {
        fe.setId(id++);
        entities.put(fe.getId(), fe);
    }

    private void initEntities() {

        if (entities.isEmpty()) {

            FakeEntity e1 = new FakeEntity();
            e1.setName("e1");
            e1.setValue1("val1.1");
            e1.setValue2("val2.1");
            //e1.setValue3("val3.1");
            e1.setValInt(1);
            persist(e1);

            FakeEntity e2 = new FakeEntity();
            e2.setName("e2");
            e2.setValue1("val1.2");
            e2.setValue2("val2.2");
            e2.setValInt(2);
            persist(e2);
        }
    }

    /**
     * Fake merge, simply overwrites entity with matching key.
     *
     * @param entity
     */
    public void merge(FakeEntity entity) {
        entities.put(entity.getId(), entity);
    }
}
