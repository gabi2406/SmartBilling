package org.smartbilling.service;

import org.smartbilling.model.Province;
import org.springframework.stereotype.Service;
import org.smartbilling.repository.ProvinceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    public List<Province> getAllProvince(){
        return provinceRepository.findAll()
                .stream().map(
                        province -> new Province(province.getId(),province.getName()))
                .collect(Collectors.toList());
    }
}
