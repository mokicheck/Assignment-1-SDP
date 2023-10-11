public class OAuthAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String username, String oauthToken) {
        return true; 
    }
}
