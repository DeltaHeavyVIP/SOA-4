package com.example.additional.utils;

import com.example.additional.exception.InvalidInputDataException;

public class Validator {

    public static void decreasePercentIsValid(Integer decreasePercent) {
        if (decreasePercent <= 0 || decreasePercent > 100) {
            throw new InvalidInputDataException("Validation Failed");
        }
    }

}
