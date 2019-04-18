import java.sql.ResultSet;
import java.sql.SQLException;




public class Consultas {
	private String busca;
	private int indice;
	
	
	
	public String getNomeDataApelidoAtivo(){
		busca = "SELECT nome, apelido, ano_nasc FROM tenista WHERE esta_ativo = '1' ";
		return busca;
	}
	
	
	/*
	 * listar o nome, apelido e ano de nascimento de cada jogador na ativa
	 */
	public void buscaNomeDataApelidoAtivo(ResultSet rs) throws SQLException {
		indice = 0;
		while(rs.next()){
			System.out.print("Tenista" + indice++ + ":");
			System.out.print(" " + rs.getString("nome"));
			System.out.print(" " + rs.getInt("ano_nasc"));
			System.out.println(" " + rs.getString("apelido"));
		}
	}
	
	
	public String getNomeIdadeRG(){
		busca = "SELECT DISTINCT t.nome, t.ano_nasc FROM tenista t, participar p WHERE p.id_torneio = '4' and t.id = p.id_tenista";
		return busca;
	}
	/*
	 * Listar o nome e a idade dos jogadores que já disputaram o torneio de 'Roland Garros'
	 */
	public void nomeIdadeRG(ResultSet rs) throws SQLException{
		indice = 0;
		while(rs.next()){
			System.out.print("Tenista" + indice++ + ":");
			System.out.print(" " + rs.getString("nome"));
			int ano = 2014 - rs.getInt("ano_nasc");
			System.out.println(" " + ano );
		}
	}
	
	
	public String getTorneioDisputado(){
		busca = "SELECT t.nome, COUNT(*) FROM participar p, tenista t WHERE t.id = p.id_tenista";
		//busca = "SELECT COUNT(*) FROM participar";
		return busca;
	}
	/*
	 * Quantos torneios foram disputados ao longo da carreira de cada jogador.
	 */
	public void torneioDisputadoPorJogador(ResultSet rs) throws SQLException{
		indice = 0;
		while(rs.next()){
			System.out.print("Tenista" + indice++ + ":");
			System.out.print(" " + rs.getInt("COUNT(id)"));
		}
		
	}
	
	/*public String x(Tenist tenist) throws SQLException{
		
	String name = tenist.getName();
	String nickname = tenist.getNickname();
	int yearBirth = tenist.getYearBirth();
	String yearCity = tenist.getYearCity();
	String residenceCity = tenist.getResidenceCity();
	int isActive = tenist.isActive();

	String sql = "INSERT INTO tenista (nome,apelido,ano_nasc,cidade_nascimento,cidade_moradia,esta_ativo) VALUES ('"
			+ name
			+ "','"
			+ nickname
			+ "',"
			+ yearBirth
			+ ",'"
			+ yearCity
			+ "','" + residenceCity + "'," + isActive + ")";
		return sql;
	}
	
	public String a(Tenist tenist) throws SQLException{
		String idTournament = "SELECT id FROM torneio WHERE nome = 'Arapiraca Open'";
		
		
	}
	*/
	

}
