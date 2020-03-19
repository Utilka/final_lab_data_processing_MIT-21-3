package finalLab;

import finalLab.Class.Item;
import finalLab.Class.RefrigeratorSection;
import finalLab.Class.Refrigerator;
import finalLab.Class.Shop;
import finalLab.Class.ShopLot;
import finalLab.Class.Storage;
import java.util.ArrayList;
import java.util.List;
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
     */
    @Override
    public void run(String... args) throws Exception {
        Item item1 = new Item("name 1");
        Item item2 = new Item("name 2");
        Item item3 = new Item("name 3");

//        itemRepository.save(item1);
//        itemRepository.save(item2);
//        itemRepository.save(item3);
//        item1 = itemRepository.findById(1L).get();
//        item2 = itemRepository.findById(2L).get();
//        item3 = itemRepository.findById(3L).get();

        RefrigeratorSection refrigeratorSection1 = new RefrigeratorSection("name 11");
        RefrigeratorSection refrigeratorSection2 = new RefrigeratorSection("name 12");

//        refrigeratorSection1.addItem(item1);
//        refrigeratorSection1.addItem(item2);
//        refrigeratorSection2.addItem(item3);

        item1.setInFrigeSection(refrigeratorSection1);
        item2.setInFrigeSection(refrigeratorSection1);
        item3.setInFrigeSection(refrigeratorSection2);

//        refrigeratorSectionRepository.save(refrigeratorSection1);
//        refrigeratorSectionRepository.save(refrigeratorSection2);
//
//        itemRepository.save(item1);
//        itemRepository.save(item2);
//        itemRepository.save(item3);

//        refrigeratorSection1 = refrigeratorSectionRepository.findById(4L).get();
//        refrigeratorSection2 = refrigeratorSectionRepository.findById(5L).get();

        Refrigerator refrigerator = new Refrigerator("name 21");

        List<RefrigeratorSection> sectionList = new ArrayList<RefrigeratorSection>();
        sectionList.add(refrigeratorSection1);
        sectionList.add(refrigeratorSection2);

        refrigerator.setSectionList(sectionList);

//        refrigeratorRepository.save(refrigerator);

//        refrigerator = refrigeratorRepository.findById(6L).get();

        Item shopItem1 = new Item("shop item name 31");
        Item shopItem2 = new Item("shop item name 32");
        Item shopItem3 = new Item("shop item name 33");

//        itemRepository.save(shopItem1);
//        itemRepository.save(shopItem2);
//        itemRepository.save(shopItem3);
//
//        shopItem1 = itemRepository.findById(7L).get();
//        shopItem2 = itemRepository.findById(8L).get();
//        shopItem3 = itemRepository.findById(9L).get();

        ShopLot shopLot1 = new ShopLot("name 41");
        ShopLot shopLot2 = new ShopLot("name 42");
        ShopLot shopLot3 = new ShopLot("name 43");

        shopLot1.setItem(shopItem1);
        shopLot2.setItem(shopItem2);
        shopLot3.setItem(shopItem3);

//        shopLotRepository.save(shopLot1);
//        shopLotRepository.save(shopLot2);
//        shopLotRepository.save(shopLot3);
//
//        shopLot1 = shopLotRepository.findById(10L).get();
//        shopLot2 = shopLotRepository.findById(11L).get();
//        shopLot3 = shopLotRepository.findById(12L).get();

        Shop shop = new Shop("name 51");

        shopLot1.setShop(shop);
        shopLot2.setShop(shop);
        shopLot3.setShop(shop);

//        shopRepository.save(shop);
        Storage storage = new Storage();
//        storageRepository.save(storage);

        System.out.println("finished data init");
        
        storageRepository.save(storage);
        refrigeratorRepository.save(refrigerator);
        refrigeratorSectionRepository.save(refrigeratorSection1);
        refrigeratorSectionRepository.save(refrigeratorSection2);
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(shopItem1);
        itemRepository.save(shopItem2);
        itemRepository.save(shopItem3);
        shopRepository.save(shop);
        shopLotRepository.save(shopLot1);
        shopLotRepository.save(shopLot2);
        shopLotRepository.save(shopLot3);
        
        System.out.println("finished db init");
        
        item1 = itemRepository.findById(4L).get();
        item2 = itemRepository.findById(5L).get();
        item3 = itemRepository.findById(7L).get();        
        refrigeratorSection1 = refrigeratorSectionRepository.findById(3L).get();
        refrigeratorSection2 = refrigeratorSectionRepository.findById(6L).get();
        refrigerator = refrigeratorRepository.findById(2L).get();
        shopItem1 = itemRepository.findById(8L).get();
        shopItem2 = itemRepository.findById(9L).get();
        shopItem3 = itemRepository.findById(10L).get();
        shopLot1 = shopLotRepository.findById(12L).get();
        shopLot2 = shopLotRepository.findById(13L).get();
        shopLot3 = shopLotRepository.findById(14L).get();
        shop = shopRepository.findById(11L).get();
        storage = storageRepository.findById(1L).get();
        
        
        System.out.println("get data");

    }
}
