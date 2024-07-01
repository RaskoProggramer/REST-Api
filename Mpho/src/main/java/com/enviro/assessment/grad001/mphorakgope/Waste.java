package com.enviro.assessment.grad001.mphorakgope;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Entity
public class Waste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String manageWaste;

    public Waste(){}

    public Waste(String name, String manageWaste){
        this.name = name;
        this.manageWaste = manageWaste;
    }
    public  Long getId(){
        return this.id;
    }
    public void SetId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public  void setName(String name){
        this.name = name;
    }
    public String getManageWaste(){
        return this.manageWaste;
    }
    public void setManageWaste(String manageWaste){
        this.manageWaste = manageWaste;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Waste))
            return false;
        Waste garbage = (Waste) o;
        return Objects.equals(this.id, garbage.id) &&
                Objects.equals(this.name, garbage.name) &&
                Objects.equals(this.manageWaste, garbage.manageWaste);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.manageWaste);
    }
    @Override
    public String toString(){
        return "Waste Management{" + " id=" + this.id+ ", waste type= "+this.name+
        "how to manage it="+ this.manageWaste+ " }";
    }
}
