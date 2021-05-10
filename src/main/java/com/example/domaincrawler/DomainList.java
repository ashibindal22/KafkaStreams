package com.example.domaincrawler;

import java.util.List;
import java.util.Objects;

public class DomainList {
	
	List<Domain> domains;

	public DomainList() {
		
	}

	public DomainList(List<Domain> domains) {
		this.domains = domains;
	}

	public List<Domain> getDomains() {
		return domains;
	}

	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}

	@Override
	public int hashCode() {
		return Objects.hash(domains);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		DomainList other = (DomainList) obj;
		return Objects.equals(domains, other.domains);
	}
	
	
}
