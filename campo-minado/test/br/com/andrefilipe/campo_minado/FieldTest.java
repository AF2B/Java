package br.com.andrefilipe.campo_minado;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.andrefilipe.campo_minado.exception.ExplosionException;
import br.com.andrefilipe.campo_minado.model.Field;

public class FieldTest {
	
	private Field field = new Field(3, 3);
	
	/*
	@BeforeEach //For every method, this will be called.
	void InitField()
	{
		field = new Field(3, 3);
	}
	*/
	
	/*
	 * Need review. error test...
	 */
	@Test
	void neighborsDistanceTest()
	{
		Field leftNeighbors = new Field(3, 2);
		Field rightNeighbors = new Field(3, 4);
		Field topNeighbors = new Field(2, 3);
		Field bottomNeighbors = new Field(4, 3);
		
		boolean leftResult = field.addNeighbors(leftNeighbors);
		boolean rightResult = field.addNeighbors(rightNeighbors);
		boolean topResult = field.addNeighbors(topNeighbors);
		boolean bottomResult = field.addNeighbors(bottomNeighbors);
		
		assertTrue(leftResult);
		assertTrue(rightResult);
		assertTrue(topResult);
		assertTrue(bottomResult);
	}
	
	@Test
	void diagonalyDistanceTest()
	{
		Field diagonaly = new Field(2, 2);
		
		boolean resultDiagonaly = field.addNeighbors(diagonaly);
		
		assertTrue(resultDiagonaly);
	}
	
	
	@Test
	void nonNeighbor()
	{
		Field nonNeighbor = new Field(1, 1);
		
		boolean resultNonNeighbor = field.addNeighbors(nonNeighbor);
		
		assertFalse(resultNonNeighbor);
	}
	
	@Test
	void attributeValueSelected()
	{
		Field switchMarking = new Field(3, 3);
		
		assertFalse(switchMarking.isMarked());
	}
	
	@Test
	void switchMarkingTest()
	{
		Field switchMarking = new Field(3, 3);
		
		switchMarking.switchMarking();
		assertTrue(switchMarking.isMarked());
	}
	
	@Test
	void switchMarkingTwoCallsTest()
	{
		Field switchMarking = new Field(3, 3);
		
		switchMarking.switchMarking();
		switchMarking.switchMarking();
		assertFalse(switchMarking.isMarked());
	}
	
	@Test
	void openUnminedAndUnmarkedField()
	{
		Field field = new Field(3, 3);
		
		assertTrue(field.openNeighbors());
	}
	
	@Test
	void openUnminedAndMarkedField()
	{
		Field field = new Field(3, 3);
		
		field.switchMarking();
		assertFalse(field.openNeighbors());
	}
	
	@Test
	void openMinedAndMarkedField()
	{
		Field field = new Field(3, 3);
		
		field.switchMarking();
		field.mining();
		assertFalse(field.openNeighbors());
	}
	
	@Test
	void openMinedAndUnmarkedField()
	{
		Field field = new Field(3, 3);
		
		field.mining();
		assertThrows(ExplosionException.class, () -> field.openNeighbors());	
	}
	
	/*
	 * need review, failure.
	 */
	@Test
	void openWithNeighbors()
	{
		Field neighbor11 = new Field(1, 1); //"neighbor's neighbor"
		Field neighbor22 = new Field(2, 2);
		
		neighbor22.addNeighbors(neighbor11);
		
		field.addNeighbors(neighbor22);
		field.openNeighbors();
		
		assertTrue(neighbor22.isOpen() && neighbor11.isOpen());
	}
	
	/*
	 * review, failure.
	 */
	@Test
	void openWithNeighbors2()
	{
		Field neighbor11 = new Field(1, 1); //"neighbor's neighbor"
		Field neighbor12 = new Field(1, 1);
		Field neighbor22 = new Field(2, 2);
		
		neighbor12.mining();
		
		neighbor22.addNeighbors(neighbor11);
		neighbor22.addNeighbors(neighbor12);
		
		field.addNeighbors(neighbor22);
		field.openNeighbors();
		
		assertTrue(neighbor22.isOpen() && neighbor11.isClose());
	}

}
