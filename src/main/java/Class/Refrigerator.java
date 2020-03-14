/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrii
 */
public class Refrigerator {

    private long id;
    private String name="fridge";
    private boolean door1=false;
    private boolean door2=false;
    private int level = 1;
    private String Skin = "default";
    private List<RefrigeratorSection> SectionList = new ArrayList<RefrigeratorSection>();
    
    public Refrigerator() {
    }
    
    public Refrigerator(String name,boolean door1,boolean door2){
        this.name = name;
        this.door1 = door1;
        this.door2 = door2;
    }
    public Refrigerator(String name,boolean door1,boolean door2,int level,String Skin,List<RefrigeratorSection> SectionList){
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
