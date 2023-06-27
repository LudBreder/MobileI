package com.example.annalyn;

public class Functions {

    // Espia o grupo para saber qual deles está acordado.
    public static boolean checkSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        if (knightIsAwake == true || archerIsAwake == true || prisonerIsAwake == true) {
            return true;
        } else {
            return false;
        }
    }

    // Assobiar para o prisioneiro.
    public static boolean checkSignalPrisoner(boolean knightIsAwake, boolean prisonerIsAwake) {
        if (knightIsAwake == true && prisonerIsAwake == false) {
            return true;
        } else {
            return false;
        }
    }

    // Verifica se o cavaleiro esta dormindo.
    public static boolean actionAttack(boolean knightIsAwake) {
        if (knightIsAwake == false) {
            return true;
        } else {
            return false;
        }
    }

    // Acão de libertar o prosioneiro.
    public static boolean actionFreePrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        if (archerIsAwake == false && prisonerIsAwake == true) {
            return true;
        } else {
            return false;
        }
    }
}
