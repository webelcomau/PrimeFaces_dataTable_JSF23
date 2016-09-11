package com.webel.pf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author darrenkelly
 */
//@Named(value = "viewBean")
//@Dependent
@ManagedBean
@ViewScoped
public class ViewBean implements Serializable {

    private static final Logger logger = Logger.getLogger(ViewBean.class.getName());
    
    private static void echo(String s) {
        logger.info(s);
    }
    
    /**
     * Creates a new instance of ViewBean
     */
    public ViewBean() {
    }
    
    private boolean showAllColumns = false;

    public boolean isShowAllColumns() {
        return showAllColumns;
    }

    public void setShowAllColumns(boolean showAllColumns) {
        this.showAllColumns = showAllColumns;
    }
    
    private FakeQuery query = new FakeQuery();
    
    private List<FakeEntity> entities;
    
    public List<FakeEntity> getEntities() {
        if (entities==null) {
            entities = fetchEntities();
        }
        return entities;
    }
    
    private List<FakeEntity> fetchEntities() {
        return query.getEntities();
    }
    
    public void reset() {
        entities = null;
    }
    
    public void updateRow(RowEditEvent event) {
        FakeEntity e = (FakeEntity) event.getObject();
        query.merge(e);
        logger.info("updateRow: e.id: "+e.getId());
        reset(); //!
    }
    
    private String newName;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
    
    public String addNewEntity() {        
        FakeEntity e = new FakeEntity();
        String name = getNewName() == null || getNewName().isEmpty() ? "[name]" : getNewName();
        e.setName(name);
        query.persist(e);
        logger.info("addNewEntity: e.id:" + e.getId());
        logger.info("addNewEntity: e.name:" + e.getName());
        return null;
    } 
    
    
    private FakeEntity selected;

    public FakeEntity getSelected() {
        return selected;
    }

    public void setSelected(FakeEntity selected) {
        echo("setSelected: "+selected);
        this.selected = selected;
    }
    
    public void saveSelected() {
        echo("saveSelected: "+selected);
        query.merge(selected);
    }
    
    public Integer getSumValInt() {
        Integer out = 0;
        for (FakeEntity fe: getEntities()) {
            if (fe.getValInt() == null) {
                return null;
            }
            else {
                out += fe.getValInt();
            }
        }
        return out;
    }
}
