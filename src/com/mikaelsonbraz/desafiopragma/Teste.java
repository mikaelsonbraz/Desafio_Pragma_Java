package com.mikaelsonbraz.desafiopragma;


import java.util.List;
import java.util.Objects;

public class Teste {

    public static void main(String[] args) {

        String linha = " 21:51 ClientUserinfoChanged: 3 n\\Dono da Bola\\t\\0\\model\\sarge/krusade\\hmodel\\sarge/krusade\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0\n";
        List<String> lista = List.of(linha.split(" "));
        System.out.println(lista);
    }

}
