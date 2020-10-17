package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInfo {

    Team teams = new Team();
    Match matches = new Match();

    public ParseInfo(Team teams, Match matches) throws IOException {

        this.teams = teams;
        this.matches = matches;

        // PARSING //

        BufferedReader in = new BufferedReader(new InputStreamReader((new URL("https://plk.pl/terminarz-i-wyniki.html").openStream())));

        AtomicInteger matchCount = new AtomicInteger();

        in.lines().forEach(line -> {
                    String html = line;
                    Pattern match = Pattern.compile(".*Mecz koszykówki męskiej TBL.*");
                    Pattern date = Pattern.compile(".*div.*\\d{2}.\\d{2}.\\d{4}");
                    Pattern result = Pattern.compile("([1-9]\\d{2,}|[5-9]\\d):([1-9]\\d{2,}|[5-9]\\d)");
                    Matcher m = match.matcher(html);
                    Matcher d = date.matcher(html);
                    Matcher r = result.matcher(html);

                    while (m.find()) {
                        String[] onlyMatch = html.split("TBL");
                        String fullMatch = onlyMatch[1].substring(0, onlyMatch[1].length() - 2);
                        String[] hostAndGuest = fullMatch.split(":");
                        teams.name.add(hostAndGuest);
                        matchCount.getAndIncrement();
                    }
                    while (d.find()) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                        String[] onlyDate = html.split("below-sm\">");
                        String fullDate = onlyDate[1].substring(0, onlyDate[1].length() - 6);
                        matches.date.set(matchCount.intValue() - 1, fullDate);
                    }
                    while (r.find()) {
                        html = html.replaceAll(" ", "");
                        String fullResult = html.substring(0, html.length() - 4);
                        String[] hostResultGuestResult = fullResult.split(":");
                        matches.hostPoints.set(matchCount.intValue() - 1, Integer.parseInt(hostResultGuestResult[0]));
                        matches.guestPoints.set(matchCount.intValue() - 1, Integer.parseInt(hostResultGuestResult[1]));
                    }
                }

        );

        System.out.println(teams.getName().get(75)[0].trim() + "-" + teams.getName().get(5)[1].trim());
        System.out.println(matches.getDate().get(75));
        System.out.println(matches.getHostPoints().get(75) + ":" + matches.getGuestPoints().get(75));


    }

}
