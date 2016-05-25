package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.Builder;
import DAO.GuitarSpec;
import DAO.Type;
import DAO.Wood;
import DB.DbUtil;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");

		String search = request.getParameter("search");
		System.out.println(search);
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		
		String sql="select * from Guitars";
		DbUtil db=new DbUtil();
		try{
			ResultSet rs = db.query(sql);
			while (rs.next()) {
				Builder builder=Builder.valueOf(rs.getString("builder").toUpperCase());
				Type type=Type.valueOf(rs.getString("type").toUpperCase());
				Wood bWood=Wood.valueOf(rs.getString("backWood").toUpperCase());
				Wood tWood=Wood.valueOf(rs.getString("topWood").toUpperCase());
				String model=rs.getString("model");
				int numStrings=Integer.parseInt(rs.getString("numStrings"));			
				GuitarSpec spec=new GuitarSpec(builder,model,type,numStrings,bWood,tWood);
				if(spec.matches(spec,search.toUpperCase())||search.toUpperCase().equals(rs.getString("model").toUpperCase())){
					JSONObject jo = new JSONObject();
					jo.put("serialNumber", rs.getString("serialNumber"));
					jo.put("price",rs.getString("price"));
					jo.put("builder", builder.toString());
					jo.put("model",model);
					jo.put("type", type.toString());
					jo.put("numStrings", numStrings);
					jo.put("backwood", bWood.toString());
					jo.put("topwood",tWood.toString());
					ja.put(jo);
				}
			}
			rs.close();
			out.print(ja.toString());
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
