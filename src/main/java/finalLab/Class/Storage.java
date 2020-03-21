/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.Class;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 *
 * @author andrii
 */
@EnableAutoConfiguration
@Entity
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "max_volume")
    private int maxVolume;
    @Column(name = "name")
    private String name;
    @OneToMany(
            mappedBy = "inStorage",
//            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Item> contents = new HashSet<Item>();

    public Storage() {
    }

    public Storage(String name) {
        this.name = name;
    }

    public Storage(int maxVolume, String type, String name, String contentsType, Set<Item> contents) {
        this.maxVolume = maxVolume;
        this.name = name;
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
            throw new Exception("TODO maxVolume in storage");
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
    public int getVolume() {
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
    public Set<Item> getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(Set<Item> contents) {
        this.contents = contents;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

}
