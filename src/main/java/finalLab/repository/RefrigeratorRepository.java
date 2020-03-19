/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalLab.repository;

import finalLab.Class.Refrigerator;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author andrii
 */
public interface RefrigeratorRepository extends CrudRepository<Refrigerator, Long> {

}