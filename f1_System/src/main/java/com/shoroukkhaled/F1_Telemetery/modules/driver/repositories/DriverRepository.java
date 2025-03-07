package com.shoroukkhaled.F1_Telemetery.modules.driver.repositories;

import com.shoroukkhaled.F1_Telemetery.modules.driver.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**JpaRepository extends CrudRepository with pagination
 * @Repository annotation is a specialization of the @Component annotation with similar use and functionality. plus exception handling
 * for jdbc errors
 * */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
