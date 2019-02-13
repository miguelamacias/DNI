package application;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

class Pruebas {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void testCalculoLetraDNI() {
		Assert.assertEquals("D", DNI.calculoNIF("45814859"));
	}

	@Test
	public void testCalculoLetraNIE() {
		Assert.assertEquals("B", DNI.calculoNIF("Y3641219"));
	}

	@Test
	public void testVerificarLetraDNI() {
		Assert.assertEquals(true, DNI.compruebaNIF("45814859D"));
		Assert.assertEquals(false, DNI.compruebaNIF("45814859X"));
	}

	@Test
	public void testVerificarLetraNIE() {
		Assert.assertEquals(true, DNI.compruebaNIF("Y3641219B"));
		Assert.assertEquals(false, DNI.compruebaNIF("Y3641219C"));
	}

}
