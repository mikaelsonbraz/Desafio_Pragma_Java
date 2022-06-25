package com.mikaelsonbraz.desafiopragma;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/com/mikaelsonbraz/desafiopragma/archives/teste.txt"));

        String linha;

        while ((linha = br.readLine()) != null) {
            System.out.println(linha);
        }


        br.close();
    }
}
