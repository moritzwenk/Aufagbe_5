package de.hfu.meldeauskunft;

import static org.easymock.EasyMock.*;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;
import de.hs_furtwangen.informatik.meldeauskunft.domain.*;
import de.hs_furtwangen.informatik.meldeauskunft.repository.*;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;

public class ResidentServiceTest {	
	
	private static List<Resident> getTestResidents()
	{
		List<Resident> list = new ArrayList<Resident>();
		
		list.add(new Resident("Moritz", "Wenk", "Kussenhofstraße", "Furtwangen", new Date(1995,4,4)));
		list.add(new Resident("Angela", "Merkel", "Schallstraße", "Berlin", new Date(1801,3,8)));
		list.add(new Resident("Harald", "Fritz", "Fritzstraße", "Kiel", new Date(1954,7,10)));
		list.add(new Resident("Leonardo", "Da Vinci", "Erfinderstraße", "Florenz", new Date(1230,12,24)));
		list.add(new Resident("Anna", "Müller", "An der Pforte", "Dummhausen", new Date(875,8,2)));
		return list;
	}
	
	private static BaseResidentService createTestResidentService()
	{
		ResidentRepository repositoryMock = createMock(ResidentRepository.class);
		expect(repositoryMock.getResidents()).andReturn(getTestResidents());
		
		replay(repositoryMock);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(repositoryMock);
		return service;
	}
	
	@Test
	
	public void getFilteredResidentListTestname()
	{
		
		BaseResidentService ser = createTestResidentService();
		
		List<Resident> residents= ser.getFilteredResidentsList(new Resident("M*", "", "", "",null));
		
		assertEquals(1, residents.size());
	}
	
	@Test
	
	public void getFilteredResidentListTestfamilyName()
	{
		
		BaseResidentService ser = createTestResidentService();
		
		List<Resident> residents= ser.getFilteredResidentsList(new Resident("", "M*", "", "",null));
		
		assertEquals(2, residents.size());
	}
	
	@Test
	
	public void getFilteredResidentListTestdateOfBirth()
	{
		
		BaseResidentService ser = createTestResidentService();
		
		List<Resident> residents= ser.getFilteredResidentsList(new Resident("", "", "", "",new Date(1995,4,4)));
		
		assertEquals(1, residents.size());
	}
	
	@Test
	
	public void getUniqueResidentname()
	{
		BaseResidentService ser = createTestResidentService();
		
		Resident res = null;
		try {
			res = ser.getUniqueResident(new Resident("Moritz", "", "", "", null));
		} catch (ResidentServiceException e) {
			fail();
		}
		
		assertEquals("Moritz", res.getGivenName());
	}
	
	@Test
	public void getUniqueResidentfamilyName()
	{
		BaseResidentService ser = createTestResidentService();
		
		Resident res = null;
		try {
			res = ser.getUniqueResident(new Resident("", "Müller", "", "", null));
		} catch (ResidentServiceException e) {
			fail();
		}
		
		assertEquals("Müller", res.getFamilyName());
	}
	
	@Test
	public void getUniqueResidentdateOfBirth()
	{
		BaseResidentService ser = createTestResidentService();
		
		Resident res = null;
		try {
			res = ser.getUniqueResident(new Resident("", "", "", "", new Date(1995,04,04)));
		} catch (ResidentServiceException e) {
			fail();
		}
		
		assertEquals(new Date(1995,04,04), res.getDateOfBirth());
	}
}
