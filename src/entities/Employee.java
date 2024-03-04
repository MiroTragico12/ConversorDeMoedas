package entities;

public class Employee {

	private String name;
	private Integer codeAccount;
	
	
	Employee(){
		
	}

	public Employee(String name, Integer codeAccount) {
		this.name = name;
		this.codeAccount = codeAccount;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCodeAccount() {
		return codeAccount;
	}

	public void setCodeAccount(Integer codeAccount) {
		this.codeAccount = codeAccount;
	}

	public String toString() {
        return "Nome = " + name +", Codigo da sua conta: "+codeAccount;
    }
	
}
