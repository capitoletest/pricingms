package com.capitole.inditex.pricingms.infrastructure.mapper;

import com.capitole.inditex.pricingms.domain.model.Price;
import com.capitole.inditex.pricingms.infrastructure.entitty.PriceEntity;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Price domain model and PriceEntity.
 * Uses MapStruct for automatic mapping generation.
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * Converts a PriceEntity to a Price domain model.
     *
     * @param entity the PriceEntity to convert
     * @return the converted Price domain model
     */
    Price toDomain(PriceEntity entity);

    /**
     * Converts a Price domain model to a PriceEntity.
     *
     * @param domain the Price domain model to convert
     * @return the converted PriceEntity
     */
    PriceEntity toEntity(Price domain);
}
