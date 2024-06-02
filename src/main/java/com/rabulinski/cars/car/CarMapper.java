package com.rabulinski.cars.car;

import com.rabulinski.cars.owner.Owner;
import lombok.NonNull;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CarMapper {
    @NonNull
    Car toEntity(@NonNull CarCreateRequest request, @NonNull Owner owner);

    @NonNull
    CarResponse toResponse(@NonNull Car car);

    @NonNull
    Car update(@MappingTarget Car car, @NonNull CarCreateRequest request, @NonNull Owner owner);
}
