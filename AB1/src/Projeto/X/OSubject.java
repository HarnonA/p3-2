package Projeto.X;

public interface OSubject {
	
	public void registra(Observer o);
	
	public void retira(Observer o);
	
	public void notificaObserver();
	
}