package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBrutaVendedor() {
		Empleado e = new Empleado();
		float expected = 2000;
		float nominaBrutaVendedor = e.calculoNominaBruta(TipoEmpleado.Vendedor, 0, 0);
		assertEquals(expected, nominaBrutaVendedor);

	}

	@Test
	void testCalculoNominaBrutaEncargado() {
		Empleado e = new Empleado();
		float expected = 2500;
		float nominaBrutaEncargado = e.calculoNominaBruta(TipoEmpleado.Encargado, 0, 0);
		assertEquals(expected, nominaBrutaEncargado);

	}

	@Test
	void testCalculoNominaBrutaOtro() {
		Empleado e = new Empleado();
		float expected = 0;
		float nominaBrutaOtro = e.calculoNominaBruta(null, 0, 0);
		assertEquals(expected, nominaBrutaOtro);
	}

	@Test
	void testCalculoNominaBrutaVentasNegativas() {
		Empleado e = new Empleado();
		float expected = 0;
		float nominaBrutaNegativas = e.calculoNominaBruta(null, -10, 0);
		assertEquals(expected, nominaBrutaNegativas);
	}

	@Test
	void testCalculoNominaBrutaVentas0y1000() {
		Empleado e = new Empleado();
		float expected = 0;
		float nominaBruta = e.calculoNominaBruta(null, 100, 0);
		assertEquals(expected, nominaBruta);
	}

	@Test
	void testCalculoNominaBrutaVentas1000y1500() {
		Empleado e = new Empleado();
		float expected = 100;
		float nominaBruta = e.calculoNominaBruta(null, 1200, 0);
		assertEquals(expected, nominaBruta);
	}

	@Test
	void testCalculoNominaBrutaVentas1500() {
		Empleado e = new Empleado();
		float expected = 200;
		float nominaBruta = e.calculoNominaBruta(null, 1600, 0);
		assertEquals(expected, nominaBruta);
	}

	@Test
	void testCalculoNominaBrutaHorasExtrasNegativas() {
		Empleado e = new Empleado();
		float expected = 0;
		float nominaBruta = e.calculoNominaBruta(null, 0, -10);
		assertEquals(expected, nominaBruta);
	}

	@Test
	void testCalculoNominaBrutaHorasExtrasPositivas() {
		Empleado e = new Empleado();
		float expected = 120;
		float nominaBruta = e.calculoNominaBruta(null, 100, 4);
		assertEquals(expected, nominaBruta);
	}

	@Test
	void testCalculoNominaNetaNegativa() {
		Empleado e = new Empleado();
		float expected = 0;
		float nominaNeta = e.calculoNominaNeta(-10);
		assertEquals(expected, nominaNeta);
	}

	@Test
	void testCalculoNominaNetaMenor2100() {
		Empleado e = new Empleado();
		float expected = 1000;
		float nominaNeta = e.calculoNominaNeta(1000);
		assertEquals(expected, nominaNeta);
	}

	@Test
	void testCalculoNominaNetaMayor2100yMenor2500() {
		Empleado e = new Empleado();
		float expected = 1870;
		float nominaNeta = e.calculoNominaNeta(2200);
		assertEquals(expected, nominaNeta);
	}

	@Test
	void testCalculoNominaNetaMayor2500() {
		Empleado e = new Empleado();
		float expected = 2214;
		float nominaNeta = e.calculoNominaNeta(2700);
		assertEquals(expected, nominaNeta);
	}

}
