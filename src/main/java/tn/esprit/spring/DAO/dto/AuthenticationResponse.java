package tn.esprit.spring.DAO.dto;

public class AuthenticationResponse {
    private String jwtToken;

    public AuthenticationResponse(String jwt) {
        this.jwtToken = jwt; // Assign the jwt parameter to the class variable
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
