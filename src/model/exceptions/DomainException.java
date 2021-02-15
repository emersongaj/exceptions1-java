package model.exceptions;
/*Domain, vai ser uma exceção, que vai ser lançada numa entidade de domínio que é a Reservation
extends Exception  --> o compilador obrigará a tratar
ou RuntimeException  --> tipo de exceção que o compilador não obriga a tratar*/
public class DomainException extends Exception{  //troque por RuntimeException pra testar (no caso pode apagar no construtor e no método o throw que foi propagado, 
												//pois não é obrigado a tratar erros no RunTimeException, ou seja, posso apagar algum catch que o programa vai funcionar normalmente)
	private static final long serialVersionUID = 1L; 
	
	//construtor
	public DomainException(String msg) {
		super(msg);//passar a msg para o construtor da superclasse
	}			   //permite instanciar essa exceção personalizada passando uma msg pra ela 


}
