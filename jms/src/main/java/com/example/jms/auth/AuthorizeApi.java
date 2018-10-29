package com.example.jms.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.jms.security.Auth0User;
import com.example.jms.security.LoggedinUser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthorizeApi {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizeApi.class);

	@Value("${token.info.url}")
	private String tokenInfoUrl;

	/**
	 * Validate token before any request processing.
	 * 
	 * @param token
	 * @param requestURI
	 * @return
	 * @throws MalformedURLException
	 * @throws ProtocolException
	 * @throws IOException
	 * @throws AuthorizationException
	 */
	public LoggedinUser isValidToken(String token, String requestURI)
			throws MalformedURLException, ProtocolException, IOException {
		LoggedinUser loggedInUser = null;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("isValidToken token--url----------------" + tokenInfoUrl);
			}
			URL validateTokenURL = new URL(tokenInfoUrl);
			HttpURLConnection conn = (HttpURLConnection) validateTokenURL.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			String str = "{\"id_token\": \"" + token + "\"}";
			os.write(str.getBytes());
			os.flush();
			os.close();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				if (logger.isInfoEnabled()) {
					logger.info("OK response code...");
				}
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output;
				if (logger.isInfoEnabled()) {
					logger.info("Output from Server .... \n");
				}
				ObjectMapper mapper = new ObjectMapper();
				Auth0User user = null;
				while ((output = br.readLine()) != null) {
					user = mapper.readValue(output, Auth0User.class);
				}
				if (user != null) {
					String email;
					if (user.getEmail() == null || user.getEmail().isEmpty()) {
						email = user.getEmailAddress();
					} else {
						email = user.getEmail();
					}
					if (logger.isInfoEnabled()) {
						logger.info("email---------------" + email);
					}
					loggedInUser = new LoggedinUser();
					loggedInUser.setEmail(email);
					loggedInUser.setName(user.getName());

					if (!requestURI.endsWith("createAccount")) {
						String domain = email.substring(email.indexOf('@') + 1);

					}
				}
			} else {
				logger.error("Not OK response code...");
			}
		} catch (MalformedURLException e) {
			logger.error("Malformed URL ", e);
			throw e;
		} catch (ProtocolException e) {
			logger.error("Protocol problem ", e);
			throw e;
		} catch (IOException e) {
			logger.error("IO exception ", e);
			throw e;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("isValidToken");
		}
		return loggedInUser;
	}

}
