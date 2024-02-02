

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.Voucher;
import api.VoucherListJsonDecode;

/**
 * Servlet implementation class SikakuListServlet
 */
@WebServlet({ "/voucher/list" })
public class VoucherListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoucherListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Voucher> vouchers = VoucherListJsonDecode.getVoucherList();
		request.setAttribute("vouchers", vouchers);
		request.getRequestDispatcher("/voucherList.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String voucherId = request.getParameter("voucherId");
		String voucherLimit = request.getParameter("voucherLimit");
		
		VoucherListJsonDecode.addVoucher(voucherId,voucherLimit);
		response.sendRedirect("./list");
	}

}
