package com.rabulinski.cars.car;

import com.rabulinski.cars.owner.Owner;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CarMapper {
    @NotNull
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "owner", source = "owner")
    @Mapping(target = "verified", constant = "false")
    Car toEntity(@NotNull @Valid CarCreateRequest request, @NotNull @Valid Owner owner);

    @NotNull
    @Mapping(target = "ownerName", expression = "java(car.getOwner().getName())")
    CarResponse toResponse(@NotNull @Valid Car car);

    @NotNull
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "verified", ignore = true)
    @Mapping(target = "owner", source = "owner")
    Car update(@MappingTarget Car car, @NotNull @Valid CarCreateRequest request, @NotNull @Valid Owner owner);
}
