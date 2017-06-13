package de.hfu.meldeauskunft;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.*;

public class ResidentRepositoryStub implements ResidentRepository{

	public List<Resident> getResidents() {
		List<Resident> list = new ArrayList<Resident>();
		
		list.add(new Resident("Moritz", "Wenk", "Kussenhofstraﬂe", "Furtwangen", new Date(1995,4,4)));
		list.add(new Resident("Angela", "Merkel", "Schallstraﬂe", "Berlin", new Date(1801,3,8)));
		list.add(new Resident("Harald", "Fritz", "Fritzstraﬂe", "Kiel", new Date(1954,7,10)));
		list.add(new Resident("Leonardo", "Da Vinci", "Erfinderstraﬂe", "Florenz", new Date(1230,12,24)));
		list.add(new Resident("Anna", "M¸ller", "An der Pforte", "Dummhausen", new Date(875,8,2)));
		return list;
	}

}
