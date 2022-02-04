package com.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rotor extends Reflector {

    private int ringOffset = 0;
    private List<ValidCharacters> turnOverNotches;
    private boolean isOnNotch;


    /**
     * 
     * @param ringOffset The initial ring offset of the rotor. This automatically changes with every rotation
     * @param ringSetting This is essentially the same as the ring offset, however this can only be changed manually.
     * @param turnOverNotches Whenever a character within this list is hit, the next rotation will cause the next rotor in line, if there is one, to also rotate
     */
    public Rotor(int ringOffset, int ringSetting, List<ValidCharacters> turnOverNotches) {
        this.wiring = wireRotor();
        this.ringOffset = ringOffset;
        this.ringSetting = ringSetting;
        this.turnOverNotches = turnOverNotches;
    }
    

    public Rotor(List<ValidCharacters> turnOverNotches) {
        this(0, 0, turnOverNotches);
    }

    public Rotor() {
        this(new ArrayList<ValidCharacters>(){
            {
                add(ValidCharacters.values()[ValidCharacters.values().length - 1]);
            }
        });
    }

    public int getRingOffset() {
        return ringOffset;
    }

    public void setRingOffset(int ringOffset) {
        this.ringOffset = ringOffset % ValidCharacters.values().length;
    }

    public List<ValidCharacters> getTurnOverNotches() {
        return turnOverNotches;
    }

    public boolean getOnNotch() {
        return isOnNotch;
    }

    public void setOnNotch(boolean isOnNotch) {
        this.isOnNotch = isOnNotch;
    }

    public void rotateRotor() {
        if(turnOverNotches.contains(ValidCharacters.values()[(this.ringOffset + this.ringSetting) % ValidCharacters.values().length])) {
            setOnNotch(true);
        } else {
            setOnNotch(false);
        }
        this.setRingOffset(ringOffset + 1);
    }

    @Override
    public ValidCharacters translateCharacterPosition(ValidCharacters character) {
        return ValidCharacters.values()[(character.ordinal() + this.ringSetting + this.ringOffset) % ValidCharacters.values().length];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        final Rotor other = (Rotor)obj;

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
