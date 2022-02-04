package com.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    //TODO
    //Methods for rotors: adding rotors to total rotors list, removing rotors from list, check if list is filled.
    //Methods for reflectors: adding reflectors to reflectors list, removing reflectors from list, check if list is filled.

    //Methods for usedRotors: removing a rotor, inserting a new one, swapping two rotors (1: one out of use and one in use rotor, 2: two in use rotors), check if all rotors slots are filled
    //Methods for reflector: removing reflector, inserting a new one and swapping the current one with an unused one, check if reflector is filled
    //Methods for plugs: inserting plugs (one end at a time, give two characters and auto connect), removing plugs, swapping plugs (1: swapping two ports of in use plugs, 2: swapping an in use port to be used by an unused plug), check if both ends are connected, resetting all plugs 


public class Enigma {
    private List<Rotor> rotors;
    private List<Rotor> usedRotors;
    private List<Reflector> reflectors;
    private Reflector reflector;

    /**
     * This constructor will create random rotors and reflectors.
     * @param totalRotorCount the amount of rotors available to swap in and out for use in encryption
     * @param rotorCount the amount of rotors the enigma machine uses for encryption and decryption
     * @param reflectorCount the amount of reflectors available to swap in and out for use in encryption
    */
    public Enigma(int totalRotorCount, int rotorCount, int reflectorCount) {
        this.rotors = new ArrayList<Rotor>(Arrays.asList(new Rotor[totalRotorCount]));
        this.usedRotors = new ArrayList<Rotor>(Arrays.asList(new Rotor[rotorCount]));
        this.reflectors = new ArrayList<Reflector>(Arrays.asList(new Reflector[reflectorCount]));
        
        for (int i = 0; i < rotorCount; i++) {
            this.usedRotors.set(i, new Rotor());
        }
    }
    
    private void rotateRotor(int rotorNumber) {
        Rotor currentRotor = usedRotors.get(rotorNumber);
        if(currentRotor.getOnNotch()) {
            rotateRotor(rotorNumber + 1);
        } 
        currentRotor.rotateRotor();
    }

    public char encryptCharacter(char character) {
        Rotor currentRotor = null;
        for (int i = 0; i < usedRotors.size(); i++) {
            currentRotor = usedRotors.get(i);
            ValidCharacters validCharacter = ValidCharacters.getByChar(character);
            rotateRotor(0);
            character = currentRotor.getEncryptedCharacter(currentRotor.translateCharacterPosition(validCharacter));
        }
        return character;
    }
}