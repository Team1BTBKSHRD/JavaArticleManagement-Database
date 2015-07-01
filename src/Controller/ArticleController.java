package Controller;

import java.util.ArrayList;

import Model.ArticleDTO;
import View.ArticleView;

public class ArticleController {
	public static void main(String[] args) {
		ArticleView articleview=new ArticleView();
		ArrayList<ArticleDTO> listDTO=new ArrayList<ArticleDTO>();
		for(int i=0; i<100; i++){
			listDTO.add(new ArticleDTO(i, "A", "B", "C", "D"));
		}
		articleview.setArticles(listDTO);
		articleview.process();		
	}
}
