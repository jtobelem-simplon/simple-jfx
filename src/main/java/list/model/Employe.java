package list.model;

public class Employe {
	
	private String name;
	private int anciennete;
	private Role role;
	
	public static enum Role {
		MANAGER, GROUILLOT, STAGIAIRE;
	}

	public Employe(String name, int anciennete, Role role) {
		this.name = name;
		this.anciennete = anciennete;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public int getAnciennete() {
		return anciennete;
	}

	public Role getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	

}
