package com.example.models;

import java.util.Arrays;

public enum ValidCharacters {
    A('a'),
    B('b'),
    C('c'),
    D('d'),
    E('e'),
    F('f'),
    G('g'),
    H('h'),
    I('i'),
    J('j'),
    K('k'),
    L('l'),
    M('m'),
    N('n'),
    O('o'),
    P('p'),
    Q('q'),
    R('r'),
    S('s'),
    T('t'),
    U('u'),
    V('v'),
    W('w'),
    X('x'),
    Y('y'),
    Z('z');
    

    private char character;

    private ValidCharacters(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public static ValidCharacters getByChar(char character) {
        return Arrays.asList(ValidCharacters.values()).stream().filter(x -> x.getCharacter() == character).findFirst().get();
    }
}
