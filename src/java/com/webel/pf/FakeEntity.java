package com.webel.pf;

import java.io.Serializable;

/**
 *
 * @author darrenkelly
 */
public class FakeEntity implements Serializable {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String value1 = "val1";
    
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    private String value2 = "val2";
    
    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
    
    private Integer valInt = 0;
    
    public Integer getValInt() {
        return valInt;
    }

    public void setValInt(Integer valInt) {
        this.valInt = valInt;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " ["+id+"] '"+name+"' "+
                "{ value1="+value1+", value2="+value2+", valInt="+valInt+"}";                
    }
    
    
}
