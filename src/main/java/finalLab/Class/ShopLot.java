/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.Class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 *
 * @author andrii
 */
@EnableAutoConfiguration
@Entity
public class ShopLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToOne(
//            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "item_id")
    private Item item;// TODO need onedirectional relation
    @Column(name = "price")
    private int price;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public ShopLot() {
    }
    /**
     *
     * @param name
     */
    public ShopLot(String name) {
        this.name = name;
    }

    /**
     *
     * @param name
     * @param item
     * @param price
     * @param shop
     */
    public ShopLot(String name, Item item, int price, Shop shop) {
        this.name = name;
        this.item = item;
        this.price = price;
        this.shop = shop;
    }
    
    public Item getCopyOfItem(){
        Item baseItem = this.getItem();
        Item copiedItem = new Item(baseItem.getVolume(), baseItem.getType(), baseItem.getName(), baseItem.getShelfLife(), baseItem.getManufactureDate());
        
        return copiedItem;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * @param shop the shop to set
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

}
