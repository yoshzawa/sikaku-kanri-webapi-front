

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
 * Servlet implementation class SikakuListServlet
 */
@WebServlet({ "/exam/list" })
public class ExamListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Exam> exams = ExamListJsonDecode.getExamList();
		request.setAttribute("exams", exams);
		request.getRequestDispatcher("/examList.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String examId = request.getParameter("examId");
		String examName = request.getParameter("examName");
		
		ExamListJsonDecode.addExam(examId,examName);
		response.sendRedirect("./list");
	}

}
