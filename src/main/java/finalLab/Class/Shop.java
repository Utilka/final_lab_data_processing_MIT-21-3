/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.Class;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
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
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<ShopLot> contents = new HashSet<ShopLot>();

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public Shop(String name, Set<ShopLot> contents) {
        this.name = name;
        this.contents = contents;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the contents
     */
    public Set<ShopLot> getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(Set<ShopLot> contents) {
        this.contents = contents;
    }

}
