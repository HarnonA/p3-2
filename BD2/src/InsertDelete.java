import java.sql.SQLException;

public class InsertDelete {

	//public InsertDelete(ClassManagement control) {
	//	super(control);
	//}

	public String insertTenist(Tenist tenist) {

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
	//	try {
		//	stmt.execute(sql);
			//System.out.println("\nInserção OK!");
		//} catch (SQLException e) {
			//System.out.println("\n" + e.getMessage());
		//}

	}
	
	public void insertFiveTenists(){
		Tenist t1 = new Tenist("Jones", "Jô", 1978, "Maceió", "São Paulo", 1);
		Tenist t2 = new Tenist("Sivirino", "Cuscui", 1989, "Cajueiro", "Recife", 1);
		Tenist t3 = new Tenist("Cafuringa", "Ôi de sapo", 1958, "Rio Largo", "Maceió", 0);
		Tenist t4 = new Tenist("David Gilmour", "Guitar Man", 1946, "Reino Unido", "Reino Unido", 0);
		Tenist t5 = new Tenist("Chris", "Fumaça", 1992, "New York", "Chicago", 1);
		
		insertTenist(t1);
		insertTenist(t2);
		insertTenist(t3);
		insertTenist(t4);
		insertTenist(t5);
		
		System.out.println("--------- Inclusões realizadas com sucesso!------------");
	}

	public void deleteTournament() {
		String idTournament = "SELECT id FROM torneio WHERE nome = 'Arapiraca Open'";

		try {

			rs = stmt.executeQuery(idTournament);
			rs.first();
			int id = rs.getInt("id");

			String sql = "DELETE FROM participar WHERE ano = 2009 AND id_torneio = "
					+ id + "";

			stmt.execute(sql);
			System.out.println("Deletado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Não foi possível a exclusão!" + e.getMessage());

		}
	}
}