/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.Class;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 *
 * @author andrii
 */
@EnableAutoConfiguration
@Entity
public class Item {

    final long milisecondsInDay = 86400000;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "volume")
    private int volume = 1;
    @Column(name = "type")
    private String type = "general";
    @Column(name = "name")
    private String name = "sample_item_name";
    @Column(name = "shelf_life")
    private int shelfLife = 10; //in days
    @Column(name = "manufacture_date")
    private Date manufactureDate = new Date(1584169190000L); // GMT: Saturday, March 14, 2020 6:59:50 AM

    @ManyToOne
    @JoinColumn(name = "frige_section_id")
    private RefrigeratorSection inFrigeSection; // GMT: Saturday, March 14, 2020 6:59:50 AM
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private RefrigeratorSection inStorage; // GMT: Saturday, March 14, 2020 6:59:50 AM

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int volume, String type, String name, int shelfLife, Date manufactureDate) {
        this.volume = volume;
        this.type = type;
        this.name = name;
        this.shelfLife = shelfLife;
        this.manufactureDate = manufactureDate;
    }

    public String checkShelfLife() {
        long shelfLifeInMiliseconds = shelfLife * milisecondsInDay;
        Date currentDate = new Date();
        if (currentDate.getTime() > manufactureDate.getTime() + shelfLifeInMiliseconds) {
            return "Expired";
        }
        if (currentDate.getTime() > manufactureDate.getTime() + shelfLifeInMiliseconds - 7 * 86400000) { //7 days before expiration date
            return "Close to Expiring";
        }
        if (currentDate.getTime() < manufactureDate.getTime() + shelfLifeInMiliseconds) {
            return "Fresh";
        }
        return "";
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
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
     * @return the shelfLife
     */
    public int getShelfLife() {
        return shelfLife;
    }

    /**
     * @param shelfLife the shelfLife to set
     */
    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    /**
     * @return the manufactureDate
     */
    public Date getManufactureDate() {
        return manufactureDate;
    }

    /**
     * @param manufactureDate the manufactureDate to set
     */
    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the inFrigeSection
     */
    public RefrigeratorSection getInFrigeSection() {
        return inFrigeSection;
    }

    /**
     * @param inFrigeSection the inFrigeSection to set
     */
    public void setInFrigeSection(RefrigeratorSection inFrigeSection) {
        this.inFrigeSection = inFrigeSection;
    }

    /**
     * @return the inStorage
     */
    public RefrigeratorSection getInStorage() {
        return inStorage;
    }

    /**
     * @param inStorage the inStorage to set
     */
    public void setInStorage(RefrigeratorSection inStorage) {
        this.inStorage = inStorage;
    }

}
