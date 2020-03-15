/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author andrii
 */
@Entity
public class Refrigerator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name = "fridge";
    @Column(name = "door1")
    private boolean door1 = false;
    @Column(name = "door2")
    private boolean door2 = false;
    @Column(name = "level")
    private int level = 1;
    @Column(name = "skin")
    private String Skin = "default";
    @OneToMany(
            mappedBy = "frige",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<RefrigeratorSection> SectionList = new ArrayList<RefrigeratorSection>();

    public Refrigerator() {
    }

    public Refrigerator(String name, boolean door1, boolean door2) {
        this.name = name;
        this.door1 = door1;
        this.door2 = door2;
    }

    public Refrigerator(String name, boolean door1, boolean door2, int level, String Skin, List<RefrigeratorSection> SectionList) {
        this.name = name;
        this.door1 = door1;
        this.door2 = door2;
        this.level = level;
        this.Skin = Skin;
        this.SectionList = SectionList;
    }

    /**
     * @return the SectionList
     */
    public List<RefrigeratorSection> getSectionList() {
        return SectionList;
    }

    /**
     * @param SectionList the SectionList to set
     */
    public void setSectionList(List<RefrigeratorSection> SectionList) {
        this.SectionList = SectionList;
    }

    /**
     * @return the Skin
     */
    public String getSkin() {
        return Skin;
    }

    /**
     * @param Skin the Skin to set
     */
    public void setSkin(String Skin) {
        this.Skin = Skin;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the door1
     */
    public boolean isDoor1() {
        return door1;
    }

    /**
     * @param door1 the door1 to set
     */
    public void setDoor1(boolean door1) {
        this.door1 = door1;
    }

    /**
     * @return the door2
     */
    public boolean isDoor2() {
        return door2;
    }

    /**
     * @param door2 the door2 to set
     */
    public void setDoor2(boolean door2) {
        this.door2 = door2;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

}
