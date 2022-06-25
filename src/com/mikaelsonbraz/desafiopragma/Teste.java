package com.mikaelsonbraz.desafiopragma;


import java.util.List;
import java.util.Objects;

public class Teste {

    public static void main(String[] args) {

        String InitGame = "  0:00 InitGame: \\sv_floodProtect\\1\\sv_maxPing\\0\\sv_minPing\\0\\sv_maxRate\\10000\\sv_minRate\\0\\sv_hostname\\Code Miner Server\\g_gametype\\0\\sv_privateClients\\2\\sv_maxclients\\16\\sv_allowDownload\\0\\dmflags\\0\\fraglimit\\20\\timelimit\\15\\g_maxGameClients\\0\\capturelimit\\8\\version\\ioq3 1.36 linux-x86_64 Apr 12 2009\\protocol\\68\\mapname\\q3dm17\\gamename\\baseq3\\g_needpass\\0\n";
        String ClientUserInfo = " 12:14 ClientUserinfoChanged: 5 n\\Assasinu Credi\\t\\0\\model\\sarge\\hmodel\\sarge\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0";
        String Kill = "  9:53 Kill: 3 5 7: Isgalamido killed Assasinu Credi by MOD_ROCKET_SPLASH";
        String ShutDownGame = " 12:13 ShutdownGame:";
        List<String> listaInitGame = List.of(InitGame.strip().split(" "));
        List<String> listaClientUserInfo = List.of(ClientUserInfo.strip().split(" "));
        List<String> listaKill = List.of(Kill.strip().split(" "));
        List<String> listaShutDownGame = List.of(ShutDownGame.strip().split(" "));
        String listPlayer = ClientUserInfo.strip().split(" n\\\\")[1].split("\\\\t")[0];
        System.out.println(listaInitGame);
        System.out.println(listaClientUserInfo);
        System.out.println(listPlayer);
        System.out.println(listaKill);
        System.out.println(listaShutDownGame);
    }

}
