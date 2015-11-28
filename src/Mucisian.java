
public class Mucisian extends Person{

//	Design a Mucisian subclass of the Person class. 
//	It is to have the following extra fields, Instrument which indicates 
//	that Musicians main instrument, 
//	a field representing their musical genre e.g. classical , traditional,etc 
//	and a field indicating whether they play solo, in a group, an ensemble an orchestra. 
//	Again supply any methods you deem appropriate.
	
	//fields
	String instrument;
	String genre;
	String band;
	
	//Constructor 
	public Mucisian(String n, String mInstrument, String mGenre, String sBand) {
		super(n);
		instrument = mInstrument;
		genre = mGenre;
		band = sBand;
	}
	
	//methods
	public String getInstrument(){
		return instrument;
	}
	
	public void setInstrument(String i){
		instrument = i;
	}
	
	public String getGenre(){
		return genre;
	}
	
	public void setGenre(String g){
		genre = g;
	}
	
	public String getBand(){
		return band;
	}
	
	public void setBand(String b){
		band = b;
	}

}
