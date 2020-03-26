/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.UI;

import finalLab.Class.Item;
import finalLab.Class.Refrigerator;
import finalLab.Class.RefrigeratorSection;
import finalLab.Class.Shop;
import finalLab.Class.ShopLot;
import finalLab.repository.ItemRepository;
import finalLab.repository.RefrigeratorRepository;
import finalLab.repository.RefrigeratorSectionRepository;
import finalLab.repository.ShopLotRepository;
import finalLab.repository.ShopRepository;
import finalLab.repository.StorageRepository;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author andrii
 */
@Controller
public class appUIController {

    private final ItemRepository itemRepository;

    private final RefrigeratorRepository refrigeratorRepository;

    private final RefrigeratorSectionRepository refrigeratorSectionRepository;

    private final ShopLotRepository shopLotRepository;

    private final ShopRepository shopRepository;

    private final StorageRepository storageRepository;

    @Autowired
    public appUIController(
            ItemRepository itemRepository,
            RefrigeratorRepository refrigeratorRepository,
            RefrigeratorSectionRepository refrigeratorSectionRepository,
            ShopLotRepository shopLotRepository,
            ShopRepository shopRepository,
            StorageRepository storageRepository) {
        this.itemRepository = itemRepository;
        this.refrigeratorRepository = refrigeratorRepository;
        this.refrigeratorSectionRepository = refrigeratorSectionRepository;
        this.shopLotRepository = shopLotRepository;
        this.shopRepository = shopRepository;
        this.storageRepository = storageRepository;

    }

    public void buyItem(ShopLot shopLot, RefrigeratorSection refrigeratorSection) {
        Item item = shopLot.getCopyOfItem();
        item.setInFrigeSection(refrigeratorSection);
        itemRepository.save(item);
        
    }
    
    public void generateStartItems() {
        Iterable<ShopLot> shopLots = shopLotRepository.findAll();
        shopLots.forEach(shopLot -> {
            Iterable<RefrigeratorSection> refs = refrigeratorSectionRepository.findByName("Main-s-1");
            RefrigeratorSection ref = refs.iterator().next();
            buyItem(shopLot, ref);
        });
        
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showStartingPage(@RequestParam(name = "type", required = false, defaultValue = "default") String type, Model model) { //@RequestParam(name="type", required=false, defaultValue="default") String name,
//        Iterable<Item> contents = itemRepository.findAll();
//        model.addAttribute("items", contents);
        Iterable<Refrigerator> refrigerators = refrigeratorRepository.findAll();
        Refrigerator refrigerator = refrigerators.iterator().next();

        model.addAttribute("refrigerator", refrigerator);
        
        generateStartItems();
//        Iterable<RefrigeratorSection> sections = refrigeratorSectionRepository.findAll();
//        model.addAttribute("sections", sections);
        if (refrigerator.getSkin().equals("default")) {
            System.out.println("IF OK");
            Iterable<RefrigeratorSection> Main_s_1_s = refrigeratorSectionRepository.findByName("Main-s-1");
            RefrigeratorSection Main_s_1 = Main_s_1_s.iterator().next();
            Iterable<RefrigeratorSection> Main_s_2_s = refrigeratorSectionRepository.findByName("Main-s-2");
            RefrigeratorSection Main_s_2 = Main_s_2_s.iterator().next();
            Iterable<RefrigeratorSection> Main_s_3_s = refrigeratorSectionRepository.findByName("Main-s-3");
            RefrigeratorSection Main_s_3 = Main_s_3_s.iterator().next();
            Iterable<RefrigeratorSection> Main_s_4_s = refrigeratorSectionRepository.findByName("Main-s-4");
            RefrigeratorSection Main_s_4 = Main_s_4_s.iterator().next();
            Iterable<RefrigeratorSection> Main_d_s = refrigeratorSectionRepository.findByName("Main-d");
            RefrigeratorSection Main_d = Main_d_s.iterator().next();
            Iterable<RefrigeratorSection> Freezer_s_1_s = refrigeratorSectionRepository.findByName("Freezer-s-1");
            RefrigeratorSection Freezer_s_1 = Freezer_s_1_s.iterator().next();
            Iterable<RefrigeratorSection> Freezer_s_2_s = refrigeratorSectionRepository.findByName("Freezer-s-2");
            RefrigeratorSection Freezer_s_2 = Freezer_s_2_s.iterator().next();
            Iterable<RefrigeratorSection> Freezer_s_3_s = refrigeratorSectionRepository.findByName("Freezer-s-3");
            RefrigeratorSection Freezer_s_3 = Freezer_s_3_s.iterator().next();
            Iterable<RefrigeratorSection> Freezer_d_s = refrigeratorSectionRepository.findByName("Freezer-d");
            RefrigeratorSection Freezer_d = Freezer_d_s.iterator().next();
            model.addAttribute("Main_s_1", Main_s_1);
            model.addAttribute("Main_s_2", Main_s_2);
            model.addAttribute("Main_s_3", Main_s_3);
            model.addAttribute("Main_s_4", Main_s_4);
            model.addAttribute("Main_d", Main_d);
            model.addAttribute("Freezer_s_1", Freezer_s_1);
            model.addAttribute("Freezer_s_2", Freezer_s_2);
            model.addAttribute("Freezer_s_3", Freezer_s_3);
            model.addAttribute("Freezer_d", Freezer_d);
        }
        
        
        return "index";
    }
    @RequestMapping(value = "/shop/", method = RequestMethod.GET)
    public String showShopPage(@RequestParam(name = "type", required = false, defaultValue = "default") String type, Model model) {
        
        Iterable<Refrigerator> refrigerators = refrigeratorRepository.findAll();
        Refrigerator refrigerator = refrigerators.iterator().next();
        
        model.addAttribute("refrigerator", refrigerator);
        
        Iterable<Shop> shops = shopRepository.findAll();
        Shop shop = shops.iterator().next();
        
        model.addAttribute("shop", shop);
        
        
        
        return "shop";
    }
    /*@RequestMapping(value = "/", method = RequestMethod.POST)
    public String changeRef(@Valid ,
            BindingResult result, Model model) {
        {
            if (result.hasErrors()) {
                return "redirect:/";
            }
            Iterable<Refrigerator> refrigerators = refrigeratorRepository.findAll();
            Refrigerator refrigerator = refrigerators.iterator().next();
            refrigerator.setSkin("new");
            refrigeratorRepository.save(refrigerator);
            return "redirect:/persons";
        }
    }*/

//    @RequestMapping(value = "/persons", method = RequestMethod.GET)
//    public String showPersonsPage(Person person, Model model) {
//        model.addAttribute("persons", personRepository.findAll());
//        return "persons";
//    }
//
//    @RequestMapping(value = "/houses", method = RequestMethod.GET)
//    public String showHousesPage(House house, Model model) {
//        model.addAttribute("houses", houseRepository.findAll());
//        return "houses";
//    }
//
//    @RequestMapping(value = "/dogs", method = RequestMethod.GET)
//    public String showDogsPage(Dog dog, Model model) {
//        model.addAttribute("dogs", dogRepository.findAll());
//        return "dogs";
//    }
//
//    @RequestMapping(value = "/persons", method = RequestMethod.POST)
//    public String addPerson(@Valid Person new_person,
//            BindingResult result, Model model) {
//        {
//            if (result.hasErrors()) {
//                return "redirect:/persons";
//            }
//            personRepository.save(new_person);
//            return "redirect:/persons";
//        }
//    }
//
//    @RequestMapping(value = "/houses", method = RequestMethod.POST)
//    public String addHouse(@RequestParam("ownerId") String ownerId,
//            @Valid House new_house,
//            BindingResult result, Model model) {
//        {
//            Person owner = personRepository.findById(Long.parseLong(ownerId));
//            
//            if (result.hasErrors() || owner==null) {
//                return "redirect:/houses";
//            }
//            new_house.setOwner(owner);
//            houseRepository.save(new_house);
//            return "redirect:/houses";
//        }
//    }
//
//    @RequestMapping(value = "/dogs", method = RequestMethod.POST)
//    public String addDog(
//            @RequestParam("ownerId") String ownerId,
//            @Valid Dog new_dog, BindingResult result, Model model) {
//        Person owner = personRepository.findById(Long.parseLong(ownerId));
//        if (result.hasErrors() || owner==null) {
//            return "redirect:/dogs";
//        }
//        new_dog.setOwner(owner);
//        dogRepository.save(new_dog);
//        return "redirect:/dogs";
//    }
//
//    @RequestMapping(value = "/editPerson/{id}", method = RequestMethod.GET)
//    public String showPersonsEditPage(@PathVariable("id") long id, Model model) {
//
//        model.addAttribute("person", personRepository.findById(id));
//        return "editPerson";
//    }
//
//    @RequestMapping(value = "/editHouse/{id}", method = RequestMethod.GET)
//    public String showHousesEditPage(@PathVariable("id") long id, Model model) {
//        House house = houseRepository.findById(id);
//        model.addAttribute("house", house);
////        model.addAttribute("ownerId", house.getOwner().getId());
//        return "editHouse";
//    }
//
//    @RequestMapping(value = "/editDog/{id}", method = RequestMethod.GET)
//    public String showDogsEditPage(@PathVariable("id") long id, Model model) {
//        Dog dog = dogRepository.findById(id);
//        model.addAttribute("dog", dog);
////        model.addAttribute("ownerId", dog.getOwner().getId());
//        return "editDog";
//    }
//
//    @RequestMapping(value = "/editPerson/{id}", method = RequestMethod.POST)
//    public String editPerson(@PathVariable("id") long id, @Valid Person upd_person, BindingResult result, Model model) {
//        if (result.hasErrors()) {
////            model.addAttribute("person", personRepository.findById(id));
//            return String.format("redirect:/editPerson/%s", id);
//        }
//        Person person = personRepository.findById(id);
//        person.setCharacterName(upd_person.getCharacterName());
//        personRepository.save(person);
//        return "redirect:/persons";
//    }
//
//    @RequestMapping(value = "/editHouse/{id}", method = RequestMethod.POST)
//    public String editHouse(@PathVariable("id") long id,
//            @RequestParam("ownerId") String ownerId,
//            @Valid House upd_house, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return String.format("redirect:/editHouse/%s", id);
//        }
//        House house = houseRepository.findById(id);
//        Person owner = personRepository.findById(Long.parseLong(ownerId));
//        house.setCharacterName(upd_house.getCharacterName());
//        house.setOwner(owner);
//        house.setDoorOpened(upd_house.isDoorOpened());
//        houseRepository.save(house);
//        return "redirect:/houses";
//    }
//
//    @RequestMapping(value = "/editDog/{id}", method = RequestMethod.POST)
//    public String editDog(@PathVariable("id") long id,
//            @RequestParam("ownerId") String ownerId,
//            @Valid House upd_house, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return String.format("redirect:/editDog/%s", id);
//        }
//        Dog dog = dogRepository.findById(id);
//        Person owner = personRepository.findById(Long.parseLong(ownerId));
//        dog.setCharacterName(upd_house.getCharacterName());
//        dog.setOwner(owner);
//        dogRepository.save(dog);
//        return "redirect:/dogs";
//    }
//    @RequestMapping(value = "/addhouse")
//    public String addUser(@Valid House house, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-house";
//        }
//
//        houseRepository.save(house);
//        model.addAttribute("houses", houseRepository.findAll());
//        return "redirect:finalPage";
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") int id, Model model) {
//        Optional<House> house = houseRepository.findById(id);
//                //.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        houseRepository.delete(house.get());
//        model.addAttribute("houses", houseRepository.findAll());
//        return "index";
//    }
}
