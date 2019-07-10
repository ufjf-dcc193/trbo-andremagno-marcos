package br.ufjf.dcc193.trbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "br.ufjf.dcc193.trbo")
@ComponentScan(basePackages = {"br.*"})
@EnableJpaRepositories(basePackages = "br.ufjf.dcc193.trbo")
@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(DemoApplication.class, args);
		System.out.println("Rodando!");

		RepositorioUsuario repositorioUsuario;
		
		RepositorioAtendente repositorioAtendente;
		
		RepositorioCategoria repositorioCategoria;

		ConfigurableApplicationContext entrada;

		entrada = SpringApplication.run(DemoApplication.class, args);

		repositorioUsuario = entrada.getBean(RepositorioUsuario.class);
		repositorioAtendente = entrada.getBean(RepositorioAtendente.class);
		repositorioCategoria = entrada.getBean(RepositorioCategoria.class);
		
		repositorioAtendente.save(new Atendente("Marcos","asdfa","","","asdf@adsf"));

		repositorioUsuario.save(new Usuario("Andre","","","","",""));
		
		repositorioCategoria.save(new Categoria("TTTTTTTtt","")); */

		RepositorioUsuario repositorioUsuario;
		
		RepositorioAtendente repositorioAtendente;
		
		RepositorioCategoria repositorioCategoria;

		ConfigurableApplicationContext entrada;

		entrada = SpringApplication.run(DemoApplication.class, args);

		repositorioUsuario = entrada.getBean(RepositorioUsuario.class);
		repositorioAtendente = entrada.getBean(RepositorioAtendente.class);
		repositorioCategoria = entrada.getBean(RepositorioCategoria.class);
		
		Usuario user1;
		Usuario user2;

		Atendente atd1;
		Atendente atd2;

		Categoria cat1;
		Categoria cat2;
		Categoria cat3;

		user1 = new Usuario("Andre", "Cozinha", "123", "99995555", "88882222", "andre@gmail.com");
		repositorioUsuario.save(user1);
		user2 = new Usuario("Marcos", "Loja", "123", "99995555", "88882222", "marcos@gmail.com");
		repositorioUsuario.save(user2);


		atd1 = new Atendente("Igor", "123", "99995555", "88882222", "igor@gmail.com");
		repositorioAtendente.save(atd1);
		atd2 = new Atendente("Caio", "123", "99995555", "88882222", "caioba@gmail.com");
		repositorioAtendente.save(atd2);


		cat1 = new Categoria("Pizza", "massas");
		repositorioCategoria.save(cat1);
		cat2 = new Categoria("Sanduiche", "bife");
		repositorioCategoria.save(cat2);
		cat3 = new Categoria("doces", "doces");
		repositorioCategoria.save(cat3);
	}

}
