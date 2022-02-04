package com.example.models;

import java.util.Arrays;

public class LoopedReflector extends Reflector {

    @Override
    protected ValidCharacters[][] wireRotor() {
        ValidCharacters[][] output = new ValidCharacters[2][ValidCharacters.values().length];
        output[0] = ValidCharacters.values();
        int characterOne = 0;
        boolean characterOneIsNotNew;
        boolean characterOneIsFilled;
        boolean characterOneNeedsNewValue; 

        int characterTwo = 0;
        boolean characterTwoIsNotNew;
        boolean characterTwoIsFilled;
        boolean characterTwoNeedsNewValue;
        
        //the boolean function in the while could use a little refining
        //in essence we need to make sure no double characters get put in, no character that's been written on gets overwritten because that breaks a loop, and no character gets paired with itself YET
        
        //in an uneven array, there will be 1 character with a null value. 
        //When all other values are assigned, grab the index of the null value and set it with the character of that index of the first array.
        for (int i = 0; i < output[0].length / 2; i++) {
            do {
                characterOne = (int)Math.floor(Math.random() * (((output[0].length - 1) - 0 + 1) + 0));
                characterOneIsNotNew = Arrays.asList(output[1]).contains(output[0][characterOne]);
                characterOneIsFilled = output[1][characterOne] != null;
                characterOneNeedsNewValue = characterOneIsNotNew || characterOneIsFilled; 

                characterTwo = (int)Math.floor(Math.random() * (((output[0].length - 1) - 0 + 1) + 0));
                characterTwoIsNotNew = Arrays.asList(output[1]).contains(output[0][characterTwo]);
                characterTwoIsFilled = output[1][characterTwo] != null;
                characterTwoNeedsNewValue = characterTwoIsNotNew || characterTwoIsFilled; 

            } while(characterOneNeedsNewValue || characterTwoNeedsNewValue || characterOne == characterTwo);

            output[1][characterTwo] = output[0][characterOne];
            output[1][characterOne] = output[0][characterTwo];
        }
        System.out.println(Arrays.toString(output));
        return output;
    }
}
