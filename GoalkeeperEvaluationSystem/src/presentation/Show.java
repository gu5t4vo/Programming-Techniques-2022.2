package presentation;

import players.Simulation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Show implements Simulation {
    public String title(String title){
        return "=-=-=-=- " + title + " -=-=-=-=";
    }

    public void goalkeepersMean(HashMap<String, Double> defenseMean){

        for(Map.Entry<String, Double> mean: defenseMean.entrySet()){
            System.out.printf(
                    "Defenses mean: %-20s: %.2f%%\n",
                    mean.getKey(),
                    mean.getValue() * 100.0
            );
        }

    }

    public void goalkeepersMisses(HashMap<String, Double> missesMean){

        for(Map.Entry<String, Double> mean: missesMean.entrySet()){
            System.out.printf(
                    "Misses mean: %-20s: %.2f%%\n",
                    mean.getKey(),
                    mean.getValue() * 100.0
            );
        }

    }

    @Override
    public ArrayList<String> getGoalkeeperNames() {
        ArrayList<String>   goalkeepers = new ArrayList<>();
        String[]            namesDB     = {
                "Pratik Skaggs" , "Uehudah Hack"    , "Edison Drye"     , "Ajani Harding"   , "Orazio Hart"     ,
                "Tristan Karns" , "Niven Glaser"    , "Derwyn Devers"   , "Tod Phan"        , "Eddie Hulse"     ,
                "Welford Yepez" , "Rishley Snyder"  , "Milo Mccurdy"    , "Carden Justus"   , "Carlyon Gorby"   ,
                "Mungo Spangler", "Whitmore Squires", "Ridgley Leo"     , "Pedrog Mccurdy"  , "Bolton Tarin"    ,
                "Edison Loy"    , "Delling Herndon" , "Senichi Iorio"   , "Albin Kerner"    , "Jivin Justus"    ,
                "Clement Fleisher"
        };

        Collections.addAll(goalkeepers, namesDB);

        return goalkeepers;
    }

    @Override
    public ArrayList<String> getTeamNames() {
        ArrayList<String> teamNames = new ArrayList<>();

        String[] namesDB = {
                "Flamengo"  , "Fluminense"  , "Cruzeiro"    , "Real Madrid"         , "Barcelona"       ,
                "Inter"     , "Corinthians" , "Palmeiras"   , "Grêmio"              , "Vasco da Gama"   ,
                "Bahia"     , "Santos"      , "PSG"         , "Guarany de Sobral"   , "Ceará"           ,
                "Botafogo"  , "Bragantino"  , "Avaí"        , "Juventude"           , "Athletico-PR"    ,
                "São Paulo" , "Fortaleza"   , "Londrina"    , "Ponte Preta"         , "Chapecoense"
        };

        Collections.addAll(teamNames, namesDB);

        return teamNames;
    }


}
