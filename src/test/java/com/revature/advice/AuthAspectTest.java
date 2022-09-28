package com.revature.advice;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.revature.models.User;


//@SpringBootTest
//@AutoConfigureMockMvc
public class AuthAspectTest {
    
    //@Autowired
    //private MockMvc mockMvc;  // creates mock Spring request & session
    HttpSession session = Mockito.mock(HttpSession.class);
    // HttpServletRequest req = Mockito.mock(HttpServletRequest.class);

    @Test
    void testAuthenticate(){
        User user = new User(1, "j@gmail.com", "password", "firstName", "lastName");
        //HttpSession session = Mockito.mock(HttpSession.class);
        session.setAttribute("user", user);
        // HashMap<String,User> sessionAttr = new HashMap<>();
        // sessionAttr.put("user",user);
        Mockito.when(session.getAttribute("user")).thenReturn(session);
        Assertions.assertNotNull(session.getAttribute("user"));
    }

    @Test
    void testAuthenticateFail(){
        session.setAttribute("user", null);
        Mockito.when(session.getAttribute("user")).thenReturn(null);
        Assertions.assertNull(session.getAttribute("user"));
    }
}
