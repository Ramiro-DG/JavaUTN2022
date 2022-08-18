package ej1;

public class Show extends Event{
	private String type;
	private String name;
	private Double durationHs;
	private Artist artist;
	private Equipment equipment;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getDurationHs() {
		return durationHs;
	}
	public void setDurationHs(Double durationHs) {
		this.durationHs = durationHs;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public Double getOverallCost(){
		Double acum=super.getOverallCost();
		acum+=(equipment.getCost()+(artist.getHourlyCost()*this.durationHs));
		return acum;
	}

}
