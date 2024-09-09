package com.example.ddd.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money add(Money other){

        if(!this.currency.equals(other.currency)){
            throw new IllegalArgumentException("Connot add money in different currencies");
        }
        return new Money(this.amount.add(other.amount), this.currency);
    }




}
