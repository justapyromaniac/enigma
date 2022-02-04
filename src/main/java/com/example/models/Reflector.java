package com.example.models;

import java.util.Arrays;
import java.util.Collections;

public class Reflector {
    protected ValidCharacters[][] wiring;
    protected int ringSetting;

    /**
     * 
     * @param ringSetting This affects what the input character will be read as using a simple Caesar cypher: if ring setting is 1, A will be B, B will be C etc
     */
    public Reflector(int ringSetting) {
        this.wiring = wireRotor();
        this.ringSetting = ringSetting;
    }

    public Reflector() {
        this(0);
    }

    /**
     * 
     * @param wiring Set the internal wiring of the reflector manually, the first array corresponds to the input characters, the second array corresponds to what the input will be encrypted as
     * @param ringSetting This affects what the input character will be read as using a simple Caesar cypher: if ring setting is 1, A will be B, B will be C etc
     */
    public Reflector(ValidCharacters[][] wiring, int ringSetting) {
        this.wiring = wiring;
        this.ringSetting = ringSetting;
    }

    public ValidCharacters[][] getWiring() {
        return wiring;
    }

    public int getRingSetting() {
        return ringSetting;
    }

    public void setRingSetting(int ringSetting) {
        this.ringSetting = ringSetting % ValidCharacters.values().length;
    }

    protected ValidCharacters[][] wireRotor() {
        ValidCharacters[][] output = new ValidCharacters[2][ValidCharacters.values().length];
        output[0] = ValidCharacters.values();
        var temp = Arrays.asList(output[0].clone());
        Collections.shuffle(temp);
        output[1] = temp.toArray(output[1]);
        return output;
    }

    public ValidCharacters translateCharacterPosition(ValidCharacters character) {
        return ValidCharacters.values()[(character.ordinal() + this.ringSetting) % ValidCharacters.values().length];
    }

    public char getEncryptedCharacter(ValidCharacters character) {
        return this.wiring[1][character.ordinal()].getCharacter();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        final Reflector other = (Reflector)obj;

        if(this.wiring.length != other.wiring.length) return false;


        return Arrays.deepEquals(this.wiring, other.wiring);
    }

    @Override
    public int hashCode() {
        final int prime = 19;
        int result = 73;
        for (ValidCharacters[] validCharacters : wiring) {
            for(ValidCharacters character : validCharacters) {
                result = prime * result + character.hashCode();
            }
        }
        return super.hashCode();
    }

    @Override
    public String toString() {
        return Arrays.toString(wiring[0]) + "\n" + Arrays.toString(wiring[1]);
    }
}
