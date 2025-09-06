package service;

import java.util.List;
import java.util.stream.Collectors;
import repository.ProvinceRepository;
import org.smartbilling.model.Province;
import org.springframework.stereotype.Service;

@Service
 /* @Service used to mark a class as a service layer component.
 Key points:
 Indicates that the class holds business logic.
 Makes the class detectable by Spring’s component scanning so it can be injected with @Autowired.
 Semantically separates the service layer from controllers and repositories.
 */

public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    public List<Province> getAllProvince(){
        return provinceRepository.findAll()
                .stream().map(
                        province -> new Province(province.getId(), province.getName()))
                .collect(Collectors.toList());
    }

    public Province getProvinceById(Long id){
        Province province = provinceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Province not found"));
        return new Province(province.getId(), province.getName());
    }
}
