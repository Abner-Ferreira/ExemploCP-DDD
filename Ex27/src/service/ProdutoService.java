package service;

import model.ProdutoModel;
import dao.Dao;
import java.sql.ResultSet;


public class ProdutoService {

	 public static void InserirProduto(ProdutoModel p) {  
		 	String query = String.format("select max(id_produto) as id_produto from t_produto");
		 	ResultSet rs = Dao.SelectCommand(query);
		 	
		 	try {
				int id = -1;
				while(rs.next()) {
					id = rs.getInt("id_produto");
				}
				id++;
				query = String.format("insert into t_produto (id_produto,nome, preco, quantidade) values(%s,'%s',%s, %s)", id, p.getNome(), p.getPreco(), p.getQuantidade());
		        Dao.InsertUpdateDeleteCommand(query);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
	        
	    }
	   
	 
	 public static void InserirProduto(ProdutoModel p, int id_categoria) {  
		 	String query = String.format("select max(id_produto) as id_produto from t_produto");
		 	ResultSet rs = Dao.SelectCommand(query);
		 	
		 	try {
				int id = -1;
				while(rs.next()) {
					id = rs.getInt("id_produto");
				}
				id++;
				query = String.format("insert into t_produto (id_produto,nome, preco, quantidade, id_categoria) values(%s,'%s',%s, %s,%s)", id, p.getNome(), p.getPreco(), p.getQuantidade(),id_categoria);
		        Dao.InsertUpdateDeleteCommand(query);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
	        
	  }
	 
	    public static void AtualizarProduto(ProdutoModel p) {
	        String query = String.format("update t_produto set nome = '%s', preco = %s, quantidade = %s where id_produto = %s", p.getNome(),p.getPreco(), p.getQuantidade() ,p.getId());
	        Dao.InsertUpdateDeleteCommand(query);
	    }
	   
	    public static void ExcluirProduto(int id) {
	        String query = String.format("delete from t_produto where id_produto = %s", id);
	        Dao.InsertUpdateDeleteCommand(query);
	    }
	   
	    public static void ExibirProduto() {
	        String query= "select * from t_produto";
	       
	        ResultSet rs = Dao.SelectCommand(query);
	       
	        try {
	            while(rs.next()){
	                System.out.println(rs.getString("id_produto"));
	                System.out.println(rs.getString("nome"));
	                System.out.println(rs.getString("preco"));
	                System.out.println(rs.getString("quantidade"));
	            }
	        }
	        catch (Exception e){
	                System.out.println(e);
	        }  
	    }
	   
	    public static void ExibirProduto(int id) {
	        String query = String.format("select * from t_produto where id_produto = %s", id);
	        ResultSet rs = Dao.SelectCommand(query);
	       
	        try {
	            while(rs.next()){
	                System.out.println(rs.getString("id_produto"));
	                System.out.println(rs.getString("nome"));
	                System.out.println(rs.getString("preco"));
	                System.out.println(rs.getString("quantidade"));
	            }
	        }
	        catch (Exception e){
	                System.out.println(e);
	        }
	    }
	 
}
