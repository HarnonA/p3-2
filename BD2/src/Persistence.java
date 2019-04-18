import java.sql.SQLException;


public class Persistence {

	private Tenist tenist;
	private String sql;
	
	public Persistence(Tenist tenist){
		this.tenist = tenist;
		
	}
	
	public String x() throws SQLException{
		
		sql = "INSERT INTO 'tenista' (nome,apelido,ano_nasc,cidade_nascimento,cidade_moradia,esta_ativo) VALUES ('"
				+ tenist.getName() + "','" + tenist.getNickname() + "','" + tenist.getYearBirth() + "','" +
				tenist.getYearCity() + "','" + tenist.getResidenceCity() + "','" + tenist.isActive() + ")";
		return sql;
		
		
	}
	
}
