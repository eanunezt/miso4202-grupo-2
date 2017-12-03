package marketplace.servicio;

import java.io.UnsupportedEncodingException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import marketplace.interfaz.IAutenticacion;

public class TokenAutServicio implements IAutenticacion{

	@Override
	public boolean autenticar(String username, String token, String password) {
		System.out.println("Autenticando con Token");
		try{
			Algorithm algorithm = Algorithm.HMAC256(password);
			JWTVerifier verifier = JWT.require(algorithm)
					.withClaim("username", username)
					.build(); //Reusable verifier instance
			DecodedJWT jwt = verifier.verify(token);
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return false;
		} catch (JWTVerificationException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
