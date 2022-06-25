package com.mikaelsonbraz.desafiopragma.services;

import com.mikaelsonbraz.desafiopragma.models.Game;
import com.mikaelsonbraz.desafiopragma.models.Player;
import com.mikaelsonbraz.desafiopragma.models.Status;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Reader {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/com/mikaelsonbraz/desafiopragma/archives/teste.txt"));
        String linha;
        Reader reader = new Reader();

        while ((linha = br.readLine()) != null) {
            List<String> itensList = reader.parserList(linha);
            reader.organizer(itensList);
        }
        System.out.println(reader.gameList);

    }

    int gameId = 1;
    Game game;
    List<Game> gameList = new ArrayList<>();
    List<Player> playersList = new ArrayList<>();
    Status status = new Status(0, playersList);

    private Player findPlayerById(int id){
        for (Player player : playersList) {
            if (player.getId() == id){
                return player;
            }
        }
        return null;
    }

    private String findPlayerName(String nameSomewhere){
        return nameSomewhere.split("\\\\t")[0].substring(2);
    }

    private void setPlayerOldNames(Player player, String atualName){
        if (!Objects.equals(player.getName(), atualName)){
            if (!player.getOld_names().contains(player.getName())){
                player.getOld_names().add(player.getName());
            }
            player.setName(atualName);
        }
    }

    private void mathKills(int idKill, int idKilled){
        Player playerKill = findPlayerById(idKill);
        Player playerKilled = findPlayerById(idKilled);
        if (playerKill == null || Objects.equals(playerKill, playerKilled)){
            assert playerKilled != null;
            playerKilled.setKills(playerKilled.getKills() - 1);
            if (playerKilled.getKills() < 0){
                playerKilled.setKills(0);
            }
        } else {
            playerKill.setKills(playerKill.getKills() + 1);
        }
    }

    private List<String> parserList(String line){
        return List.of(line.split(" "));
    }

    private void organizer(List<String> list){
        if (Objects.equals(list.get(3), "InitGame:")){
            game = new Game();
            game.setId(gameId);
            gameId += 1;
        } else if (Objects.equals(list.get(3), "ClientUserinfoChanged:")){
            int playerId = Integer.parseInt(list.get(4));
            String playername = findPlayerName(list.get(5));
            if (findPlayerById(playerId) == null){
                playersList.add(new Player(playerId, playername, 0, new ArrayList<>()));
            } else {
                setPlayerOldNames(Objects.requireNonNull(findPlayerById(playerId)), playername);
            }
        } else if (Objects.equals(list.get(3), "Kill:")){
            status.setTotal_kills(status.getTotal_kills() + 1);
            int idKill = Integer.parseInt(list.get(4));
            int idKilled = Integer.parseInt(list.get(5));
            mathKills(idKill, idKilled);
        } else if (Objects.equals(list.get(3), "ShutdownGame:")){
            game.setStatus(status);
            gameList.add(game);
        }
    }

}
