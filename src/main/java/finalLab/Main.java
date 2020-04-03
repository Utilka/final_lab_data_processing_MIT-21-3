package finalLab;

import finalLab.Class.Item;
import finalLab.Class.RefrigeratorSection;
import finalLab.Class.Refrigerator;
import finalLab.Class.Shop;
import finalLab.Class.ShopLot;
import finalLab.Class.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import finalLab.repository.ItemRepository;
import finalLab.repository.RefrigeratorRepository;
import finalLab.repository.RefrigeratorSectionRepository;
import finalLab.repository.ShopLotRepository;
import finalLab.repository.ShopRepository;
import finalLab.repository.StorageRepository;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RefrigeratorRepository refrigeratorRepository;

    @Autowired
    RefrigeratorSectionRepository refrigeratorSectionRepository;

    @Autowired
    ShopLotRepository shopLotRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    StorageRepository storageRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     *
     * @param args
     * @throws java.lang.Exception
     */
    @Override
    public void run(String... args) throws Exception {
        
        RefrigeratorSection refrigeratorSection3 = new RefrigeratorSection("Main-s-1");
        RefrigeratorSection refrigeratorSection4 = new RefrigeratorSection("Main-s-2");
        RefrigeratorSection refrigeratorSection5 = new RefrigeratorSection("Main-s-3");
        RefrigeratorSection refrigeratorSection6 = new RefrigeratorSection("Main-s-4");
        RefrigeratorSection refrigeratorSection7 = new RefrigeratorSection("Main-d");
        RefrigeratorSection refrigeratorSection8 = new RefrigeratorSection("Freezer-s-1");
        RefrigeratorSection refrigeratorSection9 = new RefrigeratorSection("Freezer-s-2");
        RefrigeratorSection refrigeratorSection10 = new RefrigeratorSection("Freezer-s-3");
        RefrigeratorSection refrigeratorSection11 = new RefrigeratorSection("Freezer-d");
        
        refrigeratorSection8.setContentsType("frozen");
        refrigeratorSection9.setContentsType("frozen");
        refrigeratorSection10.setContentsType("frozen");
        refrigeratorSection11.setContentsType("frozen");
        
        Refrigerator refrigerator = new Refrigerator("name 21");
        
        refrigeratorSection3.setFrige(refrigerator);
        refrigeratorSection4.setFrige(refrigerator);
        refrigeratorSection5.setFrige(refrigerator);
        refrigeratorSection6.setFrige(refrigerator);
        refrigeratorSection7.setFrige(refrigerator);
        refrigeratorSection8.setFrige(refrigerator);
        refrigeratorSection9.setFrige(refrigerator);
        refrigeratorSection10.setFrige(refrigerator);
        refrigeratorSection11.setFrige(refrigerator);

        Shop shop = new Shop("name 51");

        Storage storage = new Storage();
        
        storageRepository.save(storage);
        refrigeratorRepository.save(refrigerator);
        refrigeratorSectionRepository.save(refrigeratorSection3);
        refrigeratorSectionRepository.save(refrigeratorSection4);
        refrigeratorSectionRepository.save(refrigeratorSection5);
        refrigeratorSectionRepository.save(refrigeratorSection6);
        refrigeratorSectionRepository.save(refrigeratorSection7);
        refrigeratorSectionRepository.save(refrigeratorSection8);
        refrigeratorSectionRepository.save(refrigeratorSection9);
        refrigeratorSectionRepository.save(refrigeratorSection10);
        refrigeratorSectionRepository.save(refrigeratorSection11);
        shopRepository.save(shop);
        
        // Creating items
        // Item item, int price, Shop shop
        Item item1 = new Item("normal", "/item_pictures/default.svg", "fruits", "apple");
        ShopLot shoplot1 = new ShopLot(item1, 10, shop);
        itemRepository.save(item1);
        shopLotRepository.save(shoplot1);
        
        Item item2 = new Item("normal", "/item_pictures/default.svg", "vegetables", "potato");
        ShopLot shoplot2 = new ShopLot(item2, 20, shop);
        itemRepository.save(item2);
        shopLotRepository.save(shoplot2);
        
        Item item3 = new Item("normal", "/item_pictures/burger.svg", "coocked", "burger");
        ShopLot shoplot3 = new ShopLot(item3, 30, shop);
        itemRepository.save(item3);
        shopLotRepository.save(shoplot3);
        
        Item item4 = new Item("normal", "/item_pictures/default.svg", "coocked", "breakfast");
        ShopLot shoplot4 = new ShopLot(item4, 40, shop);
        itemRepository.save(item4);
        shopLotRepository.save(shoplot4);
        
        Item item5 = new Item("frozen", "/item_pictures/default.svg", "semifinished", "dumplings");
        ShopLot shoplot5 = new ShopLot(item5, 40, shop);
        item5.setShelfLife(1);
        itemRepository.save(item5);
        shopLotRepository.save(shoplot5);
        
        Item item6 = new Item("frozen", "/item_pictures/ice-cream.svg", "sweet", "ice-cream");
        ShopLot shoplot6 = new ShopLot(item6, 10, shop);
        item6.setShelfLife(1);
        itemRepository.save(item6);
        shopLotRepository.save(shoplot6);
        
        Item item7 = new Item("normal", "/item_pictures/meat.svg", "meet", "meet");
        ShopLot shoplot7 = new ShopLot(item7, 80, shop);
        itemRepository.save(item7);
        shopLotRepository.save(shoplot7);
        
        Item item8 = new Item("frozen", "/item_pictures/default.svg", "meet", "fr-meet");
        ShopLot shoplot8 = new ShopLot(item8, 70, shop);
        itemRepository.save(item8);
        shopLotRepository.save(shoplot8);
        
        Item item9 = new Item("normal", "/item_pictures/default.svg", "drink", "water");
        ShopLot shoplot9 = new ShopLot(item9, 10, shop);
        
        itemRepository.save(item9);
        shopLotRepository.save(shoplot9);
        
        Item item10 = new Item("normal", "/item_pictures/energy-drink.svg", "drink", "energy-drink");
        ShopLot shoplot10 = new ShopLot(item10, 20, shop);
        itemRepository.save(item10);
        shopLotRepository.save(shoplot10);
        
        Item item11 = new Item("normal", "/item_pictures/six-pack.svg", "drink", "beer");
        ShopLot shoplot11 = new ShopLot(item11, 50, shop);
        itemRepository.save(item11);
        shopLotRepository.save(shoplot11);
        
        /*Item item12 = new Item("normal", "/item_pictures/default.svg", "cheese", "cheese");
        ShopLot shoplot12 = new ShopLot(item12, 60, shop);
        itemRepository.save(item12);
        shopLotRepository.save(shoplot12);*/

        
        System.out.println("finished data init");

/*
        storage = storageRepository.findById(1L).get();
        refrigerator = refrigeratorRepository.findById(2L).get();
        refrigeratorSection1 = refrigeratorSectionRepository.findById(3L).get();
        refrigeratorSection2 = refrigeratorSectionRepository.findById(4L).get();
        item1 = itemRepository.findById(5L).get();
        item2 = itemRepository.findById(6L).get();
        item3 = itemRepository.findById(7L).get();        
        shopItem1 = itemRepository.findById(8L).get();
        shopItem2 = itemRepository.findById(9L).get();
        shopItem3 = itemRepository.findById(10L).get();
        shopLot1 = shopLotRepository.findById(12L).get();
        shopLot2 = shopLotRepository.findById(13L).get();
        shopLot3 = shopLotRepository.findById(14L).get();
        shop = shopRepository.findById(11L).get();
        
        
*/      


    }
}
