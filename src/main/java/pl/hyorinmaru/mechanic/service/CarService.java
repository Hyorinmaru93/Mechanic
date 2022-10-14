package pl.hyorinmaru.mechanic.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.mechanic.domain.Car;
import pl.hyorinmaru.mechanic.domain.User;
import pl.hyorinmaru.mechanic.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void create(Car car) {
        carRepository.save(car);
    }

    public Optional<Car> readById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> readAll() {
        return carRepository.findAll();
    }

    public List<Car> readByOwner(User owner){
      return carRepository.findCarByOwner(owner);
    };

    public void update(Car car) {
        carRepository.update(car.getBrand(), car.getModel(), car.getProductionDate(), car.getId());
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }
}
