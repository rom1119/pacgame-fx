package com.pacgame;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan({"com.pacgame.*"})
@PropertySource("classpath:application.properties")
public class MainConfig
{

//    @Autowired
//    private MainSettings mainSettings;
//
//    @Autowired
//    private LoginForm loginForm;
//
//    @Autowired
//    private RegisterForm registerForm;
//
//    @Autowired
//    private UserAccount userAccount;
//
//    @Autowired
//    private MainReadGame mainReadGame;
//
//    @Autowired
//    private ContextMenu contextMenu;
//
//    @Autowired
//    private MainMenu mainMenu;
//
//    @Autowired
//    private ContextSettings contextSettings;
//
//    @Autowired
//    private ContextSaveGame contextSaveGame;
//
//    @Autowired
//    private GameInfo gameInfo;
//
//    @Autowired
//    private Map map;

//    @Bean
//    public OnBackToMenu onBackToMenu()
//    {
//        return new OnBackToMenu(map, mainMenu);
//    }
//
//    @Bean
//    public OnLoginUser onLoginUser()
//    {
//        return new OnLoginUser(loginForm, mainMenu);
//    }

//    @Autowired
//    public void setLoggedUserUrl(Environment env)
//    {
//        ApiImpl.GET_LOGGED_USER_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.getLoggedUser");
//    }
//
//    @Autowired
//    public void setGetUserUrl(Environment env)
//    {
//        ApiImpl.GET_USER_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.getUser");
//    }
//
//    @Autowired
//    public void setPutUserUrl(Environment env)
//    {
//        ApiImpl.PUT_USER_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.putUser");
//    }
//
//    @Autowired
//    public void setPutUserImageUrl(Environment env)
//    {
//        ApiImpl.PUT_USER_IMAGE_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.putUserImage");
//    }
//
//    @Autowired
//    public void setGetUsersUrl(Environment env)
//    {
//        ApiImpl.GET_USERS_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.getUsers");
//    }
//
//    @Autowired
//    public void setTokenUrl(Environment env)
//    {
//        ApiImpl.GET_TOKEN_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.getToken");
//    }
//
//    @Autowired
//    public void setClientId(Environment env)
//    {
//        ApiImpl.CLIENT_ID = env.getProperty("oauth.clientId");
//    }
//
//    @Autowired
//    public void setClientSecret(Environment env)
//    {
//        ApiImpl.CLIENT_SECRET = env.getProperty("oauth.clientSecret");
//    }
//
//    @Autowired
//    public void setLogout(Environment env)
//    {
//        ApiImpl.LOGOUT_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.logout");
//    }
//
//    @Autowired
//    public void setRegisterUrl(Environment env)
//    {
//        ApiImpl.REGISTER_URL = env.getProperty("oauth.host") + env.getProperty("oauth.url.register");
//    }
//
//    @Autowired
//    public void setResourceUrl(Environment env)
//    {
//        ApiImpl.RESOURCE_URL = env.getProperty("oauth.host") + env.getProperty("url.resource");
//    }
}
