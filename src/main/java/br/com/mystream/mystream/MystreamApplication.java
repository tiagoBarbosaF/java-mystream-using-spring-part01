package br.com.mystream.mystream;

import br.com.mystream.mystream.main.Main;
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
        Main main = new Main();
        main.showMenu();
    }
}
