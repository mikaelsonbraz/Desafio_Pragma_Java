package com.mikaelsonbraz.desafiopragma;


import java.util.List;

public class Teste {

    public static void main(String[] args) {

        String linha = " 25:52 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT";
        List<String> palavras = List.of(linha.split(" "));


        System.out.println(palavras);
    }
}
