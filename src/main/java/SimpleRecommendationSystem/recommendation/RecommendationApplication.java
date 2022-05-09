package SimpleRecommendationSystem.recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class RecommendationApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RecommendationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO recipe (id, Cuisine, Ingredients, Instructions) VALUES(4,'Hello', '{h, welcome, home}', '{there}');";
		int rows = jdbcTemplate.update(sql);
		if(rows < 0){
			System.out.println("No row has been inserted");
		}else{
			System.out.println("Data inserted successfully");
		}

	}
}
