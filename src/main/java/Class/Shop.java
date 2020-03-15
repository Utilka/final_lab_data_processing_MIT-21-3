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
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<ShopLot> contents = new ArrayList<ShopLot>();
}
