package br.com.mystream.mystream;

import br.com.mystream.mystream.models.SeriesDao;
import br.com.mystream.mystream.service.ApiConsumer;
import br.com.mystream.mystream.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MystreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MystreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiConsumer apiConsumer = new ApiConsumer();
		String json = apiConsumer.getData("http://www.omdbapi" +
				".com/?apikey=a9399783&t=fringe");
		System.out.println("\nomdb:\n" + json);

		ConvertData convertData = new ConvertData();
		SeriesDao dataSeries = convertData.getData(json, SeriesDao.class);
		System.out.println("\n\nSerie:\n" + dataSeries);
	}
}
