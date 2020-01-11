package rs.raf.service1.service;

public interface TokenHandlerService {

    String getTokenByEmail(String email);

    String getEmailByToken(String token);

}
