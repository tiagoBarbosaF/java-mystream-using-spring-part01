package br.com.mystream.mystream.main;

import br.com.mystream.mystream.models.MovieDao;
import br.com.mystream.mystream.models.SeasonDao;
import br.com.mystream.mystream.models.SeriesDao;
import br.com.mystream.mystream.service.ApiConsumer;
import br.com.mystream.mystream.service.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ApiConsumer consumer = new ApiConsumer();
    private ConvertData convertData = new ConvertData();
    private static final String ADDRESS = "http://www.omdbapi.com/?apikey=";
    private static final String API_KEY = "a9399783";

    public void showMenu() {
        String exit = "";

        while (!exit.equals("0")) {
            System.out.print("\nEnter what do you want to search (Movie, " +
                    "Series) " +
                    "or 0 to exit: ");
            String searchType = scanner.nextLine();

            if (searchType.equalsIgnoreCase("0")) {
                break;
            }

            System.out.print("Enter the title: ");
            String searchTitle = scanner.nextLine();

            String json = consumer.getData(String.format("%s%s&t=%s", ADDRESS,
                    API_KEY, searchTitle.replace(" ", "+").trim()));

            switch (searchType.toLowerCase()) {
                case "movie":
                    MovieDao movieDao = convertData.getData(json, MovieDao.class);
                    System.out.println("\nMovie:\n" + movieDao);
                    break;
                case "series":
                    SeriesDao seriesDao = convertData.getData(json,
                            SeriesDao.class);
                    System.out.println("\nSeries:\n" + seriesDao);

                    List<SeasonDao> seasonDaoList = new ArrayList<>();
                    for (int i = 1; i <= seriesDao.totalSeasons(); i++) {
                        json = consumer.getData(String.format("%s%s&t=%s" +
                                        "&Season=%d", ADDRESS, API_KEY,
                                searchTitle.replace(" ", "+").trim(), i));
                        SeasonDao seasonDao = convertData.getData(json,
                                SeasonDao.class);
                        seasonDaoList.add(seasonDao);
                    }

                    seasonDaoList.forEach(season -> {
                        System.out.println("\nSeason: " + season.season());
                        season.episodes()
                                .forEach(episode ->
                                        System.out.println("Episode: " +
                                                episode.numberEpisode() +
                                                ", Title: " +
                                                episode.title()));
                    });
                    break;
            }
        }
    }
}
