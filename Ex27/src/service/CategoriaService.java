package service;

import model.CategoriaModel;
import dao.Dao;
import java.sql.ResultSet;


public class CategoriaService {

	 public static void InserirCategoria(CategoriaModel c) {  
		 	String query = String.format("select max(id_categoria) as id_categoria from t_categoria");
		 	ResultSet rs = Dao.SelectCommand(query);
		 	
		 	try {
				int id = -1;
				while(rs.next()) {
					id = rs.getInt("id_categoria");
				}
				id++;
				query = String.format("insert into t_categoria (id_categoria,nome) values(%s,'%s')", id, c.getNome());
		        Dao.InsertUpdateDeleteCommand(query);
		        query = String.format("insert into t_produto (id_categoria) values(%s)", id);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
	        
	   }
	   
	    public static void AtualizarCategoria(CategoriaModel c) {
	        String query = String.format("update t_categoria set nome = '%s' where id_categoria = %s", c.getNome(), c.getId());
	        Dao.InsertUpdateDeleteCommand(query);
	    }
	   
	    public static void ExcluirCategoria(int id) {
	        String query = String.format("delete from t_categoria where id_categoria = %s", id);
	        Dao.InsertUpdateDeleteCommand(query);
	    }
	   
	    public static void ExibirCategoria() {
	        String query= "select * from t_categoria";
	       
	        ResultSet rs = Dao.SelectCommand(query);
	       
	        try {
	            while(rs.next()){
	                System.out.print(rs.getString("id_categoria")+" ");
	                System.out.println(rs.getString("nome"));
	            }
	        }
	        catch (Exception e){
	                System.out.println(e);
	        }  
	    }
	   
	    public static void ExibirCategoria(int id) {
	        String query = String.format("select * from t_categoria where id_categoria = %s", id);
	        ResultSet rs = Dao.SelectCommand(query);
	       
	        try {
	            while(rs.next()){
	                System.out.print(rs.getString("id_categoria")+" ");
	                System.out.println(rs.getString("nome"));
	            }
	        }
	        catch (Exception e){
	                System.out.println(e);
	        }
	    }
	 
}
