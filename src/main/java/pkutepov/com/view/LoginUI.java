package pkutepov.com.view;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.user_dao.UserService;
import pkutepov.com.security.SecurityService;

public class LoginUI  extends UI {
    String path  =VaadinService.getCurrentRequest().getContextPath().replace("^\\/", "");
    private final Panel mainPanel = new Panel("Вход");
    private final TextField username = new TextField("Введите логин");
    private final PasswordField password = new PasswordField("Введите пароль");
    private final Button logIn = new Button("Вход");
    private final Button registration = new Button("Регистрация");
    private ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
    SecurityService securityService = context.getBean("securityService",SecurityService.class);
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.addComponent(username);
        verticalLayout.addComponent(password);
        verticalLayout.addComponent(logIn);
        verticalLayout.addComponent(registration);

        verticalLayout.setSizeUndefined();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        horizontalLayout.addComponent(verticalLayout);

        horizontalLayout.setComponentAlignment(verticalLayout, Alignment.MIDDLE_CENTER);
        horizontalLayout.setSizeFull();


        initListener();
        mainPanel.setSizeUndefined();
        mainPanel.setContent(horizontalLayout);
        mainPanel.setWidth("100%");
//        setContent(panel);
        setContent(mainPanel);

    }
    void initListener(){
        logIn.addClickListener(clickEvent -> {
            securityService.autoLogin(username.getValue(),password.getValue());

            getUI().getPage().setLocation(path+"/index");
        });
        registration.addClickListener(clickEvent -> {
            ;

            getUI().getPage().setLocation(path+"/registration");
        });
    }
}
