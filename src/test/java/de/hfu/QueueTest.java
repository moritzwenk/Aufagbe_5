package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest
{	
	
	@Test
	
	public void testdequeue()
	{
		Queue queue = new Queue(3);
		
		final int wert_1 = 1;
		final int wert_2 = 2;
		
		queue.enqueue(1);
		queue.enqueue(2);
		
		assertEquals(wert_1, queue.dequeue());
		assertEquals(wert_2, queue.dequeue());
	}
	
	@Test
	
	public void testenqueueoverflow()
	{
		Queue queue = new Queue(3);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		final int wert_1 = 4;
		final int wert_2 = 2;
		final int wert_3 = 1;
		
		assertEquals(wert_3, queue.dequeue());
		assertEquals(wert_2, queue.dequeue());
		assertEquals(wert_1, queue.dequeue());
	}
	
	@Test(expected=IllegalStateException.class)
	
	public void testdequeueEmpty()
	{
		Queue queue = new Queue(3);
		
		queue.dequeue();
	}
}
