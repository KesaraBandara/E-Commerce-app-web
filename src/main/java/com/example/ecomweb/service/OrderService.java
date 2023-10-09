package com.example.ecomweb.service;

import com.example.ecomweb.dto.checkout.CheckoutItemDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Value("${BASE_URL}")
    private String baseURL;

    @Value("${STRIPE_SECRET_KEY}")
    private String apiKey;
    public Session createSession(List<CheckoutItemDTO> checkoutItemDTOList) throws StripeException {

        String successURL = baseURL + "payment/success";

        String failedURL = baseURL + "payment/failed";
        Stripe.apiKey = apiKey;

        List<SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();

        for(CheckoutItemDTO checkoutItemDTO: checkoutItemDTOList){
            sessionItemList.add(createSessionLineItem(checkoutItemDTO));
        }
        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setCancelUrl(failedURL)
                .setSuccessUrl(successURL)
                .addAllLineItem(sessionItemList)
                .build();
        return Session.create(params);
    }
    private SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDTO checkoutItemDto){
        return SessionCreateParams.LineItem.builder()
                .setPriceData(createPriceData(checkoutItemDto))
                .setQuantity(Long.parseLong(String.valueOf(checkoutItemDto.getQuantity())))
                .build();
    }
    private SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDTO checkoutItemDto){
        return SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("usd")
                .setUnitAmount((long)(checkoutItemDto.getPrice()*100))
                .setProductData(
                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                .setName(checkoutItemDto.getProductName())
                                .build())
                .build();
    }
}
