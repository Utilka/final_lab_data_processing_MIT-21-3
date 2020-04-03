/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.Class;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "volume")
    private int volume = 1;
    @Column(name = "type")
    private String type = "general";
    @Column(name = "name")
    private String state = "normal";
    @Column(name = "state")
    private String picture = "/item_pictures/default.svg";
    @Column(name = "picture")
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
        Date currentDate = new Date();
        this.manufactureDate = currentDate;
    }

    public Item(String name) {
        this.name = name;
        Date currentDate = new Date();
        this.manufactureDate = currentDate;
    }
    
    public Item(String state,String picture, String type, String name) {
        this.volume = volume;
        this.state = state;
        this.picture = picture;
        this.type = type;
        this.name = name;
        this.shelfLife = shelfLife;
        Date currentDate = new Date();
        this.manufactureDate = currentDate;
    }
    
    public Item(int volume, String state,String picture, String type, String name, int shelfLife, Date manufactureDate) {
        this.volume = volume;
        this.state = state;
        this.picture = picture;
        this.type = type;
        this.name = name;
        this.shelfLife = shelfLife;
        Date currentDate = new Date();
        this.manufactureDate = currentDate;
    }
    
    public String getPic(){
        String pic = "/item_pictures/error.svg";
        if(this.picture.equals("/item_pictures/default.svg")){
            System.out.println(this.name + " " + this.getState());
            if(this.getState().equals("normal")){
                System.out.println(this.name + " nornmal");
                if(this.type.equals("fruits")){
                    pic = "/item_pictures/fruit-salad.svg";
                }else if(this.type.equals("vegetables")){
                    pic = "/item_pictures/vegetable.svg";
                }else if(this.type.equals("coocked")){
                    pic = "/item_pictures/breakfast.svg";
                }else if(this.type.equals("semifinished")){
                    System.out.println(this.name + " semifinished");
                    pic = "/item_pictures/pizza.svg";
                }else if(this.type.equals("sweet")){
                    pic = "/item_pictures/cake.svg";
                }else if(this.type.equals("meet")){
                    pic = "/item_pictures/meat.svg";
                }else if(this.type.equals("drink")){
                    pic = "/item_pictures/water.svg";
                }else if(this.type.equals("cheese")){
                    pic = "/item_pictures/cheese.svg";
                }else{
                    pic = "/item_pictures/default.svg";
                }
            }else if(this.getState().equals("frozen")){
                if(this.type.equals("fruits")){
                    pic = "/item_pictures/fruit-salad.svg";
                }else if(this.type.equals("vegetables")){
                    pic = "/item_pictures/fr_vegetable.svg";
                }else if(this.type.equals("coocked")){
                    pic = "/item_pictures/breakfast.svg";
                }else if(this.type.equals("sweet")){
                    pic = "/item_pictures/cake.svg";
                }else if(this.type.equals("meet")){
                    pic = "/item_pictures/fr_steak.svg";
                }else if(this.type.equals("drink")){
                    pic = "/item_pictures/water.svg";
                }else if(this.type.equals("cheese")){
                    pic = "/item_pictures/cheese.svg";
                }else{
                    pic = "/item_pictures/frozen.svg";
                }
            }else if(this.getState().equals("spoiled")){
                pic = "/item_pictures/spoiled.png";
            }
        }else if(this.getState().equals("spoiled")){
                pic = "/item_pictures/spoiled.png";
        }else{
            pic = this.picture;
        }
        
        return pic;
    }
    
    public String getStateColor() {
        if (this.getState().equals("frozen")){
            return "aqua";
        }
        if (this.getState().equals("spoiled")){
            return "brown";
        }
        if(this.checkShelfLife().equals("Close to Expiring")){
            return "orange";
        }
        return "black";
    }
    
    public String getState() {
        if(this.inFrigeSection!=null){
            if(this.getInFrigeSection().getContentsType().equals("frozen")){
                this.state = "frozen";
            } else if(this.checkShelfLife().equals("Expired")){
                this.state = "spoiled";
            }
        }
        return state;
    }
    
    public String checkShelfLife() {
        if(this.inFrigeSection!=null){
            if(this.inFrigeSection.getContentsType().equals("frozen")){
                return "Frozen";
            }else{
                long shelfLifeInMiliseconds = shelfLife * 86400000;
                Date currentDate = new Date();
                if (currentDate.getTime() > manufactureDate.getTime() + shelfLifeInMiliseconds) {
                    return "Expired";
                }
                if (currentDate.getTime() > manufactureDate.getTime() + shelfLifeInMiliseconds - 3 * 86400000) { //3 days before expiration date
                    return "Close to Expiring";
                }
                if (currentDate.getTime() < manufactureDate.getTime() + shelfLifeInMiliseconds) {
                    return "Fresh";
                } 
            }
        }
        return "";
    }
    public String getLeftDateString() {
        return  getDateString();
    }
    public String getDateString() {
        long shelfLifeInMiliseconds = shelfLife * 86400000;
        Date currentDate = new Date();
        long date_left = currentDate.getTime() - manufactureDate.getTime() + shelfLifeInMiliseconds;
        if(date_left >= 3600000){
            if(date_left >= 86400000){
                return date_left/86400000 + "д";
            }else{
                return date_left/3600000 + "ч";
            }
        }else{
            return date_left/60000 + "мин";
        }
    }
    
    public int getDateInt() {
        long shelfLifeInMiliseconds = shelfLife * 86400000;
        Date currentDate = new Date();
        long date_left = currentDate.getTime() - manufactureDate.getTime() + shelfLifeInMiliseconds;
        if(date_left >= 3600000){
            if(date_left >= 86400000){
                date_left = date_left/86400000;
                return (int)date_left;
            }else{
                date_left =date_left/3600000;
                return (int)date_left;
            }
        }else{
            date_left =date_left/60000;
            return (int)date_left;
        }
    }
    
    public void setInFrigeSection(RefrigeratorSection newFrigeSection) {
            if(this.state.equals("frozen")){
                if(newFrigeSection.getContentsType().equals("frozen")){
                }else{
                    this.state = "normal";
                }
            }
        this.inFrigeSection = newFrigeSection;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
