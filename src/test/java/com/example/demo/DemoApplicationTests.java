
package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.diy4rent.demo.model.Herramientas;

import com.example.diy4rent.demo.repo.IHerramientaRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class Diy4rentApplicationTests {

	@Autowired

	private IHerramientaRepo repo;

	@Test

	void TestPublicar() {

		Herramientas herramienta = new Herramientas();
		herramienta.setUuid("1334");
		herramienta.setTitle("martillo rojo");
		herramienta.setDescription("prácticamente como nuevo");
		herramienta.setPrice(2);
		herramienta.setCategory("de golpe");
		herramienta.setLocation("Madrid");
		herramienta.setCharge_info("ES3333333");
		repo.save(herramienta);
		Herramientas s = repo.findByUuid("1334");
		assertEquals(s.getTitle(), herramienta.getTitle());
		assertEquals(s.getCategory(), "de golpe");

		herramienta.setTitle("martillo rojo premium");

		repo.save(herramienta);
		s = repo.findByUuid("1334");
		assertNotEquals(s.getTitle(), "martillo rojo");
	}

}