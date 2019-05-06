package tutoJUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.*;

public class CuveTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testCuve() {
		Cuve c=new Cuve(100.0,200.0);
		Assert.assertEquals(100.0,c.quantite,0.001);
		Assert.assertEquals(200.0,c.quantiteMax, 0.001);
		
	}

	@Test
	public void testRemplir() {
		Cuve c=new Cuve(100.0,200.0);
		c.remplir(50.0);
		Assert.assertEquals(150.0,c.quantite, 0.001);
		
	}

	@Test
	public void testVider() {
		System.out.println("testVider");
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		System.out.println("testToString");
		
		fail("Not yet implemented");
	}

}
