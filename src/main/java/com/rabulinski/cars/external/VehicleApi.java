package com.rabulinski.cars.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vpic", url = "https://vpic.nhtsa.dot.gov/api")
public interface VehicleApi {
    @GetMapping("/vehicles/GetModelsForMakeYear/make/{make}/modelyear/{modelyear}?format=csv")
    String getModelsForMakeYear(@PathVariable("make") String make, @PathVariable("modelyear") Integer modelyear);
}
