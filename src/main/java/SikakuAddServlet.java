

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.Exam;
import api.ExamListJsonDecode;

/**
 * Servlet implementation class SikakuAddServlet
 */
@WebServlet("/sikaku/add")
public class SikakuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SikakuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Exam> result = ExamListJsonDecode.getExamList();
		request.setAttribute("result", result);
		request.getRequestDispatcher("/sikakuAdd.jsp").forward(request, response);
	}

}
