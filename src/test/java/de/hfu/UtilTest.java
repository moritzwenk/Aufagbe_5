package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest
{
	@Test
	
	public void testisterstesHalbjahr()
	{
		assertTrue(Util.istErstesHalbjahr(6));
		assertTrue(!Util.istErstesHalbjahr(7));
	}
}