package model.exceptions;
/*Domain, vai ser uma exce��o, que vai ser lan�ada numa entidade de dom�nio que � a Reservation
extends Exception  --> o compilador obrigar� a tratar
ou RuntimeException  --> tipo de exce��o que o compilador n�o obriga a tratar*/
public class DomainException extends Exception{  //troque por RuntimeException pra testar (no caso pode apagar no construtor e no m�todo o throw que foi propagado, 
												//pois n�o � obrigado a tratar erros no RunTimeException, ou seja, posso apagar algum catch que o programa vai funcionar normalmente)
	private static final long serialVersionUID = 1L; 
	
	//construtor
	public DomainException(String msg) {
		super(msg);//passar a msg para o construtor da superclasse
	}			   //permite instanciar essa exce��o personalizada passando uma msg pra ela 


}
