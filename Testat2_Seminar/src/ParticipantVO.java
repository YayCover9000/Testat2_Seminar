
public  class ParticipantVO implements Comparable<ParticipantVO> {
	
	private String name;


	public int compareTo(ParticipantVO o) {
		return this.name.compareTo(o.name);
	}
	
	public ParticipantVO( String name) {
		setName(name);
	}
	
	public ParticipantVO() {
		this(null);
	}
	
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipantVO other = (ParticipantVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// /
	// / Setter und Getter
	// /

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

} 
