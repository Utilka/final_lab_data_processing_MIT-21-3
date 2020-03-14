/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import jdk.jshell.spi.ExecutionControl;

/**
 *
 * @author andrii
 */
public class Storage {
    private int maxVolume;
    private String name;
    private List<Item> contents = new ArrayList<Item>();

   
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
     */
    public int getVolume(){
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
    
}
