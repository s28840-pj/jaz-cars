package com.rabulinski.cars.owner;

import com.rabulinski.cars.exception.BaseException;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class OwnerNotFoundException extends BaseException {
    public OwnerNotFoundException(@NonNull final UUID id) {
        super("Owner with id " + id + " not found");
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
