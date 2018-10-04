package com.pacgame;

import com.pacgame.data.service.ApiImpl;
import com.pacgame.ui.component.*;
import com.pacgame.ui.event.eventHandler.OnBackToMenu;
import com.pacgame.ui.event.eventHandler.OnLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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

    @Autowired
    public void setLoggedUserUrl(Environment env)
    {
        ApiImpl.GET_LOGGED_USER_URL = env.getProperty("oauth.url.getLoggedUser");
    }

    @Autowired
    public void setTokenUrl(Environment env)
    {
        ApiImpl.GET_TOKEN_URL = env.getProperty("oauth.url.getToken");
    }

    @Autowired
    public void setClientId(Environment env)
    {
        ApiImpl.CLIENT_ID = env.getProperty("oauth.clientId");
    }

    @Autowired
    public void setClientSecret(Environment env)
    {
        ApiImpl.CLIENT_SECRET = env.getProperty("oauth.clientSecret");
    }
}
