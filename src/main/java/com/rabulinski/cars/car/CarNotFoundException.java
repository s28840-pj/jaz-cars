package com.rabulinski.cars.car;

import com.rabulinski.cars.exception.BaseException;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class CarNotFoundException extends BaseException {
    public CarNotFoundException(@NonNull final UUID id) {
        super("Car with id " + id + " not found");
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
