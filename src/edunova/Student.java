package edunova;

public class Student extends Osoba {
	
	double prosjek;
	int id;

	public Student(){
		super();
		
	}

	@Override
	public String toString() {
		return id + ". " + super.getIme() +", "+ super.getPrezime() +"- " + prosjek ;
	}

	public double getProsjek() {
		return prosjek;
	}

	public void setProsjek(double prosjek) {
		this.prosjek = prosjek;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setIme(String ime)
	{
		super.setIme(ime);
	}
	
	public void setPrezime(String prezime)
	{
		super.setPrezime(prezime);
	}
	
}
