package com.mikaelsonbraz.desafiopragma.services;

import com.mikaelsonbraz.desafiopragma.models.Game;
import com.mikaelsonbraz.desafiopragma.models.Player;
import com.mikaelsonbraz.desafiopragma.models.Status;
import com.mikaelsonbraz.desafiopragma.org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {

    public static void main(String[] args) throws IOException {

        List<String> jsonList = new ArrayList<>();

        FileWriter fileWriter = null;

        BufferedReader br = new BufferedReader(new FileReader("src/com/mikaelsonbraz/desafiopragma/archives/Quake.txt"));
        String linha;
        Reader reader = new Reader();

        while ((linha = br.readLine()) != null) {
            reader.organizer(linha);
        }

        for (Game game : reader.gameList){
            JSONObject jsonObject = new JSONObject(game);
            jsonList.add(jsonObject.toString(4));
        }

        try{
            fileWriter = new FileWriter("src/com/mikaelsonbraz/desafiopragma/archives/saida.json");
            fileWriter.write(jsonList.toString());
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

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
        return nameSomewhere.split("\\\\t")[0];
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


    private void organizer(String line){
        List<String> list = List.of(line.strip().split(" "));
        if (Objects.equals(list.get(1), "InitGame:")){
            game = new Game();
            game.setId(gameId);
            gameId += 1;
        } else if (Objects.equals(list.get(1), "ClientUserinfoChanged:")){
            int playerId = Integer.parseInt(list.get(2));
            String playername = findPlayerName(line.strip().split(" n\\\\")[1]);
            if (findPlayerById(playerId) == null){
                playersList.add(new Player(playerId, playername, 0, new ArrayList<>()));
            } else {
                setPlayerOldNames(Objects.requireNonNull(findPlayerById(playerId)), playername);
            }
        } else if (Objects.equals(list.get(1), "Kill:")){
            status.setTotal_kills(status.getTotal_kills() + 1);
            int idKill = Integer.parseInt(list.get(2));
            int idKilled = Integer.parseInt(list.get(3));
            mathKills(idKill, idKilled);
        } else if (Objects.equals(list.get(1), "ShutdownGame:")){
            game.setStatus(status);
            gameList.add(game);
            playersList = new ArrayList<>();
            status = new Status(0, playersList);
        }
    }
}
