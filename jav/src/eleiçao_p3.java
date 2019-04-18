
import java.util.Scanner;

public class eleiçao_p3 {

	public static void main( String[] args){
		
		Scanner scanner = new Scanner( System.in );
		int total_votadores,
			partido1 = 0,
			partido2 = 0,
			outros_partidos = 0,
			lido,
			i;
		
		System.out.print("Quantos irao votar? ");
		total_votadores = scanner.nextInt();
		for( i=0 ; i < total_votadores; i++){
			
			System.out.print("Escolha seu partido: ");
			lido = scanner.nextInt();
			if( lido == 45)
				partido1++;
			if( lido == 15)
				partido2++;
			else
				outros_partidos++;
				
		}
		System.out.println("\n* Resultado *");
		if( outros_partidos > (partido1+partido2) )
			System.out.println("Eleicao cancelada");
		else{
			
			if(partido1 > partido2)
				System.out.print("PSDB 45 VENCEU! ");
			else
				System.out.print("PMDB 15 VENCEU! ");
		}
		System.out.print("45 - %d votos\n15 - %d votos\nEm branco %d votos", partido1,partido2,outros_partidos);
		
	}
}
