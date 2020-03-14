/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

/**
 *
 * @author andrii
 */
public class RefrigeratorSection {

    private long id;
    private int maxVolume=100;
    private String type="shelf"; // тип секции: дверца, или обычная полка
    private String name="sample_section_name";
    private String contentsType="general";
    private List<Item> contents = new ArrayList<Item>();

    public RefrigeratorSection() {
    }

    public RefrigeratorSection(int maxVolume, String type, String name, String contentsType) {
        this.maxVolume = maxVolume;
        this.type = type;
        this.name = name;
        this.contentsType = contentsType;
    }

    public RefrigeratorSection(int maxVolume, String type, String name, String contentsType, List<Item> contents) {
        this.maxVolume = maxVolume;
        this.type = type;
        this.name = name;
        this.contentsType = contentsType;
        this.contents = contents;
    }

    /**
     * @param itemToAdd
     * @throws jdk.jshell.spi.ExecutionControl.NotImplementedException
     */
    public void addItem(Item itemToAdd) throws Exception {
        if (this.getVolume() + itemToAdd.getVolume() <= maxVolume) {
            contents.add(itemToAdd);
        } else {
            throw new Exception("TODO");
        }

    }

    /**
     * @param itemToRemove
     */
    public void removeItem(Item itemToRemove) {
        contents.remove(itemToRemove);
    }

    /**
     * @return the volume
     * @throws jdk.jshell.spi.ExecutionControl.NotImplementedException
     */
    public int getVolume() throws NotImplementedException {
        int volume = 0;
        for (Item contentItem : contents) {
            volume += contentItem.getVolume();
        }
        return volume;
    }

    /**
     * @return the maxVolume
     */
    public int getMaxVolume() {
        return maxVolume;
    }

    /**
     * @param maxVolume the maxVolume to set
     */
    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    /**
     * @return the ContentsType
     */
    public String getContentsType() {
        return contentsType;
    }

    /**
     * @param contentsType
     */
    public void setContentsType(String contentsType) {
        this.contentsType = contentsType;
    }

    /**
     * @return the contents
     */
    public List<Item> getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(List<Item> contents) {
        this.contents = contents;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return the id
     */
    public long getId() {
        return id;
    }
}
