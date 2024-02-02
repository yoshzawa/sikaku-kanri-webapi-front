package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class VoucherListJsonDecode {

	public static List<Voucher> getVoucherList() {
		try {
			// HTTPリクエストを送信してJSONを取得
			URL url = new URL(ServerInterface.server+"/voucher/list?token=abcd1234");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// JSONをパースしてIDとNAMEの配列として受け取る
			Gson gson = new Gson();
			Type type = new TypeToken<List<Voucher>>() {	}.getType();
			List<Voucher> sikakus = gson.fromJson(response.toString(), type);

			return sikakus;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Voucher>();
		}

	}
	public static List<AddResult> addVoucher(String ID,String DATE) {
		try {
			// HTTPリクエストを送信してJSONを取得
			URL url = new URL(ServerInterface.server+"/voucher/add?token=abcd1234&ID="+ID+"&DATE="+DATE);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// JSONをパースしてIDとNAMEの配列として受け取る
			Gson gson = new Gson();
			Type type = new TypeToken<List<AddResult>>() {
			}.getType();
			List<AddResult> exams = gson.fromJson(response.toString(), type);

			return exams;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<AddResult>();
		}

	}

}
