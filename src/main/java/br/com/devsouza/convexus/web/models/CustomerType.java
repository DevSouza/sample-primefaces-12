package br.com.devsouza.convexus.web.models;

public enum CustomerType {
	NATURAL_PERSON("Pessoa Física", "PF"), // PESSOA FISICA
	LEGAL_PERSON("Pessoa Jurídica", "PJ"); // PESSOA JURIDICA
	
	private String description;
	private String acronym;

	private CustomerType(String description, String sigla) {
		this.description = description;
		this.acronym = sigla;
	}
	public String getDescription() {
		return description;
	}
	public String getAcronym() {
		return acronym;
	}
}