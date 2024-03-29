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

public class SikakuListJsonDecode {

	public static List<Sikaku> getSikakuList() {
		try {
			// HTTPリクエストを送信してJSONを取得
			URL url = new URL(ServerInterface.server+"/sikaku/list?token=abcd1234");
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
			Type type = new TypeToken<List<Sikaku>>() {	}.getType();
			List<Sikaku> vouchers = gson.fromJson(response.toString(), type);

			return vouchers;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Sikaku>();
		}

	}
	public static List<AddResult> addSikaku(String ID,String DATE) {
		try {
			// HTTPリクエストを送信してJSONを取得
			URL url = new URL(ServerInterface.server+"/sikaku/add?token=abcd1234&ID="+ID+"&DATE="+DATE);
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
			List<AddResult> vouchers = gson.fromJson(response.toString(), type);

			return vouchers;

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<AddResult>();
		}

	}

}
