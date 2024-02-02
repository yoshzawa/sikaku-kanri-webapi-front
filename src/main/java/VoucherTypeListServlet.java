

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.VoucherType;

/**
 * Servlet implementation class SikakuListServlet
 */
@WebServlet({ "/voucherType/list" })
public class VoucherTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoucherTypeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VoucherType> vouchers = VoucherTypeListJsonDecode.getVoucherTypeList();
		request.setAttribute("vouchers", vouchers);
		request.getRequestDispatcher("/vouchersList.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String voucherId = request.getParameter("voucherId");
		String voucherName = request.getParameter("voucherName");
		
		VoucherTypeListJsonDecode.addVoucherType(voucherId,voucherName);
		response.sendRedirect("./list");
	}

}
