package com.example.demo.jwt;

import java.util.Date;
import java.util.logging.Logger;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

@Component
public class JwtProvider {

	private static Logger log = Logger.getLogger(JwtProvider.class.getSimpleName());

	@Value("${security.secretKey}")
	private String secretKey;

	@Value("${security.prefix}")
	private String prefix;

	@Value("${security.param}")
	private String param;

	/**
	 * Method for generate JSON WEB TOKEN (JWT)
	 * 
	 * @return String - which reprents JWT
	 * 
	 */
	public String generateJwt() {
		log.info("method generateJwt() - START");
		Date dateNow = DateTime.now().toDate();
		Date expiraDate = DateTime.now().plusMonths(1).toDate();

		String jwt = JWT.create().withSubject("subject").withIssuer("issuer").withIssuedAt(dateNow)
				.withClaim("someClaim", "someClaimDesc").withExpiresAt(expiraDate)
				.sign(Algorithm.HMAC256(this.secretKey));

		log.info("method generateJwt() - DEBUG: jwt=" + jwt);
		log.info("method generateJwt() - RETURNED: jwt=" + jwt);
		log.info("method generateJwt() - END");
		return jwt;
	}

	/**
	 * This method decode JWT that arrive from request and resume an authorzation
	 * user
	 * 
	 * @param String - JWT that arrived from request-header in the filed called
	 *               'Authorization'
	 * @return
	 */
	public DecodedJWT decodeJwt(String jwtString) {
		log.info("method decodeJwt(String jwtString) - START");
		log.info("method decodeJwt(String jwtString) - PARAM: jwtString="+jwtString);

		// add a prefix on JWT string and then delete empty space at first and end it.
		jwtString = jwtString.replace(this.prefix, "").trim();
		log.info("method decodeJwt(String jwtString) - DEBUG: jwtString="+jwtString);

		// set algorithm to encrypt and specif a secretkey to encrypt
		Verification verification = JWT.require((Algorithm.HMAC256(this.secretKey)));
		
		JWTVerifier jwtVerifier = verification.build();
		DecodedJWT jwtDeocoded = jwtVerifier.verify(jwtString);
		log.info("method decodeJwt(String jwtString) - DEBUG: jwtDeocoded.subject="+jwtDeocoded.getSubject());

		log.info("method decodeJwt(String jwtString) - END");
		return jwtDeocoded;
	}
}