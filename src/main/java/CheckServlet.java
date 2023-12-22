import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(login(username, password)==true) {
			response.sendRedirect("https://www.yahoo.com");
		}else {
			response.sendRedirect("https://www.google.com");
		}
	}

	private boolean login(String username, String password) {
		Map<String, String> header=new HashMap<String, String>();
        String data ="username="+ username+ "&password="+ password;

		try {
			HttpResponse<String> resp=postJsonResponse("http://192.168.54.231:8888/account/login?"+data,
					header,""
					);
			System.out.println(data);
			System.out.println(resp.statusCode());
			System.out.println(resp.body());
			if(resp.statusCode() == 200) {
				Gson g = new Gson();
				return g.fromJson(resp.body(), LoginStatus.class).isOk();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace(System.err);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (InterruptedException e) {
			e.printStackTrace(System.err);
		}
		return false;
	}
	
	class LoginStatus{
		private String Status;
		private String Token;
		private String message;
		public String getStatus() {
			return Status;
		}
		public String getToken() {
			return Token;
		}
		public String getMessage() {
			return message;
		}
		public boolean isOk() {
			return getStatus().equals("OK");
		}
	}
	
	
	public static HttpResponse<String> postJsonResponse(String url, Map<String, String> headers, String data)
	        throws URISyntaxException, IOException, InterruptedException {
	    HttpClient client = getHttpClient();
	    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(new URI(url))
	            .POST(HttpRequest.BodyPublishers.ofString(data));
	    for (String key : headers.keySet()) {
	        requestBuilder.setHeader(key, headers.get(key));
	    }
	    HttpRequest request = requestBuilder.build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    return response;
	}

	private static HttpClient getHttpClient() {
		HttpClient client = HttpClient.newHttpClient();
		return client;
	}

	private static HttpClient getHttpClient(InetSocketAddress proxy) {
		HttpClient client = HttpClient.newBuilder().proxy(ProxySelector.of(proxy)).build();
		return client;
	}

}
