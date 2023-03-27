package converterExelToXml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConverterExelToXmlApplication {

	public static void main(String[] args) {
		Converter converter = new Converter();
		converter.convert();
		SpringApplication.run(ConverterExelToXmlApplication.class, args);
	}

}
