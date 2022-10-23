package presentation;

import players.Simulation;
import players.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Show implements Simulation {
    public String title(String title){
        return "=-=-=-=- " + title + " -=-=-=-=";
    }

    public String goalkeepersMean(Team team){
        String goalkeepersMean = "";
        HashMap<String, Float> defenseMean = team.defenseMean();

        for(Map.Entry<String, Float> mean: defenseMean.entrySet()){
            goalkeepersMean = goalkeepersMean.concat(String.format(
                    "%-20s: %.3f%%\n",
                    mean.getKey(),
                    mean.getValue()
            ));
        }

        return goalkeepersMean;
    }


    public ArrayList<String> getStrikerIds() {
        ArrayList<String> names     = new ArrayList<>();
        String[]          namesDB   = {
                "Danilo Cirqueira Domingos", "Ryan Rodrigues", "João Carlos de Sousa Irene", "Lucicarlos Fernandes",
                "Felipe Gustavo Pinheiro Pereira", "Francisco Savio Gomes da Silva", "Lucas Florencio Manso",
                "Marcus Vinicius Lino Gasparotti", "Aricrys de Oliveira Silva", "Franscisco Wesley Rodrigues de Sousa",
                "Rivaldo Soares Paulo", "José Jefferson Rodrigues de Oliveira", "Luvannor Henrique de Sousa Silva",
                "Jajá", "Bruno Rodrigues", "Rafael Cabral Barbosa", "Lincoln Corrêa dos Santos", "David Wesley",
                "Daniel de Melo Araújo Junior", "Breno Teixeira", "Rafael da Silva", "Rômulo Souza Orestes Caldeira",
                "Chay", "Pablo Siles", "Marquinhos Cipriano", "Leonardo Pais", "Stênio", "Pedro Castro", "Machado",
                "Geovane de Jesus Rocha", "Wagner Leonardo", "Ivaldo", "Willian", "Eduardo Ageu Almeida Santos",
                "Weverton", "Eduardo Brock", "Matheus Bidu", "Fernando Canesin", "Wagner da Silva Souza", "Oliveira",
                "Kaiki Bruno da Silva", "Rodolfo", "João Paulo", "Jhosefer Raphael Januário", "Juan Coelho",
                "Luis Felipe", "Pedro Henrique Franklim Martins", "Matheus Xavier de Freitas Franco", "Edu",
                "Ruan Matheus Rodrigues Santos", "Pedro", "Rodinei Marcelo De Almeida", "Gabriel Barbosa",
                "Arturo Vidal", "Giorgian De Arrascaeta", "Everton Cebolinha", "Bruno Henrique", "Éverton Ribeiro",
                "Diego Ribas", "David Luiz", "Filipe Luís", "Rodrigo Caio", "Erick Pulgar", "João Gomes", "Léo Pereira",
                "Mário Sérgio Santos Costa", "Thiago Maia", "Hugo Souza", "Guillermo Varela", "Pablo Castro", "Goku",
                "Avatar Aang", "Naruto", "Katara", "Sokka", "Luan Santana", "Luiz Inácio Lula da Silva", "Daniel-san",
                "Jair Messias Bolsonaro", "Fábio Júnior", "Felipe Neto", "Giorno Giovanna", "Joseph Joestar", "Pucci",
                "Jean Pierre Polnareff", "Jotaro Joestar", "Dio Brando", "Jonathan Joestar", "Josuke Joestar", "Doppio",
                "Yoshikage Kira", "Kishibe Rohan", "Seu Zé", "Jolyne Joestar", "Robert Speedwagon", "Koichi Hirose",
                "Okuyasu Nijimura", "Tonio Trussardi"

        };
        Collections.addAll(names, namesDB);

        return names;

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
