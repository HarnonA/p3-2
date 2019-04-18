package system;

import planning.Offline;
import planning.Online;
import planning.Planning;
import elements.Body;
import elements.BuildPlan;
import elements.Engine;
import elements.Invocation;
import elements.Item;


public class PlanningSystem {
 
	final static int UNAVAILABLE = 0;
	final static int NO_REQUEST = 1;
	final static int REQUESTED = 2;
	final static int SCHEDULED = 3;
 
	int situation = NO_REQUEST;

	private Planning planning = null;
	
	public PlanningSystem(Planning planning) {
		this.planning = planning;
	}
  
	public void makeRequest() {
		if (situation == REQUESTED) {
			System.out.println("Voce nao pode realizar outra requisicao");
		} else if (situation == NO_REQUEST) {
			situation = REQUESTED;
			System.out.println("Voce realizou uma requisicao");
		} else if (situation == UNAVAILABLE) {
			System.out.println("Voce nao pode realizar uma requisicao, o sistema esta indisponivel");
		} else if (situation == SCHEDULED) {
        	System.out.println("Por favor, espere a finalizacao do processo");
		}
	}

	public void cancelRequest() {
		if (situation == REQUESTED) {
			System.out.println("Requisicao cancelada");
			situation = NO_REQUEST;
		} else if (situation == NO_REQUEST) {
			System.out.println("Voce nao realizou nenhuma requisicao");
		} else if (situation == SCHEDULED) {
			System.out.println("Desculpe, a requisicao ja foi processada");
		} else if (situation == UNAVAILABLE) {
        	System.out.println("Voce nao pode cancelar, nenhuma requisicao foi realizada");
		}
	}
 
	public void check() {
		if (situation == SCHEDULED) {
			System.out.println("Checar outra vez nao fornecera outro plajenamento!");
		} else if (situation == NO_REQUEST) {
			System.out.println("Voce checou, mas nao existe nenhuma requisicao");
		} else if (situation == UNAVAILABLE) {
			System.out.println("Voce checou, mas o planejamento nao esta disponivel");
		} else if (situation == REQUESTED) {
			System.out.println("Voce checou...");
			situation = SCHEDULED;
			dispense();
		}
	}
 
	public void dispense() {
		if (situation == SCHEDULED) {
			System.out.println("Uma planejamento e apresentado");
			
			if (this.planning instanceof Online) {
				Online online = (Online) this.planning;
				online.playOnlinePlanning();
			}if (this.planning instanceof Offline) {
				Offline offline = (Offline) this.planning;
				offline.playOfflinePlanning();
			}
			
			
			
		} else if (situation == NO_REQUEST) {
			System.out.println("Voce precisa realizar uma requisicao");
		} else if (situation == UNAVAILABLE) {
			System.out.println("Nao existe planejamento");
		} else if (situation == REQUESTED) {
			System.out.println("Nao existe planejamento");
		}
	}
	
	public void setState(int state) {
		this.situation = state;
	}
}


