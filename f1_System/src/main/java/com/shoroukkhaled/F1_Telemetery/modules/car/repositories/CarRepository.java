package com.shoroukkhaled.F1_Telemetery.modules.car.repositories;

import com.shoroukkhaled.F1_Telemetery.modules.car.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**JpaRepository extends CrudRepository with pagination
 * @Repository annotation is a specialization of the @Component annotation with similar use and functionality. plus exception handling
 * for jdbc errors
 * */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
