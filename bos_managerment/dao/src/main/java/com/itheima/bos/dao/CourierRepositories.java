package com.itheima.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.itheima.bos.domain.base.Courier;

/**  
 * ClassName:CourierRepositories <br/>  
 * Function:  <br/>  
 * Date:     Nov 29, 2017 10:00:22 PM <br/>       
 */
public interface CourierRepositories extends JpaRepository<Courier, Long>,JpaSpecificationExecutor<Courier> {
   
    @Modifying
    @Query("update Courier set deltag=1 where id=?")
    void updateState(Long id);

    
    @Query("from Courier where deltag is null")
     List<Courier> findCourierNotDel();
}
  
