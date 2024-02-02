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

public class VoucherTypeListJsonDecode {

	public static List<VoucherType> getVoucherTypeList() {
		try {
			// HTTPリクエストを送信してJSONを取得
			URL url = new URL(ServerInterface.server+"/voucherType/list?token=abcd1234");
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
			Type type = new TypeToken<List<VoucherType>>() {
			}.getType();
			List<VoucherType> exams = gson.fromJson(response.toString(), type);

			return exams;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<VoucherType>();
		}

	}
	public static List<AddResult> addVoucherType(String ID,String NAME) {
		try {
			// HTTPリクエストを送信してJSONを取得
			URL url = new URL(ServerInterface.server+"/sikaku/add?token=abcd1234&ID="+ID+"&NAME="+NAME);
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
