package cocserv.openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cocserv.util.Log;

@Controller
public class CocOfficialAPIController {

	private static final String auth_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03"
			+ "ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSI"
			+ "sImp0aSI6Ijk5ZTMyZTU1LTFiZDYtNDg3Ni1hM2UwLTIzMGRhMjZmYTVjZCIsImlhdCI6MTQ1ODAyNTgwNyw"
			+ "ic3ViIjoiZGV2ZWxvcGVyLzhkZWQ1Y2E0LWZiODMtNGNmYS1iZTIxLWY0YmIyMDEyMTcwMSIsInNjb3BlcyI"
			+ "6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGx"
			+ "pbmcifSx7ImNpZHJzIjpbIjU0LjIxMy4yNy4xNTgiXSwidHlwZSI6ImNsaWVudCJ9XX0.4Rh_CwQ-MmUOGHC"
			+ "H1d0FAWIrHoQ8s-dGozTQw5D-_Xmbh7oDKz6IBQhP1Mm5_AfaJ6-M6f6VZKKbV_EGznmm0w";

	@RequestMapping(value = "/leagues", method = RequestMethod.GET)
	@ResponseBody
	public String getLeagues() {

		String strResult = "";
		BufferedReader bufferedReader = null;
		try {
			String strUrl = "https://api.clashofclans.com/v1/leagues";
			URL url = new URL(strUrl);
			URLConnection urlConnection = url.openConnection();

			urlConnection.setRequestProperty("accept", "application/json");
			urlConnection.setRequestProperty("authorization", "Bearer <" + auth_token + ">");

			urlConnection.connect();

			bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String strLine;
			while ((strLine = bufferedReader.readLine()) != null) {
				strResult += strLine;
			}
			Log.debug("No exception, strResult = " + strResult);
		} catch (MalformedURLException e) {
			strResult = e.getMessage();
			Log.error("MalformedURLException, msg = " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			strResult = e.getMessage();
			Log.error("IOException, msg = " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return strResult;
	}
}
