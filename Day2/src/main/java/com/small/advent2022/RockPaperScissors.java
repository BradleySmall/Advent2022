package com.small.advent2022;

import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class RockPaperScissors  {
    // A = Rock        = X = 1
    // B = Paper       = y = 2
    // C = Scissors    = Z = 3
    // AY BZ CX - win
    // AZ BX CY - lose
    public Integer scoreOneRound(String round) {


        String play = "";
        String resp = "";
        for(String string : round.split(" ")) {
            if (play.equals("")) play = string;
            else resp = string;
        }
        log.info("Play:"+play+ " Resp:"+ resp);
        resp = convert(play, resp);
        log.info("Play:"+play+ " CV-Resp:"+ resp);

        int ocVal = 0;
        int playVal;
        if (resp.equals("X")) {
            playVal = 1;
        } else {
            if (resp.equals("Y")) playVal = 2;
            else playVal = 3;
        }
        log.info("Resp = "+resp + " PlayVal = " + playVal);

        ocVal = switch (play) {
            case "A" -> switch (resp) {
                case "Y" -> 6;
                case "X" -> 3;
                default -> ocVal;
            };
            case "B" -> switch (resp) {
                case "Z" -> 6;
                case "Y" -> 3;
                default -> ocVal;
            };
            case "C" -> switch (resp) {
                case "X" -> 6;
                case "Z" -> 3;
                default -> ocVal;
            };
            default -> throw new IllegalStateException("Unexpected value: " + play);
        };
        log.info("OocVal : " + ocVal + " Play : " + playVal + " Tot: " + (ocVal + playVal));
        return ocVal + playVal;
    }

    private String convert(String play, String resp) {
        if (resp.equals("X")) {
            return getLoser(play);
        } else if (resp.equals("Y")) {
            return getDraw(play);

        } else {
            return getWinner(play);
        }
    }

    private String getLoser(String play) {
        return switch (play) {
            case "A" -> "Z";
            case "B" -> "X";
            default -> "Y";
        };
    }

    private String getDraw(String play) {
        return switch (play) {
            case "A" -> "X";
            case "B" -> "Y";
            default -> "Z";
        };
    }

    private String getWinner(String play) {
        return switch (play) {
            case "A" -> "Y";
            case "B" -> "Z";
            default -> "X";
        };
    }

    public int scoreGame(List<String> strings) {
        return strings.stream()
                .map(this::scoreOneRound)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
