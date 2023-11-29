package com.example.calculator.model;

public class CalculatorModel {
    public static float calculate(float fistOperand, float secondOperand, char operator){
    switch (operator){
        case '+':
            return fistOperand + secondOperand;
        case '-':
            return fistOperand - secondOperand;
        case '*':
            return fistOperand * secondOperand;
        case '/':
            if(secondOperand != 0){
                return fistOperand / secondOperand;
            }else {
                throw new RuntimeException("Can't divide by zero");
            }
        default:
            throw new RuntimeException("Invalid operation");
    }   
    }
}
