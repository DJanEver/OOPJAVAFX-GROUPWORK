package models;

public class Administration {
    private String provider;
    private String password;

    public Administration(){}
    public Administration(String provider, String password) {
        this.provider = provider;
        this.password = password;
    }

    public String getProvider() { return provider; }

    public void setProvider(String provider) { this.provider = provider; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}

