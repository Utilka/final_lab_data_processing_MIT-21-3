/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.repository;

import finalLab.Class.RefrigeratorSection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author andrii
 */
public interface RefrigeratorSectionRepository extends CrudRepository<RefrigeratorSection, Long> {

    Iterable<RefrigeratorSection> findByName(String name);
    
}