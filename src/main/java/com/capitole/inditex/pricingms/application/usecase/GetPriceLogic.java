package com.capitole.inditex.pricingms.application.usecase;

import com.capitole.inditex.pricingms.application.command.GetPriceCommand;
import com.capitole.inditex.pricingms.application.response.PriceResponse;

/**
 * Interface for the use case logic to retrieve price information.
 * This interface defines the contract for executing the price retrieval operation.
 */
public interface GetPriceLogic {

    /**
     * Executes the logic to retrieve the price based on the provided command.
     *
     * @param command the command containing the necessary parameters to get the price
     * @return a PriceResponse containing the price details
     */
    PriceResponse execute(GetPriceCommand command);
}
