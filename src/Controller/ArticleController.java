package Controller;
import Utilities.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ArticleDTO;
import View.ArticleView;

public class ArticleController {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		/*ArticleView articleview=new ArticleView();
		ArrayList<ArticleDTO> listDTO=new ArrayList<ArticleDTO>();
		for(int i=0; i<100; i++){
			listDTO.add(new ArticleDTO(i, "A", "B", "C", "D"));
		}
		articleview.setArticles(listDTO);
		articleview.process();		*/
		//System.out.println(DatabaseConnection.checkDatabase());
	}
}
